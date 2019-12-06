package com.pos.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity // This tells Hibernate to make a table out of this class
public class Organization {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String organization_key;
    private String description;
    private String direccion;
    
    @ManyToOne
    @JoinColumn(name = "society_id")
    private Society society;
    
    public Organization(Integer id, String organization_key, String description,String direccion, Society society) {
		super();
		this.id = id;
		this.organization_key = organization_key;
		this.description = description;
		this.direccion = direccion;
		this.society = society;
	}

	public Organization() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrganization_key() {
		return organization_key;
	}

	public void setOrganization_key(String organization_key) {
		this.organization_key = organization_key;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Society getSociety() {
		return society;
	}

	public void setSociety(Society society) {
		this.society = society;
	}
    

	

	
}

