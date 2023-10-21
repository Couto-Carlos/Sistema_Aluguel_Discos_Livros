package model.bo;

import java.sql.Date;
import java.sql.SQLDataException;
import java.text.SimpleDateFormat;
import java.util.List;

import DAO.BaseDao;
import DAO.LivroDAO;
import model.entity.Livro;

public class LivroBO {
	LivroDAO conexaoLivro = new LivroDAO();

	public LivroBO() {
		try {
			conexaoLivro.getConnection();
		} catch (Exception e) {
			System.out.println("Falha na conexão");
		}
	}

	public void criar(Livro liv) {

		Livro livro = conexaoLivro.pesquisaTitulo(liv);
		if (livro == null) {
			conexaoLivro.inserir(liv);
		} else {
			System.out.println("POP-UP LIVRO JA EXISTENTE");
		}
	}

	public void alterar(Livro liv) {
		conexaoLivro.alterar(liv);
	}

	public void Deletar(Livro liv) {

		Livro LivroPorID = conexaoLivro.buscar(liv);
		if (LivroPorID != null) {
			conexaoLivro.deletar(liv);
		} else {
			Livro Livro = conexaoLivro.pesquisaTitulo(liv);
			if (Livro != null) {
				conexaoLivro.deletar(Livro);
			} else {
				System.out.println("POP-UP LIVRO NAO EXISTENTE");
			}
		}
	}

	public Livro buscar(Livro liv) {

		Livro LivroPorID = conexaoLivro.buscar(liv);
		if (LivroPorID != null) {
			return LivroPorID;
		} else {
			Livro livro = conexaoLivro.pesquisaTitulo(liv);
			if (livro != null) {
				return livro;
			} else {
				System.out.println("POP-UP LIVRO NAO EXISTENTE");
				return null;
			}
		}
	}

	public Livro pesquisaTitulo(Livro liv) {
		Livro livro = conexaoLivro.pesquisaTitulo(liv);
		if (livro != null) {
			return livro;
		} else {
			System.out.println("POP-UP LIVRO NAO EXISTENTE");
			return null;
		}

	}

	public List<Livro> listar() {
		return conexaoLivro.listar();
	}

	public List<Livro> pesquisaTotal(Livro liv) {
		if (liv != null) {
			try {
				System.out.println("ENTROUDATA");
				// Crie um objeto SimpleDateFormat para analisar a data da string
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

				// Parse a string para um objeto java.util.Date
				java.util.Date utilDate = sdf.parse(liv.getTitulo());

				// Converta o java.util.Date em java.sql.Date
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

				// Agora você tem o java.sql.Date
				System.out.println("Data em formato java.sql.Date: " + sqlDate);

				liv.setdataLancamento(sqlDate);

				return conexaoLivro.pesquisaAno(liv);
			} catch (Exception e) {
				return conexaoLivro.pesquisaTotal(liv);
			}
		} else {
			return conexaoLivro.listar();
		}

	}

}
