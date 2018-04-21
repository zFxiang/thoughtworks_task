package practice08;

public class Student extends Person {
    private Klass klass;

    public Student() {
    }

    public Student(Integer id, String name, Integer age, Klass klass) {
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
        return super.introduce() + String.format(" I am a Student. I am %s %s.",
                this.equals(klass.getLeader()) ? "Leader of" : "at",
                klass.getDisplayName());
    }
}

