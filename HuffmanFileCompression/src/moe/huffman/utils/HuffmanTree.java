package moe.huffman.utils;
import java.util.*;
public class HuffmanTree {
    public static final int AlphabetSize = 256;

    private Node huffmanTree;
    private int frequencyTable [];
    public HuffmanTree(int frequencyTable[]) {
        this.frequencyTable = frequencyTable;
        this.huffmanTree = buildTree();
    }

    private Node buildTree() {
        PriorityQueue<Node> queue = new PriorityQueue<>();

        for(char i = 0; i < AlphabetSize; i++) {
            //if the char has frequency
            //Generate leaf node
            if(frequencyTable[i] > 0) {

                queue.add(new Node(i,frequencyTable[i],null,null));

            }
        }

        //Check if the msg only contain 1 character
        if(queue.size() == 1){
            queue.add(new Node('\0',1,null,null));
        }

        //Connect the leaf nodes together and make the subtree
        while(queue.size()>1) {
            Node left = queue.poll();
            Node right = queue.poll();
            Node parent = new Node('\0',left.getFrequency() + right.getFrequency(),left,right);

            queue.add(parent);

        }
        return queue.poll();
    }

    public Node getHuffmanTree() {
        return huffmanTree;
    }
}
