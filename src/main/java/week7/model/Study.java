package week7.model;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Study implements DBQueryble {
    private int group_id;
    private int subject_id;

    public Study(int group_id, int subject_id) {
        this.group_id = group_id;
        this.subject_id = subject_id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    @Override
    public String toQuery() {
        return "("+this.group_id+","+this.subject_id+")";
    }
}
