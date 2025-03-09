package com.sharat.financialsystems.paymentmanagement.service;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Service class for exporting entities to XML format.
 */
@Service
public class XMLTransformationService {

    public <T> void transformToXML(T entity, Class<T> clazz, String fileName) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            File file = new File("local_folder/" + fileName);
            file.getParentFile().mkdirs();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                jaxbMarshaller.marshal(entity, writer);
                writer.flush();
            }
        } catch (JAXBException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}