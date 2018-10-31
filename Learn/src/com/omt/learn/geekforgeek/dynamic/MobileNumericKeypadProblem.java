package com.omt.learn.geekforgeek.dynamic;

import java.util.ArrayList;
import java.util.List;

public class MobileNumericKeypadProblem {

    public static void main(String args[]) {
        //OMT
        char keypad[][] = { {'1', '2', '3'},
                            {'4', '5', '6'},
                            {'7', '8', '9'},
                            {'*', '0', '#'}};

        System.out.println(maxCount(1, keypad));
        System.out.println(maxCount(2, keypad));
        System.out.println(maxCount(3, keypad));
        System.out.println(maxCount(4, keypad));
        System.out.println(maxCount(5, keypad));


    }


    private static final List<Character> INVALID_CHAR = new ArrayList<Character>() {
        {
            add('*');
            add('#');
        }
    };

    public static int maxCount(int n, char[][] keypad) {

        int totalCount = 0;

        //Count at each key
        for (int row = 0; row < keypad.length; row++) {
            for (int column = 0; column < keypad[0].length; column++) {
                int countForCurrentBox = countFromParticularBoxToUpDownLeftRight(row, column, n, keypad); 
                totalCount += countForCurrentBox;
            }
        }

        return totalCount;
    }


    public static int countFromParticularBoxToUpDownLeftRight(int row, int column, int numberOfMoveLeft,
                                                              char[][] keypad) {

        if (!isValidBox(row, column, keypad)) {
            return 0;
        } else if (numberOfMoveLeft <= 0) {
            return 0;
        } 
        else if(numberOfMoveLeft == 1) {
            return 1;
        }

        //int currentCount = 1;//One for current box.

        int leftCount = countFromParticularBoxToUpDownLeftRight(row, column - 1, numberOfMoveLeft - 1, keypad);
        int rightCount = countFromParticularBoxToUpDownLeftRight(row, column + 1, numberOfMoveLeft - 1, keypad);
        int upCount = countFromParticularBoxToUpDownLeftRight(row - 1, column, numberOfMoveLeft - 1, keypad);
        int downCount = countFromParticularBoxToUpDownLeftRight(row + 1, column, numberOfMoveLeft - 1, keypad);
        int selectCurrentElementAgain = countFromParticularBoxToUpDownLeftRight(row, column, numberOfMoveLeft - 1, keypad);
                
        int totalCount = selectCurrentElementAgain + leftCount + rightCount + upCount + downCount;
        return totalCount;
    }

    public static boolean isValidBox(int row, int column, char[][] keypad) {
        int maxRow = keypad.length;
        int maxColumn = keypad[0].length;

        if (row >= maxRow || column >= maxColumn || row < 0 || column < 0) {
            return false;
        }

        if (INVALID_CHAR.contains(keypad[row][column])) {
            return false;
        }
        return true;
    }

}
