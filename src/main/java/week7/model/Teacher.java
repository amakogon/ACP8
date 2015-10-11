package week7.model;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Teacher implements DBQueryble {
    private int id;
    private String name;
    private int experience;
    private int subjectId;

    public Teacher(int id, String name, int experience, int subjectId) {
        this.id = id;
        this.name = name;
        this.experience = experience;
        this.subjectId = subjectId;
    }

    @Override
    public String toQuery() {
       return "("+this.id+","+"'"+this.name+"'"+","+this.experience+","+this.subjectId+")";
    }
}
