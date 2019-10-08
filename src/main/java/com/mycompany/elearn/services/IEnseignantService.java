package com.mycompany.elearn.services;

import java.util.List;

import com.mycompany.elearn.entites.Enseignant;

public interface IEnseignantService {
	public Enseignant save(Enseignant entity);
	
	public Enseignant update(Enseignant entity);
	
	public List<Enseignant> selectAll();
	
	public Enseignant getById(long id);
	
	public void remove(long id);
	
	public List<Enseignant> selectAll(String sortField,String sort);
	
	public Enseignant findOne(String paramName, Object paramValue);
	
	public Enseignant findOne(String[] paramNames,Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
