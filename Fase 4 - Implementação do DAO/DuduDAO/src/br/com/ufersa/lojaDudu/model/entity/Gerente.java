package br.com.ufersa.lojaDudu.model.entity;

public class Gerente extends Funcionario {
    private Boolean isGerente = false;

    public Gerente(String nome, String cpf, String endereco, Double salario, String login, String senha) {
        super(nome, "Gerente", cpf, endereco, salario, login, senha);
        setIsGerente(true);
    }
    
    public Boolean getIsGerente() { return isGerente; }

    public void setIsGerente(Boolean isGerente) {
        this.isGerente = isGerente;
    }
}
