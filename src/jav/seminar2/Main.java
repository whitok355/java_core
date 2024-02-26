package jav.seminar2;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI ='0';
    private static final char DOT_EMPTY = '*';
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static int WIN_COUNT = 4;
    static void initialize(){
        fieldSizeX = 4;
        fieldSizeY = 4;
        field = new char[fieldSizeX][fieldSizeY];

        for(int x =0; x < fieldSizeX; x++){
            for(int y = 0; y < fieldSizeY; y++){
                field[x][y] = DOT_EMPTY;
            }
        }
    }
    static void printField(){
        System.out.print("+");

        for(int i = 0; i < fieldSizeX; i++){
            System.out.print(" - " + (i + 1));
        }

        System.out.println(" - ");

        for(int x = 0; x < fieldSizeX; x++){
                System.out.print(x + 1 + " | ");
                for(int y= 0; y < fieldSizeY; y++){
                    System.out.print(field[x][y] + " | ");
                }
                System.out.println();
        }

        for(int p = 0; p < fieldSizeX *2 + 2; p++){
            System.out.print("- ");
        }
        System.out.println();
    }
    static void humanTurn(){
        int x;
        int y;
        do {
            System.out.println("Введите координаты хода X и Y\n(от 1 до)"+ fieldSizeX + " через пробел: ");
            x = scanner.nextInt() - 1;
            y = scanner.nextInt() - 1;
        }
        while(!isCellValid(x,y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }
    static void aiTurn(){
        int x;
        int y;
        do{
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        } while(!isCellEmpty(x,y));
        field[x][y] = DOT_AI;
    }
    public static boolean isCellEmpty(int x, int y){
        return field[x][y] == DOT_EMPTY;
    }
    public static boolean isCellValid(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }
//    static boolean checkWin2(char dot){
//        if(field[0][0] == dot && field[0][1] == dot && field[0][2] == dot) return true;
//        if(field[1][0] == dot && field[1][1] == dot && field[1][2] == dot) return true;
//        if(field[2][0] == dot && field[2][1] == dot && field[2][2] == dot) return true;
//
//        if(field[0][0] == dot && field[1][0] == dot && field[2][0] == dot) return true;
//        if(field[0][1] == dot && field[1][1] == dot && field[2][1] == dot) return true;
//        if(field[0][2] == dot && field[1][2] == dot && field[2][2] == dot) return true;
//
//        if(field[0][0] == dot && field[1][1] == dot && field[2][2] == dot) return true;
//        if(field[0][2] == dot && field[1][1] == dot && field[2][0] == dot) return true;
//
//        return false;
//
//    }
    static boolean checkWin(char dot){

        for(int x = 0; x <=fieldSizeX; x++){
            for(int y = 0; y <=fieldSizeY; y++){
                if(check1(x, y, dot, WIN_COUNT)
                        || check2(x, y, dot, WIN_COUNT)
                        || check3(x, y, dot, WIN_COUNT)
                        || check4(x, y, dot, WIN_COUNT)){
                    return true;
                }
            }
        }
        return false;
    }

    static boolean check1(int x, int y, char dot, int winCount){
        boolean flag = false;
        for(int count = 1; count < winCount; count++) {
            int nextY = y + count;
            if (!isCellValid(x, nextY)) {
                flag = false;
                break;
            } else {
                if (field[x][nextY] == dot) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
    static boolean check2(int x, int y, char dot, int winCount){
        boolean flag = false;
        for(int count = 1; count < winCount; count++) {
            int nextX = x + count;
            if (!isCellValid(nextX, y)) {
                flag = false;
                break;
            } else {
                if (field[nextX][y] == dot) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
    static boolean check3(int x, int y, char dot, int winCount){
        boolean flag = false;
        for(int count = 1; count < winCount; count++) {
            int nextX = x + count;
            int nextY = y + count;
            if (!isCellValid(nextX, nextY)) {
                flag = false;
                break;
            } else {
                if (field[nextX][nextY] == dot) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
    static boolean check4(int x, int y, char dot, int winCount){
        boolean flag = false;
        for(int count = 1; count < winCount; count++) {
            int nextX = x + count;
            int downY = y - count;
            if (!isCellValid(nextX, downY)) {
                flag = false;
                break;
            } else {
                if (field[nextX][downY] == dot) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
    static boolean checkDraw(){
        for(int x = 0; x < fieldSizeX; x++){
            for(int y = 0; y < fieldSizeY; y++){
                if(isCellEmpty(x,y)){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean checkState(char dot, String s){
        if(checkWin(dot)){
            System.out.println(s);
            return true;
        } else if(checkDraw()){
            System.out.println("Ничья");
            return true;
        } else{
            return false;
        }
    }
    public static void main(String[] args) {
        while(true){
            initialize();
            printField();
            while (true) {
                humanTurn();
                printField();
                if(checkState(DOT_HUMAN, "Вы победили"))
                    break;
                aiTurn();
                printField();
                if(checkState(DOT_AI, "Победил AI"))
                    break;
            }
            System.out.println("Желаете сыграть еще раз? (Y - да): ");
            if(!scanner.next().equalsIgnoreCase("Y"))
                break;
            }
        }
}