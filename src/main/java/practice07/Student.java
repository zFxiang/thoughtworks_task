package practice07;

public class Student extends Person {
    private Klass klass;

    public Student() {
    }

    public Student(String name,Integer age,Klass klass) {
        super(name,age);
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
        return super.introduce() + String.format(" I am a Student. I am at %s.",klass.getDisplayName());
    }
}

