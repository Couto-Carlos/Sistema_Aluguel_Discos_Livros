package br.com.ufersa.lojaDudu.model.bo;

import br.com.ufersa.lojaDudu.DAO.BaseDao;
import br.com.ufersa.lojaDudu.DAO.AluguelDAO;
import br.com.ufersa.lojaDudu.Exceptions.SemRuaException;
import br.com.ufersa.lojaDudu.model.entity.Aluguel;


public class AluguelBO {
	public void criar(Aluguel alu) {
	
		BaseDao aluDao = new AluguelDAO();

		aluDao.inserir(alu);
		
		
	}
}
