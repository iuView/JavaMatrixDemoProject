package org.example.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class DijkstrasAlgoTest {

    DijkstrasAlgo dijkstrasAlgo = new DijkstrasAlgo();

    @Test
    void shortestPath() {
        int n;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1, 10));
        edges.add(Arrays.asList(0,2,3));

        edges.add(Arrays.asList(1,3,2));

        edges.add(Arrays.asList(2,1,4));

        edges.add(Arrays.asList(2,3,8));

        edges.add(Arrays.asList(2,4,2));

        edges.add(Arrays.asList(3,4,5));

        Map<Integer, Integer> result = dijkstrasAlgo.shortestPath(5, edges, 0);
        Map<Integer, Integer> target = new HashMap<>();
        target.put(0, 0);
        target.put(1, 7);
        target.put(2, 3);
        target.put(3, 9);
        target.put(4, 5);

        assertThat(result).containsExactlyInAnyOrderEntriesOf(target);
    }
}