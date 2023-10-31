import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final int MAX = Integer.MAX_VALUE;

	private static class Node {

		int end;
		int weight;

		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}

	static int n;
	static int m;
	static int x;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");

		m = Integer.parseInt(split[1]);
		n = Integer.parseInt(split[0]);
		x = Integer.parseInt(split[2]);

		List<List<Node>> reverses = new ArrayList<>();
		List<List<Node>> nodes = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nodes.add(new ArrayList<>());
			reverses.add(new ArrayList<>());
		}

		int start, end, weight;
		for (int i = 0; i < m; i++) {
			split = br.readLine().split(" ");
			start = Integer.parseInt(split[0]);
			end = Integer.parseInt(split[1]);
			weight = Integer.parseInt(split[2]);

			nodes.get(end - 1).add(new Node(start, weight));
			reverses.get(start - 1).add(new Node(end, weight));
		}

		// 최단 거리 구하기
		int[] weights1 = dijkstra(nodes);
		int[] weights2 = dijkstra(reverses);

		int max = 0;
		int total;
		for (int i = 0; i < n; i++) {
			total = weights1[i] + weights2[i];
			if (total > max) {
				max = total;
			}
		}

		System.out.println(max);
	}

	private static int[] dijkstra(List<List<Node>> nodes) {
		int[] weights = new int[n];
		for (int i = 0; i < n; i++) {
			if (i == x - 1) {
				weights[i] = 0;
				continue;
			}
			weights[i] = MAX;
		}
		int[] visited = new int[n];

		// 모든 노드 방문
		for (int i = 0; i < n; i++) {

			// 1. 방문하지 않았으며 방문 가중치의 최솟값을 가지는 노드 찾기
			int min = MAX;
			int nowIndex = 0;
			for (int j = 0; j < n; j++) {
				if (visited[j] == 1) {
					continue;
				}
				if (weights[j] < min) {
					min = weights[j];
					nowIndex = j;
				}
			}

			visited[nowIndex] = 1;

			// 2. 해당 노드에 연결된 노드들 순회
			for (Node node : nodes.get(nowIndex)) {
				// 2-1. 방문했으면 패스
				if (visited[node.end - 1] == 1) {
					continue;
				}

				// 2-2. 가중치 비교하여 업데이트
				int updatedWeight = weights[nowIndex] + node.weight;
				if (updatedWeight < weights[node.end - 1]) {
					weights[node.end - 1] = updatedWeight;
				}
			}
		}
		return weights;
	}
}
