package ru.magenta_technology.test_task.service;

import ru.magenta_technology.test_task.domain.Storage;

import javax.xml.bind.JAXBException;

public interface FileStorageParser {
    Storage parseData() throws JAXBException;
}
