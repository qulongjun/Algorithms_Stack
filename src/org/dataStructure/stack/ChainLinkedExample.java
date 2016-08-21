package org.dataStructure.stack;

import org.junit.Test;

/**
 * ������������
 * 
 * @author ������
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
	 * �������нڵ�ĸ��� O(n) ʹ�ñ���count��¼��ǰ�ڵ������whileѭ��������������ǰ���Ϊnull
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
	 * ����ķ�ת ����˼·Ϊ����һ����������ԭ�����еĽڵ����δ�������ͷ������
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
			Node preHead = curNode; // ����һ���µĽ�㣬����ǰ�������㸳����
			curNode = curNode.m_next; // ������ڵ�ָ����һ���ڵ�
			preHead.m_next = reHead; // �½�����һ�����ָ���������ͷ�ڵ�
			reHead = preHead; // ��������ͷ���ָ���´����Ľ��
		}
		return reHead;
	}

	/**
	 * ����ķ�ת �ݹ�ʵ��
	 * 
	 * �ݹ�ľ����������Ĭ��reverseListRec�Ѿ��ɹ����������������ˣ�����ȥ����ν����
	 * 
	 * ����ֻҪ����ǰnode��������֮��Ĺ�ϵ��������Բ������������⡣
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
	 * ���ҵ������е�����k�����(k>0)
	 * 
	 * ���ձ�ķ����ǣ���ͳ�Ƶ������н��ĸ�����Ȼ�����ҵ��ڣ�n-k������㡣ע������Ϊ�գ�kΪ0��kΪ1��k���������нڵ����ʱ�����
	 * ��ʱ�临�Ӷ�ΪO��n��
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
	 * ���ҵ������е�����k�����(k>0)
	 * 
	 * ʹ������ָ�룬����ǰ���ָ���ߵ������k�����
	 * ������ǰ������ָ��ľ������k-1��֮��ǰ������ָ��һ����ǰ�ߣ�ǰ���ָ���ߵ����һ�����ʱ������ָ����ָ�����ǵ�����k�����
	 * 
	 * @param head
	 * @param k
	 * @return
	 */
	public Node ReGetKthNode2(Node head, int k) {
		if (head == null || k == 0)
			return null;
		int first = 0; // ���firstNode��ǰλ��
		Node firstNode = head, lastNode = head;
		while (firstNode != null && first < k) {// ����firstNode�ߵ���k����λ��
			first++;
			firstNode = firstNode.m_next;
		}
		while (firstNode != null) {// Ȼ������һ����
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

// �����������
class Node {
	int m_value;
	Node m_next;

	// ���캯��
	public Node(int m_value, Node m_next) {
		this.m_value = m_value;
		this.m_next = m_next;
	}

	// ���캯��
	public Node(int m_value) {
		this.m_value = m_value;
	}

	// ���캯��
	public Node() {
	}

}
