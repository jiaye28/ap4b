package buildings;

public class SalleDeProf extends Building {
    private String name_prof;
    private int level_bat;
    private int sequence_built=0;

    public SalleDeProf( int _column, int _level, String _name, String _name_prof, int _level_bat) {
        super( _column, _level, _name);
        name_prof = _name_prof;
        level_bat = _level_bat;
    }

    public int getLevel_bat() {
        return level_bat;
    }

    public String getName_prof() {
        return name_prof;
    }
    public  void renew_sequence(int n){
        sequence_built=n;
    }
    public int getSequence_built(){
        return sequence_built;
    }
}
