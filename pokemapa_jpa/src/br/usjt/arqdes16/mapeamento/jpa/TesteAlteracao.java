package br.usjt.arqdes16.mapeamento.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import br.usjt.arqdes16.mapeamento.dao.CidadeDAO;
import br.usjt.arqdes16.mapeamento.dao.LocalDAO;
import br.usjt.arqdes16.mapeamento.dao.TipoDAO;
import br.usjt.arqdes16.mapeamento.model.Cidade;
import br.usjt.arqdes16.mapeamento.model.Local;

import br.usjt.arqdes16.mapeamento.model.Tipo;

public class TesteAlteracao {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pokemapa");
		EntityManager manager = factory.createEntityManager();
		CidadeDAO cidadeDAO = new CidadeDAO(manager);
		LocalDAO localDAO = new LocalDAO(manager);
		TipoDAO tipoDAO = new TipoDAO(manager);
		Tipo tipoCerto = tipoDAO.selecionar(6);
		Cidade cidadeRio = cidadeDAO.selecionar(2);
		Cidade cidadeBSB = cidadeDAO.selecionar(3);
		Local localBSB = localDAO.selecionar(11);
		localBSB.setLatitude(-15.790476);
		localBSB.setLongitude(-47.904464);
		localBSB.setTipo(tipoCerto);
		localBSB.setCidade(cidadeBSB);
		Local localRJ = localDAO.selecionar(10);
		localRJ.setNome("Rato Ferrado");
		localRJ.setLatitude(-22.889086);
		localRJ.setLongitude(-43.248747);
		localRJ.setTipo(tipoCerto);
		localRJ.setCidade(cidadeRio);
		manager.getTransaction().begin();
		localDAO.atualizar(localRJ);
		localDAO.atualizar(localBSB);
		manager.getTransaction().commit();
		List<Local> lista = localDAO.selecionarTodas();
		for (Local local : lista) {
			System.out.println(local);
		}
		manager.close();
		factory.close();
	}
}