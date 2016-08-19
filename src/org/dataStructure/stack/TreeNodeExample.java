package org.dataStructure.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import org.junit.Test;

/**
 * 二叉树常用考点整理
 * 
 * @author 瞿龙俊
 * 
 */
public class TreeNodeExample {
	/**
	 * 求二叉树中的节点个数（递归解法O(N)）
	 * 
	 * （1）如果二叉树为空，节点个数为0 （2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
	 * 
	 * @return 二叉树结点个数
	 */
	public int GetNodeNumRec(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		return GetNodeNumRec(root.m_pLeft) + GetNodeNumRec(root.m_pRight) + 1;
	}

	/**
	 * 求二叉树中的节点个数（迭代解法O(N)）
	 * 
	 * @return
	 */
	public int GetNodeNum(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<BinaryTreeNode> treeNodeQueue = new LinkedList<BinaryTreeNode>();
		int count = 1;
		treeNodeQueue.add(root);
		while (!treeNodeQueue.isEmpty()) {
			BinaryTreeNode treeNode = treeNodeQueue.remove();
			if (treeNode.m_pLeft != null) {
				treeNodeQueue.add(treeNode.m_pLeft);
				count++;
			}
			if (treeNode.m_pRight != null) {
				treeNodeQueue.add(treeNode.m_pRight);
				count++;
			}

		}
		return count;
	}

	/**
	 * 求二叉树的深度（高度） 递归解法（O(N)）
	 * 
	 * （1）如果二叉树为空，二叉树的深度为0 （2）如果二叉树不为空，二叉树的深度 = max(左子树深度， 右子树深度) + 1
	 * 
	 * @param root
	 * @return
	 */
	public int GetDepthRec(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = GetDepthRec(root.m_pLeft);
		int rightDepth = GetDepthRec(root.m_pRight);
		return Math.max(leftDepth, rightDepth) + 1;
	}

	/**
	 * 求二叉树的深度（高度） 迭代解法（O(N)） 用一个Queue存储结点，根节点入队列，然后出队列的时候，把该结点的左右结点入队列，
	 * 用一个变量记录当前层的结点，另一个变量记录下一层的结点。当前层变量为0的时候，表示当前层全部出队列。
	 * 
	 * @param root
	 * @return
	 */
	public int GetDepth(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<BinaryTreeNode> treeNodeQueue = new LinkedList<BinaryTreeNode>();
		int depth = 0;
		int currentLevelNode = 1;// 当前层结点数，root为1个
		int nextLevelNode = 0;
		treeNodeQueue.add(root);
		while (!treeNodeQueue.isEmpty()) {
			BinaryTreeNode treeNode = treeNodeQueue.remove();
			currentLevelNode--;
			if (treeNode.m_pLeft != null) {
				treeNodeQueue.add(treeNode.m_pLeft);
				nextLevelNode++;
			}
			if (treeNode.m_pRight != null) {
				treeNodeQueue.add(treeNode.m_pRight);
				nextLevelNode++;
			}
			if (currentLevelNode == 0) {
				depth++;
				currentLevelNode = nextLevelNode;
				nextLevelNode = 0;
			}
		}
		return depth;
	}

	/**
	 * 前序遍历 递归解法
	 * 
	 * （1）如果二叉树为空，空操作 （2）如果二叉树不为空，访问根节点，前序遍历左子树，前序遍历右子树
	 */
	public void PreorderTraversalRec(BinaryTreeNode root) {
		if (root == null)
			return;
		System.out.println(root.m_nValue);
		PreorderTraversalRec(root.m_pLeft);
		PreorderTraversalRec(root.m_pRight);
	}

	/**
	 * 前序遍历 迭代解法
	 * 
	 * 使用Stack模拟
	 * 
	 * 关键点：入栈的时候，要先压入右孩子，然后压入左孩子，这样出栈的时候才是左孩子在前，右孩子在后
	 * 
	 * @param root
	 */
	public void PreorderTraversal(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> treeNodeStack = new Stack<BinaryTreeNode>();
		treeNodeStack.push(root);
		while (!treeNodeStack.isEmpty()) {
			BinaryTreeNode treeNode = treeNodeStack.pop();
			System.out.println(treeNode.m_nValue);
			if (treeNode.m_pRight != null) {
				treeNodeStack.push(treeNode.m_pRight);
			}
			if (treeNode.m_pLeft != null) {
				treeNodeStack.push(treeNode.m_pLeft);
			}
		}

	}

	/**
	 * 中序遍历 递归解法
	 * 
	 * （1）如果二叉树为空，空操作 （2）如果二叉树不为空，中序遍历左子树，访问根节点，中序遍历右子树
	 */
	public void InorderTraversalRec(BinaryTreeNode root) {
		if (root == null)
			return;
		InorderTraversalRec(root.m_pLeft);
		System.out.println(root.m_nValue);
		InorderTraversalRec(root.m_pRight);
	}

