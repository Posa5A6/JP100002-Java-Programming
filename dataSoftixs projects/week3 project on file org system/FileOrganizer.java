/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MR.POSA
 */
import java.io.*;
import java.nio.file.*;

public class FileOrganizer {
    public static void organizeFiles(File folder) {
        File documentsFolder = new File(folder, "Documents");
        File imagesFolder = new File(folder, "Images");
        File othersFolder = new File(folder, "Others");

        if (!documentsFolder.exists() && !documentsFolder.mkdir()) {
            System.out.println("Failed to create Documents folder.");
        }
        if (!imagesFolder.exists() && !imagesFolder.mkdir()) {
            System.out.println("Failed to create Images folder.");
        }
        if (!othersFolder.exists() && !othersFolder.mkdir()) {
            System.out.println("Failed to create Others folder.");
        }

        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isFile()) {
                String fileType = getFileExtension(file);
                switch (fileType) {
                    case "txt":
                    case "doc":
                    case "docx":
                    case "pdf":
                        moveFile(file, documentsFolder);
                        break;
                    case "jpg":
                    case "jpeg":
                    case "png":
                    case "gif":
                        moveFile(file, imagesFolder);
                        break;
                    default:
                        moveFile(file, othersFolder);
                        break;
                }
            }
        }
    }

    private static void moveFile(File file, File destinationFolder) {
        try {
            Files.move(file.toPath(), Paths.get(destinationFolder.getPath(), file.getName()), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Moved: " + file.getName() + " -> " + destinationFolder.getName());
        } catch (IOException e) {
            System.out.println("Error moving file: " + file.getName());
            e.printStackTrace();
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        int lastIndex = fileName.lastIndexOf('.');
        return (lastIndex > 0) ? fileName.substring(lastIndex + 1).toLowerCase() : "";
    }
}
