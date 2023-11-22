package org.example.neetcode;

import java.util.*;

/**
 * https://neetcode.io/problems/dijkstra
 */
public class DijkstrasAlgo {
    Map<Integer, List<Node>> mynexts = new HashMap<>();
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {

        Map<Integer, Integer> retval = new HashMap<>(); // only keep the shortest, you can do it

        // first we need a map for the thing to its next neighb
        getMyNexts(edges);

        // working from the root (src) and BFS -- broadly
        // we need a Queue to work this continually
        Deque<Node> queue = new LinkedList<>();
        queue.offer(new Node(src, src,0)); // starting from src

        while (!queue.isEmpty()) {
            List<Node> itemsOnQueue = new ArrayList<>();

            while (!queue.isEmpty()) {
                itemsOnQueue.add(queue.poll());
            }

            // put the nexts on the queue:
            for (int i = 0; i < itemsOnQueue.size(); i++) {
                Node item = itemsOnQueue.get(i);

                int total = 0;
                Integer srcdist = retval.get(item.src);
                if (srcdist != null) {
                    total = srcdist + item.w;
                } else {
                    total = item.w;
                }

                Integer dist = retval.get(item.dest);
                if (dist == null) {
                    // need to find the source
                    retval.put(item.dest, total);
                } else {
                    if (total < dist) {
                        retval.put(item.dest, total);
                        // when we update a shortest distance in the retval,
                        // we also need to update the corresponding downstreams
                        // if the downstream is already calculated
                        List<Node> nexts = mynexts.get(item.dest);
                        if (nexts != null) {
                            for (int k = 0; k < nexts.size(); k++) {
                                Node knode = nexts.get(k);
                                Integer kval = retval.get(knode.dest);
                                if (kval != null) {
                                    retval.put(knode.dest, total + knode.w);
                                }
                            }
                        }
                    }
                }

                List<Node> nexts = mynexts.get(item.dest);
                if (nexts != null) {
                    for (int j = 0; j < nexts.size(); j++) {
                        queue.add(nexts.get(j));
                    }
                }
            }

        }

        for (int i = 0; i < n; i++) {
            if (retval.get(i) == null)
                retval.put(i, -1);
        }
        return retval;
    }

    void getMyNexts(List<List<Integer>> edges) {
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> tups = edges.get(i);
            int src = tups.get(0);
            int des = tups.get(1);
            int w = tups.get(2);
            List<Node> vals = mynexts.get(src);
            if (vals == null)
                vals = new ArrayList<>();
            vals.add(new Node(src, des, w));
            mynexts.put(src, vals);
        }
    }
}

class Node {
    int src;
    int dest;
    int w;

    public Node(int src, int dest, int w) {
        this.src = src;
        this.dest = dest;
        this.w = w;
    }
}