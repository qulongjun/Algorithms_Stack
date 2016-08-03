package org.dataStructure.stack;

import java.util.Stack;

import org.junit.Test;

/**
 * 用两个栈模拟队列(add、poll、peek)
 * 
 * 
 * @author 瞿龙俊
 * 
 */
public class StackSaveQuene {
	private Stack<Integer> stackPush = new Stack<Integer>(); // 压入栈
	private Stack<Integer> stackPop = new Stack<Integer>();// 弹出栈

	public void add(int newNum) {
		stackPush.add(newNum);
	}

	public int poll() {
		if (stackPop.isEmpty() && stackPush.isEmpty()) {
			throw new RuntimeException("队列中不存在数据");
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
			throw new RuntimeException("队列中不存在数据");
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
