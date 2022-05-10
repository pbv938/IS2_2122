package es.unican.is2.GestionTienda2;


/**
 * Vendedor de la tienda. 
 * Por cada vendedor se almacenan sus datos personales 
 * y sus datos sobre ventas y comisiones
 */
public abstract class Vendedor {
	
	private static final double PagoSenior = 0.01;
	private static final double PagoJunior = 0.005;
	private String id;
	private String nombre;
	
	
	// Valor total de las ventas mensuales realizadas por el vendedor
	private double t;
	private String dni;
	
	
	public Vendedor(String nombre, String id,String dni) {//WMC+1
		this.nombre = nombre;
		this.id = id;
	}
	

	/**
	 * Retorna el nombre del vendedor
	 * @return nombre
	 */
	public String getNombre() {//WMC+1
		return nombre;
	}
	
	/**
	 * Retorna el dni del vendedor
	 * @return dni
	 */
	public String getId() {//WMC+1
		return id;
	}
	
	
	/**
	 * Retorna el total de ventas acumuladas por el vendedor
	 * @return Total de ventas
	 */
	public double getTotalVentas() {//WMC+1
		return t;
	}
	
	/**
	 * Asigna el total de ventas acumuladas por el vendedor
	 * Se utiliza para poder cargar los datos desde fichero
	 * @param Total de ventas
	 */
	public void setT(double totalVentas) {//WMC+1
		this.t = totalVentas;
	}
	
	/**
	 * Anhade una nueva venta al vendedor, actualizando su comision
	 * @param importe de la venta
	 */
	public void anhade(double importe){//WMC+1
		t += importe;
	}


	double getImporte(double importeFinal) {//WMC+1
		switch (((VendedorEnPlantilla) this).tipo()) {
		case JUNIOR://WMC+1
			importeFinal += importeFinal * PagoJunior;
			break;
		case SENIOR://WMC+1
			importeFinal += importeFinal * PagoSenior;
			break;
		}
		return importeFinal;
	}


	public String getDni() {//WMC+1
		return dni;
	}



	
}
