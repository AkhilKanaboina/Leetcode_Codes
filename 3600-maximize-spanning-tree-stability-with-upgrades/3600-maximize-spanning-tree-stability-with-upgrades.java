
class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];

            for (int i = 0; i < n; i++)
                parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pb] < rank[pa]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }

            return true;
        }
    }

    public int maxStability(int n, int[][] edges, int k) {

        int max = 0;
        for (int[] e : edges)
            max = Math.max(max, e[2]);

        int low = 1, high = max * 2;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canBuild(n, edges, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean canBuild(int n, int[][] edges, int k, int target) {

        DSU dsu = new DSU(n);
        int used = 0;

        // Step 1: add mandatory edges
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 1) {
                if (s < target) return false;

                if (!dsu.union(u, v))
                    return false;

                used++;
            }
        }

        // Step 2: use optional edges already >= target
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 0 && s >= target) {
                if (dsu.union(u, v))
                    used++;
            }
        }

        // Step 3: use upgrades if possible
        for (int[] e : edges) {
            int u = e[0], v = e[1], s = e[2], must = e[3];

            if (must == 0 && s < target && s * 2 >= target && k > 0) {
                if (dsu.union(u, v)) {
                    used++;
                    k--;
                }
            }
        }

        return used == n - 1;
    }
}