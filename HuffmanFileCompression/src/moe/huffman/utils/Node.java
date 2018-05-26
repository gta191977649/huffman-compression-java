package moe.huffman.utils;

import java.util.*;

public class Node implements Comparable<Node> {
    private char character;
    private int frequency;
    private Node left;
    private Node right;

    public Node(char character, int frequency, Node left, Node right) {
        this.character = character;
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }


    public boolean isLeaf() {
        return left == null && right == null;
    }
    public char getCharacter() {
        return character;
    }

    public int getFrequency() {
        return frequency;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node o) {
        int freqCompare = Integer.compare(frequency,o.getFrequency());
        if(freqCompare != 0) {
            return freqCompare;
        }
        return Integer.compare(character,o.getCharacter());
    }
}
