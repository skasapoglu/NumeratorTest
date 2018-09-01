package org.numerator.test.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is for holding each selected numeric elements and the
 * corresponding leafs of the tree will be the {@link char} elements like for
 * numeric 3 leafs {D, E, F}
 * 
 * @author Sabahattin Kasapoglu
 *
 */
class TreeNode {

	private String value;
	private List<TreeNode> children;
	private TreeNode parentNode;

	TreeNode(String value, TreeNode parentNode) {
		this.value = value;
		this.children = new ArrayList<>();
		this.parentNode = parentNode;
	}

	/**
	 * Adds child node to a particular selected (parent node) and sets the value of
	 * child concatenated with the parent node's value
	 * 
	 * @param value
	 *            the value element for the child node
	 * @return instance of {@code TreeNode} as child node
	 */
	TreeNode addChild(String value) {

		TreeNode newChild = new TreeNode(this.getValue() + value , this);
		children.add(newChild);
		return newChild;
	}

	String getValue() {
		return this.value;
	}

	TreeNode getParentNode() {
		return parentNode;
	}

}
