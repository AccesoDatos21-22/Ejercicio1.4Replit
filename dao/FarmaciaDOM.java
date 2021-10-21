package dao;

import java.nio.file.Path;
import modelo.Farmacia;

public class FarmaciaDOM implements FarmaciaDAO{

	/**
	 * Lee los medicamentos de la farmacia de un fichero xml
	 * mediante DOM
	 * @param farmacia
	 * @return
	 */
	public Farmacia leer(Path farmaciaXML) {
		return null;
		
	}
	
	/**
	 * Guarda los medicamentos de la farmacia en un fichero XML 
	 * mediamente DOM
	 * @param farmacia
	 * @return
	 */
	public boolean guardar(Farmacia farmacia) {
		return false;
		
	}

}
