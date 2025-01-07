package com.Dice;

public class TestAll {
    public static void main(String[] args) {
        Test t= new Test();
        t.run();
        String diceDetails = t.getDiceDetails(1); // 获取第一个骰子的详细信息
        System.out.println(diceDetails);
    }
}
