package org.dataStructure.stack;

import org.junit.Test;

/**
 * ��ջ��ģ�⺺ŵ����A����ֱ�ӵ�C��CҲ����ֱ�ӵ�A�����뾭��B
 * 
 * @author ������
 * 
 */
public class HanoiTowen_02 {
	private int i;// ����

	public void move(int n, char from, char to) {
		System.out.println("��" + n + "�����Ӵ�" + from + "�ƶ���" + to);
	}

	public void hanoi(int n, char from, char depend, char to) {
		if (n == 1) {
			move(1, 'A', 'B');
			move(1, 'B', 'C');
		} else {
			hanoi(n - 1, 'A', 'C', 'B');
			hanoi(n - 1, 'B', 'A', 'C');
			move(n, 'A', 'B');
			hanoi(n - 1, 'C', 'A', 'B');
			hanoi(n - 1, 'B', 'C', 'A');
			move(n, 'B', 'C');
		}
	}
	@Test
	public void testTowen() {
		// TODO �Զ����ɵķ������
		hanoi(2, 'A', 'B', 'C');
	}

}
