package impl;

import main.HuffmanNode;

import java.util.Map;

public interface HuffmanCoding {

    //建造哈夫曼树方法
    HuffmanNode buildTree(Map<Character, Integer> frequency);//将返回一个哈夫曼树的根节点

    //生成哈夫曼树编码方法
    void generateCode(HuffmanNode root, String code);//

    //返回哈夫曼树编码方法
    Map<Character, String> getCodes();
}