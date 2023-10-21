package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Cliente;

public class ClienteDAO extends BaseDaoImpl<Cliente> {

	public Long inserir(Cliente cli) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_clientes (cpf, nome, endereco) "
				+ "values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cli.getCpf());
			ps.setString(2, cli.getNome());
			ps.setString(3, cli.getEndereco());
			ps.execute();
			ps.close();

			sql = "SELECT MAX(codigo_cliente) AS max_codigo FROM tb_clientes";
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
	public void deletar(Cliente cli) {
		Connection con = getConnection();
		String sql = "DELETE FROM tb_clientes WHERE codigo_cliente = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, cli.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	@Override
	public void alterar(Cliente cli) {
		Connection con = getConnection();
		String sql = "UPDATE tb_clientes SET cpf = ?, nome = ?, endereco = ? WHERE codigo_cliente = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cli.getCpf());
			ps.setString(2, cli.getNome());
			ps.setString(3, cli.getEndereco());
			ps.setLong(4, cli.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	@Override
	public Cliente buscar(Cliente cli) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_clientes WHERE codigo_cliente = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, cli.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Cliente ClienteEncontrado = new Cliente();
				ClienteEncontrado.setId(rs.getLong("codigo_cliente"));
				ClienteEncontrado.setCpf(rs.getString("cpf"));
				ClienteEncontrado.setNome(rs.getString("nome"));
				ClienteEncontrado.setEndereco(rs.getString("endereco"));
				return ClienteEncontrado;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	@Override
	public List<Cliente> listar() {
		Connection con = getConnection();
		String tb_Cliente = "SELECT * FROM tb_clientes";
		List<Cliente> Clientes = new ArrayList<Cliente>();
		try {
			PreparedStatement ps = con.prepareStatement(tb_Cliente);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cliente cli = new Cliente();

				try {
					cli.setCpf(rs.getString("cpf"));
					cli.setNome(rs.getString("nome"));
					cli.setEndereco(rs.getString("endereco"));
					cli.setId(rs.getLong("codigo_cliente"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				Clientes.add(cli);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return Clientes;
	}


	public Cliente pesquisaNome(Cliente cli) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_clientes WHERE nome = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cli.getNome());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Cliente ClienteEncontrado = new Cliente();
				ClienteEncontrado.setId(rs.getLong("codigo_cliente"));
				ClienteEncontrado.setCpf(rs.getString("cpf"));
				ClienteEncontrado.setNome(rs.getString("nome"));
				ClienteEncontrado.setEndereco(rs.getString("endereco"));
				return ClienteEncontrado;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	public Cliente verificarCPF(Cliente cli) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_clientes WHERE cpf = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cli.getCpf());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Cliente ClienteEncontrado = new Cliente();
				ClienteEncontrado.setId(rs.getLong("codigo_cliente"));
				ClienteEncontrado.setCpf(rs.getString("cpf"));
				ClienteEncontrado.setNome(rs.getString("nome"));
				ClienteEncontrado.setEndereco(rs.getString("endereco"));
				return ClienteEncontrado;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	

	public List<Cliente> pesquisaTotal(Cliente cliente) {
		Connection con = getConnection();
		String tb_Cliente = "SELECT * FROM tb_clientes WHERE cpf = ? or nome = ? or endereco = ?";
		List<Cliente> Clientes = new ArrayList<Cliente>();
		try {
			PreparedStatement ps = con.prepareStatement(tb_Cliente);
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getNome());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Cliente cli = new Cliente();

				try {
					cli.setCpf(rs.getString("cpf"));
					cli.setNome(rs.getString("nome"));
					cli.setEndereco(rs.getString("endereco"));
					cli.setId(rs.getLong("codigo_cliente"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				Clientes.add(cli);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return Clientes;
	}

}