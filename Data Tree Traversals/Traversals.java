import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    	public List<T> preorder(TreeNode<T> root) {
		List<T> list = new ArrayList<>();
		if (root != null) {
			list.add(root.getData());
			list.addAll(preorder(root.getLeft()));
			list.addAll(preorder(root.getRight()));
		}
		return list;
    	}

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    	public List<T> inorder(TreeNode<T> root) {
		List<T> list = new ArrayList<>();
		if (root != null) {
			list.addAll(inorder(root.getLeft()));
			list.add(root.getData());
			list.addAll(inorder(root.getRight()));
		}
		return list;
    	}

    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    	public List<T> postorder(TreeNode<T> root) {
        	List<T> list = new ArrayList<>();
		if (root != null) {
			list.addAll(postorder(root.getLeft()));
			list.addAll(postorder(root.getRight()));
			list.add(root.getData());
		}
		return list;
    	}

	public static void main(String[] args) {
		Traversals tree = new Traversals();

		TreeNode<Integer> root = new TreeNode<>(50);
		TreeNode<Integer> a = new TreeNode<>(25);
    		TreeNode<Integer> b = new TreeNode<>(10);
    		TreeNode<Integer> c = new TreeNode<>(100);
    		TreeNode<Integer> d = new TreeNode<>(75);
    		TreeNode<Integer> e = new TreeNode<>(125);
    		TreeNode<Integer> f = new TreeNode<>(110);

    		root.setLeft(a);
    		a.setLeft(b);
    		root.setRight(c);
    		c.setLeft(d);
    		c.setRight(e);
    		e.setLeft(f);

		List preorder_list = tree.preorder(root);
		List postorder_list = tree.postorder(root);
		List inorder_list = tree.inorder(root);
		System.out.println(postorder_list);
	}
}