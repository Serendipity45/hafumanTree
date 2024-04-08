package main;

import impl.HuffmanCoding;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCodingImpl implements HuffmanCoding {
    private Map<Character, String> codes = new HashMap<>();//存储每个节点的hafuman编码

    @Override
    public HuffmanNode buildTree(Map<Character, Integer> frequency) {
        PriorityQueue<HuffmanNode> queue = new PriorityQueue<>(frequency.size(), new MyComparator());//new main.MyComparator()自定义比较器
                                                                                                      //由小到大排序
        //节点入栈
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {//Entry：键值对变量
            HuffmanNode hn = new HuffmanNode(entry.getKey(), entry.getValue());
            queue.add(hn);
        }

        //构造哈夫曼树
        while (queue.size() > 1) {
            HuffmanNode x = queue.poll();//出栈
            HuffmanNode y = queue.poll();//出栈
            HuffmanNode sum = new HuffmanNode('-', x.frequency + y.frequency);
            sum.left = x;
            sum.right = y;
            queue.add(sum);
        }//结束条件，只剩下一个节点

        return queue.poll();//返回根节点
    }

    @Override
    public void generateCode(HuffmanNode root, String code) {//递归方法，左0，右1
        if (root.left == null && root.right == null && Character.isLetter(root.data)) {//isLetter方法，判断是否为字母
            codes.put(root.data, code);//如果是叶子节点，且是字母就添加到哈夫曼树编码codes中
            return;//递归结束条件---当前节点是叶子节点
        }
        if (root.left != null) {
            generateCode(root.left, code + "0");
        }
        if (root.right != null) {
            generateCode(root.right, code + "1");
        }
    }

    @Override
    public Map<Character, String> getCodes() {
        return codes;
    }

}