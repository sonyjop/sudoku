package com.sonyjop.games.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Utilities {

    public static Cell[][] readFromFile(File file) {
        Cell[][] retArr = new Cell[9][9];
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                int j = 0;
                String[] nums = line.split(",");
                for (String string : nums) {
                    retArr[i][j++] = new Cell(Integer.parseInt(string));
                }
                ++i;
            }
        } catch (Throwable fne) {
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return retArr; 
    }

    public static void printBoard(Cell[][] board) {
        for (Cell[] row : board) {
            for (Cell col : row) {
                System.out.print(col.getValue() + " | ");
            }
            System.out.println("\n===================================");
        }
    }
    public static void printExclusions(List exclusion, String type) {
        int size = exclusion.size();
        System.out.println("========== Exclusions =========");
            
        for(int i = 0; i < size; i++) {
            System.out.println(type + "-" + (i+1) + " " + exclusion.get(i));
        }
    }
}