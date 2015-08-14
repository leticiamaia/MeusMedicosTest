package com.example.meusmedicos.models.test;

import java.util.Calendar;

import junit.framework.TestCase;

import org.junit.Test;

import com.example.meusmedicos.models.Consulta;
import com.example.meusmedicos.models.Especialidade;

public class ConsultaTest extends TestCase {
	
	@Test
	public void testCopy() {
		Consulta consulta1 = new Consulta("dr", new Especialidade("Dermatologista"), Calendar.getInstance(), false);
		Consulta consulta2 = new Consulta(null, null, null, true);
		consulta2.copy(consulta1);
		assertEquals(consulta1.getMedico(), consulta2.getMedico());
		assertEquals(consulta1.getDate(), consulta2.getDate());
		assertEquals(consulta1.getEspecialidade(), consulta2.getEspecialidade());
		assertEquals(consulta1.getLembrar(), consulta2.getLembrar());
		assertEquals(consulta1.getAnotacao(), consulta2.getAnotacao());
	}
	
	@Test
	public void testEqualsNotTrue() {
		Consulta consulta1 = new Consulta("dr", new Especialidade("Dermatologista"), Calendar.getInstance(), false);
		Consulta consulta2 = new Consulta("dr1", new Especialidade("Dermatologista"), Calendar.getInstance(), false);
		assertFalse(consulta1.equals(consulta2));
	}
	
	@Test
	public void testEqualsTrue() {
		Calendar calendar = Calendar.getInstance();
		Consulta consulta1 = new Consulta("dr", new Especialidade("Dermatologista"), calendar, false);
		Consulta consulta2 = new Consulta("dr", new Especialidade("Dermatologista"), calendar, false);
		assertTrue(consulta1.equals(consulta2));
	}

}
