package com.jeanbesson;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.locks.Condition;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

import com.jeanbesson.model.ConditionTaxation;
import com.jeanbesson.model.Tarif;
import com.jeanbesson.utils.Constants;
import com.jeanbesson.utils.XMLReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws XPathExpressionException, JAXBException, ParserConfigurationException, SAXException, IOException
    {
        XMLReader xmlReader = new XMLReader();
        
        List<ConditionTaxation> conditions = xmlReader.readConditionsTaxation(Constants.CONDITIONTAXATION_XML_PATH);
        for(ConditionTaxation c : conditions) {
        	System.out.println(c.getIdClient());
        }
        
    }
}
