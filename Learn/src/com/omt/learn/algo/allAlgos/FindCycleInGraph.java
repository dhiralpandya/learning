package com.omt.learn.algo.allAlgos;

import com.omt.learn.algo.util.graph.Graph;
import com.omt.learn.algo.util.graph.Node;
import com.omt.learn.algo.util.graph.State;

public class FindCycleInGraph {

	public static void main(String[] args) {

		System.out.println(generateNonLoopGraph().getEdgeCount());

		System.out.println("Is graph contains cycle :" + isGraphContainsCycle(generateLoopGraph()));
		System.out.println("Is graph contains cycle :" + isGraphContainsCycle(generateNonLoopGraph()));

	}

	public static boolean isGraphContainsCycle(Graph graph) {

		for (Node parentNode : graph.getVertices()) {

			parentNode.setState(State.VISITED);
			int numberOfVisitedChild = 0;
			for (Node childNode : parentNode.getAdjacent()) {
				if (childNode.isVisited()) {
					if (numberOfVisitedChild == 0) {
						numberOfVisitedChild++;
					} else {
						return true;
					}
				}
			}

		}

		return false;
	}

	public static Graph generateLoopGraph() {

		Graph graph = new Graph();

		Node a = new Node("A"); // 0
		Node b = new Node("B"); // 1
		Node c = new Node("C"); // 2
		Node d = new Node("D"); // 3
		Node e = new Node("E"); // 4
		Node f = new Node("F"); // 5
		Node g = new Node("G"); // 6
		Node h = new Node("H"); // 7
		Node i = new Node("I"); // 8

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

	public static Graph generateNonLoopGraph() {

		Graph graph = new Graph();

		Node a = new Node("A"); // 0
		Node b = new Node("B"); // 1
		Node c = new Node("C"); // 2
		Node d = new Node("D"); // 3
		Node e = new Node("E"); // 4
		Node f = new Node("F"); // 5
		Node g = new Node("G"); // 6
		Node h = new Node("H"); // 7
		Node i = new Node("I"); // 8

		a.addAdjacent(b);
		a.addAdjacent(c);

		b.addAdjacent(d);
		b.addAdjacent(a);

		d.addAdjacent(b);
		d.addAdjacent(f);

		e.addAdjacent(i);
		e.addAdjacent(g);

		f.addAdjacent(d);
		f.addAdjacent(g);

		g.addAdjacent(e);
		g.addAdjacent(f);

		c.addAdjacent(a);
		c.addAdjacent(h);

		h.addAdjacent(c);

		i.addAdjacent(e);

		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(h);
		graph.addVertex(d);
		graph.addVertex(f);
		graph.addVertex(g);
		graph.addVertex(e);
		graph.addVertex(i);

		return graph;

	}

}
