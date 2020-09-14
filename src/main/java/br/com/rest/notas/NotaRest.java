package br.com.rest.notas;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import br.com.rest.model.Nota;

public class NotaRest {

	
	public List<Nota> listar() {
		Client client = Client.create();
		WebResource webResource = client.resource("http://www.deveup.com.br/notas/api/");
		
		return webResource.path("notes").get(new GenericType<List<Nota>>() {});
	}
	
	public static void main(String[] args) {
		NotaRest n = new NotaRest();
		List<Nota> notas = n.listar();
		
		for (Nota nota : notas) {
			System.out.println(nota.getTitle());
		}
	}
	
	
	
	
	
	
}





















