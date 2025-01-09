import buildings.Building;
import dices.Dice;
import dices.Place;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    Dice[] dice = new Dice[4];  // 保存4个骰子对象
    Place place = new Place();   // 一个Place对象，代表广场

    Scanner scanner = new Scanner(System.in);// 用于接收玩家输入

    public void run() {
        // 模拟游戏进行9天，每天有两回合
        int currentRound = 1;

        while (currentRound <= 18) {
            int day = (currentRound - 1) / 2 + 1;  // 计算当前是第几天
            int roundInDay = (currentRound - 1) % 2 + 1;  // 计算是今天的上午还是下午

            // 根据回合数判断是“上午”还是“下午”
            String timeOfDay = (roundInDay == 1) ? "上午" : "下午";
            System.out.println("第" + day + "天, " + timeOfDay + ":");

            // 处理每一回合的逻辑
            playRound(currentRound);

            if (currentRound < 18) {
                // 询问玩家是否进入下一个回合
                System.out.println("是否进入下一个回合？输入1继续，其他键退出：");
                int userInput = scanner.nextInt();
                if (userInput != 1) {
                    System.out.println("pause");
                    break;  // 如果玩家输入不为1，退出游戏
                }
            }
            currentRound++;  // 增加回合数
            place.nextDay();  // 进入下一天
        }
    }
    // 获取骰子的详细信息

    public String getDiceColor(int diceIndex) {
        Dice selectedDice = dice[diceIndex-1];
        String color = selectedDice.getColor();


        // 根据骰子的索引，获取地块的 cost

        return color;
    }

    public int getDicePoint(int diceIndex) {
        Dice selectedDice = dice[diceIndex-1];
        int point = selectedDice.getPoint();


        return point;
    }
    public int getDiceCost(int diceIndex) {
        Dice selectedDice = dice[diceIndex-1];


        // 根据骰子的索引，获取地块的 cost
        int placeIndex = (place.getDay() - 1) * 2 + (diceIndex ) - 1;
        placeIndex %= 9; // 确保索引在 0-8 范围内
        int cost = place.getCostAtIndex(placeIndex);

        return cost;
    }
    public String getDiceDetails(int diceIndex) {
        Dice selectedDice = dice[diceIndex-1];
        String color = selectedDice.getColor();
        int point = selectedDice.getPoint();

        // 根据骰子的索引，获取地块的 cost
        int placeIndex = (place.getDay() - 1) * 2 + (diceIndex ) - 1;
        placeIndex %= 9; // 确保索引在 0-8 范围内
        int cost = place.getCostAtIndex(placeIndex);

        return "骰子颜色: " + color + ", 点数: " + point + ", 地块Cost: " + cost;
    }


    // 处理每一回合的逻辑
    public void playRound(int currentRound) {
        int day = (currentRound - 1) / 2 + 1;  // 计算当前是第几天
        int roundInDay = (currentRound - 1) % 2 + 1;  // 计算是今天的上午还是下午
        int startIndex = (roundInDay == 1) ? (day + 1) : (day + 5);  // 根据上午/下午确定起始地块

        // 1. 为每个骰子分配颜色并生成随机点数
        for (int i = 0; i < 4; i++) {
            int blockIndex = (startIndex + i - 1) % 9;  // 根据起始地块位置分配，取模循环

            dice[i] = new Dice(place.getColorAtIndex(blockIndex));  // 为每个骰子分配颜色
            dice[i].roll(); // 随机点数
        }

        // 2. 随机选择一个骰子，设置为黑色
        int r = (int) (Math.random() * 4);
        dice[r].setColor("noir");

        // 3. 打印骰子的点数和颜色
        for (int i = 0; i < 4; i++) {
            System.out.println("d" + (i + 1) + "的点数为：" + dice[i].getPoint() + ", 颜色为：" + dice[i].getColor());
        }

        // 4. 打印广场的当前状态
        place.printWheelStatus();
    }
}
