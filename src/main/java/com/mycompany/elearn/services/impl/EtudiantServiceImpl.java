package com.mycompany.elearn.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.elearn.dao.IEtudiantDao;
import com.mycompany.elearn.entites.Etudiant;
import com.mycompany.elearn.services.IEtudiantService;


@Transactional
public class EtudiantServiceImpl implements IEtudiantService{

	private IEtudiantDao dao;
	
	public void setDao(IEtudiantDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Etudiant save(Etudiant entity) {
		
		return dao.save(entity);
	}

	@Override
	public Etudiant update(Etudiant entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Etudiant> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Etudiant getById(long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public List<Etudiant> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Etudiant findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Etudiant findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
