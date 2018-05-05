package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaBuscaContaDaMovimentacao {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(manager);
		
		manager.getTransaction().begin();
		
		Movimentacao movimentacao = movimentacaoDAO.busca(1);
		System.out.println(movimentacao.getConta().getTitular());
		
		manager.getTransaction().commit();
		manager.close();

	}

}
