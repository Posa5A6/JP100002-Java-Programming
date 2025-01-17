/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MR.POSA
 */
public class Main {
    public static void main(String[] args) {
        StudentService studentService = new StudentService();
        StudentUI studentUI = new StudentUI(studentService);
        studentUI.displayMenu();
    }
}
