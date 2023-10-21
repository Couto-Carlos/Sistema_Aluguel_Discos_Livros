package br.com.ufersa.lojaDudu.model.entity;
//import java.util;

public class Livro extends Item {

    // private Long id;
    // private String titulo;
    // private String autor;
    private String genero; //multivalorado
    private String anoLancamento;
    private Integer quantidadePaginas;
    


    public Livro(String titulo, String autor, String genero, String anoLancamento, Integer quantPag, Integer quantEstq, Double valorAluguel){
        //setCodigoObjeto();  // AutoIncrement do banco para codigoObjeto
        setId(novoId++);
        setTitulo(titulo);
        setAutor(autor);
        setTipo("Livro");
        setGenero(genero);
        setAnoLancamento(anoLancamento);
        setPaginas(quantPag);
        setQuantEstq(quantEstq);
        setValorAluguel(valorAluguel);
        //adicionarExemplar();
    }


    // public Long getId() {
	// 	return id;
	// }
	// public void setId(Long id) {
	// 	this.id = id;
	// }
    /*
    public void exemplarAlugado(){
      if (getQuantidadeExemplares() <= 0) {
        System.out.println("Não há exemplares disponíveis");
      } 
      else {
        adicionarExemplar(-1);
      }
    }
   
    public void exemplarAlugado(int quantidade){
        adicionarExemplar(getQuantidadeExemplares() - quantidade);
    }
    */
    public void adicionarGenero(String genero){
        if (genero.length() < 1) {
            System.out.println("Valor Nulo, Coloque um genero válido");
        }
        else {
            this.genero = this.genero + " " +  genero; // concatena os generos em uma string
        }
    }

    // public String getTitulo() { return this.titulo; }

    // public void setTitulo(String titulo){
    //     if (titulo.length() < 1) {
    //         System.out.println("Valor Nulo, Coloque um titulo válido");
    //     }
    //     else {
    //         this.titulo = titulo;
    //     }
    // }

    public String getGenero() { return this.genero; }

    public void setGenero(String genero){
        if (genero.length() < 1) {
            System.out.println("Valor Nulo, Coloque um genero válido");
        }
        else {
            this.genero = genero;
        }
    }

    public String getAnoLancamento() { return this.anoLancamento; }

    public void setAnoLancamento(String anoLancamento){
        if (anoLancamento.length() < 10) {
            System.out.println("Valor Nulo, Coloque uma data válida (26/08/2013)");
        }
        else {
            this.anoLancamento = anoLancamento;
        }
        // Colocar DateTime futuramente ...
    }

    // public String getAutor() { return this.autor; }

    // public void setAutor(String autor){
    //     if (autor.length() < 1) {
    //         System.out.println("Valor Nulo, Coloque um autor válido");
    //     }
    //     else {
    //         this.autor = autor;
    //     }
    // }

    public int getPaginas() { return this.quantidadePaginas; }

    public void setPaginas(int quantidadePaginas){
        if (quantidadePaginas < 1) {
            System.out.println("Valor das páginas devem ser maior que 0");
        }
        else {
            this.quantidadePaginas = quantidadePaginas;
        }
    }
    
}
