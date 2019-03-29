import java.util.Scanner;

public class Runner {

    public static void main(String[] args){

        //just once
        Scanner sc = new Scanner(System.in);
        Board b = new Board();
        String whichPlayer = "1";


        //repeat every turn

        while(b.gameOn) {
            b.printBoard();
            System.out.println("Which column would you like to put your piece?");
            int selection = sc.nextInt();
            int col = -1;
            if(selection<=7){
                col = selection;
                b.handleMove(whichPlayer, col);
                if(whichPlayer.equals("1")){
                    whichPlayer = "2";
                }else{
                    whichPlayer = "1";
                }
            }else{
                System.out.println("You cannot choose that column.");
            }
           if(!b.checkWinner()){
                b.printBoard();
                System.out.println("You Won!!");
            }
        }




        //b.populateBoard();


    }
}
