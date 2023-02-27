package com.jeanbesson.model;

public class Localite {
    private String ville;
    private String codePostal;
    private int zone;

    public Localite(String ville, String codePostal, int zone) {
        this.ville = ville;
        this.codePostal = codePostal;
        this.zone = zone;
    }

    public String getVille() {
        return ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public String toString() {
        return ville + " " + codePostal;
    }

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}
    
    
}

