package br.usjt.arqdes16.mapeamento.dao;

import java.util.List;
import javax.persistence.EntityManager;

import br.usjt.arqdes16.mapeamento.model.Usuario;

public class UsuarioDAO {
	EntityManager manager;

	public UsuarioDAO(EntityManager manager) {
		this.manager = manager;
	}

	public void criar(Usuario usuario) {
		manager.persist(usuario);
	}

	public void atualizar(Usuario usuario) {
		manager.merge(usuario);
	}

	public void remover(Usuario usuario) {
		manager.remove(usuario);
	}

	public Usuario selecionar(int id) {
		return manager.find(Usuario.class, id);
	}

	public List<?> selecionarTodas() {
		return manager.createQuery("select u from Usuario u").getResultList();
	}
}