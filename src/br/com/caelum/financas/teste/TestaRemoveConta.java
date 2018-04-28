package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

/**
 * @author jpa7520
 *
 */
public class TestaRemoveConta {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		manager.getTransaction().begin();
		
		ContaDAO contaDAO = new ContaDAO(manager);
		Conta conta = contaDAO.busca(1);
		contaDAO.remove(conta);
		
		manager.getTransaction().commit();
		manager.close();
		System.out.println("Conta removida com sucesso!");
		
	}

}
