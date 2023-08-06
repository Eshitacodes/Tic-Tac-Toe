import java.util.*;
class TicforTack
{
    static char[][] board = new char[3][3];
    static int row,col;
    static char player='X';
    static int countSpace=9;
 public static void main(String[] args) 
 {
    
    for(row=0;row<board.length;row++)
    {
        for(col=0;col<board.length;col++)
        {
            board[row][col]=' ';
        }
    }

    printBoard(board);
    
    while(!gameOver(board) && countSpace!=0)
    {
        player=player=='X'?'O':'X';
        System.out.println("Player "+player+" \nRow : Column");
        Scanner src=new Scanner(System.in);
        row=src.nextInt();
        col=src.nextInt();
       if(board[row-1][col-1]==' ')
       {
         board[row-1][col-1]=player;
         countSpace--;
       }
       else
       {
        System.out.println("Invalid Choice");
       }
       printBoard(board);
    }
    if(countSpace==0)
    {
        System.out.println("It's a Tie!");
    }
    else
    {
        System.out.println("Game Over! \nPlayer "+player+ " wins!");
    }
    
    
 } 

 public static boolean gameOver(char[][] board)
 {
    if((board[0][0]==player && board[1][1]==player && board[2][2]==player)||(board[0][2]==player && board[1][1]==player && board[2][0]==player))
    {
        return true;
    }
    for(row=0;row<3;row++)
    {
        if(board[row][0]==player && board[row][1]==player && board[row][2]==player)
        {
            return true;
        }
        else if(board[0][row]==player && board[1][row]==player && board[2][row]==player)
        {
            return true;
        }
    }
    return false;
 }
 
 public static void printBoard(char[][] board)
 {
   for(int row=0;row<3;row++)
    {
        for(int col=0;col<3;col++)
        {
            System.out.print(board[row][col]);
            if(col!=2)
            {
                System.out.print("|");
            }
        }
        System.out.println();
        if(row!=2)
            {
                System.out.println("_ _ _");
            }
    }   

 }
}