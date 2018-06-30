package com.omt.learn.algo.util.huffman;

public class HuffmanNode implements Comparable<HuffmanNode> {

	public int frequency = 0;
	public char c;
	public boolean isInternalNode = false;
	public HuffmanNode left = null;
	public HuffmanNode right = null;

	@Override
	public int compareTo(HuffmanNode o) {
		return this.frequency - o.frequency;
	}

}
