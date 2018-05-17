package com.omt.learn.algo.util.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Node {

	private List<Node> adjacent = new ArrayList<>();
	private String vertex = "";
	private int nodeId = -1;
	private State state = State.UNVISITED;
	private Set<Edge> edges = new HashSet<>();

	public Node(String vertex) {
		this.vertex = vertex;
	}

	public void addAdjacent(Node node) {
		edges.add(new Edge(this, node));
		adjacent.add(node);
	}

	public Set<Edge> getEdges() {
		return edges;
	}

	public boolean isVisited() {
		return getState() == State.VISITED;
	}

	public boolean isUnvisited() {
		return getState() == State.UNVISITED;
	}

	public boolean isFoundAlready() {
		return getState() == State.FOUND;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public List<Node> getAdjacent() {
		return adjacent;
	}

	public String getVertex() {
		return vertex;
	}

	public int getNodeId() {
		return nodeId;
	}

	void setNodeId(int nodeId) {
		this.nodeId = nodeId;
	}

}
