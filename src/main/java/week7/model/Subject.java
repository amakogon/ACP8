package week7.model;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Subject implements DBQueryble {
    private int id;
    private String name;
    private String description;


    public Subject(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toQuery() {
        return "("+this.id+","+"'"+this.name+"'"+","+"'"+this.description+"'"+")";
    }
}
