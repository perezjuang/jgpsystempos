package com.pos;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.pos.models.Customer;
import com.pos.models.Organization;
import com.pos.models.Society;
import com.pos.repository.CustomerRepository;
import com.pos.repository.OrganizationRepository;
import com.pos.repository.SocietyRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final CustomerRepository customerRepository;
	private final SocietyRepository societyRepository;
	private final OrganizationRepository organizationRepository;
	
	@Autowired
	public DatabaseLoader(CustomerRepository customerRepository,
			SocietyRepository societyRepository,
			OrganizationRepository organizationRepository
			
			) {
		super();
		this.customerRepository = customerRepository;
		this.societyRepository = societyRepository;
		this.organizationRepository = organizationRepository;
	}

	@Override
	public void run(String... strings) throws Exception {

		Society sociedad = new Society();
		sociedad.setDescription("Sociedad Capacitaciones");
		sociedad.setId(1);
		sociedad.setSociety_key("SOCIEDADCAPACITACION");
		sociedad.setNit("99999999-9");
		this.societyRepository.save(sociedad);
		

		sociedad.setDescription("Sociedad Capacitaciones 2");
		sociedad.setId(2);
		sociedad.setSociety_key("SOCIEDADCAPACITACION2");
		sociedad.setNit("99999999-8");
		this.societyRepository.save(sociedad);
		
		sociedad.setDescription("Sociedad Capacitaciones 3");
		sociedad.setId(3);
		sociedad.setSociety_key("SOCIEDADCAPACITACION3");
		sociedad.setNit("99999999-7");
		this.societyRepository.save(sociedad);
		
		Organization organizacion = new Organization();
		organizacion.setDescription("Organizacion Estadio Capacitacion");
		organizacion.setId(1);
		organizacion.setOrganization_key("ESTADIO01");
		organizacion.setDireccion("Calle 40 # 86 a 86");
		organizacion.setSociety(sociedad);		
		this.organizationRepository.save(organizacion);

		
	}




}
