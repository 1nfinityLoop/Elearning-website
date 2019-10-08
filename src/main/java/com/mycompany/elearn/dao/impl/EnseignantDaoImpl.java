package com.mycompany.elearn.dao.impl;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;

import com.mycompany.elearn.dao.IEnseignantDao;
import com.mycompany.elearn.entites.Enseignant;


@Repository
public class EnseignantDaoImpl extends GenericDaoImpl<Enseignant> implements IEnseignantDao  {
		
	@PersistenceContext
	private EntityManager entityManager;
	
	
	
	
	
	
}
