package model.bo;

import java.util.List;

import DAO.BaseDao;
import DAO.FuncionarioDAO;
import model.entity.Disco;
import model.entity.Funcionario;

public class FuncionarioBO {
	private FuncionarioDAO conexaoFuncionario = new FuncionarioDAO();

	public FuncionarioBO() {
		try {
			conexaoFuncionario.getConnection();
		} catch (Exception e) {
			System.out.println("Falha na conexão");
		}
	}

	public void alterar(Funcionario fun) {
			System.out.println(fun.getId());
			conexaoFuncionario.alterar(fun);
	}

	public void criar(Funcionario fun) {

		Funcionario autenticarFuncionario = conexaoFuncionario.VerificarLogin(fun);
		if (autenticarFuncionario == null) {
			conexaoFuncionario.inserir(fun);
		} else {
			fun.setId(autenticarFuncionario.getId());
			conexaoFuncionario.alterar(fun);
			// System.out.println("POP-UP , Login já existente");

		}
	}

	public void deletar(Funcionario fun) {

		Funcionario autenticarFuncionario = conexaoFuncionario.VerificarLogin(fun);
		if (autenticarFuncionario == null) {
			System.out.println("POP-UP , Login não existente");
		} else {
			conexaoFuncionario.deletar(fun);
		}
	}

	public Funcionario buscar(Funcionario fun) {

		Funcionario funcionarioPorID = conexaoFuncionario.buscar(fun);
		if (funcionarioPorID == null) {
			Funcionario funcionarioPorAutenticacao = conexaoFuncionario.autenticar(fun);
			if (funcionarioPorAutenticacao == null) {
				Funcionario funcionarioPorLogin = conexaoFuncionario.VerificarLogin(fun);
				if (funcionarioPorLogin == null) {
					System.out.println("POP UP - Funcionario Inexistente ");
					return null;
				} else
					return funcionarioPorLogin;
			} else
				return funcionarioPorAutenticacao;

		} else
			return funcionarioPorID;

	}

	public List<Funcionario> listar() {
		List<Funcionario> funcionarios = conexaoFuncionario.listar();
		return funcionarios;
	}

	public List<Funcionario> pesquisaTotal(Funcionario funcionario) {
		if (funcionario != null) {
			return conexaoFuncionario.pesquisaTotal(funcionario);
		} else {
			return conexaoFuncionario.listar();
		}

	}

	public Funcionario VerificarLogin(Funcionario funcionario){
		return conexaoFuncionario.VerificarLogin(funcionario);
	}

	public Funcionario login(Funcionario login) {

		Funcionario autenticarFuncionario = conexaoFuncionario.autenticar(login);
		if (autenticarFuncionario == null) {
			System.out.println("POP-UP, Login não existente");
			return null;
		} else {
			return autenticarFuncionario;
		}

	}

}
