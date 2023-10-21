package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.Livro;
import model.entity.Objeto;

public class LivroDAO extends BaseDaoImpl<Livro> {

	public Long inserir(Livro liv) {
		Connection con = getConnection();
		String sql = "INSERT INTO tb_livros (titulo,codigo_objeto,genero,autor,data_de_lancamento,quantidade_pagina) "
				+ "values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, liv.getTitulo());

			Objeto novo_objeto = new Objeto(liv.getQuantidadeExemplares(), liv.getValorAluguel());
			Long id_objeto = CriarObjeto(novo_objeto);
			ps.setLong(2, id_objeto);

			ps.setString(3, liv.getGenero());
			ps.setString(4, liv.getAutor());

			ps.setDate(5, liv.getdataLancamento());
			ps.setInt(6, liv.getQuantidadePaginas());
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
	public void deletar(Livro liv) {
		Connection con = getConnection();
		String sql = "DELETE FROM tb_livros WHERE codigo_objeto = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, liv.getId());
			ps.executeUpdate();

			Objeto objeto = new Objeto(liv.getId(), 0, 0);
			DeleterObjeto(objeto);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	@Override
	public void alterar(Livro liv) {
		Connection con = getConnection();
		String sql = "UPDATE tb_livros SET titulo = ?, genero = ? ," +
				"autor = ?, data_de_lancamento = ?," +
				"quantidade_pagina = ? WHERE codigo_objeto = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, liv.getTitulo());

			Objeto novo_objeto = new Objeto(liv.getId(), liv.getQuantidadeExemplares(), liv.getValorAluguel());
			AlterarObjeto(novo_objeto);

			ps.setString(2, liv.getGenero());
			ps.setString(3, liv.getAutor());

			ps.setDate(4, liv.getdataLancamento());
			ps.setInt(5, liv.getQuantidadePaginas());
			ps.setLong(6, liv.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

	@Override
	public Livro buscar(Livro liv) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_livros WHERE codigo_objeto = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setLong(1, liv.getId());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				Livro livro = new Livro();
				livro.setId(rs.getLong("codigo_objeto"));

				Objeto objeto = new Objeto(rs.getLong("codigo_objeto"), 0, 0);
				Objeto novo_objeto = buscarObjeto(objeto);

				livro.setQuantidadeExemplares(novo_objeto.getQuantidadeExemplares());
				livro.setValorAluguel(novo_objeto.getValorAluguel());

				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setGenero(rs.getString("genero"));
				livro.setdataLancamento(rs.getDate("data_de_lancamento"));
				livro.setQuantidadePaginas(rs.getInt("quantidade_pagina"));

				return livro;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
	}

	@Override
	public List<Livro> listar() {
		Connection con = getConnection();
		String tb_livro = "SELECT * FROM tb_livros";
		List<Livro> Livros = new ArrayList<Livro>();
		try {
			PreparedStatement ps = con.prepareStatement(tb_livro);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Livro liv = new Livro();
				try {
					liv.setId(rs.getLong("codigo_objeto"));

					Objeto objeto = new Objeto(rs.getLong("codigo_objeto"), 0, 0);
					Objeto novo_objeto = buscarObjeto(objeto);

					liv.setQuantidadeExemplares(novo_objeto.getQuantidadeExemplares());
					liv.setValorAluguel(novo_objeto.getValorAluguel());

					liv.setTitulo(rs.getString("titulo"));
					liv.setAutor(rs.getString("autor"));
					liv.setGenero(rs.getString("genero"));
					liv.setdataLancamento(rs.getDate("data_de_lancamento"));
					liv.setQuantidadePaginas(rs.getInt("quantidade_pagina"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				Livros.add(liv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return Livros;
	}

	public List<Livro> pesquisaTotal(Livro livro) {
		Connection con = getConnection();
		String tb_livro = "SELECT * FROM tb_livros WHERE titulo = ? or genero = ? or autor = ? ";
		List<Livro> Livros = new ArrayList<Livro>();
		try {
			PreparedStatement ps = con.prepareStatement(tb_livro);
			ps.setString(1, livro.getTitulo());
			ps.setString(2, livro.getTitulo());
			ps.setString(3, livro.getTitulo());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Livro liv = new Livro();
				try {
					liv.setId(rs.getLong("codigo_objeto"));

					Objeto objeto = new Objeto(rs.getLong("codigo_objeto"), 0, 0);
					Objeto novo_objeto = buscarObjeto(objeto);

					liv.setQuantidadeExemplares(novo_objeto.getQuantidadeExemplares());
					liv.setValorAluguel(novo_objeto.getValorAluguel());

					liv.setTitulo(rs.getString("titulo"));
					liv.setAutor(rs.getString("autor"));
					liv.setGenero(rs.getString("genero"));
					liv.setdataLancamento(rs.getDate("data_de_lancamento"));
					liv.setQuantidadePaginas(rs.getInt("quantidade_pagina"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				Livros.add(liv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return Livros;
	}

	public List<Livro> pesquisaAno(Livro livro) {
		Connection con = getConnection();
		String tb_livro = "SELECT * FROM tb_livros WHERE data_de_lancamento = ? ";
		List<Livro> Livros = new ArrayList<Livro>();
		try {
			PreparedStatement ps = con.prepareStatement(tb_livro);
			ps.setDate(1, livro.getdataLancamento());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Livro liv = new Livro();
				try {
					liv.setId(rs.getLong("codigo_objeto"));

					Objeto objeto = new Objeto(rs.getLong("codigo_objeto"), 0, 0);
					Objeto novo_objeto = buscarObjeto(objeto);

					liv.setQuantidadeExemplares(novo_objeto.getQuantidadeExemplares());
					liv.setValorAluguel(novo_objeto.getValorAluguel());

					liv.setTitulo(rs.getString("titulo"));
					liv.setAutor(rs.getString("autor"));
					liv.setGenero(rs.getString("genero"));
					liv.setdataLancamento(rs.getDate("data_de_lancamento"));
					liv.setQuantidadePaginas(rs.getInt("quantidade_pagina"));
				} catch (Exception e) {
					e.printStackTrace();
				}
				Livros.add(liv);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return Livros;
	}

	// 

	public Livro pesquisaTitulo(Livro liv) {
		Connection con = getConnection();
		String sql = "SELECT * FROM tb_livros WHERE titulo = ?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, liv.getTitulo());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {

				Livro livro = new Livro();
				livro.setId(rs.getLong("codigo_objeto"));

				Objeto objeto = new Objeto(rs.getLong("codigo_objeto"), 0, 0);
				Objeto novo_objeto = buscarObjeto(objeto);

				livro.setQuantidadeExemplares(novo_objeto.getQuantidadeExemplares());
				livro.setValorAluguel(novo_objeto.getValorAluguel());

				livro.setTitulo(rs.getString("titulo"));
				livro.setAutor(rs.getString("autor"));
				livro.setGenero(rs.getString("genero"));
				livro.setdataLancamento(rs.getDate("data_de_lancamento"));
				livro.setQuantidadePaginas(rs.getInt("quantidade_pagina"));

				return livro;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return null;
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
