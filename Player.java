
//import buildings.Building;
//
//import java.util.ArrayList;
import buildings.Sheet_Buildings;

import java.util.Objects;
import java.util.Scanner;

public class Player {
    private int euros, connaissance, individu_r, individu_y, individu_w, autorite;
    //    private Test test;
    protected Sheet_Buildings sheet = new Sheet_Buildings();

    public Player() {
        euros = 3;
        connaissance = 3;
        individu_r = 0;
        individu_w = 0;
        individu_y = 0;
        autorite = 3;
    }

    public void modify_euros(int value) {
        if (euros + value > 0) {
            if (euros + value >= (euros % 6 + 1) * 6) {

            }
            euros += value;
            System.out.println("Vous avez " + euros + " euros%n");

        } else if (euros + value < 0) {
            System.out.println("Vous n'avez pas assez d'euros%n");
        }
    }

    public void modify_connaissance(int value) {
        if (connaissance + value > 0) {
            connaissance += value;
            System.out.println("Vous avez " + connaissance + " connaissance%n");
        } else {
            System.out.println("Vous n'avez pas assez de connaissance%n");
        }
    }

    public void modify_autorite(int value) {
        if (autorite + value > 0) {
            autorite += value;
            System.out.println("Vous avez " + autorite + " autorite%n");
        } else {
            System.out.println("Vous n'avez pas assez d'autorite%n");
        }
    }

