package es.unican.is2.Test;
import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Test;

import es.unican.is2.ImpuestoCirculacion.Furgoneta;
	import es.unican.is2.ImpuestoCirculacion.Motocicleta;
	import es.unican.is2.ImpuestoCirculacion.Turismo;
	import es.unican.is2.ImpuestoCirculacion.Vehiculo;

public class Tests {	
		@Test
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
		public void testImpuestoTurismos() {
			//Potencia < 8
			Vehiculo v = new Turismo("1111AAA",LocalDate.now(),5);
			assertEquals(v.precioImpuesto(),25.24,0.01);
			//8 <= Potencia < 12
			Vehiculo v1 = new Turismo("1111BBB",LocalDate.now(),10);
			assertEquals(v1.precioImpuesto(),68.16,0.01);
			//12 <= Potencia < 16
			Vehiculo v2 = new Turismo("1111BBB",LocalDate.now(),13);
			assertEquals(v2.precioImpuesto(),143.88,0.01);
			//16 <= Potencia < 20
			Vehiculo v3 = new Turismo("1111BBB",LocalDate.now(),18);
			assertEquals(v3.precioImpuesto(),179.22,0.01);
			 //20 <= Potencia
			Vehiculo v4 = new Turismo("1111BBB",LocalDate.now(),25);
			assertEquals(v4.precioImpuesto(),224,0.01);
			//Fecha Matriculacion con antiguedad mayor a 25 años
			Vehiculo v5 = new Turismo("1111BBB",LocalDate.of(1950, 1, 1),25);
			assertEquals(v5.precioImpuesto(),0,0.01);
			
		}
		
		@org.junit.Test
		public void testImpuestoFurgonetas() {
			//Potencia < 8
			Vehiculo v = new Furgoneta("1111AAA",LocalDate.now(),5);
			assertEquals(v.precioImpuesto(),25.24,0.01);
			//8 <= Potencia < 12
			Vehiculo v1 = new Furgoneta("1111BBB",LocalDate.now(),10);
			assertEquals(v1.precioImpuesto(),68.16,0.01);
			//12 <= Potencia < 16
			Vehiculo v2 = new Furgoneta("1111BBB",LocalDate.now(),13);
			assertEquals(v2.precioImpuesto(),143.88,0.01);
			//16 <= Potencia < 20
			Vehiculo v3 = new Furgoneta("1111BBB",LocalDate.now(),18);
			assertEquals(v3.precioImpuesto(),179.22,0.01);
		    //20 <= Potencia
			Vehiculo v4 = new Furgoneta("1111BBB",LocalDate.now(),25);
			assertEquals(v4.precioImpuesto(),224,0.01);
			//Fecha Matriculacion con antiguedad mayor a 25 años
			Vehiculo v5 = new Furgoneta("1111BBB",LocalDate.of(1950, 1, 1),25);
			assertEquals(v5.precioImpuesto(),0,0.01);
		
			
		}
		@org.junit.Test
		public void testImpuestoMotocicletas() {
			//Potencia <= 125
			Vehiculo v = new Motocicleta("1111CCC",LocalDate.now(),120);
			assertEquals(v.precioImpuesto(),8.84,0.01);
			//125 < Potencia <= 250
			Vehiculo v1 = new Motocicleta("1111CSC",LocalDate.now(),200);
			assertEquals(v1.precioImpuesto(),15.14,0.01);
			//250 < Potencia <= 500
			Vehiculo v2 = new Motocicleta("1111DDD",LocalDate.now(),350);
			assertEquals(v2.precioImpuesto(),30.30,0.01);
			//500 < Potencia <= 1000
			Vehiculo v3 = new Motocicleta("1111DDD",LocalDate.now(),750);
			assertEquals(v3.precioImpuesto(),60.58,0.01);
			//1000 < Potencia 
			Vehiculo v4 = new Motocicleta("1111DEE",LocalDate.now(),1200);
			assertEquals(v4.precioImpuesto(),121.16,0.01);
			//Fecha Matriculacion con antiguedad mayor a 25 años
			Vehiculo v5 = new Motocicleta("1111BBB",LocalDate.of(1950, 1, 1),230);
			assertEquals(v5.precioImpuesto(),0,0.01);
			
		}
		
		
		
		
		
}