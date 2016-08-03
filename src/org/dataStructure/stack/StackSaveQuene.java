package org.dataStructure.stack;

import java.util.Stack;

import org.junit.Test;

/**
 * ������ջģ�����(add��poll��peek)
 * 
 * 
 * @author ������
 * 
 */
public class StackSaveQuene {
	private Stack<Integer> stackPush = new Stack<Integer>(); // ѹ��ջ
	private Stack<Integer> stackPop = new Stack<Integer>();// ����ջ

	public void add(int newNum) {
		stackPush.add(newNum);
	}

	public int poll() {
		if (stackPop.isEmpty() && stackPush.isEmpty()) {
			throw new RuntimeException("�����в���������");
		}
		if (stackPop.empty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}

	public int peek() {
		if (stackPop.isEmpty() && stackPush.isEmpty()) {
			throw new RuntimeException("�����в���������");
		}
		if (stackPop.empty()) {
			while (!stackPush.empty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}

	@Test
	public void testQueue() throws Exception {
		Integer[] numList = {1,26,5,7,9};
		for (Integer number : numList) {
			add(number);
		}
		
		System.out.println(poll());
		System.out.println(poll());
		System.out.println(poll());
		System.out.println(poll());
		System.out.println(poll());
		
		
	}
}
