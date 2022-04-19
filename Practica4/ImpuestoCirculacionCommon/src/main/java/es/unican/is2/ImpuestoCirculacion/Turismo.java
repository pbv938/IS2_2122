package es.unican.is2.ImpuestoCirculacion;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

@SuppressWarnings("serial")
public class Turismo
    extends Vehiculo implements Serializable
{

	private double potencia;
	
	
	public Turismo(String matricula, LocalDate fechaMatriculacion, double potencia) {
		super(matricula,fechaMatriculacion);
		this.potencia = potencia;
		
	}


	/**
	 * Retorna la potencia del turismo
	 * @return potencia en caballos fiscales
	 */
    public double getPotencia() {
        return potencia;
    }
       
    
    /**
     * Retorna el precio del impuesto a pagar
     *  @return precio
     */
	@Override
    public double precioImpuesto() {
		double precio = 0;
    	if(potencia > 0 && potencia < 8 ) {
    		precio = 25.24;
    	}
    	else if(potencia >= 8 && potencia <= 11.99) {
    		precio = 68.16;
    	}
    	else if(potencia >= 12 && potencia <= 15.99 ) {
    		precio =143.88;
    	}
    	else if(potencia >= 16 && potencia <= 19.99) {
    		precio = 179.22;
    	}
    	else if(potencia >= 20) {
    		precio = 224;
    	}
    	
    	if(getFechaMatriculacion().isBefore(LocalDate.now().minusYears(25))) {
    		precio = 0;
    	}
    	
    	return precio;
    }
    
}
