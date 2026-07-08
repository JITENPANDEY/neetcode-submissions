class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++) {
                if(board[i][j]=='.') continue;

                //check for row
                if(!set.add(board[i][j] + " in row " + i)){
                    return false;
                }

                //check for col
                if(!set.add(board[i][j] + " in col " + j)){
                    return false;
                }

                //check for grid
                int gridNumber = ((i/3)*3) + (j/3);
                if(!set.add(board[i][j] + " in grid " + gridNumber)){
                    return false;
                }
            }
        }
        for(String s : set){
            System.out.println(s);
        }
        return true;
    }
}
