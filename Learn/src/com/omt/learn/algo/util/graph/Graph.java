package com.omt.learn.algo.util.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Node> vertices = new ArrayList<>();

	public void addVertex(Node node) {
		node.setNodeId(vertices.size());
		vertices.add(node);
	}

	public List<Node> getVertices() {
		return vertices;
	}

}
