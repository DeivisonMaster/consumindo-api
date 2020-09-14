package br.com.rest.notas;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

import br.com.rest.model.Nota;

public class NotaRest {
	private Client client;
	private WebResource webResource;
	
	public NotaRest() {
		this.client = Client.create();
		this.webResource = client.resource("http://www.deveup.com.br/notas/api/");
	}
	
	public List<Nota> listar() {
		return webResource.path("notes").get(new GenericType<List<Nota>>() {});
	}
	
	
	public Nota obter(Integer id) {
		return webResource.path("notes").path(id.toString()).get(new GenericType<Nota>() {});
	}
	
	public void editar(Nota nota) {
		webResource.path("notes").path(nota.getId().toString()).put(ClientResponse.class, nota);
	}
	
	public static void main(String[] args) {
		NotaRest n = new NotaRest();
		List<Nota> notas = n.listar();
		
		for (Nota nota : notas) {
			System.out.println(nota.getTitle());
		}
		
		System.out.println("***************************************");
		
		Nota nota = n.obter(730);
		System.out.println(nota.getTitle());
		
		System.out.println("***************************************");
		Nota n1 = new Nota();
		n1.setId(730);
		n1.setTitle("teste2");
		n1.setBody("hello world 444");
		
		n.editar(nota);
		
		System.out.println("***************************************");
		
		Nota nota2 = n.obter(730);
		System.out.println(nota2.getBody());
	}
	
}

































