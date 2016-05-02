package com.omt.learn.algo.util.graph;

import java.util.ArrayList;
import java.util.List;

public class Node {

	private List<Node> adjacent = new ArrayList<>();
	private String vertex = "";
	private State state = State.UNVISITED;

	public Node(String vertex) {
		this.vertex = vertex;
	}

	public void addAdjacent(Node node) {
		adjacent.add(node);
	}

	public boolean isVisited() {
		return getState() == State.VISITED;
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

}
