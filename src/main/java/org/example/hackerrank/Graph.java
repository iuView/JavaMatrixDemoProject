package org.example.hackerrank;

import org.example.DirectedNode;

import java.util.*;

/**
 *
 *
 */
public class Graph {
    /**
     * <a href="https://www.hackerrank.com/challenges/bfsshortreach/problem">BFS problem</a>
     * Complete the 'bfs' function below.
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n (number of integers we are working, 1, 2, 3..., n)
     *  2. INTEGER m (number of edges, equals the size of edges list)
     *  3. 2D_INTEGER_ARRAY edges
     *  4. INTEGER s (the starting node)
     *  the goal is to get the shortest distance.
     *  each edge is worth $6
     *
     *  now that with the Dijkstras problem fixed, coming back to this 'easier' one
     *  this passed the tests on hackerrank, but there are definitely some loops need improving
     */

    Map<Integer, List<DirectedNode>> mynexts = new HashMap<>();

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        Graph graph = new Graph();
        return graph.bfsInternal(n, m, edges, s);
    }

    public List<Integer> bfsInternal(int n, int m, List<List<Integer>> edges, int s) {

        List<Integer> retval = new ArrayList<>();

        // keeps the nodeID and distance map
        // this is also the 'visited' map, so won't visit the same node again
        Map<Integer, Integer> map = new HashMap<>();

        getMyNexts(edges);

        Deque<DirectedNode> queue = new LinkedList<>();
        queue.offer(new DirectedNode(s, s,0)); // starting from src

        while (!queue.isEmpty()) {
            List<DirectedNode> itemsOnQueue = new ArrayList<>();

            while (!queue.isEmpty()) {
                itemsOnQueue.add(queue.poll());
            }

            // put the nexts on the queue:
            for (int i = 0; i < itemsOnQueue.size(); i++) {
                DirectedNode item = itemsOnQueue.get(i);

                int total = 0;
                Integer srcdist = map.get(item.getSrc());
                if (srcdist != null) {
                    total = srcdist + item.getW();
                } else {
                    total = item.getW();
                }

                Integer dist = map.get(item.getDest());
                if (dist == null) {
                    // need to find the source
                    map.put(item.getDest(), total);
                    List<DirectedNode> nexts = mynexts.get(item.getDest());
                    if (nexts != null) {
                        for (int j = 0; j < nexts.size(); j++) {
                            queue.add(nexts.get(j));
                        }
                    }
                } else {
                    if (total < dist) {
                        map.put(item.getDest(), total);
                        // when we update a shortest distance in the retval,
                        // we also need to update the corresponding downstreams
                        // if the downstream is already calculated
                        List<DirectedNode> nexts = mynexts.get(item.getDest());
                        if (nexts != null) {
                            for (int k = 0; k < nexts.size(); k++) {
                                DirectedNode knode = nexts.get(k);
                                Integer kval = map.get(knode.getDest());
                                if (kval != null) {
                                    map.put(knode.getDest(), total + knode.getW());
                                }
                            }
                        }
                    }
                }
            }

        }

//        Comparator<? super Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
//                return o1.getKey().compareTo(o2.getKey());
//            }
//        };
//        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream().sorted(comparator).collect(Collectors.toList());

        for (int i = 1; i <= n; i++) {
            if (i != s) {
                Integer val = map.get(i);
                if (val != null)
                    retval.add(val);
                else
                    retval.add(-1);
            }
        }
        return retval;
    }

    void getMyNexts(List<List<Integer>> edges) {
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> pair = edges.get(i);
            int src = pair.get(0);
            int des = pair.get(1);

            List<DirectedNode> vals = mynexts.get(src);
            if (vals == null)
                vals = new ArrayList<>();
            vals.add(new DirectedNode(src, des, 6));
            mynexts.put(src, vals);

            // now reverse direction since it is undirected
            List<DirectedNode> reverseVals = mynexts.get(des);
            if (reverseVals == null)
                reverseVals = new ArrayList<>();
            reverseVals.add(new DirectedNode(des, src, 6));
            mynexts.put(des, reverseVals);
        }
    }
}
