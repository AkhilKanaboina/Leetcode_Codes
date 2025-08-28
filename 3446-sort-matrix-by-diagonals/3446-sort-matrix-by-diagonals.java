class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        // diagonals starting from first column -> sort descending
        for (int i = n - 1; i >= 0; i--) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n && (i + j) < n; j++) {
                list.add(grid[i + j][j]);
            }
            Collections.sort(list, Collections.reverseOrder());
            for (int j = 0; j < n && (i + j) < n; j++) {
                grid[i + j][j] = list.get(j);
            }
        }

        // diagonals starting from first row (skip col=0) -> sort ascending
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n && (i + j) < n; j++) {
                list.add(grid[j][i + j]);
            }
            Collections.sort(list); // ascending
            for (int j = 0; j < n && (i + j) < n; j++) {
                grid[j][i + j] = list.get(j);
            }
        }

        return grid;
    }
}
