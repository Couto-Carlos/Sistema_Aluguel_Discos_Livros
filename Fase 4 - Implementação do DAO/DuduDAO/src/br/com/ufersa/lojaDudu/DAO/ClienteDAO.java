package br.com.ufersa.lojaDudu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufersa.lojaDudu.model.entity.Cliente;



public class ClienteDAO extends BaseDaoImpl<Cliente>{

	
	public Long inserir(Cliente cli) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_clientes (nome,endereco,cpf) "
				+ "values (?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cli.getNome());
			ps.setString(2, cli.getEndereco());
			ps.setString(3, cli.getCpf());
			ps.execute();
			ps.close();
			
			sql = "SELECT * FROM tb_clientes as c WHERE c.cpf=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, cli.getCpf());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) return rs.getLong("id");
			else return null;
					
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally {closeConnection();}
		
	}

	@Override
	public void deletar(Cliente cli) {
		Connection con = getConnection();
        String sql = "DELETE FROM tb_clientes WHERE id = ?";

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
        String sql = "UPDATE tb_clientes SET nome = ?, endereco = ?, cpf = ? WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, cli.getNome());
            ps.setString(2, cli.getEndereco());
            ps.setString(3, cli.getCpf());
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
        String sql = "SELECT * FROM tb_clientes WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, cli.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente clienteEncontrado = new Cliente();
                clienteEncontrado.setId(rs.getLong("id"));
                clienteEncontrado.setNome(rs.getString("nome"));
                clienteEncontrado.setEndereco(rs.getString("endereco"));
                clienteEncontrado.setCpf(rs.getString("cpf"));
                return clienteEncontrado;
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
		String carlos = "SELECT * FROM tb_clientes";
		List<Cliente> clientes = new ArrayList<Cliente>();
		try {
			PreparedStatement ps = con.prepareStatement(carlos);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente cli = new Cliente();
				
				try {
					cli.setNome(rs.getString("nome"));
					cli.setEndereco(rs.getString("endereco"));
					cli.setCpf(rs.getString("cpf"));
					cli.setId(rs.getLong("id"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				clientes.add(cli);				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {closeConnection();}
		return clientes;
	}

}
