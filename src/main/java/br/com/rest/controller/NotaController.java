package br.com.rest.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import br.com.rest.model.Nota;
import br.com.rest.notas.NotaRest;

@Named
@ViewScoped
public class NotaController implements Serializable{
	private static final long serialVersionUID = 1L;
	private NotaRest notaRest;
	private List<Nota> notas;
	private Integer id;
	private Nota nota;
	
	@PostConstruct
	public void init() {
		this.notaRest = new NotaRest();
		
		this.listar();
	}
	
	public void listar() {
		this.notas = notaRest.listar();
	}
	
	public void obterDetalhes() {
		if(this.id != null) {
			this.nota = this.notaRest.obter(this.id);
		}else {
			this.nota = new Nota();
		}
	}
	
	public String obterDetalhes(Nota nota) {
		this.nota = nota;
		return "DetalhesNota";
	}
	
	public String editar() {
		if(this.id != null) {
			this.notaRest.editar(this.nota);
		}else {
			this.notaRest.inserir(this.nota);
		}
		
		this.listar();
		
		return "ListagemNotas";
	}
	
	public List<Nota> getNotas() {
		return notas;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Nota getNota() {
		return nota;
	}
}
