package week7.model;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Student implements DBQueryble {
    private int id;
    private String name;
    private int groupId;

    public Student(int id, String name, int groupId) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }

    public Student(String name, int groupId) {
        this.name = name;
        this.groupId = groupId;
    }

    @Override
    public String toQuery() {
        return "("+this.id+","+"'"+this.name+"'"+","+this.groupId+")";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
}
