package model.entity;

public class Disco extends Objeto {

    private String titulo;
    private String nomeBanda;
    private String estilo;

    public Disco(int quantidade_exemplares, float valorAluguel, String titulo, String nomeBanda, String estilo) {
        setTitulo(titulo);
        setNomeBanda(nomeBanda);
        setEstilo(estilo);
        setQuantidadeExemplares(quantidade_exemplares);
        setValorAluguel(valorAluguel);
    }

    public Disco(long id, int quantidade_exemplares, float valorAluguel, String titulo, String nomeBanda,
            String estilo) {
        setId(id);
        setTitulo(titulo);
        setNomeBanda(nomeBanda);
        setEstilo(estilo);
        setQuantidadeExemplares(quantidade_exemplares);
        setValorAluguel(valorAluguel);
    }

    public Disco() {
    }

    public void adicionarNomeBanda(String nomeBanda) {
        if (nomeBanda.length() < 1) {
            System.out.println("Valor Nulo, Coloque um nome da banda válido");
        } else {
            this.nomeBanda = this.nomeBanda + " " + nomeBanda;
        }
    }

    public void adicionarEstilo(String estilo) {
        if (estilo.length() < 1) {
            System.out.println("Valor Nulo, Coloque um estilo válido");
        } else {
            this.estilo = this.estilo + " " + estilo;
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo.length() < 1) {
            System.out.println("Valor Nulo, Coloque um titulo válido");
        } else {
            this.titulo = titulo;
        }
    }

    public String getNomeBanda() {
        return this.nomeBanda;
    }

    public void setNomeBanda(String nomeBanda) {
        if (nomeBanda.length() < 1) {
            System.out.println("Valor Nulo, Coloque um nome para a Banda válido");
        } else {
            this.nomeBanda = nomeBanda;
        }
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

}