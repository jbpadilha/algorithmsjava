package com.padilha.algorithms.java;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    public static class Vertex<T> {
        private final T data;
        private boolean visited;
        private List<Vertex<T>> neighbours = new LinkedList<>();

        public Vertex(T data) {
            this.data = data;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

        public List<Vertex<T>> getNeighbours() {
            return neighbours;
        }

        public void setNeighbours(List<Vertex<T>> neighbours) {
            this.neighbours = neighbours;
        }
    }

    private final Vertex startVertex;

    BreadthFirstSearch(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public void traverse() {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(startVertex);
        while (!queue.isEmpty()) {
            Vertex current = queue.poll();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current.data.toString());
                queue.addAll(current.getNeighbours());
            }
        }
    }

    public static void main(String[] args) {
        Vertex<Integer> vertex0 = new Vertex<>(0);
        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        Vertex<Integer> vertex3 = new Vertex<>(3);
        Vertex<Integer> vertex4 = new Vertex<>(4);
        Vertex<Integer> vertex5 = new Vertex<>(5);
        Vertex<Integer> vertex6 = new Vertex<>(6);

        vertex0.setNeighbours(Arrays.asList(vertex1, vertex5, vertex6));
        vertex1.setNeighbours(Arrays.asList(vertex3, vertex4, vertex5));
        vertex4.setNeighbours(Arrays.asList(vertex2, vertex6));
        vertex6.setNeighbours(Arrays.asList(vertex0));

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(vertex1);
        breadthFirstSearch.traverse();

    }
}
