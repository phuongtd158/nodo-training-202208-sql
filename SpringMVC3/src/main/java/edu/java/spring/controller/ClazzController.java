package edu.java.spring.controller;

import edu.java.spring.dao.StudentDAO;
import edu.java.spring.model.JavaClazz;
import edu.java.spring.utils.XSLUtils;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@Controller
@RequestMapping("/clazz")
public class ClazzController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping(value = "xml", produces = {MediaType.APPLICATION_XML_VALUE})
    public @ResponseBody
    JavaClazz viewInXml() {
        return new JavaClazz(studentDAO.list());
    }

    @GetMapping(value = "json", produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    JavaClazz viewInJson() {
        return new JavaClazz(studentDAO.list());
    }

    @GetMapping("xslt")
    public ModelAndView viewXSLT() throws JAXBException, ParserConfigurationException, IOException, SAXException {
        JavaClazz clazz = new JavaClazz(studentDAO.list());

        ModelAndView modelAndView = new ModelAndView("ClazzView");
        modelAndView.getModelMap().put("data", XSLUtils.clazzToDomSource(clazz));

        return modelAndView;
    }

    @GetMapping("excel")
    public ModelAndView viewExcel() throws JAXBException, ParserConfigurationException, IOException, SAXException {
        JavaClazz clazz = new JavaClazz(studentDAO.list());

        ModelAndView modelAndView = new ModelAndView("excelView");
        modelAndView.getModelMap().put("clazzObj", clazz);

        return modelAndView;
    }

    @GetMapping(value = "pdf", produces = "application/pdf")
    public ModelAndView viewPdf() {
        JavaClazz clazz = new JavaClazz(studentDAO.list());

        ModelAndView modelAndView = new ModelAndView("pdfView");
        modelAndView.getModelMap().put("clazzObj", clazz);

        return modelAndView;
    }

    @GetMapping(value = "report", produces = "application/pdf")
    public ModelAndView viewReport() {
        JRDataSource dataSource = new JRBeanCollectionDataSource(studentDAO.list());
        ModelAndView modelAndView = new ModelAndView("pdfReport");
        modelAndView.addObject("dataSource", dataSource);
        return modelAndView;
    }
}
