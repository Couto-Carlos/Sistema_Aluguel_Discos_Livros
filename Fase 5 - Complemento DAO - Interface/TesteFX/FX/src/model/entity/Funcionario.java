package model.entity;

public class Funcionario {

  private Long id;
  private String login;
  private String senha;
  private String funcao;

  public Funcionario(String login, String senha, String funcao) {
    setLogin(login);
    setSenha(senha);
    setFuncao(funcao);
  }

  public Funcionario(long id, String login, String senha, String funcao) {
    setId(id);
    setLogin(login);
    setSenha(senha);
    setFuncao(funcao);
  }

  public Funcionario() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setFuncao(String funcao) {
    if (funcao.length() < 1) {
      System.out.println("Valor Invalido");
    } else {
      this.funcao = funcao;
    }
  }

  public String getFuncao() {
    return funcao;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    if (login.length() < 1) {
      System.out.println("Valor Invalido");
    } else {
      this.login = login;
    }
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    if (senha.length() < 3) {
      System.out.println("Valor Invalido");
    } else {
      this.senha = senha;
    }
  }

  public void alterarSenha(String senha) {
    if (senha.length() < 3) {
      System.out.println("Valor Invalido");
    } else {
      this.senha = senha;
    }
  }

}