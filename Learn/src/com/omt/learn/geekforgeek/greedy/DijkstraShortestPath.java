package com.omt.learn.geekforgeek.greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

import com.omt.learn.algo.util.graph.Edge;
import com.omt.learn.algo.util.graph.Graph;
import com.omt.learn.algo.util.graph.Node;
import com.omt.learn.algo.util.graph.State;

public class DijkstraShortestPath {

	public static void main(String args[]) {

		Map<Node, Integer> nodeWithDistance = getNodeWithDistance(generateLoopGraph());
		for (Node n : nodeWithDistance.keySet()) {
			System.out.println(n.getVertex() + " is at distance :" + nodeWithDistance.get(n));
		}

	}

	public static Map<Node, Integer> getNodeWithDistance(Graph graph) {
		Map<Node, Integer> nodeWithDistance = new HashMap<>();

		// Here we are going to use same MST Prim’s algorithm
		int totalEdgesInMST = graph.getVertices().size() - 1;

		// Start with Edges from root node. Root node is node at 0 position.
		PriorityQueue<Edge> nextSmallestEdge = new PriorityQueue<>();
		nextSmallestEdge.addAll(graph.getVertices().get(0).getEdges());// Get root node's edges

		// This is to just break loop
		Set<Edge> selectedEdges = new HashSet<>();

		// Below to keep track of distance from root node to current node.
		// int totalDistanceFromRootNode = 0;

		nodeWithDistance.put(graph.getVertices().get(0), 0);
		graph.getVertices().get(0).setState(State.VISITED);

		while (!nextSmallestEdge.isEmpty() && selectedEdges.size() < totalEdgesInMST) {

			Edge nextEdge = nextSmallestEdge.poll();

			if (!selectedEdges.contains(nextEdge)
					&& (nextEdge.getFrom().isUnvisited() || nextEdge.getTo().isUnvisited())) {

				// One of from or to nodes must visited previously. So taking distance from
				// there and adding it to other node
				if (nextEdge.getFrom().isUnvisited()) {
					nextEdge.getFrom().setState(State.VISITED);
					nodeWithDistance.put(nextEdge.getFrom(),
							nodeWithDistance.get(nextEdge.getTo()) + nextEdge.getWeight());
					nextSmallestEdge.addAll(nextEdge.getFrom().getEdges());
				} else if (nextEdge.getTo().isUnvisited()) {
					nextEdge.getTo().setState(State.VISITED);
					nodeWithDistance.put(nextEdge.getTo(),
							nodeWithDistance.get(nextEdge.getFrom()) + nextEdge.getWeight());
					nextSmallestEdge.addAll(nextEdge.getTo().getEdges());
				}

				selectedEdges.add(nextEdge);
			}

		}

		return nodeWithDistance;
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
