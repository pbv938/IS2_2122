package es.unican.is2.Pruebas;

import static org.junit.Assert.assertEquals;

public class Test {
	ListaOrdenadaAcotada<Integer> l = new ListaOrdenadaAcotada<Integer>(10);
	
	@org.junit.Test
	public void TestListaOrdenada() {
		l.add(0);
		l.add(1);
		l.add(2);
		l.add(3);
		l.add(4);
		l.add(5);
		l.add(6);
		l.add(7);
		l.add(8);
		l.add(9);
		
		assertEquals(l.size(),10);
		
		int n = l.get(2);
		assertEquals(n,2);
		
		l.remove(9);
		assertEquals(l.size(),9);
		
	}
	
	

	
	
	
	
}
