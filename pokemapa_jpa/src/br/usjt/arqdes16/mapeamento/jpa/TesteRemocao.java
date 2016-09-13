package br.usjt.arqdes16.mapeamento.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.usjt.arqdes16.mapeamento.dao.LocalDAO;
import br.usjt.arqdes16.mapeamento.model.Local;

public class TesteRemocao {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pokemapa");
		EntityManager manager = factory.createEntityManager();
		LocalDAO localDAO = new LocalDAO(manager);
		Local localRmv;
		manager.getTransaction().begin();
		for (int i = 10; i <= 11; i++) {
			localRmv = localDAO.selecionar(i);
			localDAO.remover(localRmv);
		}
		manager.getTransaction().commit();
		List<Local> lista = localDAO.selecionarTodas();
		for (Local local : lista) {
			System.out.println(local);
		}
		manager.close();
		factory.close();
	}
}