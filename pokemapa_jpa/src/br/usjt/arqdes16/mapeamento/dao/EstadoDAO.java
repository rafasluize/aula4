package br.usjt.arqdes16.mapeamento.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.usjt.arqdes16.mapeamento.model.Cidade;
import br.usjt.arqdes16.mapeamento.model.Estado;

public class EstadoDAO {
	EntityManager manager;

	public EstadoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void criar(Estado estado) {
		manager.persist(estado);
	}

	public void atualizar(Estado estado) {
		manager.merge(estado);
	}

	public void remover(Estado estado) {
		manager.remove(estado);
	}

	public Estado selecionar(String id) {
		return manager.find(Estado.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Estado> selecionarTodas() {
		return manager.createQuery("select uf from Estado uf").getResultList();
	}
}