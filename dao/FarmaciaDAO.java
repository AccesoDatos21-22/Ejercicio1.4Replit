package dao;

import modelo.Farmacia;
import java.nio.file.Path;

public interface FarmaciaDAO {
	
	/**
	 * Lee los medicamentos de la farmacia de un fichero
	 * @return devuelve si se ha leido correctamente
	 */
	public Farmacia leer(Path farmaciaXML);

	
	/**
	 * Guarda los medicamentos de la farmacia en un fichero  
	 * @param farmacia
	 * @return devuelve si se ha guardado correctamente
	 */
	public boolean guardar(Farmacia farmacia);

}
