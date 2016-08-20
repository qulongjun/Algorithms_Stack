package org.dataStructure.stack;

import java.util.ArrayList;
import java.util.Iterator;
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
		while (!outPut.isEmpty()) { // 进栈顺序为根>右>左，出栈顺序为左>右>根
			System.out.println(outPut.pop().m_nValue + " ");
		}
	}

	/**
	 * 层次遍历 递归解法 【很少出现】
	 * 
	 * 基本思想是用一个大的ArrayList，里面包含了每一层的ArrayList。 大的ArrayList的size和level有关系
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
		if (level >= ret.size()) { // 递归到下一层
			ret.add(new ArrayList<Integer>());// 新创建一个ArrayList
		}
		ret.get(level).add(root.m_nValue);// 当前结点值放入ArrayList
		dfs(root.m_pLeft, level + 1, ret);
		dfs(root.m_pRight, level + 1, ret);
	}

	/**
	 * 层次遍历 迭代实现
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
	 * 将二叉查找树变为有序的双向链表 要求不能创建新节点，只调整指针。【递归实现】
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
	 * 递归转换BST为双向链表(DLL)
	 * 
	 * 思想：只需要将根节点左子树的最右叶子结点与根结点相连，右子树的最左叶子结点与根结点相连即可（互相）
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
	 * 【思考】 将二叉查找树变为有序的双向链表 要求不能创建新节点，只调整指针。【迭代实现】
	 * http://blog.csdn.net/ljianhui/article/details/22338405
	 * 
	 * @param root
	 * @return
	 */
	public BinaryTreeNode ConvertBST2DLL(BinaryTreeNode root) {
		if (root == null)
			return null;
		Stack<BinaryTreeNode> binaryTreeNodeStack = new Stack<BinaryTreeNode>();
		BinaryTreeNode curNode = root;// 指向当前处理结点
		BinaryTreeNode oldNode = null;// 指向上一个处理结点
		BinaryTreeNode head = null;// 链表头

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
	 * 求二叉树第K层的节点个数 递归解法：
	 * 
	 * （1）如果二叉树为空或者k<1返回0 （2）如果二叉树不为空并且k==1，返回1
	 * （3）如果二叉树不为空且k>1，返回root左子树中k-1层的节点个数与root右子树k-1层节点个数之和
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
	 * 求二叉树第K层的节点个数 迭代解法：
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
	 * 求二叉树中叶子节点的个数（递归）
	 * 
	 * @param root
	 * @return
	 */
	public int GetNodeNumLeafRec(BinaryTreeNode root) {
		if (root == null) // root不存在，返回0
			return 0;
		if (root.m_pLeft == null && root.m_pRight == null) { // 递归结束条件：不存在左子树和右子树
			return 1;
		}
		return GetNodeNumLeafRec(root.m_pLeft)
				+ GetNodeNumLeafRec(root.m_pRight);
	}

	/**
	 * 求二叉树中叶子节点的个数（迭代）
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
	 * 判断两棵二叉树是否相同的树(递归解法)
	 * 
	 * （1）如果两棵二叉树都为空，返回真 （2）如果两棵二叉树一棵为空，另一棵不为空，返回假
	 * （3）如果两棵二叉树都不为空，如果对应的左子树和右子树都同构返回真，其他返回假
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
	 * 判断两棵二叉树是否相同的树(迭代解法)
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
	 * 判断二叉树是不是平衡二叉树 递归解法：
	 * 
	 * （1）如果二叉树为空，返回真 （2）如果二叉树不为空，如果左子树和右子树都是AVL树并且左子树和右子树高度相差不大于1，返回真，其他返回假
	 * 
	 * @param root
	 * @return
	 */
	public boolean isAVLRec(BinaryTreeNode root) {
		if (root == null)
			return true;
		// 判断当前结点左子树和右子树高度差是否大于1
		if (Math.abs(GetDepth(root.m_pLeft) - GetDepth(root.m_pRight)) > 1) {
			return false;
		}
		return isAVLRec(root.m_pLeft) && isAVLRec(root.m_pRight);
	}

	/**
	 * 求二叉树的镜像 递归实现
	 * 
	 * （1）如果二叉树为空，返回空 （2）如果二叉树不为空，求左子树和右子树的镜像，然后交换左子树和右子树
	 * 
	 * 破坏原来的树，把原来的树破坏掉
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
	 * 求二叉树的镜像 递归实现
	 * 
	 * （1）如果二叉树为空，返回空 （2）如果二叉树不为空，求左子树和右子树的镜像，然后交换左子树和右子树
	 * 
	 * 不能破坏原来的树，返回一个新的镜像树
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
	 * 判断两个树是否互相镜像 递归实现
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
		if (root1.m_nValue != root2.m_nValue) // 判断根值是否一样
			return false;

		// 判断左右子树是否一样
		return isMirrorRec(root1.m_pLeft, root2.m_pRight)
				&& isMirrorRec(root1.m_pRight, root2.m_pLeft);
	}

	/**
	 * 求二叉树的镜像 迭代实现
	 * 
	 * 
	 * 破坏原来的树，把原来的树破坏掉
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
	 * 求二叉树的镜像 迭代实现
	 * 
	 * 不能破坏原来的树，返回一个新的镜像树
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
			BinaryTreeNode treeNode = binaryTreeNodeStack.pop(); // 根先出栈
			BinaryTreeNode newTreeNode = newStack.pop();
			if (treeNode.m_pRight != null) { // 右子树出栈
				binaryTreeNodeStack.push(treeNode.m_pRight);
				newTreeNode.m_pLeft = new BinaryTreeNode(
						treeNode.m_pRight.m_nValue);
				newStack.push(newTreeNode.m_pLeft);

			}
			if (treeNode.m_pLeft != null) {// 左子树出栈
				binaryTreeNodeStack.push(treeNode.m_pLeft);
				newTreeNode.m_pRight = new BinaryTreeNode(
						treeNode.m_pLeft.m_nValue);
				newStack.push(newTreeNode.m_pRight);

			}
		}
		return newRoot;
	}

	/**
	 * 求二叉树中两个节点的最低公共祖先节点 递归解法
	 * 
	 * （1）如果两个节点分别在根节点的左子树和右子树，则返回根节点
	 * （2）如果两个节点都在左子树，则递归处理左子树；如果两个节点都在右子树，则递归处理右子树
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
	 * 辅助方法，判断一个点是否在树里
	 * 
	 * 若root为null或者treeNode为null，则直接返回false
	 * 
	 * @param root
	 * @param treeNode
	 * @return
	 */
	private boolean findNodeRec(BinaryTreeNode root, BinaryTreeNode treeNode) {
		if (root == null || treeNode == null)
			return false;
		if (root == treeNode) // 递归结束条件，root和treeNode相等
			return true;
		// 递归查找左子树中和右子树中是否有该值
		return findNodeRec(root.m_pLeft, treeNode)
				|| findNodeRec(root.m_pRight, treeNode);
	}

	public BinaryTreeNode GetLastCommonParentRec2(BinaryTreeNode root,
			BinaryTreeNode n1, BinaryTreeNode n2) {
		if (root == null)
			return null;
		if (root == n1 || root == n2) { // 用来结束递归，判断当前结点是否和n1或者和n2一样
			return root;
		}
		BinaryTreeNode leftTreeNode = GetLastCommonParentRec2(root.m_pLeft, n1,
				n2);// 从左子树中找n1或者n2结点
		BinaryTreeNode rightTreeNode = GetLastCommonParentRec2(root.m_pRight,
				n1, n2);// 从右子树中找N1或者N2
		if (leftTreeNode != null && rightTreeNode != null) {
			// 左子树和右子树各有一个，则说明公共根结点为root
			return root;
		}
		if (leftTreeNode != null)// 如果右子树为空，则说明在左子树
			return leftTreeNode;
		return rightTreeNode;
	}

	/**
	 * 求二叉树中两个节点的最低公共祖先节点 迭代解法
	 * 
	 * 先求从根节点到两个节点的路径，然后再比较对应路径的节点就行，最后一个相同的节点也就是他们在二叉树中的最低公共祖先节点
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
	 * 从根节点到node结点路径上所有的结点都添加到path路径中
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
		path.add(root); // 把这个节点加到路径中
		if (root == node) {
			return true;
		}
		boolean find = getNodePath(root.m_pLeft, node, path);// 先在左子树中找
		if (!find) { // 如果没找到，再在右子树找
			find = getNodePath(root.m_pRight, node, path);
		}
		if (!find) { // 如果实在没找到证明这个节点不在路径中，说明刚才添加进去的不是路径上的节点，删掉！
			path.remove(root);
		}
		return find;
	}

	/**
	 * 求二叉树中节点的最大距离 即二叉树中相距最远的两个节点之间的距离，递归解法
	 * 
	 * （1）如果二叉树为空，返回0，同时记录左子树和右子树的深度，都为0
	 * （2）如果二叉树不为空，最大距离要么是左子树中的最大距离，要么是右子树中的最大距离，
	 * 要么是左子树节点中到根节点的最大距离+右子树节点中到根节点的最大距离，同时记录左子树和右子树节点中到根节点的最大距离。
	 * 
	 * 
	 * 计算一个二叉树的最大距离有两个情况:
	 * 
	 * 情况A: 路径经过左子树的最深节点，通过根节点，再到右子树的最深节点。 情况B: 路径不穿过根节点，而是左子树或右子树的最大距离路径，取其大者。
	 * 只需要计算这两个情况的路径距离，并取其大者，就是该二叉树的最大距离
	 * 
	 * @param root
	 * @return
	 */
	public Result GetMaxDistanceRec(BinaryTreeNode root) {
		if (root == null) {
			Result empty = new Result(0, -1); // 目的是让调用方 +1 后，把当前的不存在的
												// (NULL)子树当成最大深度为 0
			return empty;
		}
		Result lResult = GetMaxDistanceRec(root.m_pLeft);
		Result rResult = GetMaxDistanceRec(root.m_pRight);
		Result res = new Result();
		res.maxDepth = Math.max(lResult.maxDepth, rResult.maxDepth) + 1; // 当前最大深度
		// 取情况A和情况B中较大值
		res.maxDistance = Math.max(lResult.maxDepth + rResult.maxDepth,
				Math.max(lResult.maxDistance, rResult.maxDistance));
		return res;
	}

	/**
	 * 由前序遍历序列和中序遍历序列重建二叉树
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
			// 把preorder的第一个元素作为root
			root = new BinaryTreeNode(preOrder.get(0));
			// 知道root节点，所以根据root节点位置，把preorder，inorder分别划分为 root左侧和右侧 的两个子区间
			inorderPos = inOrder.indexOf(preOrder.get(0)); // inorder序列的分割点
			leftInorder = inOrder.subList(0, inorderPos);
			rightInorder = inOrder.subList(inorderPos + 1, inOrder.size());
			preorderPos = leftInorder.size(); // preorder序列的分割点
			leftPreOrder = preOrder.subList(1, preorderPos + 1);
			rightPreOrder = preOrder.subList(preorderPos + 1, preOrder.size());
			root.m_pLeft = RebuildBinaryTreeRec(leftPreOrder, leftInorder); // root的左子树就是preorder和inorder的左侧区间而形成的树
			root.m_pRight = RebuildBinaryTreeRec(rightPreOrder, rightInorder); // root的右子树就是preorder和inorder的右侧区间而形成的树
		}
		return root;
	}
	
	

	@Test
	public void testNode() throws Exception {
		// 第一个二叉树
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
		// 第二个二叉树
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
				treeNode15); // root结点

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

class Result {
	int maxDistance;
	int maxDepth;

	public Result() {
		// TODO 自动生成的构造函数存根
	}

	public Result(int maxDistance, int maxDepth) {
		this.maxDistance = maxDistance;
		this.maxDepth = maxDepth;
	}

}
