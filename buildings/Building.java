package buildings;

public abstract class Building{
    protected int column,level;
    protected String type;
    protected boolean isbuilt=false,can_build=true;

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

    public boolean isBuilt(){
        return isbuilt;
    }
    public void getBuilt(){
        isbuilt=true;
    }
    public boolean can_build(){
        return can_build;
    }
    public void destroy(){
        can_build=false;
    }
    public  void renew_sequence(int count){};


}