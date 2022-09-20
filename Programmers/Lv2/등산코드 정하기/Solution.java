import java.util.*;

class Solution {

    static int distance[], INFINITY, answer[];
    static List<Edge>[] edgelist;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        INFINITY = Integer.MAX_VALUE;
        distance = new int[n + 1];
        edgelist = new ArrayList[n + 1];
        answer = new int[] { 0, INFINITY };

        for (int i = 1; i <= n; i++) {
            edgelist[i] = new ArrayList<Edge>();
        }

        for (int p = 0; p < paths.length; p++) {
            int s = paths[p][0];
            int e = paths[p][1];
            int w = paths[p][2];

            if (isGate(gates, s) || isSummit(summits, e)) {
                edgelist[s].add(new Edge(e, w));
            } else if (isGate(gates, e) || isSummit(summits, s)) {
                edgelist[e].add(new Edge(s, w));
            } else {
                edgelist[s].add(new Edge(e, w));
                edgelist[e].add(new Edge(s, w));
            }
        }

        Dijkstra(n, summits, gates);
        // Arrays.sort(summits);
        int min_intensity = INFINITY;

        for (int s : summits) {
            if ((distance[s] == min_intensity && answer[0] > s) || (distance[s] < min_intensity)) {
                min_intensity = distance[s];
                answer[0] = s;
                answer[1] = min_intensity;
            }
        }
        return answer;
    }

    private void Dijkstra(int n, int[] summits, int[] gates) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        Arrays.fill(distance, INFINITY);
        for (int g = 0; g < gates.length; g++) {
            distance[gates[g]] = 0;
            pq.offer(new Edge(gates[g], 0));
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.weight < distance[cur.end])
                continue;

            for (Edge e : edgelist[cur.end]) {
                int dis = Math.max(distance[cur.end], e.weight);
                if (distance[e.end] > dis) {
                    distance[e.end] = dis;
                    pq.offer(new Edge(e.end, distance[e.end]));
                }
            }
        }
    }

    private boolean isSummit(int[] summits, int end) {
        for (int s : summits) {
            if (s == end)
                return true;
        }
        return false;
    }

    private boolean isGate(int[] gates, int end) {
        for (int g : gates) {
            if (g == end)
                return true;
        }
        return false;
    }

    private static class Edge implements Comparable<Edge> {
        int end, weight;

        public Edge(int end, int weight) {
            super();
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }
}