package com.omt.learn.algo.util.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Graph {

	private List<Node> vertices = new ArrayList<>();

	public void addVertex(Node node) {
		vertices.add(node);
	}

	public List<Node> getVertices() {
		return vertices;
	}

	public int getEdgeCount() {
		Set<Edge> totalEdges = new HashSet<>();
		for (Node n : vertices) {
			totalEdges.addAll(n.getEdges());
		}
		return totalEdges.size();
	}

	public boolean isThereALoopInGraph() {

		Set<Node> nodes = new TreeSet<>();

		for (Node n : vertices) {
			int count = 0;
		}

		return false;
	}

}
