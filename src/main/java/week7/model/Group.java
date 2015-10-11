package week7.model;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Group implements DBQueryble {
    private int id;
    private String name;

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toQuery() {
        return "("+this.id+","+"'"+this.name+"'"+")";
    }
}
