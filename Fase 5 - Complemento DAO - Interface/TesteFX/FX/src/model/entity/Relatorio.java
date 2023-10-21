package model.entity;

import java.sql.Date;

public class Relatorio {
    private String nome;
    private String titulo;
    private double valorAluguel;
    private Date dataAquisicao;
    private Date dataDevolucao;

    public Relatorio(String nome, String titulo, double valorAluguel, Date dataAquisicao,Date dataDevolucao) {
        setNome(nome);
        setTitulo(titulo);
        setValorAluguel(valorAluguel);
        setDataAquisicao(dataAquisicao);
        setDataDevolucao(dataDevolucao);
    }

    public Relatorio() {
  
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
            this.nome = nome; 
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo != null && titulo.length() > 0) {
            this.titulo = titulo;
        } else {
            throw new IllegalArgumentException("O título não pode ser vazio ou nulo.");
        }
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        if (valorAluguel >= 0) {
            this.valorAluguel = valorAluguel;
        } else {
            throw new IllegalArgumentException("O valor do aluguel não pode ser menor que 0.");
        }
    }

    public Date getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(Date dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}