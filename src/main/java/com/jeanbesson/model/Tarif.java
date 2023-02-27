package com.jeanbesson.model;

public class Tarif {
	private Integer idClient;
	private Integer idClientHeritage;
	private String codeDepartement;
	private Integer zone;
	private Double montant;
	
	 public Tarif(Integer idClient, Integer idClientHeritage, String codeDepartement, Integer zone, Double montant) {
	        this.idClient = idClient;
	        this.idClientHeritage = idClientHeritage;
	        this.codeDepartement = codeDepartement;
	        this.zone = zone;
	        this.montant = montant;
	    }

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public Integer getIdClientHeritage() {
		return idClientHeritage;
	}

	public void setIdClientHeritage(Integer idClientHeritage) {
		this.idClientHeritage = idClientHeritage;
	}

	public String getCodeDepartement() {
		return codeDepartement;
	}

	public void setCodeDepartement(String codeDepartement) {
		this.codeDepartement = codeDepartement;
	}

	public Integer getZone() {
		return zone;
	}

	public void setZone(Integer zone) {
		this.zone = zone;
	}

	public Double getMontant() {
		return montant;
	}

	public void setMontant(Double montant) {
		this.montant = montant;
	}

}
