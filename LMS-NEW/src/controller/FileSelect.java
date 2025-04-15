package controller;

import java.awt.*;
import java.io.File;
import java.util.HashMap;

public class FileSelect {

    private static final HashMap<String, String> map = new HashMap<>();

    public static HashMap<String,String> getPDFFile() {

        FileDialog fileDialog = new FileDialog((java.awt.Frame) null, "Select PDF Marks File");// Create a file dialog
        fileDialog.setMode(FileDialog.LOAD);// Set the mode to select files
        fileDialog.setMultipleMode(false);// Disable multiple file selection

        fileDialog.setFilenameFilter((dir, name) -> {// Set the file filter for image files
            String extension = name.substring(name.lastIndexOf('.') + 1).toLowerCase();
            return extension.equals("pdf");
        });

        fileDialog.setVisible(true);// Show the file dialog

        String directory = fileDialog.getDirectory();// Get the selected file's directory
        String fileName = fileDialog.getFile();// Get the selected file's name

        if (directory != null && fileName != null) {// Check if a file was selected
            File selectedFile = new File(directory, fileName);

            if (isPDFFile(selectedFile)) {// Check if the file is an image

                map.put("filename", fileName);
                map.put("selectedFile", String.valueOf(selectedFile));
                map.put("pdf", "1");

                return map;

            } else {
                // System.out.println("Selected file is not an image.");
                map.put("pdf", "2");

                return map;
            }
        } else {
            // System.out.println("No file selected");
            map.put("pdf", "3");

            return map;
        }
    }

    private static boolean isPDFFile(File file) {
        String fileName = file.getName();
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1).toLowerCase();
        return extension.equals("pdf");
    }

}
