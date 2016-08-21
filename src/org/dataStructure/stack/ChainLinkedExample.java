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
			mergedNode.m_next = MergeSortedListRec(head1.m_next, head2);
		} else {
			mergedNode = head2;
			mergedNode.m_next = MergeSortedListRec(head1, head2.m_next);
		}
		return mergedNode;
	}

	/**
	 * 判断一个单链表中是否有环
	 * 这里也是用到两个指针。如果一个链表中有环，也就是说用一个指针去遍历，是永远走不到头的。因此，我们可以用两个指针去遍历，一个指针一次走两步
	 * ，一个指针一次走一步，如果有环，两个指针肯定会在环中相遇。时间复杂度为O（n）
	 * 
	 * @param head
	 * @return
	 */
	public boolean HasCycle(Node head) {
		Node p1 = head;
		Node p2 = head;
		while (p1.m_next != null) {
			p1 = p1.m_next;
			p2 = p2.m_next;
			if (p1.m_next != null) {
				p1 = p1.m_next;
			}
			if (p1 == p2) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 判断两个单链表是否相交
	 * 
	 * 如果两个链表相交于某一节点，那么在这个相交节点之后的所有节点都是两个链表所共有的。 也就是说，如果两个链表相交，那么最后一个节点肯定是共有的
	 * 先遍历第一个链表，记住最后一个节点，然后遍历第二个链表， 到最后一个节点时和第一个链表的最后一个节点做比较，如果相同，则相交，
	 * 否则不相交。时间复杂度为O(len1+len2)，因为只需要一个额外指针保存最后一个节点地址， 空间复杂度为O(1)
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public boolean IsIntersect(Node head1, Node head2) {
		if (head1 == null || head2 == null)
			return false;
		Node finalNode = head1;
		while (finalNode.m_next != null) {
			finalNode = finalNode.m_next;
		}
		Node finalNode2 = head2;
		while (finalNode2.m_next != null) {
			finalNode2 = finalNode2.m_next;
		}
		return finalNode == finalNode2;
	}

	/**
	 * 求两个单链表相交的第一个节点
	 * 
	 * 对第一个链表遍历，计算长度len1，同时保存最后一个节点的地址。
	 * 对第二个链表遍历，计算长度len2，同时检查最后一个节点是否和第一个链表的最后一个节点相同，若不相同，不相交，结束。
	 * 
	 * 两个链表均从头节点开始，假设len1大于len2,
	 * 那么将第一个链表先遍历len1-len2个节点，此时两个链表当前节点到第一个相交节点的距离就相等了，然后一起向后遍历，直到两个节点的地址相同。
	 * 时间复杂度，O(len1+len2)
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public Node GetFirstCommonNode(Node head1, Node head2) {
		if (head1 == null || head2 == null)
			return null;
		Node finalNode = head1;
		int head1_len = 1;
		while (finalNode.m_next != null) {
			finalNode = finalNode.m_next;
			head1_len++;
		}
		Node finalNode2 = head2;
		int head2_len = 1;
		while (finalNode2.m_next != null) {
			finalNode2 = finalNode2.m_next;
			head2_len++;
		}
		if (finalNode != finalNode2) {
			return null;
		}
		Node curNode1 = head1;
		Node curNode2 = head2;
		if (head1_len > head2_len) {
			int len = head1_len - head2_len;
			while (len != 0) {
				curNode1 = curNode1.m_next;
				len--;
			}
		} else {
			int len = head2_len - head1_len;
			while (len != 0) {
				curNode2 = curNode2.m_next;
				len--;
			}
		}
		while (curNode1 != curNode2) {
			curNode1 = curNode1.m_next;
			curNode2 = curNode2.m_next;
		}
		return curNode1;

	}

	/**
	 * 求进入环中的第一个节点 用快慢指针做
	 * 
	 * @param head
	 * @return
	 */
	public Node GetFirstNodeInCycle(Node head) {
		Node fast = head;
		Node slow = head;
		// 1） 找到快慢指针相遇点
		while (fast != null && fast.m_next != null) {
			fast = fast.m_next.m_next;
			slow = slow.m_next;
		}
		// 判断有没有环
		if (fast == null || slow == null) {
			return null;
		}
		// 2）现在，相遇点离环的开始处的距离等于链表头到环开始处的距离，
		// 这样，我们把慢指针放在链表头，快指针保持在相遇点，然后
		// 同速度前进，再次相遇点就是环的开始处！
		slow = head;
		while (slow != fast) {
			slow = slow.m_next;
			fast = fast.m_next;
		}
		// 再次相遇点就是环的开始处
		return fast;

	}

	/**
	 * 给出一单链表头指针head和一节点指针toBeDeleted，O(1)时间复杂度删除节点tBeDeleted
	 * 
	 * 对于删除节点，我们普通的思路就是让该节点的前一个节点指向该节点的下一个节点
	 * ，这种情况需要遍历找到该节点的前一个节点，时间复杂度为O(n)。对于链表，
	 * 链表中的每个节点结构都是一样的，所以我们可以把该节点的下一个节点的数据复制到该节点
	 * ，然后删除下一个节点即可。要注意最后一个节点的情况，这个时候只能用常见的方法来操作，先找到前一个节点，但总体的平均时间复杂度还是O(1)
	 * 
	 * @param head
	 * @param toDelete
	 */
	public void Delete(Node head, Node toDelete) {
		if (toDelete == null) {
			return;
		}
		if (toDelete.m_next != null) { // 要删除的是一个中间节点
			toDelete.m_value = toDelete.m_next.m_value; // 将下一个节点的数据复制到本节点!
			toDelete.m_next = toDelete.m_next.m_next;
		} else { // 要删除的是最后一个节点！
			if (head == toDelete) { // 链表中只有一个节点的情况
				head = null;
			} else {//要删除尾结点
				Node node = head;
				while (node.m_next != toDelete) { // 找到倒数第二个节点
					node = node.m_next;
				}
				node.m_next = null;
			}
		}
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
		// printNode(MergeSortedListRec(node1, node11));
		// System.out.println(HasCycle(node1));
		// System.out.println(IsIntersect(node1, node11));
		// System.out.println(GetFirstCommonNode(node1, node5).m_value);
		//System.out.println(GetFirstNodeInCycle(node1));
		Delete(node1,node5);
		printNode(node1);
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
