package org.dataStructure.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * ���������ÿ�������
 * 
 * @author ������
 * 
 */
public class TreeNodeExample {
	/**
	 * ��������еĽڵ�������ݹ�ⷨO(N)��
	 * 
	 * ��1�����������Ϊ�գ��ڵ����Ϊ0 ��2�������������Ϊ�գ��������ڵ���� = �������ڵ���� + �������ڵ���� + 1
	 * 
	 * @return ������������
	 */
	public int GetNodeNumRec(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}
		return GetNodeNumRec(root.m_pLeft) + GetNodeNumRec(root.m_pRight) + 1;
	}

	/**
	 * ��������еĽڵ�����������ⷨO(N)��
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
	 * �����������ȣ��߶ȣ� �ݹ�ⷨ��O(N)��
	 * 
	 * ��1�����������Ϊ�գ������������Ϊ0 ��2�������������Ϊ�գ������������ = max(��������ȣ� ���������) + 1
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
	 * �����������ȣ��߶ȣ� �����ⷨ��O(N)�� ��һ��Queue�洢��㣬���ڵ�����У�Ȼ������е�ʱ�򣬰Ѹý������ҽ������У�
	 * ��һ��������¼��ǰ��Ľ�㣬��һ��������¼��һ��Ľ�㡣��ǰ�����Ϊ0��ʱ�򣬱�ʾ��ǰ��ȫ�������С�
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
		int currentLevelNode = 1;// ��ǰ��������rootΪ1��
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
		BinaryTreeNode treeNode0 = new BinaryTreeNode(0, treeNode1, treeNode2); // root���

		System.out.println(GetNodeNumRec(treeNode0));// 13
		System.out.println(GetNodeNum(treeNode0));// 13
		System.out.println(GetDepthRec(treeNode0));// 4
		System.out.println(GetDepth(treeNode0));// 4

	}

}

/**
 * ���������ݽṹ
 * 
 * @author ������
 * 
 */
class BinaryTreeNode {
	int m_nValue;// ��ǰ�ڵ�ֵ
	BinaryTreeNode m_pLeft;// �������ڵ�
	BinaryTreeNode m_pRight;// �������ڵ�

	// ���캯��
	public BinaryTreeNode(int m_nValue) {
		this.m_nValue = m_nValue;
	}

	// ���캯��
	public BinaryTreeNode(int m_nValue, BinaryTreeNode m_pLeft,
			BinaryTreeNode m_pRight) {
		this.m_nValue = m_nValue;
		this.m_pLeft = m_pLeft;
		this.m_pRight = m_pRight;
	}

}
