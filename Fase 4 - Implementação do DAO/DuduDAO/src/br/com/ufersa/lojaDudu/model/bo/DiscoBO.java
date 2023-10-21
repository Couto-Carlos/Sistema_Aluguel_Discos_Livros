package br.com.ufersa.lojaDudu.model.bo;

import br.com.ufersa.lojaDudu.DAO.BaseDao;
import br.com.ufersa.lojaDudu.DAO.DiscoDAO;
import br.com.ufersa.lojaDudu.Exceptions.SemRuaException;
import br.com.ufersa.lojaDudu.model.entity.Disco;


public class DiscoBO {
	public void criar(Disco dis) {
	
		BaseDao disDao = new DiscoDAO();

		disDao.inserir(dis);
		
		
	}
}
