package com.uca.capas.Labo7.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.Labo7.domain.Estudiante;
import com.uca.capas.Labo7.service.EstudianteService;

@Controller
public class MainController {
	
	@Autowired
	private EstudianteService estudianteService;
	
	@RequestMapping("/estudiante")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		
		try {
			estudiantes = estudianteService.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("main");
		
		return mav;
	}
	
	@RequestMapping(value = "/mostrarEstudiante", method = RequestMethod.POST)
	public ModelAndView findOne(@RequestParam(value = "codigo") int id) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = null;
		try {
			estudiante = estudianteService.findOne(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("estudiante", estudiante);
		mav.setViewName("estudiante");
		
		return mav;
	
	}
	
	//Editar
	@RequestMapping(value = "/editarEstudiante", method= RequestMethod.POST)
	public ModelAndView editar(@RequestParam(value = "codigo") int id) {
		ModelAndView mav = new ModelAndView();
		Estudiante estudiante = estudianteService.findOne(id);
		mav.addObject("estudiante", estudiante);
		mav.setViewName("agregarEstudiante");		
		return mav;
	
	}
	
	@RequestMapping("/save")
	public ModelAndView guardar(@Valid @ModelAttribute Estudiante estudiante, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()) {
			mav.setViewName("agregarEstudiante");
		}else {
			estudianteService.save(estudiante);
			List<Estudiante> estudiantes = null;
			try {
				estudiantes = estudianteService.findAll();
			}catch(Exception e){
				e.printStackTrace();
			}
			mav.addObject("estudiantes", estudiantes);
			mav.setViewName("listaEstudiantes");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/borrarEstudiante", method = RequestMethod.POST)
	public ModelAndView delete(@RequestParam(value = "codigo") int id) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			estudianteService.delete(id);
			estudiantes = estudianteService.findAll();
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("main");
		return mav;
	}
	
	@GetMapping("/insertarEstudiante")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("estudiante", new Estudiante());
		mav.setViewName("agregarEstudiante");
		return mav;
	}
	
	@PostMapping(value = "/filtrar")
	public ModelAndView filtro(@RequestParam(value = "nombre") String nombre) {
		ModelAndView mav = new ModelAndView();
		List<Estudiante> estudiantes = null;
		try {
			//estudiantes = estudianteService.startingWith(nombre);
			estudiantes = estudianteService.filtrarPor(nombre);
		}catch(Exception e) {
			e.printStackTrace();
		}
		mav.addObject("estudiantes", estudiantes);
		mav.setViewName("main");
		return mav;
	}
	
	
	
}
