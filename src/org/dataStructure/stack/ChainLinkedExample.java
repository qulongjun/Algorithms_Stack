package org.dataStructure.stack;

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
		// System.out.println(GetListLength(node1));
		// printNode(ReverseList(node1));
		// printNode(ReverseListRec(node1));
		// System.out.println(ReGetKthNode(node1, 5).m_value);
		System.out.println(ReGetKthNode2(node1, 4).m_value);
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
