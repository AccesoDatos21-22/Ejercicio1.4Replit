package dao;

import java.nio.file.Path;


import modelo.JCCPokemon;

public interface JCCPokemonDAO {
	
	public JCCPokemon leer();
  
  public JCCPokemon leer(Path ficheroPokemon);
	
	public boolean guardar(JCCPokemon pokemones);

}