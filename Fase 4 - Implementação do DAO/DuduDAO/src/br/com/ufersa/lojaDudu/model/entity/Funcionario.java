package br.com.ufersa.lojaDudu.model.entity;

public class Funcionario extends Usuario {
  private String nome;
  private String funcao;
  private String cpf;
  private String endereco;
  private Double salario;

  
  public Funcionario(String nome, String funcao, String cpf, String endereco, Double salario, String login, String senha){
    super(login,senha);
    setNome(nome);
    setFuncao(funcao);
    setCpf(cpf);
    setEndereco(endereco);
    setSalario(salario);
  }
  public Funcionario() {}


  public String getNome() { return nome; }

  public void setNome(String nome) {
    this.nome = nome;
  }


  public String getFuncao() { return funcao; }

  public void setFuncao(String funcao) {
    this. funcao = funcao;
  }


  public String getCpf() { return cpf; }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }


  public String getEndereco() { return endereco; }

  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }


  public Double getSalario() { return salario; }

  public void setSalario(Double salario) {
    this.salario = salario;
  }

}