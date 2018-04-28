package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInsereMovimentacao {
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();

		Movimentacao movimentacao = new Movimentacao();
		movimentacao.setData(LocalDateTime.now());
		movimentacao.setDescricao("Movimentacao_1");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.ENTRADA);
		movimentacao.setValor(BigDecimal.TEN);
		
		MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(manager);

		manager.getTransaction().begin();
		movimentacaoDAO.adiciona(movimentacao);
		
		manager.getTransaction().commit();
		
	}
}
