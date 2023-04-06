package ru.ildar_technology.task.service;

import ru.ildar_technology.task.service.xml.Storage;

import javax.xml.bind.JAXBException;

public interface FileStorageParser {
    Storage parseData() throws JAXBException;
}
