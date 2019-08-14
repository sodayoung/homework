package com.xut.dijkstra;
/** 
* @author:YK;
* @Description:Dijkstra算法实现最短路径
*/
public class Dijkstra {
	
	 private static int N = 1000;
	 private static int[][] Graph = {//二维数组存放图中节点信息
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
	     int[] preNode = new int[len]; // 前驱节点数组
	     int[] minDist = new int[len]; // 最短距离数组
	     boolean[] known = new boolean[len]; // 该节点是否已经找到最短路径
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
	           System.out.println("v0->v" + i +"之间最短距离:" + minDist[i]);
	     }
	}
	 
	 public static void main(String[] args) {
		dijkstra(Graph);
	}
}
