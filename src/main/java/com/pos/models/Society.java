
package com.pos.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class Society {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	private String society_key;
	private String description;
	private String nit;
	
	/*@OneToMany(mappedBy = "society")
	private List<Organization> organizations;
	*/
	public Society(Integer id,String society_key, String i_description, List<Organization> organizations) {

		this.id = id;
		this.society_key = society_key;
		this.description = i_description;
		//this.organizations = organizations;
	}

	public Society() {
		// TODO Auto-generated constructor stub

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSociety_key() {
		return society_key;
	}

	public void setSociety_key(String society_key) {
		this.society_key = society_key;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	/*public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}*/


}

