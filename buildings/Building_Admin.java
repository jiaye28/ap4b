package buildings;

public class Building_Admin extends Building {
    private String color_pt;

    public Building_Admin(int _column,int _level,String _type,String _color_pt)
    {
        super(_column,_level,_type);
        color_pt=_color_pt;
    }
}