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
	 * 直接插入排序
	 * 
	 * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），直到全部插入排序完为止。
	 * 
	 * 直接插入排序是稳定的排序
	 * 
	 * 
	 */
	public void StraightInsertSort() {
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

	/**
	 * 二分法插入排序
	 * 
	 * 稳定排序
	 */
	public void TwoWayInsertSort() {
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			int low = 0;
			int high = i - 1;
			int mid = 0;
			while (low <= high) {
				mid = (low + high) / 2;
				if (a[mid] < temp) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			for (int j = i - 1; j >= low; j--) {
				a[j + 1] = a[j];
			}
			a[low] = temp;
		}
	}

	/**
	 * 希尔排序
	 * 
	 * 不稳定排序
	 */
	public void ShellSort() {

	}

	/**
	 * 简单选择排序
	 */
	public void sampleSort() {
		for (int i = 0; i < a.length; i++) {
			int temp = a[i];
			int min = i;
			for (int j = i; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}
			a[i] = a[min];
			a[min] = temp;
		}
	}

	/**
	 * 快速排序
	 * 
	 * 一趟快速排序是以一个为基准，小的到左边，大的到右边
	 * 
	 */
	public void FastSort(int l, int r) {
		int i = l;
		int j = r;
		int temp = a[0];
		while (i != j) {
			while (j > i && a[j] > temp) {
				j--;
			}
			if (i < j) {
				a[i] = a[j];
				i++;
			}
			while (i < j && a[i] < temp) {
				i++;
			}
			if (i < j) {
				a[j] = a[i];
				j--;
			}
			a[i] = temp;
			FastSort(l, i - 1);
			FastSort(i + 1, r);
		}
	}
	
	
	

	/**
	 * 冒泡排序算法
	 */
	public void BubbleSort() {
		int temp = 0;// 临时变量，用来交换元素
		int flag; // 若一趟下来没有元素发生变化，则表示排序完成
		for (int i = 0; i < a.length; i++) {
			flag = 0;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
					flag = 1;
				}
			}
			if (flag == 0) {
				break;
			}
		}
	}

	@Test
	public void testSort() {
		// BubbleSort();
		// TwoWayInsertSort();
		// FastSort(0, a.length - 1);
		sampleSort();
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}
