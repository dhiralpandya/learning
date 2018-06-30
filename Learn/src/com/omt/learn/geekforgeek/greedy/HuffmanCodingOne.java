package com.omt.learn.geekforgeek.greedy;

import java.util.PriorityQueue;

import com.omt.learn.algo.util.huffman.HuffmanNode;

public class HuffmanCodingOne {

	public static void main(String... args) {
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 5, 9, 12, 13, 16, 45 };
		printHuffmanCodes(charArray, charfreq);
	}

	private static void printHuffmanCodes(char[] c, int[] f) {

		PriorityQueue<HuffmanNode> huffmanNodes = new PriorityQueue<HuffmanNode>();
		int i = 0;

		for (char ch : c) {
			HuffmanNode huffmanNode = new HuffmanNode();
			huffmanNode.c = ch;
			huffmanNode.frequency = f[i++];
			huffmanNodes.add(huffmanNode);
		}

		// Create Huffman Tree
		while (huffmanNodes.size() > 1) {
			HuffmanNode huffmanNode = new HuffmanNode();
			huffmanNode.isInternalNode = true;

			huffmanNode.left = huffmanNodes.poll();
			huffmanNode.frequency = huffmanNode.left.frequency;

			huffmanNode.right = huffmanNodes.poll();
			huffmanNode.frequency += huffmanNode.right.frequency;
			huffmanNodes.add(huffmanNode);
		}

		// Print code for each char
		printCharAndCode(huffmanNodes.poll(), "");
	}

	private static void printCharAndCode(HuffmanNode root, String code) {
		if (root == null) {
			return;
		} else if (!root.isInternalNode) {
			System.out.println(root.c + ":" + code);
			return;
		}
		printCharAndCode(root.left, code + "0");
		printCharAndCode(root.right, code + "1");
	}
}
