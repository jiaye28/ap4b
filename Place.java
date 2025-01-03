package com.Dice;

import java.util.Random;

public class Place {
    private String[] colors;
    private int[] cost; // 价值数组
    private int day;
    private int position;// 当前指针位置


    // 构造器：初始化轮盘
    public Place() {
        colors = new String[9];
        cost = new int[]{-1,0, 1, 1, 2, 0, 1, 1, 2}; // 固定的价值数组
        day = 1;
        position=1;
        String[] AllColors = {"red", "yellow", "white"};
        // 随机生成地块颜色
        Random random = new Random();
        for (int i = 0; i < colors.length; i++) {
            colors[i] = AllColors[random.nextInt(3)]; // 随机生成 1, 2, 或 3
        }
    }
    public String getcolor(){
        return colors[position++];
    }

    // 方法：更新指针位置，进入下一回合
    public void nextDay() {
        day++;
    }


    // 方法：获取当前指针位置的地块信息
//    public String getCurrentTileInfo() {
//        return "指针位置: " + day +
//                ", 地块颜色: " + colors[day] +
//                ", 地块价值: " + cost[day];
//    }

    // 方法：检查游戏是否结束
//    public boolean isGameEnded() {
//        return day >= 9; // 转满 9 圈后游戏结束
//    }

    // 方法：打印轮盘状态
    public void printWheelStatus() {
        System.out.println("当前轮盘状态：");
        for (int i = 0; i < colors.length; i++) {
            System.out.println("地块 " + (i+1) + ": 颜色 " + colors[i] + ", 价值 " + cost[i]);
        }
        System.out.println("当前回合数: " + day);

}
}
