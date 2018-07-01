package com.omt.learn.geekforgeek.greedy;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import com.omt.learn.algo.util.graph.Edge;
import com.omt.learn.algo.util.graph.Graph;
import com.omt.learn.algo.util.graph.Node;
import com.omt.learn.algo.util.graph.State;

/**
 * Prim’s Minimum Spanning Tree
 * 
 * NOTE: Prim's algorithm will consider Graph as a directed graph by checking is
 * visited status of node. If both node of EDGE is visited already then do not
 * include it in selected EDGE
 * 
 * Algorithm will start with first vertex of graph.
 * 
 * @author janudhiral
 *
 */
public class MSP_PRIMS {

	public static void main(String... args) {
		for (Edge e : getSelectedMSPEdges(generateLoopGraph())) {
			System.out.println(e.getTo().getVertex() + "---" + e.getFrom().getVertex() + ":" + e.getWeight());
		}
	}

	private static Set<Edge> getSelectedMSPEdges(Graph g) {
		Set<Edge> selectedEdges = new HashSet<>();
		int totalEdgesInMSP = g.getVertices().size() - 1;

		PriorityQueue<Edge> smallestEdgeFirst = new PriorityQueue<>();
		smallestEdgeFirst.addAll(g.getVertices().get(0).getEdges());
		g.getVertices().get(0).setState(State.VISITED);

		while (!smallestEdgeFirst.isEmpty() && selectedEdges.size() < totalEdgesInMSP) {
			Edge edge = smallestEdgeFirst.poll();
			// !selectedEdges.contains(edge) : This one to avoid duplicate edge processing.
			// It is not required but will helpful to understand this algorithm properly
			if (!selectedEdges.contains(edge) && (edge.getTo().isUnvisited() || edge.getFrom().isUnvisited())) {
				selectedEdges.add(edge);

				// Get all the edges from unvisited nodes
				if (edge.getTo().isUnvisited()) {
					smallestEdgeFirst.addAll(edge.getTo().getEdges());
				}
				if (edge.getFrom().isUnvisited()) {
					smallestEdgeFirst.addAll(edge.getFrom().getEdges());
				}

				// Mark both nodes as visited, This is to avoid loop by making entire graph as
				// directed
				edge.getTo().setState(State.VISITED);
				edge.getFrom().setState(State.VISITED);
			}
		}

		return selectedEdges;

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

		return graph;

	}
}
