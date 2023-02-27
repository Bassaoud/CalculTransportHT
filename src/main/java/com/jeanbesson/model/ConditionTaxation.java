package com.jeanbesson.model;



public class ConditionTaxation {

	private Integer idClient;
    private Double taxePortDu;
    private Double taxePortPaye;
    private boolean useTaxePortDuGenerale;
    private boolean useTaxePortPayeGenerale;

    
    public ConditionTaxation() {
        // Constructeur par défaut 
    }
    
    public ConditionTaxation(Integer idClient, Double taxePortDu, Double taxePortPaye, boolean useTaxePortDuGenerale, boolean useTaxePortPayeGenerale) {
        this.idClient = idClient;
        this.taxePortDu = taxePortDu;
        this.taxePortPaye = taxePortPaye;
        this.useTaxePortDuGenerale = useTaxePortDuGenerale;
        this.useTaxePortPayeGenerale = useTaxePortPayeGenerale;
    }

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public Double getTaxePortDu() {
		return taxePortDu;
	}

	public void setTaxePortDu(Double taxePortDu) {
		this.taxePortDu = taxePortDu;
	}

	public Double getTaxePortPaye() {
		return taxePortPaye;
	}

	public void setTaxePortPaye(Double taxePortPaye) {
		this.taxePortPaye = taxePortPaye;
	}

	public boolean isUseTaxePortDuGenerale() {
		return useTaxePortDuGenerale;
	}

	public void setUseTaxePortDuGenerale(boolean useTaxePortDuGenerale) {
		this.useTaxePortDuGenerale = useTaxePortDuGenerale;
	}

	public boolean isUseTaxePortPayeGenerale() {
		return useTaxePortPayeGenerale;
	}

	public void setUseTaxePortPayeGenerale(boolean useTaxePortPayeGenerale) {
		this.useTaxePortPayeGenerale = useTaxePortPayeGenerale;
	}

    
    

}
