package org.dataStructure.stack;

import java.util.ArrayList;
import java.util.Iterator;
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
		while (!outPut.isEmpty()) { // ��ջ˳��Ϊ��>��>�󣬳�ջ˳��Ϊ��>��>��
			System.out.println(outPut.pop().m_nValue + " ");
		}
	}

	/**
	 * ��α��� �ݹ�ⷨ �����ٳ��֡�
	 * 
	 * ����˼������һ�����ArrayList�����������ÿһ���ArrayList�� ���ArrayList��size��level�й�ϵ
	 * 
	 * @param root
	 */
	public void LevelTraversalRec(BinaryTreeNode root) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		dfs(root, 0, ret);
		System.out.println(ret);
	}

	private static void dfs(BinaryTreeNode root, int level,
			ArrayList<ArrayList<Integer>> ret) {
		if (root == null)
			return;
		if (level >= ret.size()) { // �ݹ鵽��һ��
			ret.add(new ArrayList<Integer>());// �´���һ��ArrayList
		}
		ret.get(level).add(root.m_nValue);// ��ǰ���ֵ����ArrayList
		dfs(root.m_pLeft, level + 1, ret);
		dfs(root.m_pRight, level + 1, ret);
	}

	/**
	 * ��α��� ����ʵ��
	 * 
	 * @param root
	 */
	public void LevelTraversal(BinaryTreeNode root) {
		if (root == null)
			return;
		Queue<BinaryTreeNode> binaryTreeNodeQueue = new LinkedList<BinaryTreeNode>();
		binaryTreeNodeQueue.add(root);
		while (!binaryTreeNodeQueue.isEmpty()) {
			BinaryTreeNode treeNode = binaryTreeNodeQueue.poll();
			System.out.println(treeNode.m_nValue);
			if (treeNode.m_pLeft != null) {
				binaryTreeNodeQueue.add(treeNode.m_pLeft);
			}
			if (treeNode.m_pRight != null) {
				binaryTreeNodeQueue.add(treeNode.m_pRight);
			}
		}
	}

	/**
	 * �������������Ϊ�����˫������ Ҫ���ܴ����½ڵ㣬ֻ����ָ�롣���ݹ�ʵ�֡�
	 * http://blog.csdn.net/ljianhui/article/details/22338405
	 * 
	 * @param root
	 * @return
	 */
	public BinaryTreeNode ConvertBST2DLLRec(BinaryTreeNode root) {
		root = convertBST2DLLSubRec(root);
		return root;
	}

	/**
	 * �ݹ�ת��BSTΪ˫������(DLL)
	 * 
	 * ˼�룺ֻ��Ҫ�����ڵ�������������Ҷ�ӽ��������������������������Ҷ�ӽ���������������ɣ����ࣩ
	 * 
	 * @param root
	 * @return
	 */
	public BinaryTreeNode convertBST2DLLSubRec(BinaryTreeNode root) {
		if (root == null || root.m_pLeft == null || root.m_pRight == null)
			return root;
		BinaryTreeNode treeNode = null;
		if (root.m_pLeft != null) {
			treeNode = convertBST2DLLSubRec(root.m_pLeft);
			while (treeNode.m_pRight != null) {
				treeNode = treeNode.m_pRight;
			}
			treeNode.m_pRight = root;
			root.m_pLeft = treeNode;
		}
		if (root.m_pLeft != null) {
			treeNode = convertBST2DLLSubRec(root.m_pRight);
			while (treeNode.m_pLeft != null) {
				treeNode = treeNode.m_pLeft;
			}
			treeNode.m_pLeft = root;
			root.m_pRight = treeNode;
		}

		return root;

	}

	/**
	 * ��˼���� �������������Ϊ�����˫������ Ҫ���ܴ����½ڵ㣬ֻ����ָ�롣������ʵ�֡�
	 * http://blog.csdn.net/ljianhui/article/details/22338405
	 * 
	 * @param root
	 * @return
	 */
	public BinaryTreeNode ConvertBST2DLL(BinaryTreeNode root) {
		if (root == null)
			return null;
		Stack<BinaryTreeNode> binaryTreeNodeStack = new Stack<BinaryTreeNode>();
		BinaryTreeNode curNode = root;// ָ��ǰ������
		BinaryTreeNode oldNode = null;// ָ����һ��������
		BinaryTreeNode head = null;// ����ͷ

		while (true) {
			while (curNode != null) {
				binaryTreeNodeStack.push(curNode);
				curNode = curNode.m_pLeft;
			}

			if (binaryTreeNodeStack.isEmpty()) {
				break;
			}
			curNode = binaryTreeNodeStack.pop();
			if (oldNode != null) {
				oldNode.m_pRight = curNode;
			}
			if (head == null) {
				head = curNode;
			}
			oldNode = curNode;
			curNode = curNode.m_pRight;
		}
		return head;
	}

	/**
	 * ���������K��Ľڵ���� �ݹ�ⷨ��
	 * 
	 * ��1�����������Ϊ�ջ���k<1����0 ��2�������������Ϊ�ղ���k==1������1
	 * ��3�������������Ϊ����k>1������root��������k-1��Ľڵ������root������k-1��ڵ����֮��
	 * 
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public int GetNodeNumKthLevelRec(BinaryTreeNode root, int k) {
		if (root == null || k < 1)
			return 0;
		if (k == 1)
			return 1;
		int leftNodeNum = GetNodeNumKthLevelRec(root.m_pLeft, k - 1);
		int rightNodeNum = GetNodeNumKthLevelRec(root.m_pRight, k - 1);
		return leftNodeNum + rightNodeNum;
	}

	/**
	 * ���������K��Ľڵ���� �����ⷨ��
	 * 
	 * @param root
	 * @param k
	 * @return
	 */
	public int GetNodeNumKthLevel(BinaryTreeNode root, int k) {
		if (root == null)
			return 0;
		Queue<BinaryTreeNode> binaryTreeNodeQueue = new LinkedList<BinaryTreeNode>();
		binaryTreeNodeQueue.add(root);
		int i = 1;
		int currentLevel = 1;
		int nextLevel = 0;
		while (!binaryTreeNodeQueue.isEmpty() && i < k) {
			BinaryTreeNode treeNode = binaryTreeNodeQueue.poll();
			currentLevel--;
			if (treeNode.m_pLeft != null) {
				binaryTreeNodeQueue.add(treeNode.m_pLeft);
				nextLevel++;
			}
			if (treeNode.m_pRight != null) {
				binaryTreeNodeQueue.add(treeNode.m_pRight);
				nextLevel++;
			}
			if (currentLevel == 0) {
				currentLevel = nextLevel;
				nextLevel = 0;
				i++;
			}
		}

		return currentLevel;
	}

	/**
	 * ���������Ҷ�ӽڵ�ĸ������ݹ飩
	 * 
	 * @param root
	 * @return
	 */
	public int GetNodeNumLeafRec(BinaryTreeNode root) {
		if (root == null) // root�����ڣ�����0
			return 0;
		if (root.m_pLeft == null && root.m_pRight == null) { // �ݹ������������������������������
			return 1;
		}
		return GetNodeNumLeafRec(root.m_pLeft)
				+ GetNodeNumLeafRec(root.m_pRight);
	}

	/**
	 * ���������Ҷ�ӽڵ�ĸ�����������
	 * 
	 * @param root
	 * @return
	 */
	public int GetNodeNumLeaf(BinaryTreeNode root) {
		if (root == null)
			return 0;
		Queue<BinaryTreeNode> binaryTreeNodeQueue = new LinkedList<BinaryTreeNode>();
		binaryTreeNodeQueue.add(root);
		int leftNodes = 0;
		while (!binaryTreeNodeQueue.isEmpty()) {
			BinaryTreeNode treeNode = binaryTreeNodeQueue.poll();
			if (treeNode.m_pLeft != null) {
				binaryTreeNodeQueue.add(treeNode.m_pLeft);
			}
			if (treeNode.m_pRight != null) {
				binaryTreeNodeQueue.add(treeNode.m_pRight);
			}
			if (treeNode.m_pLeft == null && treeNode.m_pRight == null) {
				leftNodes++;
			}
		}
		return leftNodes;
	}

	/**
	 * �ж����ö������Ƿ���ͬ����(�ݹ�ⷨ)
	 * 
	 * ��1��������ö�������Ϊ�գ������� ��2��������ö�����һ��Ϊ�գ���һ�ò�Ϊ�գ����ؼ�
	 * ��3��������ö���������Ϊ�գ������Ӧ������������������ͬ�������棬�������ؼ�
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean isSameRec(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		}
		if (root1.m_nValue != root2.m_nValue)
			return false;

		boolean leftSame = isSameRec(root1.m_pLeft, root2.m_pLeft);
		boolean rightSame = isSameRec(root1.m_pRight, root2.m_pRight);
		return leftSame && rightSame;
	}

	/**
	 * �ж����ö������Ƿ���ͬ����(�����ⷨ)
	 * 
	 * 
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean isSame(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		} else if (root1 == null || root2 == null) {
			return false;
		}
		Stack<BinaryTreeNode> binaryTreeNodeStack1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> binaryTreeNodeStack2 = new Stack<BinaryTreeNode>();
		binaryTreeNodeStack1.push(root1);
		binaryTreeNodeStack2.push(root2);
		while (!binaryTreeNodeStack1.isEmpty()
				&& !binaryTreeNodeStack2.isEmpty()) {
			BinaryTreeNode treeNode1 = binaryTreeNodeStack1.pop();
			BinaryTreeNode treeNode2 = binaryTreeNodeStack2.pop();
			if (treeNode1 == null && treeNode2 == null) {
				continue;
			} else if (treeNode1 != null && treeNode2 != null
					&& treeNode1.m_nValue == treeNode2.m_nValue) {
				binaryTreeNodeStack1.push(treeNode1.m_pRight);
				binaryTreeNodeStack1.push(treeNode1.m_pLeft);
				binaryTreeNodeStack2.push(treeNode2.m_pRight);
				binaryTreeNodeStack2.push(treeNode2.m_pLeft);
			} else
				return false;

		}
		return true;

	}

	/**
	 * �ж϶������ǲ���ƽ������� �ݹ�ⷨ��
	 * 
	 * ��1�����������Ϊ�գ������� ��2�������������Ϊ�գ����������������������AVL���������������������߶�������1�������棬�������ؼ�
	 * 
	 * @param root
	 * @return
	 */
	public boolean isAVLRec(BinaryTreeNode root) {
		if (root == null)
			return true;
		// �жϵ�ǰ������������������߶Ȳ��Ƿ����1
		if (Math.abs(GetDepth(root.m_pLeft) - GetDepth(root.m_pRight)) > 1) {
			return false;
		}
		return isAVLRec(root.m_pLeft) && isAVLRec(root.m_pRight);
	}

	/**
	 * ��������ľ��� �ݹ�ʵ��
	 * 
	 * ��1�����������Ϊ�գ����ؿ� ��2�������������Ϊ�գ������������������ľ���Ȼ�󽻻���������������
	 * 
	 * �ƻ�ԭ����������ԭ�������ƻ���
	 * 
	 * @return
	 */
	public BinaryTreeNode MirrorRec(BinaryTreeNode root) {
		if (root == null)
			return null;
		BinaryTreeNode leftTreeNode = MirrorRec(root.m_pLeft);
		BinaryTreeNode rightTreeNode = MirrorRec(root.m_pRight);
		root.m_pLeft = rightTreeNode;
		root.m_pRight = leftTreeNode;
		return root;
	}

	/**
	 * ��������ľ��� �ݹ�ʵ��
	 * 
	 * ��1�����������Ϊ�գ����ؿ� ��2�������������Ϊ�գ������������������ľ���Ȼ�󽻻���������������
	 * 
	 * �����ƻ�ԭ������������һ���µľ�����
	 * 
	 * @return
	 */
	public BinaryTreeNode MirrorCopyRec(BinaryTreeNode root) {
		if (root == null)
			return null;

		BinaryTreeNode leftTreeNode = MirrorRec(root.m_pLeft);
		BinaryTreeNode rightTreeNode = MirrorRec(root.m_pRight);
		BinaryTreeNode treeNode = new BinaryTreeNode(root.m_nValue,
				rightTreeNode, leftTreeNode);
		return treeNode;
	}

	/**
	 * �ж��������Ƿ��ྵ�� �ݹ�ʵ��
	 * 
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean isMirrorRec(BinaryTreeNode root1, BinaryTreeNode root2) {

		if (root1 == null && root2 == null) {
			return true;
		} else {
			if (root1 == null || root2 == null)
				return false;
		}
		if (root1.m_nValue != root2.m_nValue) // �жϸ�ֵ�Ƿ�һ��
			return false;

		// �ж����������Ƿ�һ��
		return isMirrorRec(root1.m_pLeft, root2.m_pRight)
				&& isMirrorRec(root1.m_pRight, root2.m_pLeft);
	}

	/**
	 * ��������ľ��� ����ʵ��
	 * 
	 * 
	 * �ƻ�ԭ����������ԭ�������ƻ���
	 * 
	 * @return
	 */
	public void mirror(BinaryTreeNode root) {
		if (root == null)
			return;
		Stack<BinaryTreeNode> binaryTreeNodeStack = new Stack<BinaryTreeNode>();
		binaryTreeNodeStack.push(root);
		while (!binaryTreeNodeStack.isEmpty()) {
			BinaryTreeNode treeNode = binaryTreeNodeStack.pop();
			BinaryTreeNode temp = treeNode.m_pLeft;
			treeNode.m_pLeft = treeNode.m_pRight;
			treeNode.m_pRight = temp;
			if (treeNode.m_pRight != null) {
				binaryTreeNodeStack.push(treeNode.m_pRight);
			}
			if (treeNode.m_pLeft != null) {
				binaryTreeNodeStack.push(treeNode.m_pLeft);
			}
		}
	}

	/**
	 * ��������ľ��� ����ʵ��
	 * 
	 * �����ƻ�ԭ������������һ���µľ�����
	 * 
	 * @param root
	 * @return
	 */
	public BinaryTreeNode MirrorCopy(BinaryTreeNode root) {
		if (root == null)
			return null;
		Stack<BinaryTreeNode> binaryTreeNodeStack = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> newStack = new Stack<BinaryTreeNode>();
		binaryTreeNodeStack.push(root);
		BinaryTreeNode newRoot = new BinaryTreeNode(root.m_nValue);
		newStack.push(newRoot);
		while (!binaryTreeNodeStack.isEmpty()) {
			BinaryTreeNode treeNode = binaryTreeNodeStack.pop(); // ���ȳ�ջ
			BinaryTreeNode newTreeNode = newStack.pop();
			if (treeNode.m_pRight != null) { // ��������ջ
				binaryTreeNodeStack.push(treeNode.m_pRight);
				newTreeNode.m_pLeft = new BinaryTreeNode(
						treeNode.m_pRight.m_nValue);
				newStack.push(newTreeNode.m_pLeft);

			}
			if (treeNode.m_pLeft != null) {// ��������ջ
				binaryTreeNodeStack.push(treeNode.m_pLeft);
				newTreeNode.m_pRight = new BinaryTreeNode(
						treeNode.m_pLeft.m_nValue);
				newStack.push(newTreeNode.m_pRight);

			}
		}
		return newRoot;
	}

	/**
	 * ��������������ڵ����͹������Ƚڵ� �ݹ�ⷨ
	 * 
	 * ��1����������ڵ�ֱ��ڸ��ڵ�������������������򷵻ظ��ڵ�
	 * ��2����������ڵ㶼������������ݹ鴦������������������ڵ㶼������������ݹ鴦��������
	 * 
	 * 
	 * @param root
	 * @param n1
	 * @param n2
	 * @return
	 */
	public BinaryTreeNode GetLastCommonParentRec(BinaryTreeNode root,
			BinaryTreeNode n1, BinaryTreeNode n2) {
		if (findNodeRec(root.m_pLeft, n1)) {
			if (findNodeRec(root.m_pRight, n2)) {
				return root;
			} else {
				return GetLastCommonParentRec(root.m_pLeft, n1, n2);
			}
		} else {
			if (findNodeRec(root.m_pLeft, n2)) {
				return root;
			} else {
				return GetLastCommonParentRec(root.m_pRight, n1, n2);
			}
		}
	}

	/**
	 * �����������ж�һ�����Ƿ�������
	 * 
	 * ��rootΪnull����treeNodeΪnull����ֱ�ӷ���false
	 * 
	 * @param root
	 * @param treeNode
	 * @return
	 */
	private boolean findNodeRec(BinaryTreeNode root, BinaryTreeNode treeNode) {
		if (root == null || treeNode == null)
			return false;
		if (root == treeNode) // �ݹ����������root��treeNode���
			return true;
		// �ݹ�����������к����������Ƿ��и�ֵ
		return findNodeRec(root.m_pLeft, treeNode)
				|| findNodeRec(root.m_pRight, treeNode);
	}

	public BinaryTreeNode GetLastCommonParentRec2(BinaryTreeNode root,
			BinaryTreeNode n1, BinaryTreeNode n2) {
		if (root == null)
			return null;
		if (root == n1 || root == n2) { // ���������ݹ飬�жϵ�ǰ����Ƿ��n1���ߺ�n2һ��
			return root;
		}
		BinaryTreeNode leftTreeNode = GetLastCommonParentRec2(root.m_pLeft, n1,
				n2);// ������������n1����n2���
		BinaryTreeNode rightTreeNode = GetLastCommonParentRec2(root.m_pRight,
				n1, n2);// ������������N1����N2
		if (leftTreeNode != null && rightTreeNode != null) {
			// ������������������һ������˵�����������Ϊroot
			return root;
		}
		if (leftTreeNode != null)// ���������Ϊ�գ���˵����������
			return leftTreeNode;
		return rightTreeNode;
	}

	/**
	 * ��������������ڵ����͹������Ƚڵ� �����ⷨ
	 * 
	 * ����Ӹ��ڵ㵽�����ڵ��·����Ȼ���ٱȽ϶�Ӧ·���Ľڵ���У����һ����ͬ�Ľڵ�Ҳ���������ڶ������е���͹������Ƚڵ�
	 * 
	 * @param root
	 * @param n1
	 * @param n2
	 * @return
	 */
	public BinaryTreeNode GetLastCommonParent(BinaryTreeNode root,
			BinaryTreeNode n1, BinaryTreeNode n2) {
		if (root == null)
			return null;
		ArrayList<BinaryTreeNode> n1List = new ArrayList<BinaryTreeNode>();
		boolean n1Path = getNodePath(root, n1, n1List);
		ArrayList<BinaryTreeNode> n2List = new ArrayList<BinaryTreeNode>();
		boolean n2Path = getNodePath(root, n2, n2List);

		BinaryTreeNode last = null;
		if (!n1Path || !n2Path)
			return null;
		Iterator<BinaryTreeNode> node_it1 = n1List.iterator();
		Iterator<BinaryTreeNode> node_it2 = n2List.iterator();
		while (node_it1.hasNext() && node_it2.hasNext()) {
			BinaryTreeNode treeNode_1 = node_it1.next();
			BinaryTreeNode treeNode_2 = node_it2.next();
			if (treeNode_1 == treeNode_2) {
				last = treeNode_1;
			} else {
				break;
			}
		}

		return last;
	}

	/**
	 * �Ӹ��ڵ㵽node���·�������еĽ�㶼��ӵ�path·����
	 * 
	 * @param root
	 * @param node
	 * @param nodeList
	 * @return
	 */
	private boolean getNodePath(BinaryTreeNode root, BinaryTreeNode node,
			ArrayList<BinaryTreeNode> path) {
		if (root == null)
			return false;
		path.add(root); // ������ڵ�ӵ�·����
		if (root == node) {
			return true;
		}
		boolean find = getNodePath(root.m_pLeft, node, path);// ��������������
		if (!find) { // ���û�ҵ���������������
			find = getNodePath(root.m_pRight, node, path);
		}
		if (!find) { // ���ʵ��û�ҵ�֤������ڵ㲻��·���У�˵���ղ���ӽ�ȥ�Ĳ���·���ϵĽڵ㣬ɾ����
			path.remove(root);
		}
		return find;
	}

	/**
	 * ��������нڵ�������� ���������������Զ�������ڵ�֮��ľ��룬�ݹ�ⷨ
	 * 
	 * ��1�����������Ϊ�գ�����0��ͬʱ��¼������������������ȣ���Ϊ0
	 * ��2�������������Ϊ�գ�������Ҫô���������е������룬Ҫô���������е������룬
	 * Ҫô���������ڵ��е����ڵ��������+�������ڵ��е����ڵ�������룬ͬʱ��¼���������������ڵ��е����ڵ�������롣
	 * 
	 * 
	 * ����һ�������������������������:
	 * 
	 * ���A: ·������������������ڵ㣬ͨ�����ڵ㣬�ٵ�������������ڵ㡣 ���B: ·�����������ڵ㣬��������������������������·����ȡ����ߡ�
	 * ֻ��Ҫ���������������·�����룬��ȡ����ߣ����Ǹö�������������
	 * 
	 * @param root
	 * @return
	 */
	public Result GetMaxDistanceRec(BinaryTreeNode root) {
		if (root == null) {
			Result empty = new Result(0, -1); // Ŀ�����õ��÷� +1 �󣬰ѵ�ǰ�Ĳ����ڵ�
												// (NULL)��������������Ϊ 0
			return empty;
		}
		Result lResult = GetMaxDistanceRec(root.m_pLeft);
		Result rResult = GetMaxDistanceRec(root.m_pRight);
		Result res = new Result();
		res.maxDepth = Math.max(lResult.maxDepth, rResult.maxDepth) + 1; // ��ǰ������
		// ȡ���A�����B�нϴ�ֵ
		res.maxDistance = Math.max(lResult.maxDepth + rResult.maxDepth,
				Math.max(lResult.maxDistance, rResult.maxDistance));
		return res;
	}

	/**
	 * ��ǰ��������к�������������ؽ�������
	 * 
	 * @param preOrder
	 * @param inOrder
	 * @return
	 */
	public BinaryTreeNode RebuildBinaryTreeRec(List<Integer> preOrder,
			List<Integer> inOrder) {

		BinaryTreeNode root = null;
		List<Integer> leftPreOrder;
		List<Integer> rightPreOrder;
		List<Integer> leftInorder;
		List<Integer> rightInorder;
		int inorderPos;
		int preorderPos;
		if ((preOrder.size() != 0) && (inOrder.size() != 0)) {
			// ��preorder�ĵ�һ��Ԫ����Ϊroot
			root = new BinaryTreeNode(preOrder.get(0));
			// ֪��root�ڵ㣬���Ը���root�ڵ�λ�ã���preorder��inorder�ֱ𻮷�Ϊ root�����Ҳ� ������������
			inorderPos = inOrder.indexOf(preOrder.get(0)); // inorder���еķָ��
			leftInorder = inOrder.subList(0, inorderPos);
			rightInorder = inOrder.subList(inorderPos + 1, inOrder.size());
			preorderPos = leftInorder.size(); // preorder���еķָ��
			leftPreOrder = preOrder.subList(1, preorderPos + 1);
			rightPreOrder = preOrder.subList(preorderPos + 1, preOrder.size());
			root.m_pLeft = RebuildBinaryTreeRec(leftPreOrder, leftInorder); // root������������preorder��inorder�����������γɵ���
			root.m_pRight = RebuildBinaryTreeRec(rightPreOrder, rightInorder); // root������������preorder��inorder���Ҳ�������γɵ���
		}
		return root;
	}
	
	

	@Test
	public void testNode() throws Exception {
		// ��һ��������
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
		// �ڶ���������
		BinaryTreeNode treeNode25 = new BinaryTreeNode(12, null, null);
		BinaryTreeNode treeNode24 = new BinaryTreeNode(11, null, null);
		BinaryTreeNode treeNode23 = new BinaryTreeNode(10, null, null);
		BinaryTreeNode treeNode22 = new BinaryTreeNode(9, null, null);
		BinaryTreeNode treeNode21 = new BinaryTreeNode(8, null, null);
		BinaryTreeNode treeNode20 = new BinaryTreeNode(7, null, null);
		BinaryTreeNode treeNode19 = new BinaryTreeNode(6, null, null);
		BinaryTreeNode treeNode18 = new BinaryTreeNode(5, treeNode24,
				treeNode25);
		BinaryTreeNode treeNode17 = new BinaryTreeNode(4, treeNode22,
				treeNode23);
		BinaryTreeNode treeNode16 = new BinaryTreeNode(3, treeNode20,
				treeNode21);
		BinaryTreeNode treeNode15 = new BinaryTreeNode(2, treeNode18,
				treeNode19);
		BinaryTreeNode treeNode14 = new BinaryTreeNode(1, treeNode16,
				treeNode17);
		BinaryTreeNode treeNode13 = new BinaryTreeNode(0, treeNode14,
				treeNode15); // root���

		// System.out.println(GetNodeNumRec(treeNode0));// 13
		// System.out.println(GetNodeNum(treeNode0));// 13
		// System.out.println(GetDepthRec(treeNode0));// 4
		// System.out.println(GetDepth(treeNode0));// 4
		// PreorderTraversalRec(treeNode0);// 0,1,3,7,8,4,9,10,2,5,11,12,6
		// PreorderTraversalRec(treeNode0);// 0,1,3,7,8,4,9,10,2,5,11,12,6
		// InorderTraversalRec(treeNode0);// 7,3,8,1,9,4,10,0,11,5,12,2,6
		// InorderTraversal(treeNode0);// 7,3,8,1,9,4,10,0,11,5,12,2,6
		// PostorderTraversalRec(treeNode0);// 7,8,3,9,10,4,1,11,12,5,6,2,0
		// PostorderTraversal(treeNode0);
		// LevelTraversal(treeNode0);
		// LevelTraversalRec(treeNode0);
		/*
		 * System.out.println(ConvertBST2DLLRec(treeNode0).m_nValue); //0
		 * System.out.println(treeNode10.m_pRight.m_nValue);//0
		 * System.out.println(treeNode11.m_pLeft.m_nValue);//0
		 */
		// System.out.println(GetNodeNumKthLevelRec(treeNode0, 4));
		// System.out.println(GetNodeNumKthLevel(treeNode0, 4));
		// System.out.println(GetNodeNumLeafRec(treeNode0));
		// System.out.println(GetNodeNumLeaf(treeNode0));

		// System.out.println(isSameRec(treeNode0, treeNode13));
		// System.out.println(isSame(treeNode0,treeNode13));

		// System.out.println(isAVLRec(treeNode0));

		/*
		 * BinaryTreeNode treeNode = MirrorRec(treeNode0);
		 * LevelTraversalRec(treeNode);
		 */

		/*
		 * BinaryTreeNode treeNode = MirrorCopyRec(treeNode0);
		 * LevelTraversalRec(treeNode);
		 */

		// System.out.println(isMirrorRec(treeNode0, MirrorRec(treeNode13)));

		/*
		 * mirror(treeNode0); LevelTraversalRec(treeNode0);
		 */

		/*
		 * LevelTraversalRec(treeNode0); BinaryTreeNode treeNode =
		 * MirrorCopy(treeNode0); LevelTraversalRec(treeNode);
		 */

		// System.out.println(GetLastCommonParentRec(treeNode0,treeNode5,treeNode6).m_nValue);

		/*
		 * System.out.println(GetLastCommonParentRec2(treeNode0, treeNode5,
		 * treeNode6).m_nValue);
		 */
		/*
		 * System.out .println(GetLastCommonParent(treeNode0, treeNode5,
		 * treeNode6).m_nValue);
		 */
		// System.out.println(GetMaxDistanceRec(treeNode0).maxDepth);
		// System.out.println(GetMaxDistanceRec(treeNode0).maxDistance);

		List<Integer> preOrder = new ArrayList<Integer>();
		List<Integer> inOrder = new ArrayList<Integer>();
		preOrder.add(0);
		preOrder.add(1);
		preOrder.add(3);
		preOrder.add(7);
		preOrder.add(8);
		preOrder.add(4);
		preOrder.add(9);
		preOrder.add(10);
		preOrder.add(2);
		preOrder.add(5);
		preOrder.add(6);
		inOrder.add(7);
		inOrder.add(3);
		inOrder.add(8);
		inOrder.add(1);
		inOrder.add(9);
		inOrder.add(4);
		inOrder.add(10);
		inOrder.add(0);
		inOrder.add(5);
		inOrder.add(2);
		inOrder.add(6);
		LevelTraversalRec(RebuildBinaryTreeRec(preOrder, inOrder));

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

class Result {
	int maxDistance;
	int maxDepth;

	public Result() {
		// TODO �Զ����ɵĹ��캯�����
	}

	public Result(int maxDistance, int maxDepth) {
		this.maxDistance = maxDistance;
		this.maxDepth = maxDepth;
	}

}
