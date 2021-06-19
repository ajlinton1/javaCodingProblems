package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class TestBreadthFirstSearch123 {

    @Test
    public void testBreadthFirstSearch() {
        Node root = null;
        root = insert(3, root);
        root = insert(1, root);
        root = insert(7, root);
        root = insert(8, root);
        root = insert(2, root);
        root = insert(5, root);
        root = insert(9, root);
        root = insert(6, root);
        root = insert(4, root);

        Assert.assertNotNull(root);

        var target = 15;

        var visited = new ArrayList<Node>();
        var queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            var node = queue.poll();
            System.out.println(node.v);
            if (node.v==target) {
                System.out.println("Found");
                return;
            }
            if (!visited.contains(node)) {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                visited.add(node);
            }
        }
    }

    Node insert(int v, Node root) {
        if (root==null) {
            root = new Node(v);
        } else if (v < root.v) {
            root.left = insert(v, root.left);
        } else {
            root.right = insert(v, root.right);
        }
        return root;
    }

}
