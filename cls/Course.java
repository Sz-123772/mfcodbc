package mfcodbc.cls;

/**
 * Demo Course class
 *
 * @author Accer
 * @date 2022/07/05
 */

public class Course {
    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", credit=" + credit +
                ", term=" + term +
                '}';
    }

    private String id;
    private String name;
    private double credit;
    private int term;

    public Course(String id, String name, double credit, int term) {
        super();
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.term = term;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public int getTerm() {
        return term;
    }
}
