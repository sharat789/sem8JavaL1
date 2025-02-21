package com.sharat.financialsystems.paymentmanagement.service;

import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.List;

@Service
public class XMLExportService {
    public <T> String convertToXML(List<T> entities, Class<T> clazz) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(EntityListWrapper.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        EntityListWrapper<T> wrapper = new EntityListWrapper<>(entities);
        StringWriter writer = new StringWriter();
        marshaller.marshal(wrapper, writer);

        return writer.toString();
    }
}

@XmlRootElement(name = "entities")
@XmlAccessorType(XmlAccessType.FIELD)
class EntityListWrapper<T> {
    @XmlElement(name = "entity")
    private List<T> entities;

    public EntityListWrapper() {}
    public EntityListWrapper(List<T> entities) {
        this.entities = entities;
    }
}