package practice11;

import java.util.LinkedHashSet;
import java.util.Set;

public class Teacher extends Person {
    private Set<Klass> classes = new LinkedHashSet<>();

    public Teacher() {
    }

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    public Teacher(Integer id, String name, Integer age, Set<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        for (Klass klass : classes) {
            klass.appendTeacher(this);
        }
    }

    @Override
    public String introduce() {
        return super.introduce()
                + String.format(
                " I am a Teacher. I teach %s.",
                getClassDisplayName());
    }

    private String getClassDisplayName() {
        if (this.classes.isEmpty()) {
            return "No Class";
        }
        StringBuilder sb = new StringBuilder("Class ");
        for (Klass klass : this.classes) {
            sb.append(klass.getNumber()).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public Set<Klass> getClasses() {
        return classes;
    }

    public boolean isTeaching(Student student) {
        if(classes.contains(student.getKlass())){
            return true;
        }
        for (Klass klass : classes) {
            if(klass.isIn(student)){
                return true;
            }
        }
        return false;
    }
    public String introduceWith(Student stu) {
        return super.introduce()
                + String.format(
                " I am a Teacher. I %steach %s.",
                isTeaching(stu) ? "" : "don't ",
                stu.getName()
        );
    }
}
