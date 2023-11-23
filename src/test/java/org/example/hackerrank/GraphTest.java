package org.example.hackerrank;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GraphTest {

    Graph graph = new Graph();
    @Test
    void bfs() {
        int n = 5;
        int m = 3;
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(1, 2));
        edges.add(Arrays.asList(1, 3));
        edges.add(Arrays.asList(3, 4));
        int s = 1;

        List<Integer> result = graph.bfsInternal(n, m, edges, s);

        List<Integer> target = Arrays.asList(6, 6, 12, -1);

        assertThat(result).isEqualTo(target);
    }
}