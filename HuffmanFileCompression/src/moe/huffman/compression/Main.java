package moe.huffman.compression;
import moe.huffman.utils.*;

public class Main {

    public static final int AlphabetSize = 256;


    public static void main(String[] args) {
        String data = "Hello world";
        HuffmanEncoder encoder = new HuffmanEncoder();

        System.out.println("Encoded In binary:");
        System.out.println(encoder.compress(data));

    }
}
