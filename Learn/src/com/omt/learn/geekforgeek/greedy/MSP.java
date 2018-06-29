package com.omt.learn.geekforgeek.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.omt.learn.algo.util.graph.Edge;
import com.omt.learn.algo.util.graph.Graph;
import com.omt.learn.algo.util.graph.Node;

public class MSP {

	public static void main(String[] args) {
		for (Edge e : getMSPEdgeList(generateLoopGraph())) {
			System.out.println(e.getTo().getVertex() + "---" + e.getFrom().getVertex() + ":" + e.getWeight());
		}
	}

	private static List<Edge> getMSPEdgeList(Graph g) {

		List<Edge> selectedEdge = new ArrayList<>();
		Map<Node, Node> subSet = new HashMap<>();
		List<Edge> allEdges = new ArrayList<>(g.getEdges());
		Collections.sort(allEdges);
		int totalEdgesInMSP = g.getVertices().size() - 1;

		for (Edge e : allEdges) {
			Node n1 = e.getFrom();
			Node n2 = e.getTo();

			Node f1 = find(subSet, n1);
			Node f2 = find(subSet, n2);

			if (f1 == f2) {
				continue;
			} else {
				selectedEdge.add(e);
				union(n1, n2, subSet);
				if (selectedEdge.size() == totalEdgesInMSP) {
					return selectedEdge;
				}
			}

		}

		return null;
	}

	private static Node find(Map<Node, Node> subSet, Node n) {
		if (subSet.get(n) == null) {
			return n;
		}
		return find(subSet, subSet.get(n));
	}

	private static void union(Node n1, Node n2, Map<Node, Node> subSet) {
		n1 = find(subSet, n1);
		n2 = find(subSet, n2);
		if (n1.getNodeId() < n2.getNodeId()) {
			subSet.put(n2, n1);
		} else if (n1.getNodeId() > n2.getNodeId()) {
			subSet.put(n1, n2);
		} else {
			subSet.put(n2, n1);
			n2.setNodeId(n2.getNodeId() + 1);
		}
	}

	public static Graph generateLoopGraph() {

		Graph graph = new Graph();

		Node a = new Node("A"); // 0
		a.setNodeId(9);
		Node b = new Node("B"); // 1
		b.setNodeId(1);
		Node c = new Node("C"); // 2
		c.setNodeId(3);
		Node d = new Node("D"); // 3
		d.setNodeId(4);
		Node e = new Node("E"); // 4
		e.setNodeId(5);
		Node f = new Node("F"); // 5
		f.setNodeId(2);
		Node g = new Node("G"); // 6
		g.setNodeId(7);
		Node h = new Node("H"); // 7
		h.setNodeId(6);
		// Node i = new Node("I"); // 8

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
		// graph.addVertex(i);

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
