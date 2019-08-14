package com.xut.maze;
/** 
* @author:YK;
* @Description:����
*/
import java.util.Stack;

class Maze {
	private int[][] maze;//��ά��������Թ���0������ߣ�1������
	private Stack<Node> stack = new Stack<Node>();//ջ������߹���·��
	
	public  Maze(int[][] maze) {
		this.maze = maze;
	}
	
	//����·��
	public void findPath() {
		Node enter = new Node(0, 0);//��ڽڵ�
		Node exit = new Node(maze.length-1, maze[0].length-1);//���ڽڵ�
		Node curNode = enter;//��ʼ�ڵ�
		Node nextNode = null;//��һ���ڵ�
		
		//��ƥ�䵽���ڽڵ�ѭ��ֹͣ
		while (!curNode.equals(exit)) {
			nextNode = new Node(curNode.x, curNode.y);
			if ((curNode.x + 1) < maze.length && maze[curNode.x + 1][curNode.y] == 0) { //������
				nextNode.x++;
			} else if ((curNode.y + 1) < maze[0].length && maze[curNode.x][curNode.y + 1] == 0) { //������
				nextNode.y++;
			} else if ((curNode.x - 1) >= 0 && maze[curNode.x - 1][curNode.y] == 0) { //������
				nextNode.x--;
			} else if ((curNode.y - 1) >= 0 && maze[curNode.x][curNode.y - 1] == 0) { //������
				nextNode.y--;
			} else { 
				maze[curNode.x][curNode.y] = -1; // ���Ϊ��·
				if (stack.isEmpty()) { // �ж�ջ�Ƿ�Ϊ��
					System.out.println("û��·��");
					return;
				}
				curNode = stack.pop(); //������һ���ڵ�
				continue; //����ѭ��
			}
			
			stack.push(curNode);//��ǰ����ջ
			maze[curNode.x][curNode.y] = 6;//���
			curNode = nextNode;//�ƶ�����ǰ��
		}
		//ƥ�䵽���ڽڵ㣬��ջ�����
		if (nextNode.equals(exit)) {
			stack.push(nextNode);
			maze[nextNode.x][nextNode.y] = 6;
		}
		//���ջ������Ԫ��
		for (int i = 0; i < stack.size(); i++) {
			System.out.print(stack.elementAt(i));
		}
	}
}
