package com.example.meusmedicos.test;

import java.util.Calendar;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Test;

import com.example.meusmedicos.Global;
import com.example.meusmedicos.controllers.Controller;
import com.example.meusmedicos.models.Consulta;
import com.example.meusmedicos.models.Especialidade;
import com.example.meusmedicos.models.Sintoma;

public class ControllerTest extends TestCase {
	
	@Test
	public void testConfigInicial() {
		List<Consulta> consultas = Controller.getConsultas();
		assertEquals(0, consultas.size());
		
		List<Sintoma> sintomas = Controller.getSintomas();
		assertEquals(0, sintomas.size());
		
		List<Especialidade> especialidades = Controller.getEspecialidades();
		assertEquals(0, especialidades.size());
	}
	
	@Test
	public void testAddConsulta() {
		Consulta consulta = new Consulta("dr", new Especialidade("dermatologista"), Calendar.getInstance(), false);
		List<Consulta> consultas = Controller.getConsultas();
		assertEquals(0, consultas.size());
		Controller.addConsulta(consulta);
		consultas = Controller.getConsultas();
		assertEquals(1, consultas.size());
	}
	
	@Test
	public void testRemoveConsulta() {
		Consulta consulta = new Consulta("dr", new Especialidade("dermatologista"), Calendar.getInstance(), false);;
		Controller.addConsulta(consulta);
		List<Consulta> consultas = Controller.getConsultas();
		assertEquals(1, consultas.size());
		Controller.deletaConsulta(consulta);
		assertEquals(0, consultas.size());
	}
	
	@Test
	public void testAddSintoma() {
		Sintoma sintoma = new Sintoma("dor", Calendar.getInstance(), 2, new Especialidade("dermatologista"), "...");
		List<Sintoma> sintomas = Controller.getSintomas();
		assertEquals(0, sintomas.size());
		Controller.addSintoma(sintoma);
		sintomas = Controller.getSintomas();
		assertEquals(1, sintomas.size());
	}
	
	@Test
	public void testRemoveSintoma() {
		Sintoma sintoma = new Sintoma("dor", Calendar.getInstance(), 2, new Especialidade("dermatologista"), "...");
		Controller.addSintoma(sintoma);
		List<Sintoma> sintomas = Controller.getSintomas();
		assertEquals(1, sintomas.size());
		Controller.removeSintoma(sintoma);
		sintomas = Controller.getSintomas();
		assertEquals(0, sintomas.size());	
	}
	
	@Test
	public void testAddEspecialidade() {
		Especialidade especialidade = new Especialidade("dermatologista");
		List<Especialidade> especialidades = Controller.getEspecialidades();
		assertEquals(0, especialidades.size());
		Controller.adicionaEspecialidade(especialidade);
		especialidades = Controller.getEspecialidades();
		assertEquals(1,especialidades.size());
		
	}
	
	@Test
	public void testEditConsulta() {
		Consulta consulta = new Consulta("dr", new Especialidade("dermatologista"), Calendar.getInstance(), false);
		Consulta consulta2 = new Consulta("dr2", new Especialidade("dermatologista"), Calendar.getInstance(), false);
		Global.selectedConsulta = consulta;
		Controller.editConsulta(consulta2);
		assertEquals("dr2", consulta.getMedico());
	}
	
	@Test
	public void testEditSintoma() {
		Sintoma sintoma = new Sintoma("dor", Calendar.getInstance(), 2, new Especialidade("dermatologista"), "...");
		Sintoma sintoma2 = new Sintoma("pain", Calendar.getInstance(), 2, new Especialidade("dermatologista"), "...");
		Global.selectedSintoma = sintoma;
		Controller.editSintoma(sintoma2);
		assertEquals("pain", sintoma.getTitulo());
	}
	
	@After
	public void tearDown() {
		Controller.getConsultas().clear();
		Controller.getSintomas().clear();
		Controller.getEspecialidades().clear();
	}
}
