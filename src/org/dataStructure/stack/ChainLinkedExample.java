package org.dataStructure.stack;

import java.util.Stack;

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

	/**
	 * ���ҵ������е�����K�Ľ�� �ݹ�ʵ��
	 * 
	 * ͨ���ݹ��ߵ���ĩβ�Ľ�㣬Ȼ�������˳����
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
	 * ���ҵ�������м���
	 * 
	 * ��������ָ�룬����ָ��ͬʱ��ǰ�ߣ�ǰ���ָ��ÿ���������������ָ��ÿ����һ����
	 * ǰ���ָ���ߵ����һ�����ʱ�������ָ����ָ�������м��㣬���ڣ�
	 * n/2+1������㡣ע������Ϊ�գ����������Ϊ1��2�������ʱ�临�Ӷ�O(n)
	 * 
	 * @param head
	 * @return
	 */
	public Node GetMiddleNode(Node head) {
		if (head == null || head.m_next == null)
			return head;
		Node firstNode = head;
		Node lastNode = head;
		// ǰ��ָ��ÿ����������ֱ��ָ�����һ����㣬����ָ��ÿ����һ��
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
	 * ��β��ͷ��ӡ������
	 * 
	 * �������ֵߵ�˳������⣬����Ӧ�þͻ��뵽ջ������ȳ������ԣ���һ��Ҫô�Լ�ʹ��ջ��Ҫô��ϵͳʹ��ջ��Ҳ���ǵݹ顣ע������Ϊ�յ����
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
	 * ��β��ͷ��ӡ������ �ݹ�ʵ��
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
	 * ��֪����������pHead1 ��pHead2 �������򣬰����Ǻϲ���һ��������Ȼ����
	 * 
	 * ������ƹ鲢��������ע����������Ϊ�գ�������һ��Ϊ��ʱ�������ֻ��ҪO��1���Ŀռ䡣ʱ�临�Ӷ�ΪO��max(len1, len2)��
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
		if (head1.m_value < head2.m_value) { // ѡ��һ�����ڵ���룬�ҵ�mergeNode����ʼ���
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
				mergeCur.m_next = head1; // �˴���mergeCur������潫����head1���ڵ�֮�����е��������mergeCur��
				head1 = head1.m_next; // head1ָ��֮��Ľڵ�
				mergeCur = mergeCur.m_next;// ��mergeCur֮���һ�������Ϣ����mergeCur
				mergeCur.m_next = null;// �Ͽ�mergeCur��֮�����ϵ

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
	 * ��֪����������pHead1 ��pHead2 �������򣬰����Ǻϲ���һ��������Ȼ���� �ݹ�ⷨ
	 * 
	 * ��1����head1����head2Ϊ�գ�������һ��
	 * ��2���Ƚ�head1��head2��ֵ����head1����head1������������Ȼ��Ƚ�head1��next��head2��С����֮��Ȼ��
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
	 * �ж�һ�����������Ƿ��л�
	 * ����Ҳ���õ�����ָ�롣���һ���������л���Ҳ����˵��һ��ָ��ȥ����������Զ�߲���ͷ�ġ���ˣ����ǿ���������ָ��ȥ������һ��ָ��һ��������
	 * ��һ��ָ��һ����һ��������л�������ָ��϶����ڻ���������ʱ�临�Ӷ�ΪO��n��
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
	 * �ж������������Ƿ��ཻ
	 * 
	 * ������������ཻ��ĳһ�ڵ㣬��ô������ཻ�ڵ�֮������нڵ㶼���������������еġ� Ҳ����˵��������������ཻ����ô���һ���ڵ�϶��ǹ��е�
	 * �ȱ�����һ��������ס���һ���ڵ㣬Ȼ������ڶ������� �����һ���ڵ�ʱ�͵�һ����������һ���ڵ����Ƚϣ������ͬ�����ཻ��
	 * �����ཻ��ʱ�临�Ӷ�ΪO(len1+len2)����Ϊֻ��Ҫһ������ָ�뱣�����һ���ڵ��ַ�� �ռ临�Ӷ�ΪO(1)
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
	 * �������������ཻ�ĵ�һ���ڵ�
	 * 
	 * �Ե�һ��������������㳤��len1��ͬʱ�������һ���ڵ�ĵ�ַ��
	 * �Եڶ���������������㳤��len2��ͬʱ������һ���ڵ��Ƿ�͵�һ����������һ���ڵ���ͬ��������ͬ�����ཻ��������
	 * 
	 * �����������ͷ�ڵ㿪ʼ������len1����len2,
	 * ��ô����һ�������ȱ���len1-len2���ڵ㣬��ʱ��������ǰ�ڵ㵽��һ���ཻ�ڵ�ľ��������ˣ�Ȼ��һ����������ֱ�������ڵ�ĵ�ַ��ͬ��
	 * ʱ�临�Ӷȣ�O(len1+len2)
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
	 * ����뻷�еĵ�һ���ڵ� �ÿ���ָ����
	 * 
	 * @param head
	 * @return
	 */
	public Node GetFirstNodeInCycle(Node head) {
		Node fast = head;
		Node slow = head;
		// 1�� �ҵ�����ָ��������
		while (fast != null && fast.m_next != null) {
			fast = fast.m_next.m_next;
			slow = slow.m_next;
		}
		// �ж���û�л�
		if (fast == null || slow == null) {
			return null;
		}
		// 2�����ڣ��������뻷�Ŀ�ʼ���ľ����������ͷ������ʼ���ľ��룬
		// ���������ǰ���ָ���������ͷ����ָ�뱣���������㣬Ȼ��
		// ͬ�ٶ�ǰ�����ٴ���������ǻ��Ŀ�ʼ����
		slow = head;
		while (slow != fast) {
			slow = slow.m_next;
			fast = fast.m_next;
		}
		// �ٴ���������ǻ��Ŀ�ʼ��
		return fast;

	}

	/**
	 * ����һ������ͷָ��head��һ�ڵ�ָ��toBeDeleted��O(1)ʱ�临�Ӷ�ɾ���ڵ�tBeDeleted
	 * 
	 * ����ɾ���ڵ㣬������ͨ��˼·�����øýڵ��ǰһ���ڵ�ָ��ýڵ����һ���ڵ�
	 * �����������Ҫ�����ҵ��ýڵ��ǰһ���ڵ㣬ʱ�临�Ӷ�ΪO(n)����������
	 * �����е�ÿ���ڵ�ṹ����һ���ģ��������ǿ��԰Ѹýڵ����һ���ڵ�����ݸ��Ƶ��ýڵ�
	 * ��Ȼ��ɾ����һ���ڵ㼴�ɡ�Ҫע�����һ���ڵ����������ʱ��ֻ���ó����ķ��������������ҵ�ǰһ���ڵ㣬�������ƽ��ʱ�临�ӶȻ���O(1)
	 * 
	 * @param head
	 * @param toDelete
	 */
	public void Delete(Node head, Node toDelete) {
		if (toDelete == null) {
			return;
		}
		if (toDelete.m_next != null) { // Ҫɾ������һ���м�ڵ�
			toDelete.m_value = toDelete.m_next.m_value; // ����һ���ڵ�����ݸ��Ƶ����ڵ�!
			toDelete.m_next = toDelete.m_next.m_next;
		} else { // Ҫɾ���������һ���ڵ㣡
			if (head == toDelete) { // ������ֻ��һ���ڵ�����
				head = null;
			} else {//Ҫɾ��β���
				Node node = head;
				while (node.m_next != toDelete) { // �ҵ������ڶ����ڵ�
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
