package review;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class 基本数据结构的使用 {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		//基于数组和链表实现的双端队列  --  实现方式不同
		Deque<Integer> dq = new LinkedList<Integer>();
		Deque<Integer> dq2 = new ArrayDeque<Integer>();
		
	}
}
