package org.dataStructure.stack;

import org.junit.Test;

/**
 * 汉诺塔游戏
 * 
 * @author 瞿龙俊
 * 
 */
public class HanoiExapmple {
	int i = 0;

	// 定义一个移动的函数，将n号盘子从from位置移动到to的位置
	public void move(int n, char from, char to) {
		System.out.println("将" + n + "号盘子从" + from + "移动到" + to);
	}
	/**
	 * 将n个盘子从from借助depend位置，移动到to的位置
	 * 只需要做3步：
	 * 1.将n-1个盘子从A移动到B
	 * 2.将n号盘子从A移动到C
	 * 3.将n-1个盘子从B移动到C
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
		// TODO 自动生成的方法存根
		hanoi(3, 'A', 'B', 'C');
	}
}
