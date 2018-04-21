package practice11;

import java.util.HashSet;
import java.util.Set;

public class Klass {
    private Integer number;
    private String displayName;
    private Student leader;
    private Set<Student> members = new HashSet<>();
    private Set<Teacher> teachers = new HashSet<>();
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
        if(!isIn(student)){
            System.out.println("It is not one of us.");
            return;
        }
        this.leader = student;
        for (Teacher teacher : this.teachers) {
            System.out.println(String.format("I am %s. I know %s become Leader of %s.",
                    teacher.getName(),
                    student.getName(),
                    this.getDisplayName()
            ));
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student){
        this.members.add(student);
        for (Teacher teacher : this.teachers) {
            System.out.println(String.format("I am %s. I know %s has joined %s.",
                    teacher.getName(),
                    student.getName(),
                    this.getDisplayName()
                    ));
        }
    }

    public void appendTeacher(Teacher teacher){
        this.teachers.add(teacher);
    }
    public boolean isIn(Student std){
        return this.members.contains(std);
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
