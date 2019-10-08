package com.mycompany.elearn.services;

import java.util.List;

import com.mycompany.elearn.entites.Quiz;


public interface IQuizService {
	
	public Quiz save(Quiz entity);
	
	public Quiz update(Quiz entity);
	
	public List<Quiz> selectAll();
	
	public Quiz getById(long id);
	
	public void remove(long id);
	
	public List<Quiz> selectAll(String sortField,String sort);
	
	public Quiz findOne(String paramName, Object paramValue);
	
	public Quiz findOne(String[] paramNames,Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
