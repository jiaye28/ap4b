package com.Dice;


public class Test {
    public static int r=(int)(Math.random()*4);
         public void run(){
             Dice[] dice=new Dice[4];
             Place place = new Place();
         for(int i=0;i<4;i++){
             dice[i]=new Dice(place.getcolor());
         }
         dice[r].setColor("noir");
         for(int i=0;i<4;i++){
             System.out.println("d"+(i+1)+"的点数为："+dice[i].getPoint()+",颜色为："+dice[i].getColor());}
         place.printWheelStatus();


      }

}
