package lesson9;

import java.util.List;

public class Students {
    private String name;
    private List<Courses> courses;

    public Students(String name, List<Courses> courses) {
        this.name = name;
        this.courses = courses;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }

}
