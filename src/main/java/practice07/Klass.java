package practice07;

public class Klass {
    private Integer number;
    private String displayName;

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
