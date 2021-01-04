import java.util.Scanner;

public class ticTacToe {
    public static void main(String[] args) {
        char board[][] = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        Scanner in = new Scanner(System.in);
        boolean checkWinner = false;
        int playerTurn = 0;
        

        //start of the game
        System.out.println("Hello players, welcome to Tic-Tac-Toe");
        System.out.println("player one will start, and you will be x");
        System.out.println("Player two will be o");
        System.out.println("here is the board");
        System.out.println("\t " + "||" + " " + " ||" + " ");
        System.out.println("=====||==||=====");
        System.out.println("\t " + "||" + " " + " ||" + " ");
        System.out.println("=====||==||=====");
        System.out.println("\t " + "||" + " " + " ||" + " ");



        //Player one's turn
        while (playerTurn < 9) {
            if (playerTurn % 2 == 0) {
                System.out.println("player one enter the row you would like(1-3)");
                int rowsP1 = in.nextInt();
                if (rowsP1 < 1 || rowsP1 > 3) {
                    System.out.println("Sorry that isn't between 1-3, try again");
                    continue;
                }
                System.out.println("now you may put in the column you would like(1-3)");
                int colsP1 = in.nextInt();
                if (colsP1 < 1 || colsP1 > 3) {
                    System.out.println("Sorry that isn't between 1-3, try again");
                    continue;
                }

                if (board[rowsP1 - 1][colsP1 - 1] != ' ') {
                    System.out.println("that spot is taken try again");
                } else {
                    board[rowsP1 - 1][colsP1 - 1] = 'x';
                    System.out.println("\t" + board[0][0] + "||" + board[0][1] + " ||" + board[0][2]);
                    System.out.println("=====||==||=====");
                    System.out.println("\t" + board[1][0] + "||" + board[1][1] + " ||" + board[1][2]);
                    System.out.println("=====||==||=====");
                    System.out.println("\t" + board[2][0] + "||" + board[2][1] + " ||" + board[2][2]);
                    playerTurn++;
                }

                if (winChecker(board)) {
                    System.out.println("congratulations player one, you won");
                    break;
                }
            }
            if (playerTurn==9){
                System.out.println("there are no more spaces,game over");
                break;
            }
            //player two's turn
            if (playerTurn % 2 != 0) {
                System.out.println("player two enter the row you would like(1-3)");
                int rowsP2 = in.nextInt();
                if (rowsP2 < 1 || rowsP2 > 3) {
                    System.out.println("Sorry that isn't between 1-3, try again");
                    continue;
                }
                System.out.println("now you may put the column you would like(1-3)");
                int colsP2 = in.nextInt();
                if (colsP2 < 1 || colsP2 > 3) {
                    System.out.println("Sorry that isn't between 1-3, try again");
                    continue;
                }
                if (board[rowsP2 - 1][colsP2 - 1] != ' ') {
                    System.out.println("that spot is taken try again");
                    continue;
                } else {
                    board[rowsP2 - 1][colsP2 - 1] = 'O';
                    System.out.println("\t" + board[0][0] + "||" + board[0][1] + " ||" + board[0][2]);
                    System.out.println("=====||==||=====");
                    System.out.println("\t" + board[1][0] + "||" + board[1][1] + " ||" + board[1][2]);
                    System.out.println("=====||==||=====");
                    System.out.println("\t" + board[2][0] + "||" + board[2][1] + " ||" + board[2][2]);
                    playerTurn++;

                }
                if (winChecker(board)) {
                    System.out.println("congratulations player two, you won");
                    break;
                }
            }
        }
    }



    //7 win cons check
    public static boolean winChecker(char arr[][]) {
        for (int i = 0; i < 3; i++) {
            if (arr[i][0] != ' ' && arr[i][0] == arr[i][1] && arr[i][1] == arr[i][2]) {
                return true;
            }
            if (arr[0][i] != ' ' && arr[0][i] == arr[1][i] && arr[1][i] == arr[2][i]) {
                return true;
            }
        }
        if (arr[0][0] != ' ' && arr[0][0] == (arr[1][1]) && arr[1][1] == (arr[2][2])) {
            return true;
        }
        if (arr[0][2] != ' ' && arr[0][2] == (arr[1][1]) && arr[1][1] == (arr[2][0])) {
            return true;
    }
        return false;
    }
}
