package org.numerator.test.framework;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class to populate the tree structure for the test with given series of input
 * of number elements as {@code String}
 * 
 * @author Sabahattin Kasapoglu
 *
 */
class TreeBuilder {

	private List<TreeNode> listOfNodesAtLevel;

	/**
	 * Constructs the builder and populate with the initial number pressed
	 * 
	 * @throws TestFrameworkException
	 *             when the number is out of bounds
	 */
	TreeBuilder(int number) {
		listOfNodesAtLevel = new LinkedList<>();
		String[] initialElements = TestUtil.elementsOf(number);

		for (int i = 0; i < initialElements.length; i++) {
			listOfNodesAtLevel.add(new TreeNode(initialElements[i], null));
		}
	}

	/**
	 * This method will get the number and retrieve its corresponding values to create
	 * new {@link TreeNode} children items with those values and adds to previous
	 * {@TreeNode} items.
	 * 
	 * @param number
	 *            Number given between [0-9] corresponds to the telephone dial
	 *            numbers
	 */
	void addNumber(int number) {

		String[] elementsOfNumber = TestUtil.elementsOf(number);
		List<TreeNode> tempList = new LinkedList<TreeNode>();

		for (int i = 0; i < elementsOfNumber.length; i++) {

			for (TreeNode parentItem : listOfNodesAtLevel) {
				tempList.add(parentItem.addChild(elementsOfNumber[i]));
			}

		}

		listOfNodesAtLevel.clear();
		listOfNodesAtLevel.addAll(tempList);
	}

	/**
	 * Retrieves the possible number of counted elements derived with the given
	 * sequence of numbers
	 * 
	 * @return count of the possible combinations
	 */
	int countOfCombinations() {
		return listOfNodesAtLevel.size();
	}

	/**
	 * Returns the list of the nodes at given depth of the tree
	 */
	List<TreeNode> getListOfCurrentNodes() {
		return listOfNodesAtLevel;
	}
	
	
	/**
	 * Returns the combination as list
	 */
	List<String> getCombinations() {
		return listOfNodesAtLevel.stream()
                .map(TreeNode::getValue)
                .collect(Collectors.toList());
	
	}

}
