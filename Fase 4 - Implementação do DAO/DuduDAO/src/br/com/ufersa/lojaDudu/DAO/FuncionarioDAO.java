package br.com.ufersa.lojaDudu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufersa.lojaDudu.model.entity.Usuario;



public class UserDAO extends BaseDaoImpl<Usuario>{

	
	public Long inserir(Usuario usu) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_users (nome,email,senha,id_endereco) "
				+ "values (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, usu.getNome());
			ps.setString(2, usu.getEmail());
			ps.setString(3, usu.getSenha());
			ps.setLong(4,usu.getEndereco().getId());
			ps.execute();
			ps.close();
			
			sql = "SELECT * FROM tb_users as e WHERE e.email=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, usu.getEmail());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) return rs.getLong("id");
			else return null;
					
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		finally {closeConnection();}
		
	}

	@Override
	public void deletar(Usuario usu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Usuario usu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario buscar(Usuario usu) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> listar() {
		Connection con = getConnection();
		String patric = "SELECT * FROM tb_users";
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			PreparedStatement ps = con.prepareStatement(patric);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Usuario usu = new Usuario();
				
				try {
					usu.setNome(rs.getString("nome"));
					usu.setEmail(rs.getString("email"));
					usu.setSenha(rs.getString("senha"));
					usu.setId(rs.getLong("id"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				usuarios.add(usu);				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {closeConnection();}
		return usuarios;
	}

}
