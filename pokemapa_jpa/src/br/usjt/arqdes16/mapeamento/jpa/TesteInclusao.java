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

public class TesteInclusao {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("pokemapa");
		EntityManager manager = factory.createEntityManager();
		CidadeDAO cidadeDAO = new CidadeDAO(manager);
		LocalDAO localDAO = new LocalDAO(manager);
		TipoDAO tipoDAO = new TipoDAO(manager);
		Tipo tipoErrado = tipoDAO.selecionar(5);
		Cidade cidadeRio = cidadeDAO.selecionar(2);
		Cidade cidadeBSB = cidadeDAO.selecionar(3);
		Local localBSB = new Local();
		localBSB.setNome("Sir Fer MacRugem");
		localBSB.setLatitude(-15.790476);
		localBSB.setLongitude(-47.904464);
		localBSB.setTipo(tipoErrado);
		localBSB.setCidade(cidadeRio);
		Local localRJ = new Local();
		localRJ.setNome("Nome Errado");
		localRJ.setLatitude(-23.552166);
		localRJ.setLongitude(-46.597626);
		localRJ.setTipo(tipoErrado);
		localRJ.setCidade(cidadeBSB);
		manager.getTransaction().begin();
		localDAO.criar(localRJ);
		localDAO.criar(localBSB);
		manager.getTransaction().commit();
		List<Local> lista = localDAO.selecionarTodas();
		for (Local local : lista) {
			System.out.println(local);
		}
		manager.close();
		factory.close();
	}
}
