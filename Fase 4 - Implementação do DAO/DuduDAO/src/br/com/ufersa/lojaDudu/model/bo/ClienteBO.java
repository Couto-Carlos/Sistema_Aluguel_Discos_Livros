package br.com.ufersa.lojaDudu.model.bo;

import br.com.ufersa.lojaDudu.DAO.BaseDao;
import br.com.ufersa.lojaDudu.DAO.ClienteDAO;
import br.com.ufersa.lojaDudu.Exceptions.SemRuaException;
import br.com.ufersa.lojaDudu.model.entity.Cliente;


public class ClienteBO {
	public void criar(Cliente cli) {
	
		BaseDao cliDao = new ClienteDAO();

		cliDao.inserir(cli);
		
		
	}
}
