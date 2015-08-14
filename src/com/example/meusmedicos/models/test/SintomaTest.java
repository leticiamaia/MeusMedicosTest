package com.example.meusmedicos.models.test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

import com.example.meusmedicos.models.Especialidade;
import com.example.meusmedicos.models.Sintoma;

import junit.framework.TestCase;

public class SintomaTest extends TestCase {
	
	@Test
	public void testEquals() {
		Calendar date = Calendar.getInstance();
		Especialidade especialidade = new Especialidade("a");
		Sintoma sintoma1 = new Sintoma("S", date , 1, especialidade, "");
		Sintoma sintoma2 = new Sintoma("S", date , 1, especialidade, "");
		assertTrue(sintoma1.equals(sintoma2));
	}
	
	@Test
	public void testNotEquals() {
		Calendar date = Calendar.getInstance();
		Especialidade especialidade = new Especialidade("a");
		Sintoma sintoma1 = new Sintoma("S", date , 1, especialidade, "");
		Sintoma sintoma2 = new Sintoma("B", date , 1, especialidade, "");
		assertFalse(sintoma1.equals(sintoma2));
	}
	
	@Test
	public void testGetDataQueTerminou() {
		Calendar date = Calendar.getInstance();
		Especialidade especialidade = new Especialidade("a");
		Sintoma sintoma1 = new Sintoma("S", date , 1, especialidade, "");
		Calendar date2 = (Calendar) date.clone();
		date2.set(Calendar.DAY_OF_MONTH, date2.get(Calendar.DAY_OF_MONTH) + 1 );
		assertFalse(date2.equals(sintoma1.getDataQueTerminou()));
		GregorianCalendar dataQueTerminou = (GregorianCalendar) sintoma1.getDataQueTerminou();
		assertEquals(dataQueTerminou.YEAR, date2.YEAR);
		assertEquals(dataQueTerminou.MONTH, date2.MONTH);
		assertEquals(dataQueTerminou.DAY_OF_MONTH, date2.DAY_OF_MONTH);
	}	

}
