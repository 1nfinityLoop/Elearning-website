package com.mycompany.elearn.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.elearn.dao.IEtudiantDao;
import com.mycompany.elearn.dao.IFichierDao;
import com.mycompany.elearn.entites.Fichiers;
import com.mycompany.elearn.services.IFichiersService;


@Transactional
public class FichiersServiceImpl implements IFichiersService{

	private IFichierDao dao;
	
	public void setDao(IFichierDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Fichiers save(Fichiers entity) {
		
		return dao.save(entity);
	}

	@Override
	public Fichiers update(Fichiers entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Fichiers> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Fichiers getById(long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public List<Fichiers> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Fichiers findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Fichiers findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
