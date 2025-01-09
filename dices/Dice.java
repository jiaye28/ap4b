package dices;


public class Dice {
    private int point;
    private String color;
//    Dice(){
//        this.point = (int)(Math.random()*6+1);
//        this.color="noir";
//    }
    public Dice(String color){
        this.point =roll();
        this.color =color;
    }

    public int roll(){
        return (int)(Math.random()*6+1);
    }

    public String getColor() {
        return color;
    }
    public int getPoint() {
        return point;
    }
    public void setColor(String color) {
        this.color = color;

    }







}

