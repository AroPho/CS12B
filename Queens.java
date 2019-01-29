import java.io.File;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;


class Queens {

    static void placeQueen(int[][] B, int i, int j){

    }

    static void removeQueen(int[][] B, int i, int j){

    }
    static void printBoard(int[][] B){
        
    }

    static int findSolutions(int[][] B, int i, String mode){
        int n = 0;

        return n;
    }

    public static void main(String[] args) {
            if(args.length < 1) {
                System.out.println("Usage: Queens [-v] number");
                System.exit(1);
            }
            int n;
            if(args[0].compareTo("-v") == 0){
                int[][] B = new int[Integer.parseInt(args[1])][Integer.parseInt(args[1])];
                n = Integer.parseInt(args[1]);
                findSolutions(B, n, args[0]);
            } else {
                int[][] B = new int[Integer.parseInt(args[0])][Integer.parseInt(args[0])];
                n = Integer.parseInt(args[0]);
                findSolutions(B, n, "");
            }
    }

}
