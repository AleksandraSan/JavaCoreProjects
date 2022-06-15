package lesson9;

public class Courses {
    private String name;

    public Courses(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "name='" + name + '\'' +
                '}';
    }
}
