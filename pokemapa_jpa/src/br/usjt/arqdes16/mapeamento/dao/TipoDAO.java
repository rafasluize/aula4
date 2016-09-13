package br.usjt.arqdes16.mapeamento.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.usjt.arqdes16.mapeamento.model.Tipo;

public class TipoDAO {
	EntityManager manager;

	public TipoDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void criar(Tipo tipo) {
		manager.persist(tipo);
	}

	public void atualizar(Tipo tipo) {
		manager.merge(tipo);
	}

	public void remover(Tipo tipo) {
		manager.remove(tipo);
	}

	public Tipo selecionar(int id) {
		return manager.find(Tipo.class, id);
	}

	public List<?> selecionarTodas() {
		return manager.createQuery("select t from Tipo t").getResultList();
	}
}