    public void modify_res(String name_res, int value) {
        if (value > 0) {
            System.out.println("Vous gagnez " + value + " " + name_res + "%n");
        }
        if (value < 0) {
            System.out.println("Vous perdez " + value + " " + name_res + "%n");
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

    public void gainIndividu_all(String color, int value) {
        switch (color) {
            case "r":
                gainIndividu_r(value);
                break;
            case "y":
                gainIndividu_y(value);
                break;
            case "w":
                gainIndividu_w(value);
                break;
        }
    }

    public void gainIndividu_y(int value) {
        int temp = individu_y;
        individu_y += value;
        System.out.println("Vous avez " + individu_y + " individu jaune%n");

        if (temp < 15 && temp + value >= 15) {
            //bonus building
        }
        if (temp < 20 && temp > 15 && temp + value >= 20) {
            System.out.println("Choisissez votre bonus de piste(rouge ou blanc): r or w");//bonus individu
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            boolean flag = true;
            while (flag) {
                if (input.equals("r")) {
                    gainIndividu_r(1);
                    flag = false;
                } else if (input.equals("w")) {
                    individu_w++;
                    gainIndividu_w(1);
                    flag = false;
                } else {
                    System.out.println("Vous n'avez pas choisi un bonus de piste valide%n");
                }
            }

        }
    }

    public void gainIndividu_r(int value) {
        int temp = individu_r;
        individu_r += value;
        System.out.println("Vous avez " + individu_r + " individu rouge%n");
        if (temp < 15 && temp + value >= 15) {
            //bonus building
        }
        if (temp < 20 && temp < 15 && temp + value >= 15) {
            System.out.println("Choisissez votre bonus de piste(jaune ou blanc): y or w");//bonus individu
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            boolean flag = true;
            while (flag) {
                if (input.equals("y")) {
                    gainIndividu_y(1);
                    flag = false;
                } else if (input.equals("w")) {
                    gainIndividu_w(1);
                    flag = false;
                } else {
                    System.out.println("Vous n'avez pas choisi un bonus de piste valide%n");
                }
            }
        }
    }

    public void gainIndividu_w(int value) {
        int temp = individu_w;
        individu_w += value;
        System.out.println("Vous avez " + individu_w + " individu blanc%n");
        if (temp < 15 && temp + value >= 15) {
            //bonus building
        }
        if (temp < 20 && temp < 15 && temp + value >= 15) {
            System.out.println("Choisissez votre bonus de piste(rouge ou jaune): r or y");//bonus individu
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            boolean flag = true;
            while (flag) {
                if (input.equals("r")) {
                    gainIndividu_r(1);
                    flag = false;
                } else if (input.equals("y")) {
                    gainIndividu_y(1);
                    flag = false;
                } else {
                    System.out.println("Vous n'avez pas choisi un bonus de piste valide%n");
                }
            }
        }
    }


    public void action(Test t) {
        System.out.println("Faire un choix parmis les des%n");
        for (int i = 1; i <= 4; i++) {
            System.out.println(i + " : " + t.getDiceDetails(i));
        }
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        while (input < 1 || input > 4) {
            System.out.println("Vous n'avez pas choisi un des valide%n");
            input = scanner.nextInt();
        }

        while (Objects.equals(t.getDiceColor(input), "noir")) {
            System.out.println("Vous avez choisi un des noir%n");
            input = scanner.nextInt();
        }
        while (t.getDiceCost(input) > euros) {
            System.out.println("Vous n'avez pas assez d'euros%n");
            input = scanner.nextInt();
        }
        int dice_point = t.getDicePoint(input);
        String dice_color = t.getDiceColor(input);
        int dice_cost = t.getDiceCost(input);

        modify_euros(-dice_cost);


        System.out.println("Vous pouvez faire un choix parmis les options suivantes:%n");
        boolean flag_action = true;


        while (flag_action) {


            System.out.println("1: Ressources 2: Batiments 3: Changer les attributs%n");

            int choice = scanner.nextInt();
            while (choice < 1 || choice > 3) {
                System.out.println("Vous n'avez pas choisi un option valide%n");
                choice = scanner.nextInt();
            }


            switch (choice) {
                case 1: {
                    switch (dice_color) {
                        case "r": {
                            modify_res("autorite", dice_point);
                            break;
                        }
                        case "y": {
                            modify_res("euros", dice_point);
                            break;
                        }
                        case "w": {
                            modify_res("connaissance", dice_point);
                            break;
                        }

                    }
                    flag_action = false;
                    break;
                }//ressources

                case 2: {
                    build(dice_color, dice_point);//build()
                    flag_action = false;
                    break;
                }//building

                case 3: {
                    System.out.println("1: value 2: color%n");
                    int choice2 = scanner.nextInt();
                    while (choice2 < 1 || choice2 > 2) {
                        System.out.println("Vous n'avez pas choisi un option valide%n");
                        choice2 = scanner.nextInt();
                    }

                    switch (choice2) {
                        case 1: {
                            boolean flag = true;
                            while (flag) {
                                System.out.println("1: + 2: -%n");
                                int choice3 = scanner.nextInt();
                                if (choice3 < 1 || choice3 > 2) {
                                    System.out.println("Vous n'avez pas choisi un option valide%n");
                                }
                                if (Objects.equals(choice3, 1)) {
                                    System.out.println("value:");
                                    int value = scanner.nextInt();
                                    if (dice_point + value > 6) {
                                        System.out.println("Vous n'avez pas choisi un option valide%n");
                                        value = scanner.nextInt();
                                    }
                                    if (value <= autorite) {

                                        dice_point += value;
                                        System.out.println("Vous avez choisi de changer le point de la face du dé en " + dice_point + "%n");
                                        modify_autorite(-value);
                                        flag = false;
                                    }

                                } else if (Objects.equals(choice3, 2)) {
                                    System.out.println("value:");
                                    int value = scanner.nextInt();
                                    if (dice_point - value < 1) {
                                        System.out.println("Vous n'avez pas choisi un option valide%n");
                                        value = scanner.nextInt();
                                    }
                                    if (value <= autorite) {
                                        dice_point -= value;
                                        System.out.println("Vous avez choisi de changer le point de la face du dé en " + dice_point + "%n");
                                        modify_autorite(-value);
                                        flag = false;
                                    }
                                }
                            }

                            break;
                        }
                        case 2: {
                            if (connaissance < 2) {
                                System.out.println("Vous n'avez pas assez de connaissance%n");
                                break;
                            }
                            boolean flag = true;
                            while (flag) {
                                System.out.println("1: white 2: red 3: yellow");
                                int choice3 = scanner.nextInt();
                                if (choice3 < 1 || choice3 > 3) {
                                    System.out.println("Vous n'avez pas choisi un option valide%n");
                                }
                                String color_new = null;
                                switch (choice3) {
                                    case 1: {
                                        color_new = "w";
                                        break;
                                    }
                                    case 2: {
                                        color_new = "r";
                                        break;
                                    }
                                    case 3: {
                                        color_new = "y";
                                        break;
                                    }
                                    default: {
                                        break;
                                    }
                                }
                                if (dice_color.equals(color_new)) {
                                    System.out.println("Meme couleur?:y or n%n");
                                    if (scanner.next().equals("y")) {
                                        System.out.println("Vous avez choisi de changer la couleur du dé en " + color_new + "%n");
                                        flag = false;
                                    }
                                } else {
                                    System.out.println("Vous avez choisi de changer la couleur du dé en " + color_new + "%n");
                                    flag = false;
                                    dice_color = color_new;
                                    modify_connaissance(-2);
                                }
                            }
                            break;
                        }
                    }
                    break;
                }//change dice

            }


        }
    }

    public void build(String _color, int _point) {
        if(sheet.check_destroy(_point)){
            System.out.println("Choisir un batiment:%n");
            boolean flag = true;
            while (flag) {
                switch (_color) {
                    case "white": {
                        System.out.println("Salle de Prof(s) ou Machine a cafe(m)");
                        Scanner scanner = new Scanner(System.in);
                        String choice = scanner.nextLine();
                        switch (choice) {
                            case "s": {
                                sheet.build(_point, 5);
                                flag = false;
                                break;

                            }
                            case "m": {
                                sheet.build(_point, 6);
                                gainIndividu_all("w", 2);
                                if (sheet.check_lien(_point, 6)) {
                                    if (_point == 3 || _point == 4) modify_connaissance(3);
                                    if (_point == 5 || _point == 6) gainIndividu_all("w", 2);
                                }
                                flag = false;
                                break;
                            }
                        }
                        break;
                    }
                    case "yellow": {
                        System.out.println("Bibliotheque(b) ou Salle de classe(s)");
                        Scanner scanner = new Scanner(System.in);
                        String choice = scanner.nextLine();
                        switch (choice) {
                            case "b": {
                                sheet.build(_point, 3);
                                if(sheet.getBibliotheque(_point, 3).getNum_res()==3){
                                    modify_res(sheet.getBibliotheque(_point, 3).getName_res(),3);
                                } else if (sheet.getBibliotheque(_point,3).getNum_res()==2) {
                                    gainIndividu_all(sheet.getBibliotheque(_point, 3).getName_res(),2);
                                }
                                flag = false;
                                break;
                            }
                            case "s": {
                                sheet.build(_point, 4);
                                gainIndividu_all("r", 2);
                                if (sheet.check_lien(_point, 4)) {
                                    if (_point == 3 || _point == 4) modify_euros(3);
                                    if (_point == 5 || _point == 6) gainIndividu_all("y", 2);
                                }
                                flag = false;
                                break;
                            }
                        }

                        break;
                    }
                    case "red": {
                        System.out.println("Batiment d'administration(a) ou Bureau des comptes(c)");
                        Scanner scanner = new Scanner(System.in);
                        String choice = scanner.nextLine();
                        switch (choice) {
                            case "a": {
                                sheet.build(_point, 1);
                                flag = false;
                                break;
                            }
                            case "c": {
                                sheet.build(_point, 2);
                                gainIndividu_all("y", 2);
                                if (sheet.check_lien(_point, 2)) {
                                    if (_point == 3 || _point == 4) modify_autorite(3);
                                    if (_point == 5 || _point == 6) gainIndividu_all("r", 2);
                                }
                                flag = false;
                                break;
                            }
                        }
                        break;
                    }
                }
            }


        }
    }
}

