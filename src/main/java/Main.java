
import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        int column = 0;
        int row = 0;
        int i = 0;
        int[][] board = new int[8][8];
        while (column <= 7) {
            if (column <= 1) {
                board[column][row] = i%2;
                i+=1;
                row+=1;
            } else if (column >= 6) {
                board[column][row] = i%2;
                i+=1;
                row+=1;
            } else {
                board[column][row] = 0;
                i+=1;
                row+=1;
            }

            if (row == 8) {
                column += 1;
                row = 0;
                i+=1;
            }
        }
        System.out.println(Arrays.deepToString(board).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }
}
