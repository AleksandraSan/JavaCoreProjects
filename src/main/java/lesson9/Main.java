package lesson9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Students> studentsList = new ArrayList<>();
        studentsList.add(new Students("Alexandra", Arrays.asList(new Courses("ManualQA"), new Courses("AutoQA"))));
        studentsList.add(new Students("Alexey", Arrays.asList(new Courses("Java"), new Courses("Python"), new Courses("Git"))));
        studentsList.add(new Students("Andrey", Arrays.asList(new Courses("Java"), new Courses("sql"))));
        studentsList.add(new Students("Anastasia", Arrays.asList(new Courses("Тестирование ПО"), new Courses("Компьютерные сети"))));

        System.out.println(studentsList.stream()
                .map(m -> m.getCourses())
                .flatMap(f -> f.stream())
                .collect(Collectors.toSet())
        );

        System.out.println(studentsList.stream()
                .sorted((s1, s2) -> s2.getCourses().size() - s1.getCourses().size())
                .limit(3)
                .collect(Collectors.toList())
        );

        Courses courses = new Courses("testirovanie");
        System.out.println(studentsList.stream()
                .filter(s -> s.getCourses().contains(courses))
                .collect(Collectors.toList())
        );
    }
}
