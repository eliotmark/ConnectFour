import java.util.Scanner;

public class Board {


    boolean gameOn = true;


    private String[][] grid = new String[6][7];
    boolean winner = false;

    public Board() {
       populateBoard();
    }

    public void populateBoard(){
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                grid[i][j] = "\uD83E\uDDF0";
            }
        }
    }


    public void printBoard(){
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){

                System.out.print(grid[i][j] + "\t");

            }
            System.out.print("\n");
        }
        System.out.println(grid.length);
    }


    public void handleMove(String player, int col){
        if(col!=-1){
            if(player.equals("1")){
                player = "\uD83D\uDD34";
            }
            if(player.equals("2")){
                player = "\uD83D\uDD35";
            }
            col = col-1;
            for(int i=grid.length-1; i>=0; i--){
                if(grid[i][col].equals("\uD83E\uDDF0")){
                    grid[i][col]= player;
                    break;
                }
            }
        }
    }



    public boolean checkWinner() {
        for(int i=0; i<6; i++){
            for(int j=0; j<7; j++){
                if(grid[i][j].equals("\uD83D\uDD34") || grid[i][j].equals("\uD83D\uDD35")){
                    gameOn = check4(i,j);
                    if(gameOn == false){break;}
                }
            }
        }
        return gameOn;
    }

    public boolean check4(int x, int y){
        String piece = grid[x][y];
        int countX = 1;
        int countY = 1;

        int rightLength = grid.length-y-1;
        int leftLength = y;
        int downLength = grid.length-x-1;
        int upLength = x;

        for(int a=1; a<upLength; a++){
            if(grid[x-a][y].equals(piece) && grid[x-a+1][y].equals(piece)){
                countX++;
            }
        }
        for(int b=1; b<downLength; b++){
            if(grid[x+b][y].equals(piece) && grid[x+b-1][y].equals(piece)){
                countX++;
            }
        }
        for(int c=1; c<rightLength; c++){
            if(grid[x][y+c].equals(piece) && grid[x][y+c-1].equals(piece)){
                countY++;
            }
        }
        for(int d=1; d<leftLength; d++){
            if(grid[x][y-d].equals(piece) && grid[x][y-d+1].equals(piece)){
                countY++;
            }

        }

//        System.out.println(countX);
//        System.out.println(countY);
        if(countX==4 || countY==4){
            return false;
        }
       return true;

    }

}