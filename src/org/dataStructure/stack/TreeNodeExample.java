package org.dataStructure.stack;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

		System.out.println(GetNodeNumRec(treeNode0));// 13
		System.out.println(GetNodeNum(treeNode0));// 13

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
