package model.entity;

public class Objeto {
    private Long id;
    private int quantidadeExemplares;
    private float valorAluguel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Objeto(int quantidadeExemplares, float valorAluguel) {
        setQuantidadeExemplares(quantidadeExemplares);
        setValorAluguel(valorAluguel);
    }

    public Objeto(long id, int quantidadeExemplares, float valorAluguel) {
        setId(id);
        setQuantidadeExemplares(quantidadeExemplares);
        setValorAluguel(valorAluguel);
    }

    public Objeto() {
    }

    public int getQuantidadeExemplares() {
        return quantidadeExemplares;
    }

    public void setQuantidadeExemplares(int quantidadeExemplares) {
        if (quantidadeExemplares < 0) {
            System.out.println("Valor inválido, Coloque um valor maior que 0");
        } else {
            this.quantidadeExemplares = quantidadeExemplares;
        }
    }

    public float getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(float valorAluguel) {
        if (valorAluguel < 0) {
            System.out.println("Valor inválido, Coloque um valor maior que 0");
        } else {
            this.valorAluguel = valorAluguel;
        }
    }

}
