package com.dfm.his.algorithm.collections;

public class SparesArray {

	public static void main(String[] args) {
		//�洢ԭʼ����
		int chessArr1[][] = new int[11][11];
		chessArr1[1][2] = 1;
		chessArr1[2][3] = 2;
		//���ԭʼ��ά����
		for (int[] row : chessArr1) {
			for (int data : row) {
				System.out.print(data);
			}
			System.out.println();
		}
		/*
		 *   ת��Ϊ ϡ�� ����
		 */
		//�õ���Ч���ݸ���
		int count = 0;
		for (int[] row : chessArr1) {
			for (int data : row) {
				if(data != 0)count++;
			}
		}
		System.out.println(count);
		//���� count+1��������   ��һ�д�   rows cols count
		int sparesArray[][] = new int[count+1][3];
		sparesArray[0][0] = chessArr1.length;
		sparesArray[0][1] = chessArr1[0].length;
		sparesArray[0][2] = count;
		//ת����Ч����
		for (int i = 0; i < chessArr1.length; i++) {
			for (int j = 0; j < chessArr1[i].length; j++) {
				if(chessArr1[i][j] != 0 ) {
					sparesArray[count][0] = i;
					sparesArray[count][1] = j;
					sparesArray[count][2] = chessArr1[i][j];
					count--;
				}
			}
		}
		//��ӡ ϡ������
		for (int[] row : sparesArray) {
			for (int data : row) {
				System.out.print(data+" ");
			}
			System.out.println();
		}
		
		//�ָ� ԭ��ά����
		int chessArray2[][] = new int[sparesArray[0][0]][sparesArray[0][1]];
		for (int i = 1; i < sparesArray[0][2]+1; i++) {
			chessArray2[sparesArray[i][0]][sparesArray[i][1]] = sparesArray[i][2];
		}
		//����ָ� ��ά����
		for (int[] row : chessArray2) {
			for (int data : row) {
				System.out.print(data+" ");
			}
			System.out.println();
		}
	}
}
