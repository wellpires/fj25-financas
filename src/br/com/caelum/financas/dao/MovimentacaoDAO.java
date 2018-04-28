package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDAO {
	
	private EntityManager manager;
	
	public MovimentacaoDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public void adiciona(Movimentacao movimentacao){
		manager.persist(movimentacao);
	}
	
}
