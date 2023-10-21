package br.com.ufersa.lojaDudu.model.entity;

public class Item {
    private Long id;
    private String titulo;
    private String autor;
    private String tipo;
    static Long novoId = 1l; // apenas para teste

    private Integer quantidadeEstoque;
    private Double valorAluguel;
    
    
    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo){
        if (titulo.length() < 1) {
            System.out.println("Valor Nulo, Coloque um titulo válido");
        }
        else {
            this.titulo = titulo;
        }
    }


    public String getAutor() { return this.autor; }

    public void setAutor(String autor){
        if (autor.length() < 1) {
            System.out.println("Valor Nulo, Coloque um autor válido");
        }
        else {
            this.autor = autor;
        }
    }


    public String getTipo() { return tipo; }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public Integer getQuantEstq() { return quantidadeEstoque; }
    
    public void setQuantEstq(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Double getValorAluguel() { return valorAluguel; }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }
}
