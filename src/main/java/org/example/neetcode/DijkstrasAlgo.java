package org.example.neetcode;

import org.example.DirectedNode;

import java.util.*;

/**
 * https://neetcode.io/problems/dijkstra
 */
public class DijkstrasAlgo {
    Map<Integer, List<DirectedNode>> mynexts = new HashMap<>();
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {

        Map<Integer, Integer> retval = new HashMap<>(); // only keep the shortest, you can do it

        // first we need a map for the thing to its next neighb
        getMyNexts(edges);

        // working from the root (src) and BFS -- broadly
        // we need a Queue to work this continually
        Deque<DirectedNode> queue = new LinkedList<>();
        queue.offer(new DirectedNode(src, src,0)); // starting from src

        while (!queue.isEmpty()) {
            List<DirectedNode> itemsOnQueue = new ArrayList<>();

            while (!queue.isEmpty()) {
                itemsOnQueue.add(queue.poll());
            }

            // put the nexts on the queue:
            for (int i = 0; i < itemsOnQueue.size(); i++) {
                DirectedNode item = itemsOnQueue.get(i);

                int total = 0;
                Integer srcdist = retval.get(item.getSrc());
                if (srcdist != null) {
                    total = srcdist + item.getW();
                } else {
                    total = item.getW();
                }

                Integer dist = retval.get(item.getDest());
                if (dist == null) {
                    // need to find the source
                    retval.put(item.getDest(), total);
                    List<DirectedNode> nexts = mynexts.get(item.getDest());
                    if (nexts != null) {
                        for (int j = 0; j < nexts.size(); j++) {
                            queue.add(nexts.get(j));
                        }
                    }
                } else {
                    if (total < dist) {
                        retval.put(item.getDest(), total);
                        // when we update a shortest distance in the retval,
                        // we also need to update the corresponding downstreams
                        // if the downstream is already calculated
                        List<DirectedNode> nexts = mynexts.get(item.getDest());
                        if (nexts != null) {
                            for (int k = 0; k < nexts.size(); k++) {
                                DirectedNode knode = nexts.get(k);
                                Integer kval = retval.get(knode.getDest());
                                if (kval != null) {
                                    retval.put(knode.getDest(), total + knode.getW());
                                }
                            }
                        }
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
            List<DirectedNode> vals = mynexts.get(src);
            if (vals == null)
                vals = new ArrayList<>();
            vals.add(new DirectedNode(src, des, w));
            mynexts.put(src, vals);
        }
    }
}

