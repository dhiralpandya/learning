package com.omt.learn.leetcode.google;

public class LongestAbsoluteFilePath388 {


    public static void main(String args[]) {
        System.out.println(getMaxPath("dir\\n\\ts\\n\\ts2\\n\\t\\ta.txt"));
        System.out.println(getMaxPath("dir\\n\\tsubdir1\\n\\t\\tfile1" +
                ".ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext"));
    }

    /**
     * dir
     * s
     * s2
     * a.txt
     *
     * @param s
     * @return
     */
    public static int getMaxPath(String s) {
        int maxCount = 0;
        int currentTotalCount = 0;
        int currentLevelCount = 0;
        int currentLevel = 0;

        for (int count = 0; count < s.length(); count++) {
            char c = s.charAt(count);
            if (c == '\\') {
                int tempLevel = getLevel(s, count);
                int skipChar = (tempLevel * 2 + 2) - 1;
                count = count + skipChar;
                if (currentLevel >= tempLevel) {
                    currentTotalCount -= currentLevelCount;
                    currentLevelCount = 0;
                } else if (currentLevel < tempLevel) {
                    currentLevel = tempLevel;
                    //currentTotalCount += currentLevelCount;
                    currentLevelCount = 0;
                }
            } else if (c == '.') {
                count++;
                currentLevelCount++;
                currentTotalCount++;
                for (int index = count; index < s.length(); index++) {
                    if (s.charAt(index) == '\\') {
                        break;
                    }
                    count++;
                    currentLevelCount++;
                    currentTotalCount++;
                }

                maxCount = Math.max(maxCount, currentTotalCount + currentLevel);
            } else {
                currentLevelCount++;
                currentTotalCount++;
            }

        }

        return maxCount;
    }


    public static int getLevel(String s, int currentCount) {
        int level = 0;
        int lenght = s.length();
        for (int count = currentCount; currentCount < lenght; count++) {
            if (s.charAt(count) == '\\') {
                if (s.charAt(count + 1) == 't') {
                    level++;
                }
                count++;
            } else {
                break;
            }
        }
        return level;
    }

}
