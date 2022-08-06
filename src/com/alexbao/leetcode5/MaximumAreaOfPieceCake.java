package com.alexbao.leetcode5;

import java.util.Arrays;

public class MaximumAreaOfPieceCake {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int maxHorizon = 0;
        int maxVertical = 0;
        for (int i=0; i<horizontalCuts.length; i++) {
            if (i == 0) {
                maxHorizon = maxHorizon > horizontalCuts[i] ? maxHorizon : horizontalCuts[i];
            } else {
                maxHorizon = maxHorizon > (horizontalCuts[i] - horizontalCuts[i-1]) ?
                        maxHorizon : (horizontalCuts[i] - horizontalCuts[i-1]);
            }
        }
        maxHorizon = maxHorizon > (h - horizontalCuts[horizontalCuts.length-1]) ?
                maxHorizon : (h - horizontalCuts[horizontalCuts.length-1]);

        for (int i=0; i<verticalCuts.length; i++) {
            if (i == 0) {
                maxVertical = maxVertical > verticalCuts[i] ? maxVertical : verticalCuts[i];
            } else {
                maxVertical = maxVertical > (verticalCuts[i] - verticalCuts[i-1]) ?
                        maxVertical : (verticalCuts[i] - verticalCuts[i-1]);
            }
        }
        maxVertical = maxVertical > (w - verticalCuts[verticalCuts.length-1]) ?
                maxVertical : (w - verticalCuts[verticalCuts.length-1]);
        return (int) (((long)maxVertical * (long)maxHorizon % 1000000007L));
    }
}
