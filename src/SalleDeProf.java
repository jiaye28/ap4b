public class SalleDeProf extends Building {
    private String name_prof;
    private String type_bat;

    public SalleDeProf( int _column, int _level, String _name, String _name_prof, String _type_bat) {
        super( _column, _level, _name);
        name_prof = _name_prof;
        type_bat = _type_bat;
    }

    public String getType_bat() {
        return type_bat;
    }

    public String getName_prof() {
        return name_prof;
    }
}
