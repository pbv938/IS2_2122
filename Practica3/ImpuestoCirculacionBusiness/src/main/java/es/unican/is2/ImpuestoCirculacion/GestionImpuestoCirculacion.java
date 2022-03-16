package es.unican.is2.ImpuestoCirculacion;


/**
 * Clase que implementa la capa de negocio de la aplicacion
 */
public class GestionImpuestoCirculacion implements IGestionContribuyentes, IGestionVehiculos, IInfoImpuestoCirculacion {
	
	private IContribuyentesDAO contribuyentes;
	private IVehiculosDAO vehiculos;
	
	public GestionImpuestoCirculacion(IContribuyentesDAO contribuyentes, IVehiculosDAO vehiculos) {
		this.contribuyentes = contribuyentes;
		this.vehiculos = vehiculos;
	}
	
	@SuppressWarnings("serial")
	public static class OperacionNoValida extends RuntimeException {
	}
	
	public Contribuyente altaContribuyente(Contribuyente c) {
		if(c.getDni() != null) {
			return null;
		}
		
		return contribuyentes.creaContribuyente(c);
	}

	
	public Contribuyente bajaContribuyente(String dni) throws OperacionNoValida {
		if(contribuyentes.contribuyente(dni) == null) {
			return null;
		}
		if(contribuyentes.contribuyente(dni).getVehiculos().isEmpty()) {
			throw new OperacionNoValida();
		}
		return contribuyentes.eliminaContribuyente(dni);		
	 }
	
	public Contribuyente contribuyente(String dni) {
		
		return contribuyentes.contribuyente(dni);
	}

	public Vehiculo altaVehiculo(Vehiculo v, String dni) throws OperacionNoValida {
		if(contribuyentes.contribuyente(dni) == null) {
			return null;
		}
		if(vehiculos.vehiculo(v.getMatricula()) != null) {
			throw new OperacionNoValida();
		}
		contribuyentes.contribuyente(dni).getVehiculos().add(v);
		return v;
	}

	public Vehiculo bajaVehiculo(String matricula, String dni) throws OperacionNoValida {
		if(contribuyentes.contribuyente(dni) == null || vehiculos.vehiculo(matricula) == null) {
			return null;
		}
		
		if(contribuyentes.contribuyente(dni).getVehiculos().contains(vehiculos.vehiculo(matricula))) {
			throw new OperacionNoValida();
		}
		Vehiculo v = vehiculos.vehiculo(matricula);
		vehiculos.eliminaVehiculo(matricula);
		
		return v;
		
	}

	public Vehiculo vehiculo(String matricula) {
		
		return vehiculos.vehiculo(matricula);
	}	
}

