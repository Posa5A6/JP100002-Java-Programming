/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MR.POSA
 */
import java.io.*;
import java.security.*;
import java.util.*;

public class DuplicateFileHandler {
    public static void deleteDuplicateFiles(File folder) {
        Map<String, File> fileHashes = new HashMap<>();
        File[] files = folder.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isFile()) {
                try {
                    String fileHash = getFileHash(file);
                    if (fileHashes.containsKey(fileHash)) {
                        System.out.println("Deleting duplicate file: " + file.getName());
                        if (!file.delete()) {
                            System.out.println("Failed to delete file: " + file.getName());
                        }
                    } else {
                        fileHashes.put(fileHash, file);
                    }
                } catch (IOException e) {
                    System.out.println("Error reading file: " + file.getName());
                    e.printStackTrace();
                }
            }
        }
    }

    private static String getFileHash(File file) throws IOException {
        try (InputStream is = new FileInputStream(file)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            while ((bytesRead = is.read(buffer)) != -1) {
                digest.update(buffer, 0, bytesRead);
            }

            byte[] hashBytes = digest.digest();
            StringBuilder hashString = new StringBuilder();
            for (byte b : hashBytes) {
                hashString.append(String.format("%02x", b));
            }
            return hashString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new IOException("Unable to compute file hash.", e);
        }
    }
}
