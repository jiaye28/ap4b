public abstract class Building{
    protected int column,level;
    protected String type;
    protected boolean lien=false;

    public Building(int _column,int _level,String _name){column=_column;level=_level;type = _name;}



    public int getColumn(){
        return column;
    }

    public int getLevel(){
        return level;
    }

    public String getType(){
        return type;
    }

}