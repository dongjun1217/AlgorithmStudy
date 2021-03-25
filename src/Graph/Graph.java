package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	static int BFSCOUNT = 0;
	static int DFSCOUNT = 0;

	static LinkedList<String> bfs(Map<String, String[]> graph,String startNode) { // ���� Ž��

		LinkedList<String> visited = new LinkedList<String>();
		Queue<String> needVisit = new LinkedList<String>();
		needVisit.offer(startNode);
		while (!needVisit.isEmpty()) {
			BFSCOUNT++;
			String node = needVisit.poll();
			if (!visited.contains(node)) {
				visited.offer(node);
				for (int i = 0; i < graph.get(node).length; i++) {
					needVisit.offer(graph.get(node)[i]);
				}
			}
		}
		return visited;
	}

	static LinkedList<String> dfs(Map<String, String[]> graph, String startNode) { // ���� Ž��
		LinkedList<String> visited = new LinkedList<String>();
		Stack<String> needVisit = new Stack<String>();
		needVisit.push(startNode);
		while (!needVisit.isEmpty()) {
			DFSCOUNT++;
			String node = needVisit.pop();
			if (!visited.contains(node)) {
				visited.offer(node);
				for (int i = 0; i < graph.get(node).length; i++) {
					needVisit.push(graph.get(node)[i]);
				}
			}
		}
		return visited;
	}

	public static void main(String[] args) {

		Map<String, String[]> graph = new HashMap<>();
		graph.put("A", new String[] { "B", "C" });
		graph.put("B", new String[] { "A", "D" });
		graph.put("C", new String[] { "A", "G", "H", "I" });
		graph.put("D", new String[] { "B", "E", "F" });
		graph.put("E", new String[] { "D" });
		graph.put("F", new String[] { "D" });
		graph.put("G", new String[] { "C" });
		graph.put("H", new String[] { "C" });
		graph.put("I", new String[] { "C", "J" });
		graph.put("J", new String[] { "I" });

//		for (String key : graph.keySet()) {
//			System.out.println("Key: " + key + "   Value: " + Arrays.toString(graph.get(key)));
//		}

		System.out.println("����Ž���� : " + bfs(graph,"A") + " " + BFSCOUNT + "ȸ ���� ã�ҽ��ϴ�.");
		System.out.println("����Ž���� : " + dfs(graph,"A") + " " + DFSCOUNT + "ȸ ���� ã�ҽ��ϴ�.");
	}

}
