package me.engel.sergey.coursework3.service.impl;

import me.engel.sergey.coursework3.service.SocksFilesService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
@Service
public class SocksFilesServiceImpl implements SocksFilesService {
    @Value("${path.to.files.folder}")
    private String socksFilesPath;

    @Value("${name.to.files.folder}")
    private String socksFilesName;
    @Override
    public boolean saveToFile(String json) {
        try {
            cleanDataFile();
            Files.writeString(Path.of(socksFilesPath, socksFilesName), json);
            return true;
        } catch (IOException e) {
            return false;
        }

    }

    @Override
    public String readFromFile() {
        try {
            return Files.readString(Path.of(socksFilesPath,socksFilesName));
        }catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public File getDataFile() {
        return new File(socksFilesPath + socksFilesName);
    }

    @Override
    public boolean cleanDataFile() {
        try {
            Path path = Path.of(socksFilesPath, socksFilesName);
            Files.deleteIfExists(path);
            Files.createFile(path);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public boolean uploadDataFile(MultipartFile file) {
       cleanDataFile();
       File dataFile =getDataFile();
        try (FileOutputStream fileOutputStream = new FileOutputStream(dataFile)) {
            IOUtils.copy(file.getInputStream(), fileOutputStream);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
