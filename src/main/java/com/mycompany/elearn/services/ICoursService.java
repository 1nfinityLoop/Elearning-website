package com.mycompany.elearn.services;

import java.util.List;

import com.mycompany.elearn.entites.Cours;

public interface ICoursService {
	
	public Cours save(Cours entity);
	
	public Cours update(Cours entity);
	
	public List<Cours> selectAll();
	
	public Cours getById(long id);
	
	public void remove(long id);
	
	public List<Cours> selectAll(String sortField,String sort);
	
	public Cours findOne(String paramName, Object paramValue);
	
	public Cours findOne(String[] paramNames,Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
