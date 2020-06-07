package tree.no590postorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public List<Integer> postorder(Node root) {
        LinkedList<Node> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            output.addFirst(node.val);
            for (Node item : node.children) {
                if (item != null) {
                    stack.add(item);
                }
            }
        }
        return output;
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

        for (Integer i : new Solution2().postorder(node)) {
            System.out.println(i + ",");
        }

    }
}
