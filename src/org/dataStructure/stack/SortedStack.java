package org.dataStructure.stack;

import java.util.Stack;

import org.junit.Test;

/**
 * 使用一个栈实现另一个栈的排序
 * 思路：
 * 1.cur小于等于help的栈顶元素，则将cur压入help
 * 2.若cur大于help的栈顶元素，则将help中的元素依次pop到stack中，直到help中栈顶元素大于cur，再将cur压入help，直到stack为空
 * 3.将help元素全部放回stack
 * 
 * @author 瞿龙俊
 * 
 */
public class SortedStack {
	private Stack<Integer> help = new Stack<Integer>();
	private Stack<Integer> numbers = new Stack<Integer>();

	public void sort() {
		while (!numbers.isEmpty()) {
			int cur = numbers.pop();
			if (help.isEmpty()) {
				help.push(cur);
			} else {
				int temp = help.peek();
				if (cur <= temp) {
					help.push(cur);
				} else {
					while (!help.isEmpty() && help.peek() <= cur) {
						numbers.push(help.pop());
					}
					help.push(cur);
				}
			}
		}
		while(!help.isEmpty()){
			numbers.push(help.pop());
		}
	}

	@Test
	public void testSort() {
		// TODO 自动生成的方法存根
		numbers.push(1);
		numbers.push(2);
		numbers.push(4);
		numbers.push(8);
		numbers.push(2);
		numbers.push(7);
		numbers.push(6);
		sort();
		while (!numbers.isEmpty()) {
			System.out.println(numbers.pop());
		}

	}
}
