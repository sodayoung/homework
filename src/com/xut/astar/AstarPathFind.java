package com.xut.astar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import sun.net.www.content.audio.x_aiff;

/** 
* @author:YK;
* @date:2019年8月14日 上午11:29:04;
* @Description:A*算法求最短路径
*/
public class AstarPathFind {
	public final static int[] dx = { 0, -1, 0, 1, -1, -1, 1, 1};
	public final static int[] dy = {-1, 0, 1, 0, 1, -1, -1, 1 };
	public final static int[][] map = {
				  {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			      { 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1 },
			      { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
			      { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
			      { 1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
			      { 1, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1 },
			      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			      { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
			      { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }};

	public static Stack<Point> printPath(Point start,Point end) {
		ArrayList<Point> openTable = new ArrayList<Point>();
		ArrayList<Point> closeTable = new ArrayList<Point>();
		openTable.clear();
		closeTable.clear();
		Stack<Point> pathStack = new Stack<Point>();
		start.parent = null;
		
		Point currPoint = new Point(start.x, start.y);
		boolean flag = true;
		
		while (flag) {
			for (int i = 0; i < 8; i++) {
				int fx = currPoint.x+dx[i];
				int fy = currPoint.y+dy[i];
				Point temPoint = new Point(fx, fy);
				
				if (map[fx][fy]==1) {
					continue;
				}else {
					if (end.equals(temPoint)) {
						flag = false;
						end.parent = currPoint;
						break;
					}
					if (i<4) {
						temPoint.G = currPoint.G+10;
					}else {
						temPoint.G = currPoint.G+14;
					}
					temPoint.H = Point.getDis(temPoint, end);
					temPoint.F = temPoint.G+temPoint.H;
					
					if (openTable.contains(temPoint)) {
						int pos = openTable.indexOf(temPoint);
						Point temp = openTable.get(pos);
						if (temp.F>temPoint.F) {
							openTable.remove(pos);
							openTable.add(temPoint);
							temPoint.parent = currPoint;
						}
					}else if (closeTable.contains(temPoint)) {
						int pos = closeTable.indexOf(temPoint );
						Point temp = closeTable.get(pos);
						if (temp.F>temPoint.F) {
							closeTable.remove(pos);
							openTable.add(temPoint);
							temPoint.parent = currPoint;
						}
					}else {
						openTable.add(temPoint);
						temPoint.parent = currPoint;
					}
				}
				
			}
			
			if (openTable.isEmpty()) {
				return null;
			}
			if (flag==false) {
				break;
			}
			openTable.remove(currPoint);
			closeTable.add(currPoint);
			Collections.sort(openTable);
			currPoint = openTable.get(0);
		}
		
		Point node = end;
		while (node.parent!=null) {
			pathStack.push(node);
			node = node.parent;
		}
		return pathStack;
	}
	
	public static void main(String[] args) {
		Point start = new Point(1, 1);
		Point end = new Point(10, 13);
		Stack<Point> stack = printPath(start, end);
		if (stack==null) {
			System.out.println("不可达");
		}else {
			while (!stack.isEmpty()) {
				System.out.print(stack.pop()+"->");
			}
			System.out.println();
		}
	}
}

class Point implements Comparable<Point>{
	int x;
	int y;
	Point parent;
	int F,G,H;
	
	public  Point(int x,int y) {
		super();
		this.x = x;
		this.y = y;
		this.F = 0;
		this.G = 0;
		this.H = 0;
	}
	
	@Override
		public int compareTo(Point o) {
			return this.F-o.F;
		}
	
	@Override
		public boolean equals(Object obj) {
			Point point = (Point)obj;
			if (point.x ==this.x&&point.y==this.y) {
				return true;
			}
			return false;
		}
	
	public static int getDis(Point p1,Point p2) {
		int dis = Math.abs(p1.x-p2.x)*10+Math.abs(p1.y-p2.y)*10;
		return dis;
	}
	
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
}

 
