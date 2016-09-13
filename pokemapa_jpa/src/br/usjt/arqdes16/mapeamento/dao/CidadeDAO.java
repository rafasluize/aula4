package br.usjt.arqdes16.mapeamento.dao;

import java.util.List;
import javax.persistence.EntityManager;
import br.usjt.arqdes16.mapeamento.model.Cidade;

public class CidadeDAO {
	EntityManager manager;

	public CidadeDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void criar(Cidade cidade) {
		manager.persist(cidade);
	}

	public void atualizar(Cidade cidade) {
		manager.merge(cidade);
	}

	public void remover(Cidade cidade) {
		manager.remove(cidade);
	}

	public Cidade selecionar(int id) {
		return manager.find(Cidade.class, id);
	}
	@SuppressWarnings("unchecked")
	public List<Cidade> selecionarTodas() {
		return manager.createQuery("select * from cidade").getResultList();
	}
}