package com.mycompany.elearn.services;

import java.util.List;

import com.mycompany.elearn.entites.Question;


public interface IQuestionService {
	
	public Question save(Question entity);
	
	public Question update(Question entity);
	
	public List<Question> selectAll();
	
	public Question getById(long id);
	
	public void remove(long id);
	
	public List<Question> selectAll(String sortField,String sort);
	
	public Question findOne(String paramName, Object paramValue);
	
	public Question findOne(String[] paramNames,Object[] paramValues);
	
	public int findCountBy(String paramName, String paramValue);
}
