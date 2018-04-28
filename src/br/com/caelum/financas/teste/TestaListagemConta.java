package br.com.caelum.financas.teste;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaListagemConta {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		ContaDAO contaDAO = new ContaDAO(manager);
		List<Conta> contas = contaDAO.lista();
		
		contas.stream().filter(Objects::nonNull).forEach(conta -> {
			System.out.println(conta.toString());
		});
		
		manager.close();
	}
}
