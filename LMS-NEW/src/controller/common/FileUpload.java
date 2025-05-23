package controller.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Objects;

public class FileUpload {

    // todo table button not shows just the btn object

    private static final HashMap<String, String> map = new HashMap<>();

    public static final Integer PROFILE_IMAGE = 1;
    public static final Integer PDF_FILE = 2;
    public static final String SUCCESS = "3";
    public static final String FAILED = "4";

    public static HashMap<String,String> upload(HashMap<String,String> uploadedFileMap,Integer destination) {

        String basePath = System.getProperty("user.dir");
        String destinationDirectory = null;
        if(Objects.equals(destination, PROFILE_IMAGE)) {
            destinationDirectory = basePath + "/resources/profileImages/";
        }else if(Objects.equals(destination, PDF_FILE)) {
            destinationDirectory = basePath + "/resources/pdfFiles/";
        }

        // Specify the destination directory for the image
        File destDir = new File(destinationDirectory);// Create the destination directory if it does not exist
        if (!destDir.exists()) {
            destDir.mkdirs();
        }

        String destinationPath = destinationDirectory +System.currentTimeMillis()+ uploadedFileMap.get("filename");// Construct the destination file path

        // Copy the selected file to the destination directory
        try {
            Path sourcePath = new File(uploadedFileMap.get("selectedFile")).toPath();
            Path destinationFilePath = new File(destinationPath).toPath();
            Files.copy(sourcePath, destinationFilePath, StandardCopyOption.REPLACE_EXISTING);

            map.put("status", FileUpload.SUCCESS); // success
            map.put("url", destinationPath.replace(basePath,""));

            return map;

        } catch (IOException e) {
            e.printStackTrace();

            map.put("status", FileUpload.FAILED); // failed
            return map;
        }
    }

}