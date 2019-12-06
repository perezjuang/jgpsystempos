package com.pos.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class Customer {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    private String customer_id;
    private String name;

   
   protected Customer() {}

    public Customer(String customer_id, String name) {
    	this.customer_id = customer_id;
    	this.name = name;
    }

	@Override
	public String toString() {
		return "Customer [id=" + id + ", customer_id=" + customer_id + ", name=" + name + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	

}
