package com.Dice;

import java.util.Random;

public class Place {
    private String[] colors;
    private int[] cost; // 价值数组
    private int day;    // 当前天数

    // 构造器：初始化轮盘
    public Place() {
        colors = new String[9];
        cost = new int[]{-1, 0, 1, 1, 2, 0, 1, 1, 2}; // 固定的价值数组
        day = 1;  // 从第一天开始
        String[] AllColors = {"red", "yellow", "white"};
        // 随机生成地块颜色
        Random random = new Random();
        for (int i = 0; i < colors.length; i++) {
            colors[i] = AllColors[random.nextInt(3)]; // 随机生成 1, 2, 或 3
        }
    }

    // 获取指定索引位置的颜色
    public String getColorAtIndex(int index) {
        return colors[index];
    }

    public int getCostAtIndex(int index) {
        return cost[index];
    }


    // 更新到下一天
    public void nextDay() {
        day++;
        if(day%2==1)
        shiftCostArray(); // 每天更新 cost 数组
    }
    public int getDay() {
        return (day%2+1);
    }

    // 打印轮盘状态
    public void printWheelStatus() {
        System.out.println("当前轮盘状态：");
        for (int i = 0; i < colors.length; i++) {
            System.out.println("地块 " + (i + 1) + ": 颜色 " + colors[i] + ", 价值 " + cost[i]);
        }
        System.out.println("Current round:" + day);
    }

    // 向右移动 cost 数组
    private void shiftCostArray() {
        int last = cost[cost.length - 1]; // 保存最后一个元素
        for (int i = cost.length - 1; i > 0; i--) {
            cost[i] = cost[i - 1]; // 每个元素向右移动一位
        }
        cost[0] = last; // 将原最后一个元素放到第一个位置
    }
}
