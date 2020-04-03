package com.lawencon.appli.implhibernate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class ParkiranEm {
	
	@PersistenceContext
	public EntityManager em;
}
