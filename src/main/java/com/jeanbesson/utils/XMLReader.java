package com.jeanbesson.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.xpath.*;


import com.jeanbesson.model.Client;
import com.jeanbesson.model.ConditionTaxation;
import com.jeanbesson.model.Localite;
import com.jeanbesson.model.Tarif;

public class XMLReader {

	public List<Client> readClients(String fileNamePath) throws JAXBException, ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		List<Client> clients = new ArrayList<>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(fileNamePath);
        
        // Crée un objet XPath
        XPath xpath = XPathFactory.newInstance().newXPath();
        
        // Compile l'expression XPath pour récupérer toutes les balises ObjectClient
        XPathExpression expr;
		expr = xpath.compile("//ObjectClient");
		
        
        // Exécute l'expression XPath et récupère le résultat
        NodeList nodeList = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        
        // Parcourt chaque nœud et récupère les informations nécessaires
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element node = (Element) nodeList.item(i);
            int idClient = Integer.parseInt(node.getElementsByTagName("idClient").item(0).getTextContent());
            String raisonSociale = node.getElementsByTagName("raisonSociale").item(0).getTextContent();
            String ville = node.getElementsByTagName("ville").item(0).getTextContent();
            String codePostal = node.getElementsByTagName("codePostal").item(0).getTextContent();
            
            // Crée un nouvel objet Client avec les informations extraites
            Client client = new Client(idClient, raisonSociale, ville, codePostal);
            clients.add(client);
           
        }
        return clients;
	}


    public  List<ConditionTaxation> readConditionsTaxation(String fileNamePath) throws ParserConfigurationException, SAXException, IOException {
    	//File xmlFile = new File("conditiontaxation.xml");

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fileNamePath);

        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("ObjectConditionTaxation");

        List<ConditionTaxation> conditionTaxationList = new ArrayList<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                
                String idClientStr = element.getElementsByTagName("idClient").item(0).getTextContent();
                Integer idClient = 0;
                if (idClientStr != null && !idClientStr.isEmpty() && idClientStr.matches("\\d+")) {
                	idClient = Integer.parseInt(idClientStr);
                } 
                Double taxePortDu = Double.parseDouble(element.getElementsByTagName("taxePortDu").item(0).getTextContent());
                Double taxePortPaye = Double.parseDouble(element.getElementsByTagName("taxePortPaye").item(0).getTextContent());
                Boolean useTaxePortDuGenerale = Boolean.parseBoolean(element.getElementsByTagName("useTaxePortDuGenerale").item(0).getTextContent());
                Boolean useTaxePortPayeGenerale = Boolean.parseBoolean(element.getElementsByTagName("useTaxePortPayeGenerale").item(0).getTextContent());

                ConditionTaxation conditionTaxation = new ConditionTaxation(idClient, taxePortDu, taxePortPaye, useTaxePortDuGenerale, useTaxePortPayeGenerale);
                conditionTaxationList.add(conditionTaxation);
            }
        }

//        for (ConditionTaxation ct : conditionTaxationList) {
//            System.out.println(ct);
//        }
        
        return conditionTaxationList;
    }

    public  List<Localite> readLocalites(String fileNamePath) {
    	List<Localite> localites = new ArrayList<>();

        // Chargement du fichier XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        try {
            Document document = factory.newDocumentBuilder().parse(fileNamePath);

            // Récupération des éléments ObjectLocalite avec XPathExpression
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            XPathExpression xPathExpression = xPath.compile("//ObjectLocalite");
            NodeList objectLocalites = (NodeList) xPathExpression.evaluate(document, XPathConstants.NODESET);

            // Création des instances de Localite à partir des éléments ObjectLocalite
            for (int i = 0; i < objectLocalites.getLength(); i++) {
                Element objectLocalite = (Element) objectLocalites.item(i);
                String ville = objectLocalite.getElementsByTagName("ville").item(0).getTextContent();
                String codePostal = objectLocalite.getElementsByTagName("codePostal").item(0).getTextContent();
                int zone = Integer.parseInt(objectLocalite.getElementsByTagName("zone").item(0).getTextContent());
                Localite localite = new Localite(ville, codePostal, zone);
                localites.add(localite);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Affichage des instances de Localite
        for (Localite localite : localites) {
            System.out.println(localite);
        }
        return localites;
    }

    public  List<Tarif> readTarifs(String fileNamePath) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
    	List<Tarif> tarifs = new ArrayList<>();

    	try {
            // Créer une nouvelle instance de DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Créer un nouveau DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Charger le fichier XML
            Document document = builder.parse(fileNamePath);
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xPath = xPathFactory.newXPath();
            XPathExpression expression = xPath.compile("//ObjectTarif");

            // Évaluer l'expression XPath pour obtenir une liste de nœuds
            NodeList nodeList = (NodeList) expression.evaluate(document, XPathConstants.NODESET);


            // Parcourir tous les nœuds de la liste et créer une instance de la classe Tarif pour chaque ObjectTarif
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String idClientHeritageStr = element.getElementsByTagName("idClientHeritage").item(0).getTextContent();
                Integer idClientHeritage = 0;
                if (idClientHeritageStr != null && !idClientHeritageStr.isEmpty() && idClientHeritageStr.matches("\\d+")) {
                     idClientHeritage = Integer.parseInt(idClientHeritageStr);
                } 
                Integer idClient = Integer.parseInt(element.getElementsByTagName("idClient").item(0).getTextContent());
                String codeDepartement = element.getElementsByTagName("codeDepartement").item(0).getTextContent();
                Integer zone = Integer.parseInt(element.getElementsByTagName("zone").item(0).getTextContent());
                Double montant = Double.parseDouble(element.getElementsByTagName("montant").item(0).getTextContent());

                Tarif tarif = new Tarif(idClient, idClientHeritage, codeDepartement, zone, montant);
                tarifs.add(tarif);
            }

            // Afficher les tarifs
            for (Tarif tarif : tarifs) {
                System.out.println(tarif);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return tarifs;
    }
    
    
}
