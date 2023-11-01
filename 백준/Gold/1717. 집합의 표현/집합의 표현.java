import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	private static int[] nodes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		nodes = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			nodes[i] = i;
		}

		StringBuilder sb = new StringBuilder();
		int chk, node1, node2;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			chk = Integer.parseInt(st.nextToken());
			node1 = Integer.parseInt(st.nextToken());
			node2 = Integer.parseInt(st.nextToken());

			int main1 = find(node1);
			int main2 = find(node2);

			if (chk == 0) {
				// 더 작은 대표 노드로 모든 연결 노드 대표값 바꾸기
				union(main1, main2);
			} else {
				// 두 대표 노드가 같은지 판단
				if (main1 == main2) {
					sb.append("YES");
				} else {
					sb.append("NO");
				}
				sb.append("\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	private static int find(int node) {
		if (node == nodes[node]) {
			return node;
		}
		return nodes[node] = find(nodes[node]);
	}

	private static void union(int node1, int node2) {
		if (node1 == node2) {
			return;
		}

		if (node1 < node2) {
			nodes[node2] = node1;
		} else {
			nodes[node1] = node2;
		}
	}
}