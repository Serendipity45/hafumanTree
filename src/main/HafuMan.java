package main;

import java.util.HashMap;
import java.util.Map;

public class HafuMan {
    // 主函数，用于测试
    public static void main(String[] args) {
        HuffmanCodingImpl huffmanCoding = new HuffmanCodingImpl();
        Map<Character, Integer> frequency = new HashMap<>();
        frequency.put('A', 30);
        frequency.put('B', 25);
        frequency.put('C', 20);
        frequency.put('D', 10);
        frequency.put('E', 10);
        frequency.put('F', 5);

        HuffmanNode root = huffmanCoding.buildTree(frequency);
        huffmanCoding.generateCode(root, "");

        System.out.println("哈夫曼编码为: " + huffmanCoding.getCodes());
    }
}
