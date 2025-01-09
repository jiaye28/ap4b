package buildings;

public class Bibliotheque extends Building {
    private String name_res;
    private int num_res;

    public Bibliotheque(int _column,int _level,String _type,String _name_res,int _num_res)
    {
        super(_column,_level,_type);

        name_res = _name_res;
        num_res = _num_res;
    }

    public int getNum_res(){
        return num_res;
    }

    public String getName_res(){
        return name_res;
    }

}
