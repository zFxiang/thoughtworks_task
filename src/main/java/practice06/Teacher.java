package practice06;

public class Teacher extends Person{
    private Integer klass;

    public Teacher() {
    }

    public Teacher(String name, Integer age) {
        super(name, age);
    }

    public Teacher(String name, Integer age, Integer klass) {
        super(name, age);
        this.klass = klass;
    }

    public Integer getKlass() {
        return klass;
    }

    public void setKlass(Integer klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return super.introduce()
                + String.format(
                        " I am a Teacher. I teach %s.",
                        klass != null ? "Class " + klass : "No Class");
    }
}
