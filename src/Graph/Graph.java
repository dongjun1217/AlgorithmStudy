package Graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	static int BFSCOUNT = 0;
	static int DFSCOUNT = 0;

	static LinkedList<String> bfs(Map<String, String[]> graph,String startNode) { // 순차 탐색

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

	static LinkedList<String> dfs(Map<String, String[]> graph, String startNode) { // 깊이 탐색
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

		System.out.println("순차탐색법 : " + bfs(graph,"A") + " " + BFSCOUNT + "회 만에 찾았습니다.");
		System.out.println("깊이탐색법 : " + dfs(graph,"A") + " " + DFSCOUNT + "회 만에 찾았습니다.");
	}

}
