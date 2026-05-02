class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        List<List<Set<Integer>>> squares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }
        for (int i = 0; i < 3; i++) {
            squares.add(new ArrayList<>());
            for (int j = 0; j < 3; j++) {
                squares.get(i).add(new HashSet<>());
            }
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char strval = board[row][col];
                if (strval == '.') {
                    continue;
                }
                int val = Integer.parseInt(String.valueOf(strval));
                if (rows.get(row).contains(val)
                    || cols.get(col).contains(val)
                    || squares.get(row/3).get(col/3).contains(val)) {
                        return false;
                    }
                rows.get(row).add(val);
                cols.get(col).add(val);
                squares.get(row/3).get(col/3).add(val);
            }
        }
        return true;
    }
}
