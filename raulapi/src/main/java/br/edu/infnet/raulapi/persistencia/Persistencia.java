package br.edu.infnet.raulapi.persistencia;
import java.io.IOException;

public interface Persistencia {
	 void salvar() throws IOException;
	 void carregar() throws IOException;
	}