package com.omt.learn.algo;

import java.util.LinkedList;
import java.util.Queue;

import com.omt.learn.algo.util.graph.Graph;
import com.omt.learn.algo.util.graph.Node;
import com.omt.learn.algo.util.graph.State;

public class RouteBetweenTwoNodes {

	public static void main(String[] args) {

		Graph g = generateGraph();

		System.out.println("Is route :"
				+ isThereRouteBetween(g, g.getVertices().get(0), g.getVertices().get(g.getVertices().size() - 2)));

	}

	public static boolean isThereRouteBetween(Graph g, Node n1, Node n2) {

		System.out.println("Finding Route Between : " + n1.getVertex() + " and " + n2.getVertex());

		Queue<Node> queue = new LinkedList<>();

		queue.add(n1);

		while (!queue.isEmpty()) {

			Node current = queue.poll();
			current.setState(State.VISITED);
			// System.out.println(current.getVertex());

			for (Node n : current.getAdjacent()) {

				if (!n.isVisited()) {

					if (n2 == n) {
						return true;
					}
					if (!n.isFoundAlready()) {
						n.setState(State.FOUND);
						queue.add(n);
					}
				}

			}
		}

		return false;
	}

	public static Graph generateGraph() {

		Graph graph = new Graph();

		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		Node g = new Node("G");
		Node h = new Node("H");
		Node i = new Node("I");

		a.addAdjacent(b);
		a.addAdjacent(c);

		b.addAdjacent(d);
		b.addAdjacent(a);

		d.addAdjacent(b);
		d.addAdjacent(e);
		d.addAdjacent(f);

		e.addAdjacent(d);
		e.addAdjacent(f);
		e.addAdjacent(g);

		f.addAdjacent(e);
		f.addAdjacent(d);
		f.addAdjacent(g);

		g.addAdjacent(e);
		g.addAdjacent(f);

		c.addAdjacent(a);
		c.addAdjacent(h);

		h.addAdjacent(c);

		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		graph.addVertex(e);
		graph.addVertex(f);
		graph.addVertex(g);
		graph.addVertex(h);
		graph.addVertex(i);

		return graph;

	}

}
