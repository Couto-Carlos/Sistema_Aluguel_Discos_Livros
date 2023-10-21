package br.com.ufersa.lojaDudu.model.bo;

import br.com.ufersa.lojaDudu.DAO.BaseDao;
import br.com.ufersa.lojaDudu.DAO.LivroDAO;
import br.com.ufersa.lojaDudu.Exceptions.SemRuaException;
import br.com.ufersa.lojaDudu.model.entity.Livro;


public class LivroBO {
	public void criar(Livro liv) {
	
		BaseDao livDao = new LivroDAO();

		livDao.inserir(liv);
		
		
	}
}
