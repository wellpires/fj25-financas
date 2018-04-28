package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaPesquisaIDConta {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDAO contaDAO = new ContaDAO(manager);
		Conta conta = contaDAO.busca(3);
		
		manager.close();
		System.out.println(conta.toString());
		
	}

}
