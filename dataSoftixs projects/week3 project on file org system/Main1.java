/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author MR.POSA
 */
import java.io.*;
import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the folder path to organize:");
        String folderPath = scanner.nextLine();

        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Invalid folder path.");
            return;
        }

        FileOrganizer.organizeFiles(folder);
        FileLogger.logOrganizedFiles(folder);

        System.out.println("Do you want to delete duplicate files? (yes/no):");
        String deleteDuplicates = scanner.nextLine();
        if (deleteDuplicates.equalsIgnoreCase("yes")) {
            DuplicateFileHandler.deleteDuplicateFiles(folder);
        }
        System.out.println("Operation completed successfully.");
    }
}
