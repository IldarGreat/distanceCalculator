package ru.ildar_technology.task.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ru.ildar_technology.task.domain.XmlStorage;
import ru.ildar_technology.task.exception.FileStorageException;

import javax.xml.bind.*;
import java.io.File;

@Service
public class XmlParser implements FileStorageParser {

    @Value("${file.upload-dir}")
    private String filePath;

    public XmlStorage parseData() throws JAXBException {
        String fileName = FileStorageService.getFileName();
        if (!new StringBuilder(fileName).reverse().substring(0, 4).equals("lmx.")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName + " Now only xml format is accepted");
        }
        JAXBContext jaxbContext = JAXBContext.newInstance(XmlStorage.class);
        Unmarshaller un = jaxbContext.createUnmarshaller();
        return (XmlStorage) un.unmarshal(new File(filePath + "//" + fileName));
    }

}
