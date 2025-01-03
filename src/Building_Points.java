public class Building_Points extends Building{
    private int points;
    private String color;
    private String name;

    public Building_Points(int _column,int _level,String _type,int _points,String _color,String _name){
        super(_column,_level,_type);
        points = _points;
        color = _color;
        name = _name;
    }
    public int getPoints(){
        return points;
    }


}