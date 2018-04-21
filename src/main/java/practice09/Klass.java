package practice09;

import java.util.HashSet;
import java.util.Set;

public class Klass {
    private Integer number;
    private String displayName;
    private Student leader;
    private Set<Student> members = new HashSet<>();
    public Klass() {
    }

    public Klass(Integer number) {
        this.number = number;
        this.displayName = "Class " + number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void assignLeader(Student student){
        if(!members.contains(student)){
            System.out.println("It is not one of us.");
            return;
        }
        this.leader = student;
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student){
        this.members.add(student);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Klass klass = (Klass) o;

        return number.equals(klass.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
