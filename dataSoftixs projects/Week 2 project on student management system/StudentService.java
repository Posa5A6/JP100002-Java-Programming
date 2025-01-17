/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MR.POSA
 */
import java.util.*;

public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public void addStudent(String id, String name, int marks) {
        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    public List<Student> viewAllStudents() {
        return students;
    }

    public boolean updateStudent(String id, String newName, int newMarks) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(String id) {
        return students.removeIf(student -> student.getId().equals(id));
    }

    public void sortByMarks() {
        students.sort(Comparator.comparingInt(Student::getMarks).reversed());
    }

    public void sortByName() {
        students.sort(Comparator.comparing(Student::getName));
    }
}
