package org.dataStructure.stack;

import org.junit.Test;

/**
 * ���������㷨
 * 
 * @author ������
 * 
 */
public class SortAlgorithms {
	int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99,
			98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51 };

	/**
	 * ֱ�Ӳ�������
	 * 
	 * ÿ����һ��������ļ�¼������˳�����С���뵽ǰ���Ѿ�����������еĺ���λ�ã��Ӻ���ǰ�ҵ�����λ�ú󣩣�ֱ��ȫ������������Ϊֹ��
	 * 
	 * ֱ�Ӳ����������ȶ�������
	 * 
	 * 
	 */
	public void StraightInsertSort() {
		for (int i = 0; i < a.length; i++) {
			int temp = a[i]; // ������Ԫ��
			int j = 0;
			for (j = i - 1; j >= 0; j--) { // �������б�����һλ��ʼ���ң�����jλԪ��С�ڴ�����Ԫ�أ��򽫴�����Ԫ�ز���j+1��λ�ã�����ͺ���һλ
				if (a[j] > temp) {
					a[j + 1] = a[j]; // ��Ԫ�غ���һλ
				} else {
					break; // �ҵ��������λ��
				}
			}
			a[j + 1] = temp; // ����j+1λ��
		}
	}

	/**
	 * ���ַ���������
	 * 
	 * �ȶ�����
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
	 * ϣ������
	 * 
	 * ���ȶ�����
	 */
	public void ShellSort() {

	}

	/**
	 * ��ѡ������
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
	 * ��������
	 * 
	 * һ�˿�����������һ��Ϊ��׼��С�ĵ���ߣ���ĵ��ұ�
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
	 * ð�������㷨
	 */
	public void BubbleSort() {
		int temp = 0;// ��ʱ��������������Ԫ��
		int flag; // ��һ������û��Ԫ�ط����仯�����ʾ�������
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
