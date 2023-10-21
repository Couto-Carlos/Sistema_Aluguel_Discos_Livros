package Classes;

public class Funcionario {
  private String login;
  private String senha;

  public Funcionario(String login, String senha){
    setLogin(login);
    setSenha(senha);
  }


  public Funcionario() {}

  public void alterarSenha(String senha) {
    if (senha.length() < 3) {
      System.out.println("Valor Invalido");
    }
    else {
      this.senha = senha;
    }
  }


  public String getLogin() { return login; }

  public void setLogin(String login) {
    if (login.length() < 1) {
      System.out.println("Valor Invalido");
    }
    else {
      this.login = login;
    }
  }


  public String getSenha() { return senha; }

  public void setSenha(String senha) {
    if (senha.length() < 3) {
      System.out.println("Valor Invalido");
    }
    else {
      this.senha = senha;
    }
  }

}