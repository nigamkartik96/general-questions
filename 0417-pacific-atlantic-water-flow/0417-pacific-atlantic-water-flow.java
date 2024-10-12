class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            queue.add(new Pair(i, 0, heights[i][0]));
        }

        for (int i = 1; i < n; i++) {
            queue.add(new Pair(0, i, heights[0][i]));
        }

        bfs(heights, pacificVisited, queue, m, n);

        queue = new LinkedList<>();
        for (int i = 0; i < m - 1; i++) {
            queue.add(new Pair(i, n - 1, heights[i][n - 1]));
        }

        for (int i = 0; i < n; i++) {
            queue.add(new Pair(m - 1, i, heights[m - 1][i]));
        }

        bfs(heights, atlanticVisited, queue, m, n);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    static class Pair {
        int i, j;
        int height;

        Pair(int i, int j, int height) {
            this.i = i;
            this.j = j;
            this.height = height;
        }
    }

    private void bfs(int[][] heights, boolean[][] visited, Queue<Pair> queue, int m, int n) {
        int x[] = {0, 0, 1, -1};
        int y[] = {1, -1, 0, 0};
        
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            visited[pair.i][pair.j] = true;

            for (int i = 0; i <= 3; i++) {
                int i_x = pair.i + x[i];
                int j_y = pair.j + y[i];

                if (isValid(i_x, j_y, pair.height, heights, visited, m, n)) {
                    queue.add(new Pair(i_x, j_y, heights[i_x][j_y]));
                }
            }
        }
    }

    private boolean isValid(
        int i, int j, int height, 
        int[][] heights, boolean[][] visited, 
        int m, int n
    ) {
        return i >= 0 && j >= 0 
            && i < m && j < n 
            && height <= heights[i][j] 
            && !visited[i][j];
    }
}