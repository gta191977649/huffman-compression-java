package moe.huffman.utils;

import java.util.HashMap;
import java.util.Map;

public class HuffmanEncoder {
    public static final int AlphabetSize = 256;

    public String compress(String data) {
        int [] freq = buildFreqTable(data);
        HuffmanTree tree = new HuffmanTree(freq);
        Node root = tree.getHuffmanTree();
        Map<Character,String> lookupTable = getLookUptable(root);
        String encodedData = generateEncodedData(data,lookupTable);
        return encodedData;
    }

    private String generateEncodedData(String data, Map<Character,String> lookupTable) {
        StringBuilder strBuilder = new StringBuilder();
        //Get binary data for each char
        for(char character : data.toCharArray()) {
            strBuilder.append(lookupTable.get(character));
        }
        return strBuilder.toString();
    }

    //1: 频率统计
    private int[] buildFreqTable(String data) {
        int[] freq = new int[AlphabetSize];
        for(int character : data.toCharArray()){
            freq[character]++;
        }
        //Debug for print freq table
        /*
        for(int i = 0; i < freq.length; i++){
            if(freq[i] != 0) {
                System.out.println((char) i + ":" + freq[i]);
            }
        }
        */
        return freq;
    }


    ///////////// LookUp table /////////////////
    private Map<Character,String> getLookUptable(Node root) {
        Map<Character,String> lookupTable = new HashMap<>();
        buildLookupTable(root,"",lookupTable);
        return lookupTable;
    }

    private void buildLookupTable(Node node,String s, Map<Character,String> lookUpTable) {
        if(!node.isLeaf()) {
            buildLookupTable(node.getLeft(),s+'0',lookUpTable);
            buildLookupTable(node.getRight(),s+'1',lookUpTable);
        } else {
            lookUpTable.put(node.getCharacter(),s);
        }

    }
}
