package br.com.caelum.financas.teste;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaSalvaMovimentacaoComConta {
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(manager);
		manager.getTransaction().begin();
		
		Conta conta = new Conta();
		conta.setBanco("Banco Santander");
		conta.setNumero("99999-9");
		conta.setAgencia("999");
		conta.setTitular("Maria");
		
		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setConta(conta);
//		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("conta de luz - abril/2010");
		movimentacao.setValor(new BigDecimal("100"));
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		
		movimentacaoDAO.adiciona(movimentacao);
		
		manager.getTransaction().commit();
		manager.close();
		
	}
}
