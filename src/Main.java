import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("!!Tic Tac Toe Game!!");
        char[][] gridBoard = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gridBoard[i][j] = ' ';
            }
        }
        char player = 'x';
        boolean gameover = false;
        Scanner input = new Scanner(System.in);
        while(!gameover){
            print(gridBoard);
            System.out.println("Player "+player+" enter : ");
            int entry = input.nextInt();
            if(entry<0){
                System.out.println("Ops Sorry, no one won this game. Try again to win.");
                break;
            }
            int row = entry/10;
            int col = entry%10;
            if(gridBoard[row][col]==' '){
                gridBoard[row][col]=player;
                gameover=won(gridBoard, player);
                if (gameover){
                    System.out.println("Player "+player+" has won the game");
                } else{
                    if (player=='x'){
                        player='0';
                    } else{
                        player='x';
                    }
                }
            } else {
                System.out.println("Invalid move, plz try again!");
            }
        }
        print(gridBoard);
        boolean status = lose(gridBoard, player);
        if(status){
            System.out.println("Congratulations player "+player);
        } else{
            System.out.println("Ops Sorry, no one won this game. Try again to win.");
        }
    }
    public static boolean won(char[][] gridboard, char player){
        for (int i = 0; i < 3; i++) {
            if (gridboard[i][0]==player&&gridboard[i][1]==player&&gridboard[i][2]==player){
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (gridboard[0][i]==player&&gridboard[1][i]==player&&gridboard[2][i]==player){
                return true;
            }
        }
        if (gridboard[0][0]==player&&gridboard[1][1]==player&&gridboard[2][2]==player){
            return true;
        }
        if (gridboard[0][2]==player&&gridboard[1][1]==player&&gridboard[2][0]==player){
            return true;
        }
        return false;
    }
    public static boolean lose(char[][] gridboard, char player){
        boolean b = won(gridboard, player);
        return b;
    }
    public static void print(char[][] gridboard){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(gridboard[i][j]+" | ");
            }
            System.out.println();
        }
    }
}