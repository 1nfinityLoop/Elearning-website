package com.mycompany.elearn.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mycompany.elearn.dao.ICoursDao;
import com.mycompany.elearn.dao.IEtudiantDao;
import com.mycompany.elearn.dao.IFichierDao;
import com.mycompany.elearn.entites.Cours;
import com.mycompany.elearn.entites.Fichiers;
import com.mycompany.elearn.services.ICoursService;
import com.mycompany.elearn.services.IFichiersService;


@Transactional
public class CoursServiceImpl implements ICoursService{

	private ICoursDao dao;
	
	public void setDao(ICoursDao dao) {
		this.dao = dao;
	}
	
	@Override
	public Cours save(Cours entity) {
		
		return dao.save(entity);
	}

	@Override
	public Cours update(Cours entity) {
		// TODO Auto-generated method stub
		return dao.update(entity);
	}

	@Override
	public List<Cours> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public Cours getById(long id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		dao.remove(id);
	}

	@Override
	public List<Cours> selectAll(String sortField, String sort) {
		// TODO Auto-generated method stub
		return dao.selectAll(sortField, sort);
	}

	@Override
	public Cours findOne(String paramName, Object paramValue) {
		// TODO Auto-generated method stub
		return dao.findOne(paramName, paramValue);
	}

	@Override
	public Cours findOne(String[] paramNames, Object[] paramValues) {
		// TODO Auto-generated method stub
		return dao.findOne(paramNames, paramValues);
	}

	@Override
	public int findCountBy(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return dao.findCountBy(paramName, paramValue);
	}

}
