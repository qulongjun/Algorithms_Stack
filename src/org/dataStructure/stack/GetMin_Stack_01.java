package org.dataStructure.stack;

import java.util.Stack;

import org.junit.Test;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，实现返回栈中最小元素的操作 要求： 1.pop、push、getMin的操作时间为O(1)。
 * 2.可以使用现成的栈结构
 * 
 * 
 * 设计思路： 入栈：使用两个栈存放数据，第一个存放原始数据，即常规的栈，第二个存放原始数据插入的时候比较出来的最小的值。
 * 当push进stackData一个值的时候
 * ，比较这个值和stackMin最顶部的值的大小，若stackMin顶部的值小，则不插入stackMin，若push的值小，则插入stackMin顶部。
 * 因此stackMin里最顶部的值永远是最小的
 * 出栈：由于stackMin顶部元素永远是stackData中数据的最小值，因此，当stackData出栈的时候
 * ，比较出栈元素和顶部元素，若相等，则stackData和stackMin共同出栈
 * 
 * 
 * @author 瞿龙俊
 * 
 */
public class GetMin_Stack_01 {
	// 存储原始数据的栈
	private Stack<Integer> stackData = new Stack<Integer>();
	// 存储最小值的栈
	private Stack<Integer> stackMin = new Stack<Integer>();

	public void push(int newNum) {
		if (stackMin.isEmpty()) {
			// 最小值栈为空，则直接插入
			stackMin.push(newNum);
		} else {
			// 非空，的、判断newNum和getMin最顶部的值大小，若大，则不执行操作，若小，则压入
			if (getMin() >= newNum) {
				stackMin.push(newNum);
			}
		}
		stackData.push(newNum);
	}

	public int pop() {
		if (stackData.isEmpty()) {
			throw new RuntimeException("当前数据栈中为空，无法输出");
		}
		int value = this.stackData.pop();
		if (value == getMin()) {
			stackMin.pop();
		}
		return value;
	}

	public int getMin() {
		if (stackMin.isEmpty()) {
			throw new RuntimeException("当前最小值栈中为空，无法输出");
		}
		return stackMin.peek();
	}

	@Test
	public void testStack() throws Exception {
		Integer[] numList = { 8, 3, 6, 5, 4, 3, 1 };
		for (Integer number : numList) {
			push(number);
		}
		System.out.println(stackMin);
		System.out.println(getMin());
	}
}
