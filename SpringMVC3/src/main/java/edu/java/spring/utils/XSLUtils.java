package edu.java.spring.utils;

import edu.java.spring.model.JavaClazz;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.dom.DOMSource;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class XSLUtils {
    public static DOMSource clazzToDomSource(JavaClazz clazz) throws JAXBException, ParserConfigurationException, IOException, SAXException {

        JAXBContext jaxbContext = JAXBContext.newInstance(JavaClazz.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(clazz, byteArrayOutputStream);

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));

        return new DOMSource(document);
    }
}
