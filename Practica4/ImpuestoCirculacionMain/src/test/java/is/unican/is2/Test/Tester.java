package is.unican.is2.Test;

import org.fest.swing.fixture.FrameFixture;
import org.junit.After;
import org.junit.Before;

import es.unican.is2.ImpuestoCirculacion.ContribuyentesDAO;
import es.unican.is2.ImpuestoCirculacion.GestionImpuestoCirculacion;
import es.unican.is2.ImpuestoCirculacion.VehiculosDAO;
import es.unican.is2.ImpuestoCirculacion.VistaFuncionario;

public class Tester {
	private FrameFixture demo;
	
	
	@Before
	public void setUp() {
		
		ContribuyentesDAO contribuyentesDAO = new ContribuyentesDAO();
		VehiculosDAO vehiculosDAO = new VehiculosDAO();
		
		// Componentes capa negocio
		GestionImpuestoCirculacion negocio = new GestionImpuestoCirculacion(contribuyentesDAO, vehiculosDAO);
		
		// Componentes casa presentacion
		VistaFuncionario gui = new VistaFuncionario(negocio, negocio, negocio);
	
		demo = new FrameFixture(gui);
		gui.setVisible(true);
	}
	
	@After
	public void tearDown() {
		demo.cleanUp();
	}
	
	@org.junit.Test
	public void test() {
		
		demo.textBox("txtDniContribuyente").enterText("11111111A");
		demo.button("btnBuscar").click();
		demo.textBox("txtNombreContribuyente").requireText("Pepe López Martínez");
		demo.list("ListaMatriculas").requireItemCount(2);
		demo.textBox("txtTotalContribuyente").requireText("448.0");
		
		
		demo.textBox("txtDniContribuyente").setText("22222222B");
		demo.button("btnBuscar").click();
		demo.textBox("txtNombreContribuyente").requireText("Ana Pérez López");
		demo.list("ListaMatriculas").requireItemCount(2);
		demo.textBox("txtTotalContribuyente").requireText("8.84");
		
		
		demo.textBox("txtDniContribuyente").setText("33333333C");
		demo.button("btnBuscar").click();
		demo.textBox("txtNombreContribuyente").requireText("Luis Toca Pérez");
		demo.list("ListaMatriculas").requireItemCount(2);
		demo.textBox("txtTotalContribuyente").requireText("249.24");
		
		
		demo.textBox("txtDniContribuyente").setText("");
		demo.button("btnBuscar").click();
		demo.textBox("txtNombreContribuyente").requireText("DNI No Válido");
		demo.list("ListaMatriculas").requireItemCount(0);
		demo.textBox("txtTotalContribuyente").requireText("0");
		
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
