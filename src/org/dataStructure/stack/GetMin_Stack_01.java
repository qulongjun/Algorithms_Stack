package org.dataStructure.stack;

import java.util.Stack;

import org.junit.Test;

/**
 * ʵ��һ�������ջ����ʵ��ջ�Ļ������ܵĻ����ϣ�ʵ�ַ���ջ����СԪ�صĲ��� Ҫ�� 1.pop��push��getMin�Ĳ���ʱ��ΪO(1)��
 * 2.����ʹ���ֳɵ�ջ�ṹ
 * 
 * 
 * ���˼·�� ��ջ��ʹ������ջ������ݣ���һ�����ԭʼ���ݣ��������ջ���ڶ������ԭʼ���ݲ����ʱ��Ƚϳ�������С��ֵ��
 * ��push��stackDataһ��ֵ��ʱ��
 * ���Ƚ����ֵ��stackMin�����ֵ�Ĵ�С����stackMin������ֵС���򲻲���stackMin����push��ֵС�������stackMin������
 * ���stackMin�������ֵ��Զ����С��
 * ��ջ������stackMin����Ԫ����Զ��stackData�����ݵ���Сֵ����ˣ���stackData��ջ��ʱ��
 * ���Ƚϳ�ջԪ�غͶ���Ԫ�أ�����ȣ���stackData��stackMin��ͬ��ջ
 * 
 * 
 * @author ������
 * 
 */
public class GetMin_Stack_01 {
	// �洢ԭʼ���ݵ�ջ
	private Stack<Integer> stackData = new Stack<Integer>();
	// �洢��Сֵ��ջ
	private Stack<Integer> stackMin = new Stack<Integer>();

	public void push(int newNum) {
		if (stackMin.isEmpty()) {
			// ��СֵջΪ�գ���ֱ�Ӳ���
			stackMin.push(newNum);
		} else {
			// �ǿգ��ġ��ж�newNum��getMin�����ֵ��С��������ִ�в�������С����ѹ��
			if (getMin() >= newNum) {
				stackMin.push(newNum);
			}
		}
		stackData.push(newNum);
	}

	public int pop() {
		if (stackData.isEmpty()) {
			throw new RuntimeException("��ǰ����ջ��Ϊ�գ��޷����");
		}
		int value = this.stackData.pop();
		if (value == getMin()) {
			stackMin.pop();
		}
		return value;
	}

	public int getMin() {
		if (stackMin.isEmpty()) {
			throw new RuntimeException("��ǰ��Сֵջ��Ϊ�գ��޷����");
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
