package com.xut.dijkstra;
/** 
* @author:YK;
* @Description:Dijkstra�㷨ʵ�����·��
*/
public class Dijkstra {
	
	 private static int N = 1000;
	 private static int[][] Graph = {//��ά������ͼ�нڵ���Ϣ
	        { 0, 1, 5, N, N, N, N, N, N },
	        { 1, 0, 3, 7, 5, N, N, N, N },
	        { 5, 3, 0, N, 1, 7, N, N, N },
	        { N, 7, N, 0, 2, N, 3, N, N },
	        { N, 5, 1, 2, 0, 3, 6, 9, N },
	        { N, N, 7, N, 3, 0, N, 5, N },
	        { N, N, N, 3, 6, N, 0, 2, 7 },
	        { N, N, N, N, 9, 5, 2, 0, 4 },
	        { N, N, N, N, N, N, 7, 4, 0 }};
	 
	 public static void dijkstra(int[][] Graph) {
		 int len = Graph[0].length;
	     int[] preNode = new int[len]; // ǰ���ڵ�����
	     int[] minDist = new int[len]; // ��̾�������
	     boolean[] known = new boolean[len]; // �ýڵ��Ƿ��Ѿ��ҵ����·��
	     int vnear = 0;
	         
	     for (int i = 0; i < minDist.length; i++) {
	    	 preNode[i] = i;
	    	 minDist[i] = Graph[0][i];
	    	 known[i] = false;
		}
	     
	     known[0] = true;
	     for (int j = 1; j < Graph.length; j++) {
			int min = N;
			for (int k = 0; k < Graph.length; k++) {
				if (!known[k]&&minDist[k]<min) {
					min = minDist[k];
					vnear = k;
				}
			}
		
			known[vnear] = true;
			for (int v = 0; v < Graph.length; v++) {
				if (!known[v] && (min + Graph[vnear][v]) < minDist[v]) {
                    preNode[v] = vnear;
                    minDist[v] = min + Graph[vnear][v];
                }
			}
		}
	     
	     for (int i = 0; i < len; i++) {
	           System.out.println("v0->v" + i +"֮����̾���:" + minDist[i]);
	     }
	}
	 
	 public static void main(String[] args) {
		dijkstra(Graph);
	}
}
