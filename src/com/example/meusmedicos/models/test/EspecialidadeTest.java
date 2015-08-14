package com.example.meusmedicos.models.test;

import org.junit.Test;

import com.example.meusmedicos.models.Especialidade;

import junit.framework.TestCase;

public class EspecialidadeTest extends TestCase {
	
	@Test
	public void testEquals() {
		Especialidade especialidade = new Especialidade("Dermatologista");
		Especialidade especialidade2 = new Especialidade("Dermatologista");
		assertTrue(especialidade.equals(especialidade2));
	}
	
	@Test
	public void testNotEquals() {
		Especialidade especialidade = new Especialidade("Dermatologista");
		Especialidade especialidade2 = new Especialidade("Cirurgiao");
		assertFalse(especialidade.equals(especialidade2));
	}
	
}
