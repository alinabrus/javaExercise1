package com.abrus.task4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("checkstyle:HideUtilityClassConstructor")
public class Main {
    @SuppressWarnings("checkstyle:MagicNumber")
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        Student studentA = new Student("Sean Davies", 17, "school 22", "New York", "18th");
        studentA.addGrade("Math", 67);
        studentA.addGrade("English", 82);
        studentA.addGrade("Geography", 95);
        students.add(studentA);

        Student studentB = new Student("Robert Gray", 13, "school 22", "New York", "19th");
        studentB.addGrade("Math", 54);
        studentB.addGrade("English", 88);
        studentB.addGrade("Geography", 62);
        students.add(studentB);

        Student studentC = new Student("Rachel Fridman", 16, "school 14", "New York", "Madison square");
        studentC.addGrade("Math", 92);
        studentC.addGrade("English", 89);
        studentC.addGrade("Geography", 83);
        students.add(studentC);

        Student studentD = new Student("Tom Stuart", 17, "school 34", "Boston", "Acorn street");
        studentD.addGrade("Math", 77);
        studentD.addGrade("English", 79);
        studentD.addGrade("Geography", 93);
        students.add(studentD);

        Student studentE = new Student("Katherine Stuart", 15, "school 34", "Boston", "Acorn street");
        studentE.addGrade("Math", 71);
        studentE.addGrade("English", 87);
        studentE.addGrade("Geography", 84);
        students.add(studentE);

        Student studentF = new Student("Andrew Ryan", 16, "school 17", "Boston", "Maple street");
        studentF.addGrade("Math", 90);
        studentF.addGrade("English", 91);
        studentF.addGrade("Geography", 78);
        students.add(studentF);

        students.forEach(System.out::println);

        students.stream()
                .filter(student -> student.getAge() > 15 && student.getAddress().getCity().equals("New York"))
                .forEach(System.out::println);
        System.out.println();

        students.stream()
                .filter(student -> student.getAge() > 15 && student.getAddress().getCity().equals("New York"))
                .flatMap(student -> student.getGrades().stream()
                        .map(grade -> new StudentGrade(student.getName(), student.getSchool(), grade.getSubject(), grade.getScore()))
                )
                .sorted(Comparator.comparingDouble(StudentGrade::score).reversed())
                .limit(3)
                .forEach(System.out::println);
    }
}
