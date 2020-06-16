package com.uca.capas.Labo7.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.uca.capas.Labo7.domain.Estudiante;

public interface EstudianteService {
	
	public List<Estudiante> findAll() throws DataAccessException;
	
	public Estudiante findOne(Integer code) throws DataAccessException;
	
	public void save(Estudiante estudiante) throws DataAccessException;
	
	public void delete(Integer codigoEstudiante) throws DataAccessException;

	List<Estudiante> filtrarPor(String nombre) throws DataAccessException;

	List<Estudiante> startingWith(String apellido) throws DataAccessException;
	
}
