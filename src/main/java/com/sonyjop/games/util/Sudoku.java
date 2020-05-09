package com.sonyjop.games.util;

import java.io.File;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Sudoku {
    //final int SIZE = 9;
    private Cell[][] board;
    private LinkedList<Set<Integer>> zones;
    private LinkedList<Set<Integer>> rows9;
    private LinkedList<Set<Integer>> cols9;
	public Sudoku(int size) {
        
        board = new Cell[size][size];
    }

    public void intialize() {
        File file = new File(getClass()
                        .getClassLoader().getResource("com/sonyjop/games/util/game1.txt").getFile());
        
        board = Utilities.readFromFile(file);
        Utilities.printBoard(board);
        zones = new LinkedList<Set<Integer>>();
        rows9 = new LinkedList<Set<Integer>>();
        cols9 = new LinkedList<Set<Integer>>();
        for(int i = 0; i < board.length; i ++) {
            zones.add(new HashSet<>());
            rows9.add(new HashSet<>());
            cols9.add(new HashSet<>());
        }
        this.findExclusions(board);
        this.solve(board);
    }

    public void findExclusions(Cell[][] board) {
        int size = board.length;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                int zone = this.zoneFinder(row, col);
                if(board[row][col].getValue() != 0 ) {
                    zones.get(zone - 1).add(board[row][col].getValue());
                    rows9.get(row).add(board[row][col].getValue());
                    cols9.get(col).add(board[row][col].getValue());    
                }
            }
        }
        /*Utilities.printExclusions(zones, "Zone");
        Utilities.printExclusions(rows9, "Row");
        Utilities.printExclusions(cols9, "Cols");*/
    }

    public void solve(Cell[][] board) {
        for (int row = 0; row< board.length; row++ ) {
            for (int col = 0; col < board.length; col++ ) {
                int zone = zoneFinder(row, col);
                HashSet possibility = new HashSet<>();
                possibility.addAll(zones.get(zone - 1));
                possibility.addAll(rows9.get(row));
                possibility.addAll(cols9.get(col));
                System.out.println("(" + row + "," + col + ") Possibility " + possibility);
            }
        }
    }
    private int zoneFinder(int row, int col) {
        int zone = 0;
        if(row < 3) {
            if(col < 3) //zone 1
                zone = 1;  
            else if(col >= 3 && col < 6) //zone 2
                zone = 2;
            else if(col >= 6 && col < 9) //zone 3
                zone = 3;
        } else if (row >= 3 && row < 6) {
            if(col < 3) //zone 4
                zone = 4;           
            else if(col >= 3 && col < 6) //zone 5
                zone = 5;
            else if(col >= 6 && col < 9) //zone 6
                zone = 6;
        } else if (row >= 6 && row < 9) {
            if(col < 3) //zone 7
                zone = 7;           
            else if(col >= 3 && col < 6) //zone 8
                zone = 8;
            else if(col >= 6 && col < 9) //zone 9
                zone = 9;
        }
        return zone;
    }
}