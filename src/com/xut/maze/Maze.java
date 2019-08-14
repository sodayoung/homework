package com.xut.maze;
/** 
* @author:YK;
* @Description:主类
*/
import java.util.Stack;

class Maze {
	private int[][] maze;//二维数组代表迷宫，0代表可走，1不可走
	private Stack<Node> stack = new Stack<Node>();//栈，存放走过的路径
	
	public  Maze(int[][] maze) {
		this.maze = maze;
	}
	
	//查找路径
	public void findPath() {
		Node enter = new Node(0, 0);//入口节点
		Node exit = new Node(maze.length-1, maze[0].length-1);//出口节点
		Node curNode = enter;//初始节点
		Node nextNode = null;//下一个节点
		
		//当匹配到出口节点循环停止
		while (!curNode.equals(exit)) {
			nextNode = new Node(curNode.x, curNode.y);
			if ((curNode.x + 1) < maze.length && maze[curNode.x + 1][curNode.y] == 0) { //向下走
				nextNode.x++;
			} else if ((curNode.y + 1) < maze[0].length && maze[curNode.x][curNode.y + 1] == 0) { //向右走
				nextNode.y++;
			} else if ((curNode.x - 1) >= 0 && maze[curNode.x - 1][curNode.y] == 0) { //向上走
				nextNode.x--;
			} else if ((curNode.y - 1) >= 0 && maze[curNode.x][curNode.y - 1] == 0) { //向左走
				nextNode.y--;
			} else { 
				maze[curNode.x][curNode.y] = -1; // 标记为死路
				if (stack.isEmpty()) { // 判断栈是否为空
					System.out.println("没有路径");
					return;
				}
				curNode = stack.pop(); //弹出上一个节点
				continue; //继续循环
			}
			
			stack.push(curNode);//当前点入栈
			maze[curNode.x][curNode.y] = 6;//标记
			curNode = nextNode;//移动到当前点
		}
		//匹配到出口节点，入栈，标记
		if (nextNode.equals(exit)) {
			stack.push(nextNode);
			maze[nextNode.x][nextNode.y] = 6;
		}
		//输出栈中所有元素
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.elementAt(i));
		}
	}
}
