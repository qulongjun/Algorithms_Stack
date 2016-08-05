package org.dataStructure.stack;

import org.junit.Test;

/**
 * ��ŵ����Ϸ
 * 
 * @author ������
 * 
 */
public class HanoiExapmple {
	int i = 0;

	// ����һ���ƶ��ĺ�������n�����Ӵ�fromλ���ƶ���to��λ��
	public void move(int n, char from, char to) {
		System.out.println("��" + n + "�����Ӵ�" + from + "�ƶ���" + to);
	}
	/**
	 * ��n�����Ӵ�from����dependλ�ã��ƶ���to��λ��
	 * ֻ��Ҫ��3����
	 * 1.��n-1�����Ӵ�A�ƶ���B
	 * 2.��n�����Ӵ�A�ƶ���C
	 * 3.��n-1�����Ӵ�B�ƶ���C
	 * @param n
	 * @param from
	 * @param depend
	 * @param to
	 */
	public void hanoi(int n, char from, char depend, char to) {
		if (n == 1) {
			move(1, from, to);
		} else {
			hanoi(n - 1, from, to, depend);
			move(n, from, to);
			hanoi(n - 1, depend, from, to);
		}
	}

	@Test
	public void testTowen() {
		// TODO �Զ����ɵķ������
		hanoi(3, 'A', 'B', 'C');
	}
}
