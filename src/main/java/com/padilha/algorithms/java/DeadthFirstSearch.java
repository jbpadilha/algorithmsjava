package com.padilha.algorithms.java;

import java.util.*;

public class DeadthFirstSearch {

    public static class Vertex<T> {
        private final T data;
        private boolean visited;
        private List<Vertex<T>> neighbours = new ArrayList<>();

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

    DeadthFirstSearch(Vertex startVertex) {
        this.startVertex = startVertex;
    }


    public void traverse(Vertex startVertex) {
        Deque<Vertex> stack = new LinkedList<>();
        stack.add(startVertex);
        while (!stack.isEmpty()) {
            Vertex current = stack.pop();
            if (!current.isVisited()) {
                current.setVisited(true);
                System.out.println(current.data.toString());
                Collections.reverse(current.getNeighbours());
                current.getNeighbours().forEach(e -> stack.push((Vertex) e));
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
    }
}
