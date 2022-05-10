package es.unican.is2.GestionTienda2;


public class vendedorEnPracticas extends Vendedor {
	
	/**
	 * Retorna un nuevo vendedor en prácticas
	 * @param nombre
	 * @param dni
	 */
	public vendedorEnPracticas(String nombre, String id, String dni) {//WMC+1
		super(nombre, id,dni);
		
	}
	
	@Override
	public boolean equals(Object obj) {//WMC+1
		if (!(obj instanceof vendedorEnPracticas)) //WMC+1 //CCOg+1
			return false;
		Vendedor v = (Vendedor) obj;
		return (v.getId().equals(getId()) && v.getDni().equals(getDni()));
	}
}
