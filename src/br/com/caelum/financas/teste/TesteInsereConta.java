package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInsereConta {

	public static void main(String[] args) {

		JPAUtil util = new JPAUtil();
		EntityManager manager = util.getEntityManager();

		ContaDAO contaDAO = new ContaDAO(manager);
		Conta conta = new Conta();
		conta.setTitular("José Roberto2");
		conta.setBanco("Bradesco");
		conta.setNumero("678901-2");
		conta.setAgencia("0666");

		manager.getTransaction().begin();
		contaDAO.adiciona(conta);
		manager.getTransaction().commit();

		manager.close();
		util.close();

	}
}
