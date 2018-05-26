package moe.huffman.utils;
import java.util.Comparator;

public class NodeComparetor implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return o1.getFrequency() - o2.getFrequency();
    }
}
