package Classes;

public class Gerente extends Funcionario {
  private Boolean isGerente;

  public Gerente(String login, String senha){
    setLogin(login);
    setSenha(senha);
    setIsGerente();
  }


  public Boolean getIsGerente() { return isGerente; }
  
  public void setIsGerente(){
    this.isGerente = true;
  }

}