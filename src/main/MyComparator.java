package main;

import java.util.Comparator;

class MyComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.frequency - y.frequency;//x<y  x排字y前面
                                         //y<x  y排字x后面
    }
}