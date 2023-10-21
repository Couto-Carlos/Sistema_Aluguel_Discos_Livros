package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Funcionario;

public class FuncionarioDAO extends BaseDaoImpl<Funcionario> {

	public Long inserir(Funcionario fun) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_Funcionarios (login, senha, funcao) "
				+ "values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fun.getLogin());
			ps.setString(2, fun.getSenha());
			ps.setString(3, fun.getFuncao());
			ps.execute();
			ps.close();

			sql = "SELECT MAX(codigo_Funcionario) AS max_codigo FROM tb_Funcionarios";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return rs.getLong("max_codigo");
			else
				return null;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConnection();
		}

	}

	@Override
	public void deletar(Funcionario fun) {
		Connection con = getConnection();
		String sql = "DELETE FROM tb_Funcionarios WHERE codigo_Funcionario = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, fun.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	@Override
	public void alterar(Funcionario fun) {
		Connection con = getConnection();
		String sql = "UPDATE tb_Funcionarios SET login = ?, senha = ?, funcao = ? WHERE codigo_Funcionario = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fun.getLogin());
			ps.setString(2, fun.getSenha());
			ps.setString(3, fun.getFuncao());
			ps.setLong(4, fun.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	@Override
	public Funcionario buscar(Funcionario fun) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_Funcionarios WHERE codigo_funcionario = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fun.getLogin());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Funcionario FuncionarioEncontrado = new Funcionario();
				FuncionarioEncontrado.setId(rs.getLong("codigo_Funcionario"));
				FuncionarioEncontrado.setLogin(rs.getString("login"));
				FuncionarioEncontrado.setSenha(rs.getString("senha"));
				FuncionarioEncontrado.setFuncao(rs.getString("funcao"));
				return FuncionarioEncontrado;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	@Override
	public List<Funcionario> listar() {
		Connection con = getConnection();
		String tb_Funcionario = "SELECT * FROM tb_Funcionarios";
		List<Funcionario> Funcionarios = new ArrayList<Funcionario>();
		try {
			PreparedStatement ps = con.prepareStatement(tb_Funcionario);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Funcionario fun = new Funcionario();

				try {
					fun.setLogin(rs.getString("login"));
					fun.setSenha(rs.getString("senha"));
					fun.setFuncao(rs.getString("funcao"));
					fun.setId(rs.getLong("codigo_Funcionario"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				Funcionarios.add(fun);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return Funcionarios;
	}

	public List<Funcionario> pesquisaTotal(Funcionario funcionario) {
		Connection con = getConnection();
		String tb_Funcionario = "SELECT * FROM tb_Funcionarios WHERE login = ? or funcao = ? ";
		List<Funcionario> Funcionarios = new ArrayList<Funcionario>();
		try {
			PreparedStatement ps = con.prepareStatement(tb_Funcionario);
			ps.setString(1, funcionario.getLogin());
			ps.setString(2, funcionario.getLogin());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Funcionario fun = new Funcionario();

				try {
					fun.setLogin(rs.getString("login"));
					fun.setSenha(rs.getString("senha"));
					fun.setFuncao(rs.getString("funcao"));
					fun.setId(rs.getLong("codigo_Funcionario"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				Funcionarios.add(fun);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return Funcionarios;
	}

	public Funcionario autenticar(Funcionario fun) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_Funcionarios WHERE login = ? and senha = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fun.getLogin());
			ps.setString(2, fun.getSenha());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Funcionario FuncionarioEncontrado = new Funcionario();
				FuncionarioEncontrado.setId(rs.getLong("codigo_Funcionario"));
				FuncionarioEncontrado.setLogin(rs.getString("login"));
				FuncionarioEncontrado.setSenha(rs.getString("senha"));
				FuncionarioEncontrado.setFuncao(rs.getString("funcao"));
				return FuncionarioEncontrado;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	public Funcionario VerificarLogin(Funcionario fun) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_Funcionarios WHERE login = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, fun.getLogin());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Funcionario FuncionarioEncontrado = new Funcionario();
				FuncionarioEncontrado.setId(rs.getLong("codigo_Funcionario"));
				FuncionarioEncontrado.setLogin(rs.getString("login"));
				FuncionarioEncontrado.setSenha(rs.getString("senha"));
				FuncionarioEncontrado.setFuncao(rs.getString("funcao"));
				return FuncionarioEncontrado;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}


}