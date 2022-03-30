package es.unican.is2;


import static org.junit.Assert.*;

import java.time.LocalDate;

import es.unican.is2.ImpuestoCirculacion.Furgoneta;
import es.unican.is2.ImpuestoCirculacion.Motocicleta;
import es.unican.is2.ImpuestoCirculacion.Turismo;
import es.unican.is2.ImpuestoCirculacion.Vehiculo;


public class Test {
	
	@org.junit.Test
	public void devuelveMatricula() {
		Vehiculo v = new Turismo("1111AAA",LocalDate.now(),5);
		assertEquals(v.getMatricula(),"1111AAA");
	}
	@org.junit.Test
	public void devuelveFechaMatriculacion() {
		Vehiculo v = new Turismo("1111AAA",LocalDate.now(),5);
		assertEquals(v.getFechaMatriculacion(),LocalDate.now());
	}
	
	@org.junit.Test
	public void testPrecioImpuesto() {
		Vehiculo v = new Turismo("1111AAA",LocalDate.now(),5);
		assertEquals(v.precioImpuesto(),25.24,0.01);
		
		Vehiculo v1 = new Turismo("1111BBB",LocalDate.now(),10);
		assertEquals(v1.precioImpuesto(),68.16,0.01);
		
		Vehiculo v2 = new Motocicleta("1111CCC",LocalDate.now(),120);
		assertEquals(v2.precioImpuesto(),8.84,0.01);
		
		Vehiculo v3 = new Motocicleta("1111DDD",LocalDate.now(),600);
		assertEquals(v3.precioImpuesto(),60.58,0.01);
		
		Vehiculo v4 = new Furgoneta("1111TQB",LocalDate.now(),35);
		assertEquals(v4.precioImpuesto(),224,0.01);
		
		Vehiculo v5 = new Furgoneta("1111ASD",LocalDate.now(),15);
		assertEquals(v5.precioImpuesto(),143.88,0.01);
		
	}
	
	
	
}
