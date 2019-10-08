package com.mycompany.elearn.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.elearn.dao.IQuizDao;
import com.mycompany.elearn.entites.Quiz;
import com.mycompany.elearn.services.IQuizService;


@Transactional
public class QuizServiceImpl implements IQuizService{

	private IQuizDao dao;
	
	public void setDao(IQuizDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Quiz save(Quiz entity) {
		
		return dao.save(entity);
	}

	@Override
	public Quiz update(Quiz entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Quiz> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Quiz getById(long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public List<Quiz> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Quiz findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Quiz findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
