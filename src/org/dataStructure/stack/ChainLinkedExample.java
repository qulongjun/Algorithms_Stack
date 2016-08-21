package org.dataStructure.stack;

import java.util.Stack;

import org.junit.Test;

/**
 * 链表常考点整理
 * 
 * @author 瞿龙俊
 * 
 */
public class ChainLinkedExample {
	private void printNode(Node head) {
		while (head != null) {
			System.out.println(head.m_value);
			head = head.m_next;
		}
	}

	/**
	 * 求单链表中节点的个数 O(n) 使用变量count记录当前节点个数，while循环结束条件：当前结点为null
	 * 
	 * @param head
	 * @return
	 */
	public int GetListLength(Node head) {
		if (head == null) {
			return 0;
		}
		int count = 0;
		Node curNode = head;
		while (curNode != null) {
			count++;
			curNode = curNode.m_next;
		}
		return count;
	}

	/**
	 * 链表的翻转 基本思路为创建一个新链表，将原链表中的节点依次从新链表头部放入
	 * 
	 * @param head
	 * @return
	 */
	public Node ReverseList(Node head) {
		if (head == null || head.m_next == null)
			return head;
		Node reHead = null;
		Node curNode = head;
		while (curNode != null) {
			Node preHead = curNode; // 创建一个新的结点，将当前老链表结点赋给它
			curNode = curNode.m_next; // 老链表节点指向下一个节点
			preHead.m_next = reHead; // 新结点的下一个结点指向新链表的头节点
			reHead = preHead; // 将新链表头结点指向新创建的结点
		}
		return reHead;
	}

	/**
	 * 链表的翻转 递归实现
	 * 
	 * 递归的精髓在于你就默认reverseListRec已经成功帮你解决了子问题了！但别去想如何解决的
	 * 
	 * 现在只要处理当前node和子问题之间的关系。最后就能圆满解决整个问题。
	 * 
	 * @param head
	 * @return
	 */
	public Node ReverseListRec(Node head) {
		if (head == null || head.m_next == null) {
			return head;
		}
		Node reHead = ReverseListRec(head.m_next);
		head.m_next.m_next = head;
		head.m_next = null;
		return reHead;

	}

	/**
	 * 查找单链表中倒数第k个结点(k>0)
	 * 
	 * 最普遍的方法是，先统计单链表中结点的个数，然后再找到第（n-k）个结点。注意链表为空，k为0，k为1，k大于链表中节点个数时的情况
	 * 。时间复杂度为O（n）
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public Node ReGetKthNode(Node head, int k) {
		if (head == null)
			return null;
		int length = GetListLength(head);
		int revertNum = length - k;
		if (revertNum < 0 || k == 0)
			return null;
		int i = 0;
		Node curNode = head;
		while (curNode != null && i != revertNum) {
			curNode = curNode.m_next;
			i++;
		}
		return curNode;
	}

	/**
	 * 查找单链表中倒数第k个结点(k>0)
	 * 
	 * 使用两个指针，先让前面的指针走到正向第k个结点
	 * ，这样前后两个指针的距离差是k-1，之后前后两个指针一起向前走，前面的指针走到最后一个结点时，后面指针所指结点就是倒数第k个结点
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public Node ReGetKthNode2(Node head, int k) {
		if (head == null || k == 0)
			return null;
		int first = 0; // 标记firstNode当前位置
		Node firstNode = head, lastNode = head;
		while (firstNode != null && first < k) {// 先让firstNode走到第k个的位置
			first++;
			firstNode = firstNode.m_next;
		}
		while (firstNode != null) {// 然后两个一起走
			firstNode = firstNode.m_next;
			lastNode = lastNode.m_next;
		}
		return lastNode;
	}

	/**
	 * 查找单链表中倒数第K的结点 递归实现
	 * 
	 * 通过递归走到最末尾的结点，然后依次退出结点
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	int level = 0;

	public void ReGetKthNodeRec(Node head, int k) {
		if (head == null || k == 0) {
			return;
		}
		ReGetKthNodeRec(head.m_next, k);
		level++;
		if (level == k) {
			System.out.println(head.m_value);
		}
	}

	/**
	 * 查找单链表的中间结点
	 * 
	 * 设置两个指针，两个指针同时向前走，前面的指针每次走两步，后面的指针每次走一步，
	 * 前面的指针走到最后一个结点时，后面的指针所指结点就是中间结点，即第（
	 * n/2+1）个结点。注意链表为空，链表结点个数为1和2的情况。时间复杂度O(n)
	 * 
	 * @param head
	 * @return
	 */
	public Node GetMiddleNode(Node head) {
		if (head == null || head.m_next == null)
			return head;
		Node firstNode = head;
		Node lastNode = head;
		// 前面指针每次走两步，直到指向最后一个结点，后面指针每次走一步
		while (firstNode.m_next != null) {
			firstNode = firstNode.m_next;
			lastNode = lastNode.m_next;
			if (firstNode.m_next != null) {
				firstNode = firstNode.m_next;
			}
		}
		return lastNode;
	}

