package ru.ildar_technology.task.service;

import ru.ildar_technology.task.domain.Storage;

import javax.xml.bind.JAXBException;

public interface FileStorageParser {
    Storage parseData() throws JAXBException;
}
