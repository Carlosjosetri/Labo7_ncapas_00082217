package com.uca.capas.Labo7.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.uca.capas.Labo7.dao.EstudianteDAO;
import com.uca.capas.Labo7.domain.Estudiante;
import com.uca.capas.Labo7.repositories.EstudianteRepository;
import com.uca.capas.Labo7.service.EstudianteService;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	EstudianteRepository estudianteRepo;
	//EstudianteDAO estudianteDAO;
	
	@Override
	public List<Estudiante> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.findAll();
		//return estudianteRepo.showAll();
	}

	@Override
	public Estudiante findOne(Integer code) throws DataAccessException {
		// TODO Auto-generated method stub
		return estudianteRepo.getOne(code);
	}

	@Override
	@Transactional
	public void save(Estudiante estudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteRepo.save(estudiante);
	}

	@Override
	@Transactional
	public void delete(Integer codigoEstudiante) throws DataAccessException {
		// TODO Auto-generated method stub
		estudianteRepo.deleteById(codigoEstudiante);
	}
	
	@Override
	public List<Estudiante> filtrarPor(String nombre) throws DataAccessException {
		return estudianteRepo.findByNombre(nombre);
		//return estudianteRepo.showByName(nombre);
	}

	@Override
	public List<Estudiante> startingWith(String apellido) throws DataAccessException {
		return estudianteRepo.findByApellidoStartingWith(apellido);
	}
}
