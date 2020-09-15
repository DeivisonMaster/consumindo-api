package br.com.rest.notas;

import java.util.List;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;

import br.com.rest.model.Nota;

public class NotaRest {
	private Client client;
	private WebResource webResource;
	
	public NotaRest() {
		//ClientConfig config = new DefaultClientConfig(GensonProvider.class);
		
		this.client = Client.create();
		client.addFilter(new LoggingFilter(System.out));
		this.webResource = client.resource("http://www.deveup.com.br/notas/api/");
	}
	
	public List<Nota> listar() {
		return webResource.path("notes").get(new GenericType<List<Nota>>() {});
	}
	
	public void inserir(Nota nota) {
		this.webResource.path("notes").post(new GenericType<Nota>() {}, nota);
	}
	
	public Nota obter(Integer id) {
		return webResource.path("notes").path(id.toString()).get(new GenericType<Nota>() {});
	}
	
	public void editar(Nota nota) {
		webResource.path("notes").path(nota.getId().toString()).put(ClientResponse.class, nota);
	}
	
	public void excluir(Integer id){
		webResource.path("notes").path(id.toString()).delete();
	}
	
	public static void main(String[] args) {
		NotaRest n = new NotaRest();
//		List<Nota> notas = n.listar();
//		
//		for (Nota nota : notas) {
//			System.out.println(nota.getTitle());
//		}
//		
//		System.out.println("***************************************");
		
//		Nota nota = n.obter(732);
//		System.out.println(nota.getTitle());
		
//		System.out.println("***************************************");
		Nota n1 = new Nota();
		n1.setId(743);
		n1.setTitle("teste 222");
		n1.setBody("hello world 444");
		
		n.editar(n1);
//		
//		System.out.println("***************************************");
//		
//		Nota nota2 = n.obter(730);
//		System.out.println(nota2.getBody());
//		
//		System.out.println("***************************************");
//		
//		Nota n2 = new Nota();
//		n2.setTitle("novo titulo");
//		n2.setBody("nova nota");
//		
//		n.inserir(n2);
		
//		n.excluir(743);
		
	}
	
}

































