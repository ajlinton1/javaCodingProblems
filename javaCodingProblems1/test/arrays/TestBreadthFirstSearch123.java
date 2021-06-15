package arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

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

        var target = 5;
        var found = search(target, root);
        Assert.assertTrue(found);
    }

    boolean search(int target, Node root) {
        if (root==null) {
            return false;
        } else {
            Deque<Node> stack = new ArrayDeque<>();

            if (root.v==target) {
                return true;
            } else {

                if (root.left != null) {
                    stack.push(root.left);
                }
                if (root.right != null) {
                    stack.push(root.right);
                }

                while (!stack.isEmpty()) {
                    Node node = stack.pop();
                    return search(target, node);
                }

            }
        }
        return false;
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
