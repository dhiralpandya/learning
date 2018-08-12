package com.omt.learn.algo.allAlgos;

import java.util.Stack;

import com.omt.learn.algo.util.graph.Graph;
import com.omt.learn.algo.util.graph.Node;
import com.omt.learn.algo.util.graph.State;

public class TopologicalSortGraphAlgorithm {

	public static void main(String[] args) {
		generatePackageSequence(generateGraph());
	}

	public static void generatePackageSequence(Graph graph) {
		Stack<Node> stackOfVertex = new Stack();
		Stack<Node> foundNode = new Stack<>();

		for (Node n : graph.getVertices()) {
			if (!n.isVisited() && !n.isFoundAlready()) {
				n.setState(State.FOUND);
				foundNode.push(n);
				iterate(foundNode, stackOfVertex);
			}
		}

		String sequenceOfVisit = "";

		while (!stackOfVertex.isEmpty()) {
			sequenceOfVisit += stackOfVertex.pop().getVertex() + " > ";
		}

		System.out.println(sequenceOfVisit);
	}

	private static void iterate(Stack<Node> foundNode, Stack<Node> stackOfVertex) {
		if (foundNode.isEmpty()) {
			return;
		}
		Node c = foundNode.peek();

		if ((c.getAdjacent() == null || c.getAdjacent().isEmpty()) && !c.isVisited()) {
			stackOfVertex.push(c);
			foundNode.pop();
			c.setState(State.VISITED);
		} else {
			boolean isAnyNewInsert = false;
			for (Node n : c.getAdjacent()) {
				if (!n.isFoundAlready() && !n.isVisited()) {
					isAnyNewInsert = true;
					n.setState(State.FOUND);
					foundNode.push(n);
				}
			}

			if (!isAnyNewInsert) {
				stackOfVertex.push(c);
				foundNode.pop();
				c.setState(State.VISITED);
			}

		}

		iterate(foundNode, stackOfVertex);

	}

	public static Graph generateGraph() {

		Graph graph = new Graph();

		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node q = new Node("Q");
		Node r = new Node("R");
		Node g = new Node("G");
		Node h = new Node("H");
		Node i = new Node("I");
		Node p = new Node("P");

		a.addAdjacent(c);

		b.addAdjacent(c);
		b.addAdjacent(p);

		c.addAdjacent(d);
		c.addAdjacent(q);

		p.addAdjacent(r);

		q.addAdjacent(r);

		d.addAdjacent(h);
		d.addAdjacent(g);

		g.addAdjacent(i);

		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(q);
		graph.addVertex(r);
		graph.addVertex(g);
		graph.addVertex(h);
		graph.addVertex(i);
		graph.addVertex(p);

		return graph;

	}
}
