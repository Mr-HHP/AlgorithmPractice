package other.od200;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Mr.黄
 * @description 5G网络建设
 * @since 2024/7/15 16:45
 **/
public class Main6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        List<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            int z = scanner.nextInt();
            int p = scanner.nextInt();
            if (p == 1) {
                z = 0;
            }
            edgeList.add(new Edge(x, y, z));
        }
        Collections.sort(edgeList);
        UnionFind unionFind = new UnionFind(n);
        int totalCost = 0;
        int edgeUsed = 0;
        for (Edge edge : edgeList) {
            int u = edge.u;
            int v = edge.v;
            if (unionFind.union(u, v)) {
                totalCost += edge.cost;
                edgeUsed++;
                if (edgeUsed == n - 1) {
                    break;
                }
            }
        }
        if (edgeUsed == n - 1) {
            System.out.println(totalCost);
        } else {
            System.out.println(-1);
        }
    }
}

class Edge implements Comparable<Edge> {
    int u;
    int v;
    int cost;

    public Edge(int u, int v, int cost) {
        this.u = u;
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}

class UnionFind {
    private int[] parent;

    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
            return true;
        }
        return false;
    }
}
