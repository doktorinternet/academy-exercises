package com.company.week1.day4.terminal;

import com.company.ToolBox;
import com.googlecode.lanterna.*;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class ChessBoard {

    static ToolBox tb = new ToolBox();
    static Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
    static boolean[][] board = new boolean[8][8];

    public  static void run(){

        terminal.enterPrivateMode();
        terminal.applyBackgroundColor(Terminal.Color.GREEN);
        terminal.applyForegroundColor(Terminal.Color.BLUE);
        drawBoardV2();
        /*for (int i=0;i<5;i++) {
            terminal.moveCursor(,i);
            terminal.putCharacter('O');
            terminal.moveCursor(i,5);
            terminal.putCharacter('X');
        }*/

    }

    public static void drawBoard() {
        boolean[][] board = new boolean[8][8];

        for (int xAxis = 0; xAxis < 8; xAxis++) {
            for (int yAxis = 0; yAxis < 8; yAxis++) {
                if (tb.isEven(xAxis) ^ tb.isEven(yAxis)) {
                    board[xAxis][yAxis] = true;
                    //System.out.println('O');
                } else if (tb.isEven(xAxis) ^ tb.isEven(yAxis)) {
                    board[xAxis][yAxis] = false;
                    //System.out.println('X');
                }

            }
        }
        String output = "";
        for (boolean[] x : board) {
            for (boolean y : x) {
                if (y) {
                    output = output.concat("O ");
                } else {
                    output = output.concat("X ");
                }
            }
            output = output.concat("\n");
        }
        System.out.println(output);
    }

    private static void printCharacter(boolean b, int x, int y){
        board[x][y] = b;
        terminal.moveCursor(x,y);
        System.out.print(' ');
        //terminal.putCharacter(' ');
        if(b) {
            System.out.print('O');
            terminal.putCharacter('\u263a');
        }
        else if(!b){
            System.out.print('X');
            terminal.putCharacter('X');
        }
        System.out.print(' ');
        //terminal.putCharacter(' ');
    }

    public static void drawBoardV2() {

        boolean original = true;
        for (int xAxis = 0; xAxis < 8; xAxis++) {
            for (int yAxis = 0; yAxis < 8; yAxis++) {
                printCharacter(original, xAxis, yAxis);
                original = !original;
            }
            original = !original;
            System.out.println();
        }
    }
}
