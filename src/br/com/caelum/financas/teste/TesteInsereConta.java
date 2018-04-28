package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInsereConta {

	public static void main(String[] args) {

		JPAUtil util = new JPAUtil();
		EntityManager manager = util.getEntityManager();

		Conta conta = new Conta();
		conta.setTitular("José Roberto");
		conta.setBanco("Banco do Brasil");
		conta.setNumero("123456-6");
		conta.setAgencia("0999");

		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();

		manager.close();
		util.close();

	}
}
