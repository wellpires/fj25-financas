package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteCacheSegundoNivel {
	
	public static void main(String[] args) {
		
		EntityManager primeiraEM = new JPAUtil().getEntityManager();

		primeiraEM.getTransaction().begin();
		Conta primeiraConta = primeiraEM.find(Conta.class, 3);
		primeiraEM.getTransaction().commit();
		primeiraEM.close();
		
		EntityManager segundaEM = new JPAUtil().getEntityManager();
		Conta segundaConta = segundaEM.find(Conta.class, 9);
		segundaEM.close();

		System.out.println("Titular da primeira conta: " + primeiraConta.getTitular());
		System.out.println("Titular da segunda conta: " + segundaConta.getTitular());
		
		
	}
	
}
