package com.company.week1.day4.terminal;

import com.company.ToolBox;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.Random;

public class RandomBoard {
    static ToolBox tb = new ToolBox();
    static Random rand = new Random();


    // sätt storlek på array, detta täckte min skärm. Delay är hur ofta den ska rita om, håll inne valfri tangent för
    // att köra. Hittade ingen metod för att sätta terminalens fönsterstorlek, men går att maximera under körning
    static int xCells = 150, yCells = 100, delay = 50;

    private static Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
    private static int[][] board = new int[xCells][yCells];

    public static void run() { // Gör till main
        terminal.enterPrivateMode();
        drawTerminal();
    }

    private static void drawGrid() {

        for(int i = 0; i<(xCells*2); i++){
            int x = rand.nextInt(xCells);
            int y = rand.nextInt(yCells);
            board[x][y] = rand.nextInt(1);

        }

        for (int xAxis = 0; xAxis < xCells; xAxis++) {
            for (int yAxis = 0; yAxis < yCells; yAxis++) {

                terminal.moveCursor(xAxis,yAxis);
                terminal.applyForegroundColor(board[xAxis][yAxis]);
                terminal.putCharacter('\u2588');
               /* for(int i = 0; i < 3; i++){
                    xAxis
                    terminal.moveCursor(xAxis,yAxis);
                    terminal.applyForegroundColor(board[xAxis][yAxis]);
                    terminal.putCharacter('\u2588');

                }
                terminal.moveCursor(xAxis,yAxis);
                terminal.applyForegroundColor(board[xAxis][yAxis]);
                terminal.putCharacter('\u2588');*/
            }
        }
    }

    private static void drawTerminal(){
        while(true) {

            //Add one random color to the board
            int xx = rand.nextInt(xCells);
            int yy = rand.nextInt(yCells);
            board[xx][yy]= rand.nextInt(1); // rand.nextInt(255); // 256


            drawGrid();

            // Formula to take the average value of the current cell
            // and all of its neighbors
            int [][] tmpboard = new int[xCells][yCells];
            for (int y = 1; y < yCells-1; y++) {
                for (int x = 1; x < xCells-1; x++) {
                    int color = 0;
                    color += board[x - 1][y - 1]; //
                    color += board[x + 1][y - 1];
                    color += board[x ][y - 1];
                    color += board[x - 1][y];
                    color += board[x ][y];
                    color += board[x + 1][y];
                    color += board[x ][y + 1];
                    color += board[x - 1][y + 1];
                    color += board[x + 1][y + 1];
                    if(color>0) color /= 9;
            tmpboard[x][y] = color; } }
            board = tmpboard;

            //Wait for a key to be pressed

            Key key;
            do{
                try{
                    Thread.sleep(delay);
                } catch (InterruptedException i){
                    System.out.println("Error in waiting for keypress" + i);
                    System.exit(0);
                }

                key = terminal.readInput();
                board[xx][yy] = rand.nextInt(256);

            } while(key == null); }

    }

}
