package tree.no590postorder;

import javafx.collections.transformation.SortedList;

import java.util.ArrayList;
import java.util.List;


public class Solution {

    List<Integer> result = null;
    List<Integer> result2 = new ArrayList<>();
    List<List<Integer>> results = new ArrayList<>();

    public List<Integer> postorder(Node root) {

        if (null == root) {
            return new ArrayList<Integer>();
        }
        result = new ArrayList<>();
        result.add(root.val);
        results.add(result);
        postorderLoop(root.children);


        for (int i = results.size() - 1; i >= 0; i--) {
            if (null == results.get(i)) {
                continue;
            }
            for (int j : results.get(i)) {
                result2.add(j);
            }
        }
        return result2;
    }

    private List<Integer> postorderLoop(List<Node> nodes) {

        if (null == nodes) {
            return null;
        }

        result = new ArrayList<>();
        for (Node node : nodes) {
            results.add(postorderLoop(node.children));
            result.add(node.val);
        }

        return result;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node.children = new ArrayList<Node>();
        node.children.add(node3);
        node.children.add(node2);
        node.children.add(node4);
        node3.children = new ArrayList<Node>();
        node3.children.add(node5);
        node3.children.add(node6);

        for (Integer i : new Solution().postorder(node)) {
            System.out.println(i + ",");
        }

    }
}


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};