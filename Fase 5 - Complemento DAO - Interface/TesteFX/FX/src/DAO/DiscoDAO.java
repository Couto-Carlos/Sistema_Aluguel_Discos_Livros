package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Disco;
import model.entity.Objeto;

public class DiscoDAO extends BaseDaoImpl<Disco> {

	public Long inserir(Disco dis) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_Discos (titulo,codigo_objeto,nome_banda,estilo)"
				+ "values (?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dis.getTitulo());

			Objeto novo_objeto = new Objeto(dis.getQuantidadeExemplares(), dis.getValorAluguel());
			Long id_objeto = CriarObjeto(novo_objeto);
			ps.setLong(2, id_objeto);

			ps.setString(3, dis.getNomeBanda());
			ps.setString(4, dis.getEstilo());
			ps.execute();
			ps.close();

			return id_objeto;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			closeConnection();
		}

	}

	@Override
	public void deletar(Disco dis) {
		Connection con = getConnection();
		String sql = "DELETE FROM tb_discos WHERE codigo_objeto = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, dis.getId());
			ps.executeUpdate();

			Objeto objeto = new Objeto(dis.getId(), 0, 0);
			DeleterObjeto(objeto);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	@Override
	public void alterar(Disco dis) {
		Connection con = getConnection();
		String sql = "UPDATE tb_Discos SET titulo = ?, nome_banda = ? ," +
				"estilo = ? WHERE codigo_objeto = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dis.getTitulo());

			Objeto novo_objeto = new Objeto(dis.getId(), dis.getQuantidadeExemplares(), dis.getValorAluguel());
			AlterarObjeto(novo_objeto);

			ps.setString(2, dis.getNomeBanda());
			ps.setString(3, dis.getEstilo());
			ps.setLong(4, dis.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	@Override
	public Disco buscar(Disco dis) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_Discos WHERE codigo_objeto = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, dis.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				Disco Disco = new Disco();
				Disco.setId(rs.getLong("codigo_objeto"));

				Objeto objeto = new Objeto(rs.getLong("codigo_objeto"), 0, 0);
				Objeto novo_objeto = buscarObjeto(objeto);

				Disco.setQuantidadeExemplares(novo_objeto.getQuantidadeExemplares());
				Disco.setValorAluguel(novo_objeto.getValorAluguel());

				Disco.setTitulo(rs.getString("titulo"));
				Disco.setNomeBanda(rs.getString("nome_banda"));
				Disco.setEstilo(rs.getString("estilo"));

				return Disco;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	@Override
	public List<Disco> listar() {
		Connection con = getConnection();
		String tb_Disco = "SELECT * FROM tb_Discos";
		List<Disco> discos = new ArrayList<Disco>();
		try {
			PreparedStatement ps = con.prepareStatement(tb_Disco);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Disco dis = new Disco();
				try {
					dis.setId(rs.getLong("codigo_objeto"));

					Objeto objeto = new Objeto(rs.getLong("codigo_objeto"), 0, 0);
					Objeto novo_objeto = buscarObjeto(objeto);

					dis.setQuantidadeExemplares(novo_objeto.getQuantidadeExemplares());
					dis.setValorAluguel(novo_objeto.getValorAluguel());

					dis.setTitulo(rs.getString("titulo"));
					dis.setNomeBanda(rs.getString("nome_banda"));
					dis.setEstilo(rs.getString("estilo"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				discos.add(dis);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return discos;
	}

	public Disco pesquisaTitulo(Disco dis) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_Discos WHERE titulo = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, dis.getTitulo());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				Disco Disco = new Disco();
				Disco.setId(rs.getLong("codigo_objeto"));

				Objeto objeto = new Objeto(rs.getLong("codigo_objeto"), 0, 0);
				Objeto novo_objeto = buscarObjeto(objeto);

				Disco.setQuantidadeExemplares(novo_objeto.getQuantidadeExemplares());
				Disco.setValorAluguel(novo_objeto.getValorAluguel());

				Disco.setTitulo(rs.getString("titulo"));
				Disco.setNomeBanda(rs.getString("nome_banda"));
				Disco.setEstilo(rs.getString("estilo"));

				return Disco;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}


	public List<Disco> pesquisaTotal(Disco disco) {
		Connection con = getConnection();
		String tb_Disco = "SELECT * FROM tb_Discos WHERE nome_banda = ? or titulo = ? or estilo = ?";
		List<Disco> discos = new ArrayList<Disco>();
		try {
			PreparedStatement ps = con.prepareStatement(tb_Disco);
			ps.setString(1, disco.getTitulo());
	  		ps.setString(2, disco.getTitulo());
	 		ps.setString(3, disco.getTitulo());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Disco dis = new Disco();
				try {
					dis.setId(rs.getLong("codigo_objeto"));

					Objeto objeto = new Objeto(rs.getLong("codigo_objeto"), 0, 0);
					Objeto novo_objeto = buscarObjeto(objeto);

					dis.setQuantidadeExemplares(novo_objeto.getQuantidadeExemplares());
					dis.setValorAluguel(novo_objeto.getValorAluguel());

					dis.setTitulo(rs.getString("titulo"));
					dis.setNomeBanda(rs.getString("nome_banda"));
					dis.setEstilo(rs.getString("estilo"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				discos.add(dis);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return discos;
	}

	

	private Long CriarObjeto(Objeto objeto) {
		ObjetoDAO obDAO = new ObjetoDAO();
		long id_objeto = obDAO.inserir(objeto);
		return id_objeto;

	}

	private void DeleterObjeto(Objeto objeto) {
		ObjetoDAO obDAO = new ObjetoDAO();
		obDAO.deletar(objeto);
	}

	private void AlterarObjeto(Objeto objeto) {
		ObjetoDAO obDAO = new ObjetoDAO();
		obDAO.alterar(objeto);
	}

	private Objeto buscarObjeto(Objeto objeto) {
		ObjetoDAO obDAO = new ObjetoDAO();
		return obDAO.buscar(objeto);
	}

}
