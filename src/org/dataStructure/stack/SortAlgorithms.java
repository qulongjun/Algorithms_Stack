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
	 * ֱ�Ӳ������� ÿ����һ��������ļ�¼������˳�����С���뵽ǰ���Ѿ�����������еĺ���λ�ã��Ӻ���ǰ�ҵ�����λ�ú󣩣�ֱ��ȫ������������Ϊֹ��
	 */
	private void StraightInsertSort() {
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
	
	public void ShellSort(){
		
		
	}

	/**
	 * ð�������㷨
	 */
	public void BubbleSort() {
		int temp = 0;// ��ʱ��������������Ԫ��
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
