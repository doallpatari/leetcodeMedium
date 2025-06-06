import java.util.LinkedList;
import java.util.Queue;


public class MatrixTraversal {
        public void bfs(char[][] grid, int row, int col){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        grid[row][col] = '0';
        while(!q.isEmpty()){
            int[] node = q.poll();
            int l = node[0], r = node[1];
            if(l-1>=0 && grid[l-1][r] == '1'){q.add(new int[]{l-1, r}); grid[l-1][r]='0';} 
            if(r-1>=0 && grid[l][r-1] == '1'){q.add(new int[]{l, r-1}); grid[l][r-1]='0';}
            if(l+1<grid.length && grid[l+1][r] == '1'){q.add(new int[]{l+1, r}); grid[l+1][r]='0';}
            if(r+1<grid[0].length && grid[l][r+1] == '1'){q.add(new int[]{l, r+1}); grid[l][r+1]='0';}
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }


    void dfs(char[][] board, int i, int j, int m, int n){
            if(i<0 || i>=m || j<0 || j>=n || board[i][j]!='O') return;
            board[i][j]='#';
            dfs(board, i+1, j, m, n);
            dfs(board, i-1, j, m, n);
            dfs(board, i, j+1, m, n);
            dfs(board, i, j-1, m, n);
        }
    public void surroundedRegions(char[][] board) {

        
        int m = board.length, n = board[0].length;
        for(int i = 0; i<m;i++){
            if(board[i][0] == 'O'){
                dfs(board, i, 0, m, n);
            }
            if(board[i][n-1] == 'O'){
                dfs(board, i, n-1, m, n);
            }
        }

        for(int j=0;j<n;j++){
            if(board[0][j] == 'O'){
                dfs(board, 0, j, m, n);
            }
            if(board[m-1][j] == 'O'){
                dfs(board, m-1, j, m, n);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
    }
}