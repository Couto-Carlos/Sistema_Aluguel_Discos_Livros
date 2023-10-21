package br.com.ufersa.lojaDudu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufersa.lojaDudu.model.entity.Disco;



public class DiscoDAO extends BaseDaoImpl<Disco>{

	
	public Long inserir(Disco dis) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_discos (titulo,nome_banda,estilo) "
				+ "values (?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dis.getTitulo());
			ps.setString(2, dis.getNomeBanda());
			ps.setString(3, dis.getEstilo());
			ps.execute();
			ps.close();
			
			sql = "SELECT * FROM tb_discos as e WHERE e.titulo=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dis.getTitulo());
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
	public void deletar(Disco dis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Disco dis) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Disco buscar(Disco dis) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Disco> listar() {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_discos";
		List<Disco> Discos = new ArrayList<Disco>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Disco dis = new Disco();
				
				try {
					dis.setTitulo(rs.getString("titulo"));
					dis.setNomeBanda(rs.getString("nome_banda"));
					dis.setEstilo(rs.getString("estilo"));
					dis.setId(rs.getLong("id"));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Discos.add(dis);				
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {closeConnection();}
		return Discos;
	}

}
