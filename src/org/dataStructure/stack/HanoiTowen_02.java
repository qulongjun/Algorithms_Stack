package org.dataStructure.stack;

import org.junit.Test;

/**
 * 用栈来模拟汉诺塔，A不能直接到C，C也不能直接到A，必须经过B
 * 
 * @author 瞿龙俊
 * 
 */
public class HanoiTowen_02 {
	private int i;// 计数

	public void move(int n, char from, char to) {
		System.out.println("将" + n + "号盘子从" + from + "移动到" + to);
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
		// TODO 自动生成的方法存根
		hanoi(2, 'A', 'B', 'C');
	}

}
