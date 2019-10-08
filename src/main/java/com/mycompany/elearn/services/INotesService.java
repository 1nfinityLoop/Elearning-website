package com.mycompany.elearn.services;

import java.util.List;

import com.mycompany.elearn.entites.Notes;

public interface INotesService {
	
	public Notes save(Notes entity);
	
	public Notes update(Notes entity);
	
	public List<Notes> selectAll();
	
	public Notes getById(long id);
	
	public void remove(long id);
	
	public List<Notes> selectAll(String sortField,String sort);
	
	public Notes findOne(String paramName, Object paramValue);
	
	public Notes findOne(String[] paramNames,Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
