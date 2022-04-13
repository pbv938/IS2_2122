package es.unican.is2.ImpuestoCirculacion;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

@SuppressWarnings("serial")
public class Motocicleta extends Vehiculo
{
	private int cilindrada;

    public Motocicleta(String matricula, LocalDate fechaMatriculacion, int cilindrada) {
    	super(matricula,fechaMatriculacion);
		this.cilindrada = cilindrada;
	}


	/**
     * Retorna la cilindrada de la motocicleta
     * @return cilindrada
     */
    public int getCilindrada() {
        return cilindrada;
    }
    
  
	@Override
    public double precioImpuesto() {
		double precio = 0;
    	if(cilindrada <= 125 ) {
    		precio = 8.84;
    	}
    	else if(cilindrada > 125 && cilindrada <= 250) {
    		precio = 15.14;
    	}
    	else if(cilindrada > 250 && cilindrada <= 500 ) {
    		precio = 30.30;
    	}
    	else if(cilindrada > 500 && cilindrada <= 1000) {
    		precio = 60.58;
    	}
    	else if(cilindrada > 1000) {
    		precio = 121.16;
    	}
    	
    	
    	if(getFechaMatriculacion().isBefore(LocalDate.now().minusYears(25))) {
    		precio = 0;
    	}
		return precio;
    }
}
