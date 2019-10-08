package com.mycompany.elearn.services;

import java.util.List;

import com.mycompany.elearn.entites.Fichiers;

public interface IFichiersService {
	
	public Fichiers save(Fichiers entity);
	
	public Fichiers update(Fichiers entity);
	
	public List<Fichiers> selectAll();
	
	public Fichiers getById(long id);
	
	public void remove(long id);
	
	public List<Fichiers> selectAll(String sortField,String sort);
	
	public Fichiers findOne(String paramName, Object paramValue);
	
	public Fichiers findOne(String[] paramNames,Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
