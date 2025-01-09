package buildings;


import java.util.ArrayList;
import java.util.Objects;

public class Sheet_Buildings {
    protected ArrayList<Building> buildings;
    int count_Prof=0;

    public Sheet_Buildings() {
        buildings = new ArrayList<Building>();
        buildings.add(new Building_Admin(1, 1, "Admin", "r"));
        buildings.add(new Building_Admin(2, 1, "Admin", "r"));
        buildings.add(new Building_Admin(3, 1, "Admin", "y"));
        buildings.add(new Building_Admin(4, 1, "Admin", "y"));
        buildings.add(new Building_Admin(5, 1, "Admin", "w"));
        buildings.add(new Building_Admin(6, 1, "Admin", "w"));

        for (int i = 1; i <= 6; i++) {
            buildings.add(new Building_Points(i, 2, "Points", 2, "r", "Bureau des comptes"));
        }


        buildings.add(new Bibliotheque(1, 3, "Bibliotheque", "connaissance", 3));
        buildings.add(new Bibliotheque(2, 3, "Bibliotheque", "r", 2));
        buildings.add(new Bibliotheque(3, 3, "Bibliotheque", "euros", 3));
        buildings.add(new Bibliotheque(4, 3, "Bibliotheque", "y", 2));
        buildings.add(new Bibliotheque(5, 3, "Bibliotheque", "autorite", 3));
        buildings.add(new Bibliotheque(6, 3, "Bibliotheque", "w", 2));

        for (int i = 1; i <= 6; i++) {
            buildings.add(new Building_Points(i, 4, "Points", 2, "y", "Salle de classe"));
        }

        buildings.add(new SalleDeProf(1, 5, "Salle de Prof", "Hugues", 1));
        buildings.add(new SalleDeProf(2, 5, "Salle de Prof", "Isabeau", 2));
        buildings.add(new SalleDeProf(3, 5, "Salle de Prof", "Thibault", 3));
        buildings.add(new SalleDeProf(4, 5, "Salle de Prof", "Jeanne", 4));
        buildings.add(new SalleDeProf(5, 5, "Salle de Prof", "Urbain", 5));
        buildings.add(new SalleDeProf(6, 5, "Salle de Prof", "Marie", 6));

        for (int i = 1; i <= 6; i++) {
            buildings.add(new Building_Points(i, 6, "Points", 2, "w", "Machine a cafe"));
        }
    }

    public boolean isBuilt(int column, int level) {
        for (Building b : buildings) {
            if (b.getColumn() == column && b.getLevel() == level) {
                return b.isBuilt();
            }
        }
        return false;
    }

    public void build(int column, int level) {
        for (Building b : buildings) {
            if (b.getColumn() == column && b.getLevel() == level) {
                b.getBuilt();
                if(Objects.equals(b.type, "Salle de Prof")){
                    count_Prof++;
                    b.renew_sequence(count_Prof);
                }
            }
        }
    }

    public int count_level(int level) {
        int count = 0;
        for (int i = 0; i <= 6; i++) {
            if (buildings.get(i + (level - 1) * 6-1).isBuilt()){
                count++;
            }
        }
        return count;
    }

    public boolean check_lien(int column, int level){
        if(((level-1)*6+column)%2==0) {
            return buildings.get(column + (level - 1) * 6 - 2).isBuilt();
        }else{
            return buildings.get(column + (level - 1) * 6 ).isBuilt();
        }
    }

    public void destroy_column(int column){
        for (Building b : buildings){
            if(b.getColumn()==column){
                if(b.level==1&&b.isBuilt()){break;}
                else {
                    b.destroy();
                }
            }
        }

    }

    public boolean check_destroy(int column){
        for (Building b : buildings){
            if(b.getColumn()==column){
                return b.can_build;
            }

        }
        return false;
    }

    public Bibliotheque getBibliotheque(int column, int level){
        for (Building b : buildings){
            if(b.getColumn()==column&&b.getLevel()==level){
                return (Bibliotheque) b;
            }
        }
        return null;
    }

    public Building_Points getBuilding_Points(int column, int level){
        for (Building b : buildings){
            if(b.getColumn()==column&&b.getLevel()==level){
                return (Building_Points) b;
            }
        }
        return null;
    }
    public SalleDeProf getSalleDeProf(int column, int level){
        for (Building b : buildings){
            if(b.getColumn()==column&&b.getLevel()==level){
                return (SalleDeProf) b;
            }
        }
        return null;
    }
    public Building_Admin getBuilding_Admin(int column, int level){
        for (Building b : buildings){
            if(b.getColumn()==column&&b.getLevel()==level){
                return (Building_Admin) b;
            }
        }
        return null;
    }
}
