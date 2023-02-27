package com.jeanbesson.model;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


/**
 * @author bassaoud
 *
 */
public class Client {
	
	//(sert à rechercher les tarifs et les conditions de taxation)
	private Integer idClient;
	private String raisonSociale;
	//(code département pour simplifier)
	private String codePostal;
	private String ville;
	List<Client> clients = new ArrayList<>();

	
	public Client(int idClient, String raisonSociale, String codePostal, String ville) {
        this.idClient = idClient;
        this.raisonSociale = raisonSociale;
        this.codePostal = codePostal;
        this.ville = ville;
    }

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getRaisonSociale() {
		return raisonSociale;
	}

	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public List<Client> getClients() {
		return clients;
	}
	
	
	
	

}
