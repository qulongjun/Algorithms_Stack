package org.dataStructure.stack;

import java.util.Stack;

import org.junit.Test;

/**
 * ʹ��һ��ջʵ����һ��ջ������
 * ˼·��
 * 1.curС�ڵ���help��ջ��Ԫ�أ���curѹ��help
 * 2.��cur����help��ջ��Ԫ�أ���help�е�Ԫ������pop��stack�У�ֱ��help��ջ��Ԫ�ش���cur���ٽ�curѹ��help��ֱ��stackΪ��
 * 3.��helpԪ��ȫ���Ż�stack
 * 
 * @author ������
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
		// TODO �Զ����ɵķ������
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
