package com.mycompany.elearn.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.elearn.dao.IEnseignantDao;
import com.mycompany.elearn.entites.Enseignant;
import com.mycompany.elearn.services.IEnseignantService;


@Transactional
public class EnseignantServiceImpl implements IEnseignantService{

	private IEnseignantDao dao;
	
	public void setDao(IEnseignantDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Enseignant save(Enseignant entity) {
		
		return dao.save(entity);
	}

	@Override
	public Enseignant update(Enseignant entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Enseignant> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Enseignant getById(long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public List<Enseignant> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Enseignant findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Enseignant findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
