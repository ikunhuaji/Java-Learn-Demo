package com.starrysky.homework510;

public class DB {
    private int[] userCnt = new int[11];
    private static int[] totalCnt = new int[11];

    public static synchronized void addTotal(int id) {
        totalCnt[id]++;
    }

    public int getUserCnt(int id) {
        return userCnt[id];
    }

    public void setUserCnt(int id,int cnt) {
        this.userCnt[id] = cnt;
    }

    public int getTotalCnt(int id) {
        return totalCnt[id];
    }

    public void setTotalCnt(int id,int cnt) {
        this.totalCnt[id] = cnt;
    }
}
