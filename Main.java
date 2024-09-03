package tictactoe;
import java.util.Scanner;

import static java.lang.Math.abs;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s =  sc.nextLine();
        char[][] a = new char[3][3];
        for(int i = 0;i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                a[i][j]=' ';
            }
        }
        printa(a);
        int k = 0;
        boolean ans = false;
        while(k<9 && !ans) {
            if(k % 2 == 0) {
                boolean move = true;
                while(move) {
                    String c1 = sc.next();
                    String c2 = sc.next();
                    if (!c1.matches("[0-9]")) {
                        System.out.println("You should enter numbers!");
                    } else if (Integer.parseInt(c1) < 1 || Integer.parseInt(c1) > 3 || Integer.parseInt(c2) < 1 || Integer.parseInt(c2) > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (a[Integer.parseInt(c1) - 1][Integer.parseInt(c2) - 1] == ' ') {
                        a[Integer.parseInt(c1) - 1][Integer.parseInt(c2) - 1] = 'X';
                        move = false;
                        printa(a);
                        if(check(a) != "Game not finished") {
                            System.out.println(check(a));
                            ans = true;
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
            } else {
                boolean move = true;
                while (move) {
                    String c1 = sc.next();
                    String c2 = sc.next();
                    if (!c1.matches("[0-9]")) {
                        System.out.println("You should enter numbers!");
                    } else if (Integer.parseInt(c1) < 1 || Integer.parseInt(c1) > 3 || Integer.parseInt(c2) < 1 || Integer.parseInt(c2) > 3) {
                        System.out.println("Coordinates should be from 1 to 3!");
                    } else if (a[Integer.parseInt(c1) - 1][Integer.parseInt(c2) - 1] == ' ') {
                        a[Integer.parseInt(c1) - 1][Integer.parseInt(c2) - 1] = 'O';
                        move = false;
                        printa(a);
                        if (check(a) != "Game not finished") {
                            System.out.println(check(a));
                            ans = true;
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                    }
                }
            }
            k++;
        }
    }
    private static String check(char[][] a) {
        boolean p = false;
        boolean k = false;
        int x = 0 , o = 0 , l = 0;
        boolean xw = IsSym(a, 'X');
        boolean ow = IsSym(a, 'O');
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                if (a[i][j] == 'X') x++;
                else if (a[i][j] == 'O') o++;
                else if (a[i][j] == '_') l++;
            }
        }
        int diff = x - o;
        diff = Math.abs(diff);
        if (diff > 1){
            return "Impossible";
        }
        if (xw){
           return "X wins";
        }
        if (ow) {
            return "O wins";
        }
        if (xw && ow) {
            return "Impossible";
        }
        if (x + o == 9) {
            return "Draw";
        }
        return "Game not finished";
    }
    private static boolean IsSym(char[][] a, char s) {
        return a[0][0] == a[0][1] && a[0][0] == a[0][2] && a[0][0] == s || //first row
                a[0][0] == a[1][0] && a[0][0] == a[2][0] && a[0][0] == s || // first
                a[1][0] == a[1][1] && a[1][0] == a[1][2] && a[1][0] == s || // second row
                a[2][0] == a[2][1] && a[2][0] == a[2][2] && a[2][0] == s || // third row
                a[0][1] == a[1][1] && a[0][1] == a[2][1] && a[0][1] == s || // second
                a[0][2] == a[1][2] && a[0][2] == a[2][2] && a[0][2] == s || // third
                a[0][0] == a[1][1] && a[0][0] == a[2][2] && a[0][0] == s || // first diagonale
                a[0][2] == a[1][1] && a[0][2] == a[2][0] && a[1][1] == s;
    }
    private static void printa(char[][] a) {
        System.out.println("---------");
        for(int i=0; i < 3; i++){
            System.out.print("| ");
            for(int j=0;j<3;j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }


}
