package br.com.ufersa.lojaDudu.model.entity;
//import java.util;

public class Disco extends Item {

    // private Long id;

    // private String titulo;
    // private String nomeBanda; // multivalorado
    private String estilo; // multivalorado

    public Disco(String titulo, String nomeBanda, String estilo, Integer quantEstq, Double valorAluguel){
        //setCodigoObjeto();// AutoIncrement do banco para codigoObjeto
        setId(novoId++);
        setTitulo(titulo);
        setAutor(nomeBanda);
        setTipo("Disco");
        setEstilo(estilo);
        setQuantEstq(quantEstq);
        setValorAluguel(valorAluguel);
        //adicionarExemplar();
    }

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

    // public Long getId() {
    //     return id;
    // }
    // public void setId(Long id) {
    //     this.id = id;
    // }

    public void adicionarOutraBanda(String nomeBanda){
        if (nomeBanda.length() < 1) {
            System.out.println("Valor Nulo, Coloque um nome da banda válido");
        }
        else {
            setAutor(getAutor() + " e " +  nomeBanda); // concatena duas bandas em uma string
        }
    }


    public void adicionarEstilo(String estilo){
        if (estilo.length() < 1) {
            System.out.println("Valor Nulo, Coloque um estilo válido");
        }
        else {
            setEstilo(this.estilo + " e " + estilo); // concatena dois estilos em uma string
        }
    }
    

    // public String getTitulo() { return titulo; }

    // public void setTitulo(String titulo){
    //     if (titulo.length() < 1) {
    //         System.out.println("Valor Nulo, Coloque um titulo válido");
    //     }
    //     else {
    //         this.titulo = titulo;
    //     }
    // }


    // public String getNomeBanda() { return this.nomeBanda; }

    // public void setNomeBanda(String nomeBanda){
    //     if (nomeBanda.length() < 1) {
    //         System.out.println("Valor Nulo, Coloque um nome para a Banda válido");
    //     }
    //     else {
    //         this.nomeBanda = nomeBanda;
    //     }
    // }


    public String getEstilo() { return estilo; }

    public void setEstilo(String estilo){
            this.estilo = estilo; // pode não haver estilo.
            //Criar classe para estilo no futuro ...
    }

}