import java.util.*;

public class Connect4Board extends TicTacToeBoard {

   public Connect4Board() {
      board = new char[6][7]; // rows, cols
      marked = 0;
      
      // fill the top 5 rows with periods
      for(int r = 0; r < 5; r++) {
         for(int c = 0; c < 7; c++) {
            board[r][c] = '.';
         }
      }
      
      //fill the bottom row with spots 1-7
      for(int c = 0; c < 7; c++) {
         board[5][c] = (char)(c + 49);
      }
   }
   
   public boolean mark(int spot, char player) {
      boolean success = super.mark(spot, player);
      if(success) {
         for(int r = board.length - 1; r >= 0; r--) {
            if(board[r][spot-1] == '.') {
               board[r][spot-1] = (char)(spot + 48);
            }
         }
      }
      return success;
   }
   
   public boolean checkWinner() {
      return false;
   }
   
   public String toString() {
      String strBoard = "";
      for(int r = 0; r < board.length; r++) {
         strBoard += "||";
         for(int c = 0; c < board[r].length; c++) {
            strBoard += board[r][c];
         }
         strBoard += "||\n";
      }
      strBoard += "=========\n";
      strBoard += ")(      )(";
      return strBoard;
   }

}

