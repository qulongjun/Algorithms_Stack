package org.dataStructure.stack;

import org.junit.Test;

/**
 * 各类排序算法
 * 
 * @author 瞿龙俊
 * 
 */
public class SortAlgorithms {
	int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99,
			98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

	/**
	 * 直接插入排序 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。
	 */
	private void StraightInsertSort() {
		for (int i = 0; i < a.length; i++) {
			int temp = a[i]; // 待排序元素
			int j = 0;
			for (j = i - 1; j >= 0; j--) { // 从有序列表的最后一位开始查找，若第j位元素小于待插入元素，则将待插入元素插入j+1的位置，否则就后移一位
				if (a[j] > temp) {
					a[j + 1] = a[j]; // 将元素后移一位
				} else {
					break; // 找到待插入的位置
				}
			}
			a[j + 1] = temp; // 插入j+1位置
		}
	}
	
	public void ShellSort(){
		
		
	}

	/**
	 * 冒泡排序算法
	 */
	public void BubbleSort() {
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
		StraightInsertSort();
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
