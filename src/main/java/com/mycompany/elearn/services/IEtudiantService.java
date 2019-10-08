package com.mycompany.elearn.services;

import java.util.List;

import com.mycompany.elearn.entites.Etudiant;

public interface IEtudiantService {
	
	public Etudiant save(Etudiant entity);
	
	public Etudiant update(Etudiant entity);
	
	public List<Etudiant> selectAll();
	
	public Etudiant getById(long id);
	
	public void remove(long id);
	
	public List<Etudiant> selectAll(String sortField,String sort);
	
	public Etudiant findOne(String paramName, Object paramValue);
	
	public Etudiant findOne(String[] paramNames,Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
