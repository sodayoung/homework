package com.xut.maze;
/** 
* @author:YK;
* @date:2019年8月6日 下午4:09:25;
* @Description:
*/
public class Main {
	public static void main(String[] args) {
		int[][] maze = new int[][] {
					{ 0, 1, 0, 0, 0 }, 
					{ 0, 1, 0, 1, 0 }, 
					{ 0, 0, 0, 0, 0 }, 
					{ 0, 1, 1, 1, 0 },
					{ 0, 0, 0, 1, 0 }};
		Maze mazeDemo = new Maze(maze);
		mazeDemo.findPath();
	}
}
