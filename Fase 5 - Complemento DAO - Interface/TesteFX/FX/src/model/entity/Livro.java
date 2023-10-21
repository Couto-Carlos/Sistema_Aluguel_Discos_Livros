package model.entity;

import java.sql.Date;

public class Livro extends Objeto {

    private String titulo;
    private String genero;
    private Date dataLancamento;
    private String autor;
    private int quantidadePaginas;

    public Livro(int quantidadeExemplares, float valorAluguel, String titulo, String genero, Date dataLancamento,
            String autor, int quantidaPaginas) {
        setQuantidadeExemplares(quantidadeExemplares);
        setValorAluguel(valorAluguel);
        setTitulo(titulo);
        setGenero(genero);
        setdataLancamento(dataLancamento);
        setAutor(autor);
        setValorAluguel(valorAluguel);
        setQuantidadePaginas(quantidaPaginas);
    }

    public Livro(long id, int quantidadeExemplares, float valorAluguel, String titulo, String genero,
            Date dataLancamento, String autor, int quantidaPaginas) {
        setId(id);
        setQuantidadeExemplares(quantidadeExemplares);
        setValorAluguel(valorAluguel);
        setTitulo(titulo);
        setGenero(genero);
        setdataLancamento(dataLancamento);
        setAutor(autor);
        setQuantidadePaginas(quantidaPaginas);
    }

    public Livro() {
    }

    public void adicionarGenero(String genero) {
        if (genero.length() < 1) {
            System.out.println("Valor Nulo, Coloque um genero válido");
        } else {
            this.genero = this.genero + " " + genero; 
        }
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo.length() < 1) {
            System.out.println("Valor Nulo, Coloque um titulo válido");
        } else {
            this.titulo = titulo;
        }
    }

    public String getGenero() {
        return this.genero;
    }

    public void setGenero(String genero) {
        if (genero.length() < 1) {
            System.out.println("Valor Nulo, Coloque um genero válido");
        } else {
            this.genero = genero;
        }
    }

    public Date getdataLancamento() {
        return this.dataLancamento;
    }

    public void setdataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        if (autor.length() < 1) {
            System.out.println("Valor Nulo, Coloque um autor válido");
        } else {
            this.autor = autor;
        }
    }

    public int getQuantidadePaginas() {
        return this.quantidadePaginas;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        if (quantidadePaginas < 1) {
            System.out.println("Valor das páginas devem ser maior que 0");
        } else {
            this.quantidadePaginas = quantidadePaginas;
        }
    }

}
