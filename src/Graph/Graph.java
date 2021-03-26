package Graph;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.AbstractMap.SimpleEntry;

public class Graph{
	static int BFSCOUNT = 0;
	static int DFSCOUNT = 0;

	static LinkedList<String> bfs(Map<String, String[]> graph, String startNode) { // 순차 탐색

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

	static Map<String, Integer> dijkstra(Map<String, Map<String, Integer>> graph, String startNode) {
		Map<String, Integer> distances = new HashMap<String, Integer>();
		Map<String, Integer> needVisit = new HashMap<String, Integer>();
		for (String key : graph.keySet()) {
			for (int i = 0; i < graph.size(); i++) {
				distances.put(key, 100000);
			}
		}
		distances.put(startNode, 0);
		PriorityQueue<Map.Entry<Integer, String>> queue = new PriorityQueue<Map.Entry<Integer,String>>(Graph::compare);
		
		int numbering =0;
		for (String key : distances.keySet()) {
			queue.add(new AbstractMap.SimpleEntry<Integer, String>(distances.get(key)+numbering, key));
			numbering++;
		}
		
		
		while(!queue.isEmpty()) {
			int currentDistance = queue.peek().getKey();
			String currentNode = queue.peek().getValue();
			queue.poll();
			if(distances.get(currentNode) < currentDistance) {
				continue;
			}
			
			for(int i = 0; i<graph.get(currentNode).size();i++) {
				String[] adjacent = new String[graph.get(currentNode).size()];
				int[] weight = new int[graph.get(currentNode).size()];
				for(String fKey : graph.keySet()) {
					for(String sKey : graph.get(fKey).keySet()) {
						int distance = 0;
						adjacent[i] = sKey;
						weight[i] = graph.get(fKey).get(sKey);
						distance = currentDistance + weight[i];
						System.out.println(distance);
						if(distance < distances.get(adjacent[i])) {
							distances.put(adjacent[i], distance);
							queue.add(new AbstractMap.SimpleEntry<Integer,String>(distance,adjacent[i]));
						}
						
					}
				}
			}
		}
		
		return distances;
	}
	
	static int compare(Map.Entry<Integer, String> a,Map.Entry<Integer, String> b) {
		return a.getKey()<b.getKey()?-1:a.getKey()>b.getKey()?1:0;
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

		Map<String, Map<String, Integer>> dijkstraGraph = new HashMap<String, Map<String, Integer>>();
		dijkstraGraph.put("A", new HashMap<String, Integer>());
		dijkstraGraph.put("B", new HashMap<String, Integer>());
		dijkstraGraph.put("C", new HashMap<String, Integer>());
		dijkstraGraph.put("D", new HashMap<String, Integer>());
		dijkstraGraph.put("E", new HashMap<String, Integer>());
		dijkstraGraph.put("F", new HashMap<String, Integer>());
		dijkstraGraph.get("A").put("B", 8);
		dijkstraGraph.get("A").put("C", 1);
		dijkstraGraph.get("A").put("D", 2);
		dijkstraGraph.get("C").put("B", 5);
		dijkstraGraph.get("C").put("D", 2);
		dijkstraGraph.get("D").put("E", 3);
		dijkstraGraph.get("D").put("F", 5);
		dijkstraGraph.get("E").put("F", 1);
		dijkstraGraph.get("F").put("A", 5);

//		for (String key : graph.keySet()) {
//			System.out.println("Key: " + key + "   Value: " + Arrays.toString(graph.get(key)));
//		}

		System.out.println("순차탐색법 : " + bfs(graph, "A") + " " + BFSCOUNT + "회 만에 찾았습니다.");
		System.out.println("깊이탐색법 : " + dfs(graph, "A") + " " + DFSCOUNT + "회 만에 찾았습니다.");
		System.out.println(dijkstra(dijkstraGraph, "A"));
	}

}
