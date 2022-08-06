package com.alexbao.leetcode6;

import java.util.ArrayList;
import java.util.List;

class StockSpanner {

    List<Integer> stockPrices = new ArrayList<>();
    public StockSpanner() {

    }

    public int next(int price) {
        int res = 1;
        for (int i=stockPrices.size()-1; i>=0; i--) {
            if (stockPrices.get(i) <= price) {
                res ++;
            } else {
                break;
            }
        }
        stockPrices.add(price);
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */