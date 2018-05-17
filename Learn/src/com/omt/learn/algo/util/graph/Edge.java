package com.omt.learn.algo.util.graph;

public class Edge {

	private Node from;
	private Node to;

	public Edge(Node from, Node to) {
		this.from = from;
		this.to = to;
	}

	@Override
	public int hashCode() {
		return from.hashCode() + to.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		Edge oe = (Edge) obj;

		if ((oe.from == this.from || oe.to == this.from) && (oe.from == this.to || oe.to == this.to)) {
			return true;
		}

		return false;
	}

	public Node getFrom() {
		return from;
	}

	public Node getTo() {
		return to;
	}

}
