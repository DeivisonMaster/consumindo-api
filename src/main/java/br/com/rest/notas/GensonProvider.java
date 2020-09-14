package br.com.rest.notas;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;

/**
 * @description Classe Genson auxiliar utilizado pelo Jersey que pula valores nulos 
 * 
 * */
@Provider
public class GensonProvider implements ContextResolver<Genson>{
	private Genson genson = new GensonBuilder().setSkipNull(true).create(); // evita criação de objetos nulos no json

	@Override
	public Genson getContext(Class<?> type) {
		return genson;
	}

}
