package practice08;

public class Teacher extends Person {
    private Klass klass;

    public Teacher() {
    }

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    public Teacher(Integer id, String name, Integer age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return super.introduce()
                + String.format(
                        " I am a Teacher. I teach %s.",
                        klass != null ? klass.getDisplayName() : "No Class");
    }

    public String introduceWith(Student stu) {
        return super.introduce()
                + String.format(
                        " I am a Teacher. I %steach %s.",
                        klass.equals(stu.getKlass()) ? "" : "don't ",
                        stu.getName()
                );
    }
}
