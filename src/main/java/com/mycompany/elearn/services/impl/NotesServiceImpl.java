package com.mycompany.elearn.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.elearn.dao.INotesDao;
import com.mycompany.elearn.entites.Notes;
import com.mycompany.elearn.services.INotesService;


@Transactional
public class NotesServiceImpl implements INotesService{

	private INotesDao dao;
	
	public void setDao(INotesDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Notes save(Notes entity) {
		
		return dao.save(entity);
	}

	@Override
	public Notes update(Notes entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Notes> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Notes getById(long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public List<Notes> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Notes findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Notes findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
