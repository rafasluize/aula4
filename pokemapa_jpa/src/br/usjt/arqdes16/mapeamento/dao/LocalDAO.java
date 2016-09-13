package br.usjt.arqdes16.mapeamento.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.usjt.arqdes16.mapeamento.model.Local;

public class LocalDAO {
	EntityManager manager;

	public LocalDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void criar(Local local) {
		manager.persist(local);
	}

	public void atualizar(Local local) {
		manager.merge(local);
	}

	public void remover(Local local) {
		manager.remove(local);
	}

	public Local selecionar(int id) {
		return manager.find(Local.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Local> selecionarTodas() {
		return manager.createQuery("select l from Local l").getResultList();
	}
}