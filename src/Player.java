
        import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private int euros,connaissance,individu_r,individu_y,individu_w,autorite;
    //private Dice dices;
    private ArrayList<Building> buildings;

    public Player(){euros=3;connaissance=3;individu_r=0;individu_w=0;individu_y=0;autorite=3;}

    public void modify_euros(int value){
        if(euros+value>0){
            if(euros+value>=(euros%6+1)*6)
            {

            }
            euros+=value;
            System.out.println("Vous avez "+euros+" euros%n");

        }
        else if(euros+value<0){
            System.out.println("Vous n'avez pas assez d'euros%n");
        }
    }

    public void modify_connaissance(int value){
        if(connaissance+value>0){
            connaissance+=value;
            System.out.println("Vous avez "+connaissance+" connaissance%n");
        }
        else{
            System.out.println("Vous n'avez pas assez de connaissance%n");
        }
    }

    public void modify_autorite(int value){
        if(autorite+value>0){
            autorite+=value;
            System.out.println("Vous avez "+autorite+" autorite%n");
        }
        else{
            System.out.println("Vous n'avez pas assez d'autorite%n");
        }
    }

    public void modify_res(String name_res,int value) {
        if(value>0){
            System.out.println("Vous gagnez "+value+" "+name_res+"%n");
        }
        if(value<0){
            System.out.println("Vous perdez "+value+" "+name_res+"%n");
        }
        switch (name_res) {
            case "euros":
                modify_euros(value);
                break;
            case "connaissance":
                modify_connaissance(value);
                break;
            case "autorite":
                modify_autorite(value);
                break;
        }
    }

    public void gainIndividu_all(String color,int value) {
        switch (color) {
            case "r": gainIndividu_r(value);
                break;
            case "y": gainIndividu_y(value);
                break;
            case "w": gainIndividu_w(value);
                break;
        }
    }

    public void gainIndividu_y(int value) {
        int temp = individu_y;
        individu_y+=value;
        System.out.println("Vous avez "+individu_y+" individu jaune%n");

        if(temp<15&&temp+value>=15){
            //bonus building
        }
        if(temp<20&&temp<15&&temp+value>=15){
            System.out.println("Choisissez votre bonus de piste(rouge ou blanc): r or w");//bonus individu
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            boolean flag=true;
            while(flag) {
                if(input.equals("r")){
                    gainIndividu_r(1);
                    flag=false;
                }

                else if(input.equals("w")){
                    individu_w++;
                    gainIndividu_w(1);
                    flag=false;
                }
                else{
                    System.out.println("Vous n'avez pas choisi un bonus de piste valide%n");
                }
            }

        }
    }

    public void gainIndividu_r(int value) {
        int temp = individu_r;
        individu_r+=value;
        System.out.println("Vous avez "+individu_r+" individu rouge%n");
        if(temp<15&&temp+value>=15){
            //bonus building
        }
        if(temp<20&&temp<15&&temp+value>=15){
            System.out.println("Choisissez votre bonus de piste(jaune ou blanc): y or w");//bonus individu
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            boolean flag=true;
            while(flag) {
                if(input.equals("y")){
                    gainIndividu_y(1);
                    flag=false;
                }

                else if(input.equals("w")){
                    gainIndividu_w(1);
                    flag=false;
                }
                else{
                    System.out.println("Vous n'avez pas choisi un bonus de piste valide%n");
                }
            }
        }
    }

    public void gainIndividu_w(int value) {
        int temp = individu_w;
        individu_w+=value;
        System.out.println("Vous avez "+individu_w+" individu blanc%n");
        if(temp<15&&temp+value>=15){
            //bonus building
        }
        if(temp<20&&temp<15&&temp+value>=15){
            System.out.println("Choisissez votre bonus de piste(rouge ou jaune): r or y");//bonus individu
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            boolean flag=true;
            while(flag) {
                if(input.equals("r")){
                    gainIndividu_r(1);
                    flag=false;
                }

                else if(input.equals("y")){
                    gainIndividu_y(1);
                    flag=false;
                }
                else{
                    System.out.println("Vous n'avez pas choisi un bonus de piste valide%n");
                }
            }
        }
    }


    public void build(String name_building){

    }
}