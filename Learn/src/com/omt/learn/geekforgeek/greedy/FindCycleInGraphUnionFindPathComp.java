package com.omt.learn.geekforgeek.greedy;

import java.util.HashMap;
import java.util.Map;

import com.omt.learn.algo.util.graph.Graph;
import com.omt.learn.algo.util.graph.Node;
import com.omt.learn.algo.util.graph.State;

public class FindCycleInGraphUnionFindPathComp {

	public static void main(String[] args) {

		System.out.println("Is Cycle Found:" + isCycleInGraph(generateLoopGraph()));

		System.out.println("Is Cycle Found:" + isCycleInGraph(generateNonLoopGraph()));

	}

	public static boolean isCycleInGraph(Graph graph) {
		Map<Node, Node> subSet = new HashMap<Node, Node>();
		for (Node n : graph.getVertices()) {
			if (n.getAdjacent() != null && !n.getAdjacent().isEmpty()) {
				n.setState(State.VISITED);
				for (Node to : n.getAdjacent()) {
					if (to.isVisited()) {
						continue;
					}
					Node n1 = find(subSet, n);
					Node n2 = find(subSet, to);
					if (n1 == n2) {
						prettyPrintMap(subSet);
						return true;
					} else {
						union(subSet, n, to);
					}
				}
			}
		}
		prettyPrintMap(subSet);
		return false;
	}

	public static Node find(Map<Node, Node> subSet, Node n) {

		if (subSet.get(n) == null) {
			return n;
		}

		return find(subSet, subSet.get(n));
	}

	public static void union(Map<Node, Node> subSet, Node from, Node to) {
		Node n1 = find(subSet, from);
		Node n2 = find(subSet, to);

		if (n1.getNodeId() < n2.getNodeId()) {
			subSet.put(n2, n1);
		} else if (n1.getNodeId() > n2.getNodeId()) {
			subSet.put(n1, n2);
		} else {
			n1.setNodeId(n1.getNodeId() + 1);
			subSet.put(n1, n2);
		}

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

	public static void prettyPrintMap(Map<Node, Node> subSet) {
		for (Node key : subSet.keySet()) {
			System.out.println(key.getVertex() + "->" + subSet.get(key).getVertex());
		}
	}
}
