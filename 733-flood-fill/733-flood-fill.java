class Solution {
    
    int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
    
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int startColor = image[sr][sc];
        if (startColor == newColor) return image;
        image[sr][sc] = newColor;
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{sr, sc});
        
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                int[] rem = queue.poll();
                for (int[] dir : dirs) {
                    int r = rem[0] + dir[0];
                    int c = rem[1] + dir[1];
                    if (r >= 0 && c >= 0 && r < image.length && c < image[0].length && image[r][c] == startColor) {
                        queue.offer(new int[]{r, c});
                        image[r][c] = newColor;               
                    }
                }
            }
        }
        
        return image;
        
    }
}