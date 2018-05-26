package moe.huffman.utils;

public class HuffmanEncodedResult {
    Node root;
    String encodedData;
    HuffmanEncodedResult(String encodedData,Node root) {
        this.encodedData = encodedData;
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public String getEncodedData() {
        return encodedData;
    }
}
