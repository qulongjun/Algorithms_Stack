package org.dataStructure.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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

	/**
	 * ǰ����� �ݹ�ⷨ
	 * 
	 * ��1�����������Ϊ�գ��ղ��� ��2�������������Ϊ�գ����ʸ��ڵ㣬ǰ�������������ǰ�����������
	 */
	public void PreorderTraversalRec(BinaryTreeNode root) {
		if (root == null)
			return;
		System.out.println(root.m_nValue);
		PreorderTraversalRec(root.m_pLeft);
		PreorderTraversalRec(root.m_pRight);
	}

	/**
	 * ǰ����� �����ⷨ
	 * 
	 * ʹ��Stackģ��
	 * 
	 * �ؼ��㣺��ջ��ʱ��Ҫ��ѹ���Һ��ӣ�Ȼ��ѹ�����ӣ�������ջ��ʱ�����������ǰ���Һ����ں�
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
	 * ������� �ݹ�ⷨ
	 * 
	 * ��1�����������Ϊ�գ��ղ��� ��2�������������Ϊ�գ�������������������ʸ��ڵ㣬�������������
	 */
	public void InorderTraversalRec(BinaryTreeNode root) {
		if (root == null)
			return;
		InorderTraversalRec(root.m_pLeft);
		System.out.println(root.m_nValue);
		InorderTraversalRec(root.m_pRight);
	}

	/**
	 * ������� �����ⷨ
	 * 
	 * ʹ��Stackģ��
	 * 
	 * @param root
	 */
	public void InorderTraversal(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> treeNodeStack = new Stack<BinaryTreeNode>();
		BinaryTreeNode treeNode = root;
		while (true) {
			while (treeNode != null) {// ��ѭ�������дӸ���Ҷ�ӽ��������������ŵ���ջ�У���ջ��ʱ��ͻ�����Ҷ�ӽ��
				treeNodeStack.push(treeNode);
				treeNode = treeNode.m_pLeft;
			}// ���������whileѭ��ʱ��treeNodeΪnull����ΪҶ�ӽ�㣬��˵����û�����㣬Ҳû���ҽ��
			if (treeNodeStack.isEmpty()) {
				break;
			}
			treeNode = treeNodeStack.pop();// ���ý���ջ
			System.out.println(treeNode.m_nValue);
			treeNode = treeNode.m_pRight;// ָ���ҽ������������
		}

	}

	/**
	 * ������� �ݹ�ⷨ
	 * 
	 * ��1�����������Ϊ�գ��ղ��� ��2�������������Ϊ�գ����������������������������������ʸ��ڵ�
	 */
	public void PostorderTraversalRec(BinaryTreeNode root) {
		if (root == null)
			return;
		PostorderTraversalRec(root.m_pLeft);
		PostorderTraversalRec(root.m_pRight);
		System.out.println(root.m_nValue);
	}

	/**
	 * �������� �ݹ�ⷨ binaryTreeNodeStack��ջ˳��Ϊ��>��>�ң���ջ˳��Ϊ��>��>��(���ȳ�ջ��Ȼ�󽫸ý������ҽ����ջ)
	 * 
	 * outPut������ת����������ջ˳��Ϊ��>��>�󣬳�ջ˳��Ϊ��>��>��
	 * 
	 * @param root
	 */
	public void PostorderTraversal(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> binaryTreeNodeStack = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> outPut = new Stack<BinaryTreeNode>(); // ��ת��һ�����
		binaryTreeNodeStack.push(root);
		while (!binaryTreeNodeStack.isEmpty()) {
			BinaryTreeNode treeNode = binaryTreeNodeStack.pop();// ���ڵ��ջ
			System.out.println(treeNode.m_nValue);
			outPut.push(treeNode);
			if (treeNode.m_pLeft != null) {// ������ջ
				binaryTreeNodeStack.push(treeNode.m_pLeft);
			}
			if (treeNode.m_pRight != null) {// �ҽ����ջ
				binaryTreeNodeStack.push(treeNode.m_pRight);
			}
		}
		while (!outPut.isEmpty()) { //��ջ˳��Ϊ��>��>�󣬳�ջ˳��Ϊ��>��>��
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
		BinaryTreeNode treeNode0 = new BinaryTreeNode(0, treeNode1, treeNode2); // root���

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
