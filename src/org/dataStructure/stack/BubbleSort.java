package org.dataStructure.stack;

import org.junit.Test;

/**
 * 冒泡排序算法
 * 
 * @author 瞿龙俊
 * 
 */
public class BubbleSort {
	int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99,
			98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

	public void sort() {
		int temp = 0;// 临时变量，用来交换元素
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
	}

	@Test
	public void testSort() {
		sort();
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
