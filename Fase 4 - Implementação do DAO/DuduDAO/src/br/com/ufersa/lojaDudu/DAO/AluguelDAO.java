package br.com.ufersa.lojaDudu.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ufersa.lojaDudu.model.entity.Aluguel;



public class AluguelDAO extends BaseDaoImpl<Aluguel>{

	
	public Long inserir(Aluguel alu) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_alugueis (cpf_cliente,codigo_objeto,data_aquisicao,data_devolucao) "
				+ "values (?,?,?,?)";
				
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, alu.getCpfCliente());
			ps.setLong(2, alu.getCodigoObjeto());
			ps.setString(3, alu.getDataAquisicao());
			ps.setString(4, alu.getDataDevolucao());
			ps.execute();
			ps.close();
			
			sql = "SELECT * FROM tb_alugueis as a WHERE a.codigo_objeto=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, alu.getCodigoObjeto());
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
	public void deletar(Aluguel alu) {
		Connection con = getConnection();
        String sql = "DELETE FROM tb_alugueis WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, alu.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
		
	}

	@Override
	public void alterar(Aluguel alu) {
		Connection con = getConnection();
        String sql = "UPDATE tb_alugueis SET cpf_cliente = ?, codigo_objeto = ?, data_aquisicao = ?, data_devolucao = ? WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, alu.getCpfCliente());
            ps.setLong(2, alu.getCodigoObjeto());
            ps.setString(3, alu.getDataAquisicao());
            ps.setString(4, alu.getDataDevolucao());
            ps.setLong(5, alu.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
		
	}

	@Override
	public Aluguel buscar(Aluguel alu) {
		Connection con = getConnection();
        String sql = "SELECT * FROM tb_alugueis WHERE id = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, alu.getId());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Aluguel aluguelEncontrado = new Aluguel();
                aluguelEncontrado.setId(rs.getLong("id"));
                aluguelEncontrado.setCpfCliente(rs.getString("cpf_cliente"));
                aluguelEncontrado.setCodigoObjeto(rs.getLong("codigo_objeto"));
                aluguelEncontrado.setDataAquisicao(rs.getString("data_aquisicao"));
                aluguelEncontrado.setDataDevolucao(rs.getString("data_devolucao"));
                return aluguelEncontrado;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
	}

	@Override
	public List<Aluguel> listar() {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_alugueis";
		List<Aluguel> alugueis = new ArrayList<Aluguel>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Aluguel alu = new Aluguel();
				
				try {
					alu.setCpfCliente(rs.getString("cpf_cliente"));
					alu.setCodigoObjeto(rs.getLong("codigo_objeto"));
					alu.setDataAquisicao(rs.getString("data_aquisicao"));
					alu.setDataDevolucao(rs.getString("data_devolucao"));
					alu.setId(rs.getLong("id"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				alugueis.add(alu);				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {closeConnection();}
		return alugueis;
	}

}