	/**
	 * 中序遍历 迭代解法
	 * 
	 * 使用Stack模拟
	 * 
	 * @param root
	 */
	public void InorderTraversal(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> treeNodeStack = new Stack<BinaryTreeNode>();
		BinaryTreeNode treeNode = root;
		while (true) {
			while (treeNode != null) {// 该循环把所有从根到叶子结点的所有左子树放到了栈中，出栈的时候就会先左叶子结点
				treeNodeStack.push(treeNode);
				treeNode = treeNode.m_pLeft;
			}// 当跳出这个while循环时，treeNode为null，即为叶子结点，则说明它没有左结点，也没有右结点
			if (treeNodeStack.isEmpty()) {
				break;
			}
			treeNode = treeNodeStack.pop();// 将该结点出栈
			System.out.println(treeNode.m_nValue);
			treeNode = treeNode.m_pRight;// 指向右结点进行左结点遍历
		}

	}

	/**
	 * 后序遍历 递归解法
	 * 
	 * （1）如果二叉树为空，空操作 （2）如果二叉树不为空，后序遍历左子树，后序遍历右子树，访问根节点
	 */
	public void PostorderTraversalRec(BinaryTreeNode root) {
		if (root == null)
			return;
		PostorderTraversalRec(root.m_pLeft);
		PostorderTraversalRec(root.m_pRight);
		System.out.println(root.m_nValue);
	}

	/**
	 * 后续遍历 递归解法 binaryTreeNodeStack进栈顺序为根>左>右，出栈顺序为根>右>左(根先出栈，然后将该结点的左右结点入栈)
	 * 
	 * outPut用来翻转输出结果，进栈顺序为根>右>左，出栈顺序为左>右>根
	 * 
	 * @param root
	 */
	public void PostorderTraversal(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> binaryTreeNodeStack = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> outPut = new Stack<BinaryTreeNode>(); // 翻转第一个输出
		binaryTreeNodeStack.push(root);
		while (!binaryTreeNodeStack.isEmpty()) {
			BinaryTreeNode treeNode = binaryTreeNodeStack.pop();// 根节点出栈
			System.out.println(treeNode.m_nValue);
			outPut.push(treeNode);
			if (treeNode.m_pLeft != null) {// 左结点入栈
				binaryTreeNodeStack.push(treeNode.m_pLeft);
			}
			if (treeNode.m_pRight != null) {// 右结点入栈
				binaryTreeNodeStack.push(treeNode.m_pRight);
			}
		}
		while (!outPut.isEmpty()) { //进栈顺序为根>右>左，出栈顺序为左>右>根
			System.out.println(outPut.pop().m_nValue + " ");
		}
	}

	@Test
	public void testNode() throws Exception {
		BinaryTreeNode treeNode12 = new BinaryTreeNode(12, null, null);
		BinaryTreeNode treeNode11 = new BinaryTreeNode(11, null, null);
		BinaryTreeNode treeNode10 = new BinaryTreeNode(10, null, null);
		BinaryTreeNode treeNode9 = new BinaryTreeNode(9, null, null);
		BinaryTreeNode treeNode8 = new BinaryTreeNode(8, null, null);
		BinaryTreeNode treeNode7 = new BinaryTreeNode(7, null, null);
		BinaryTreeNode treeNode6 = new BinaryTreeNode(6, null, null);
		BinaryTreeNode treeNode5 = new BinaryTreeNode(5, treeNode11, treeNode12);
		BinaryTreeNode treeNode4 = new BinaryTreeNode(4, treeNode9, treeNode10);
		BinaryTreeNode treeNode3 = new BinaryTreeNode(3, treeNode7, treeNode8);
		BinaryTreeNode treeNode2 = new BinaryTreeNode(2, treeNode5, treeNode6);
		BinaryTreeNode treeNode1 = new BinaryTreeNode(1, treeNode3, treeNode4);
		BinaryTreeNode treeNode0 = new BinaryTreeNode(0, treeNode1, treeNode2); // root结点

		// System.out.println(GetNodeNumRec(treeNode0));// 13
		// System.out.println(GetNodeNum(treeNode0));// 13
		// System.out.println(GetDepthRec(treeNode0));// 4
		// System.out.println(GetDepth(treeNode0));// 4
		// PreorderTraversalRec(treeNode0);// 0,1,3,7,8,4,9,10,2,5,11,12,6
		// PreorderTraversalRec(treeNode0);// 0,1,3,7,8,4,9,10,2,5,11,12,6
		// InorderTraversalRec(treeNode0);// 7,3,8,1,9,4,10,0,11,5,12,2,6
		// InorderTraversal(treeNode0);// 7,3,8,1,9,4,10,0,11,5,12,2,6
		// PostorderTraversalRec(treeNode0);// 7,8,3,9,10,4,1,11,12,5,6,2,0
		PostorderTraversal(treeNode0);
	}

}

/**
 * 二叉树数据结构
 * 
 * @author 瞿龙俊
 * 
 */
class BinaryTreeNode {
	int m_nValue;// 当前节点值
	BinaryTreeNode m_pLeft;// 左子树节点
	BinaryTreeNode m_pRight;// 右子树节点

	// 构造函数
	public BinaryTreeNode(int m_nValue) {
		this.m_nValue = m_nValue;
	}

	// 构造函数
	public BinaryTreeNode(int m_nValue, BinaryTreeNode m_pLeft,
			BinaryTreeNode m_pRight) {
		this.m_nValue = m_nValue;
		this.m_pLeft = m_pLeft;
		this.m_pRight = m_pRight;
	}

}
