package week7.model;

/**
 * .|\_/|,,_____,~~`
 * .(.".)~~     )`~}} Created by Juff
 * ..\o/\ /---~\\ ~}}
 * ...._//    _// ~}
 */
public class Rank implements DBQueryble {
    private int student_id;
    private int subject_id;
    private int rank;

    public Rank(int student_id, int subject_id, int rank) {
        this.student_id = student_id;
        this.subject_id = subject_id;
        this.rank = rank;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toQuery() {
        return "("+this.student_id+","+this.subject_id+","+this.rank+")";
    }
}