	/**
	 * 从尾到头打印单链表
	 * 
	 * 对于这种颠倒顺序的问题，我们应该就会想到栈，后进先出。所以，这一题要么自己使用栈，要么让系统使用栈，也就是递归。注意链表为空的情况
	 * 
	 * @param head
	 */
	public void ReversePrintListStack(Node head) {
		Stack<Node> nodeStack = new Stack<Node>();
		if (head == null)
			return;
		Node curNode = head;
		while (curNode != null) {
			nodeStack.push(curNode);
			curNode = curNode.m_next;
		}
		while (!nodeStack.isEmpty()) {
			System.out.println(nodeStack.pop().m_value);
		}
	}

	/**
	 * 从尾到头打印单链表 递归实现
	 */
	public void ReversePrintListRec(Node head) {
		if (head == null) {
			return;
		} else {
			ReversePrintListRec(head.m_next);
			System.out.println(head.m_value);
		}
	}

	/**
	 * 已知两个单链表pHead1 和pHead2 各自有序，把它们合并成一个链表依然有序
	 * 
	 * 这个类似归并排序。尤其注意两个链表都为空，和其中一个为空时的情况。只需要O（1）的空间。时间复杂度为O（max(len1, len2)）
	 * 
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public Node MergeSortedList(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head2;

		Node mergeNode = null;
		if (head1.m_value < head2.m_value) { // 选择一个根节点加入，找到mergeNode的起始结点
			mergeNode = head1;
			head1 = head1.m_next;
			mergeNode.m_next = null;
		} else {
			mergeNode = head2;
			head2 = head2.m_next;
			mergeNode.m_next = null;
		}

		Node mergeCur = mergeNode;
		while (head1 != null && head2 != null) {
			if (head1.m_value < head2.m_value) {
				mergeCur.m_next = head1; // 此处将mergeCur链表后面将包括head1在内的之后所有的链表加入mergeCur中
				head1 = head1.m_next; // head1指向之后的节点
				mergeCur = mergeCur.m_next;// 将mergeCur之后的一个结点信息赋给mergeCur
				mergeCur.m_next = null;// 断开mergeCur与之后的联系

			} else {
				mergeCur.m_next = head2;
				head2 = head2.m_next;
				mergeCur = mergeCur.m_next;
				mergeCur.m_next = null;
			}
		}

		if (head1 != null) {
			mergeCur.m_next = head1;
		} else if (head2 != null) {
			mergeCur.m_next = head2;
		}
		return mergeNode;
	}

	/**
	 * 已知两个单链表pHead1 和pHead2 各自有序，把它们合并成一个链表依然有序 递归解法
	 * 
	 * （1）若head1或者head2为空，返回另一个
	 * （2）比较head1和head2的值，若head1大，则head1被加入新链表，然后比较head1的next和head2大小，反之亦然。
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public Node MergeSortedListRec(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;
		Node mergedNode = null;
		if (head1.m_value < head2.m_value) {
			mergedNode = head1;
			mergedNode.m_next =MergeSortedListRec(head1.m_next, head2);
		} else {
			mergedNode = head2;
			mergedNode.m_next= MergeSortedListRec(head1, head2.m_next);
		}
		return mergedNode;
	}

	@Test
	public void testNode() throws Exception {
		Node node10 = new Node(10, null);
		Node node9 = new Node(9, node10);
		Node node8 = new Node(8, node9);
		Node node7 = new Node(7, node8);
		Node node6 = new Node(6, node7);
		Node node5 = new Node(5, node6);
		Node node4 = new Node(4, node5);
		Node node3 = new Node(3, node4);
		Node node2 = new Node(2, node3);
		Node node1 = new Node(1, node2);

		Node node20 = new Node(20, null);
		Node node19 = new Node(19, node20);
		Node node18 = new Node(18, node19);
		Node node17 = new Node(15, node18);
		Node node16 = new Node(11, node17);
		Node node15 = new Node(9, node16);
		Node node14 = new Node(8, node15);
		Node node13 = new Node(4, node14);
		Node node12 = new Node(2, node13);
		Node node11 = new Node(1, node12);

		// System.out.println(GetListLength(node1));
		// printNode(ReverseList(node1));
		// printNode(ReverseListRec(node1));
		// System.out.println(ReGetKthNode(node1, 5).m_value);
		// System.out.println(ReGetKthNode2(node1, 4).m_value);

		// ReGetKthNodeRec(node1, 4);
		// System.out.println(GetMiddleNode(node1).m_value);
		// ReversePrintListStack(node1);
		// ReversePrintListRec(node1);
		printNode(MergeSortedListRec(node1, node11));
	}
}

// 链表基本类型
class Node {
	int m_value;
	Node m_next;

	// 构造函数
	public Node(int m_value, Node m_next) {
		this.m_value = m_value;
		this.m_next = m_next;
	}

	// 构造函数
	public Node(int m_value) {
		this.m_value = m_value;
	}

	// 构造函数
	public Node() {
	}

}
