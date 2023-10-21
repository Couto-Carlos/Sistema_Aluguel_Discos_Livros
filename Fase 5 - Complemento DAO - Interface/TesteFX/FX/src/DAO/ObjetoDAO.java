package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Objeto;

public class ObjetoDAO extends BaseDaoImpl<Objeto> {

	public Long inserir(Objeto obj) {
		Connection con = getConnection();
		String sql = "INSERT INTO Objetos (quantidade_exemplares,valor_aluguel) "
				+ "values (?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, obj.getQuantidadeExemplares());
			ps.setFloat(2, obj.getValorAluguel());
			ps.execute();
			ps.close();

			sql = "SELECT MAX(codigo_objeto) AS max_codigo FROM objetos";
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
			// closeConnection();
		}

	}

	@Override
	public void deletar(Objeto obj) {
		Connection con = getConnection();
		String sql = "DELETE FROM Objetos WHERE codigo_objeto = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, obj.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// closeConnection();
		}

	}

	@Override
	public void alterar(Objeto obj) {
		Connection con = getConnection();
		String sql = "UPDATE Objetos SET quantidade_exemplares = ?, valor_aluguel = ? WHERE codigo_objeto = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, obj.getQuantidadeExemplares());
			ps.setFloat(2, obj.getValorAluguel());
			ps.setLong(3, obj.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// closeConnection();
		}

	}

	@Override
	public Objeto buscar(Objeto obj) {
		Connection con = getConnection();
		String sql = "SELECT * FROM Objetos WHERE codigo_objeto = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, obj.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Objeto ObjetoEncontrado = new Objeto();
				ObjetoEncontrado.setId(rs.getLong("codigo_objeto"));
				ObjetoEncontrado.setQuantidadeExemplares(rs.getInt("quantidade_exemplares"));
				ObjetoEncontrado.setValorAluguel(rs.getFloat("valor_aluguel"));
				return ObjetoEncontrado;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// closeConnection();
		}
		return null;
	}

	@Override
	public List<Objeto> listar() {
		Connection con = getConnection();
		String tb_objeto = "SELECT * FROM Objetos";
		List<Objeto> Objetos = new ArrayList<Objeto>();
		try {
			PreparedStatement ps = con.prepareStatement(tb_objeto);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Objeto obj = new Objeto();

				try {
					obj.setQuantidadeExemplares(rs.getInt("quantidade_exemplares"));
					obj.setValorAluguel(rs.getFloat("valor_aluguel"));
					obj.setId(rs.getLong("codigo_objeto"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				Objetos.add(obj);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// closeConnection();
		}
		return Objetos;
	}

	

}