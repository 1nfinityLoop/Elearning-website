package com.mycompany.elearn.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.elearn.dao.IQuestionDao;
import com.mycompany.elearn.entites.Question;
import com.mycompany.elearn.services.IQuestionService;


@Transactional
public class QuestionServiceImpl implements IQuestionService{

	private IQuestionDao dao;
	
	public void setDao(IQuestionDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Question save(Question entity) {
		
		return dao.save(entity);
	}

	@Override
	public Question update(Question entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Question> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Question getById(long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public List<Question> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Question findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Question findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
