package com.xut.maze;
/** 
* @author:YK;
* @Description:½ÚµãÀà
*/
class Node {
	int x;
	int y;
	
	public  Node(int x,int y) {
		this.x = x;
		this.y = y;
	}
	
	public boolean equals(Node node) {
		return (x==node.x)&&(y==node.y);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
