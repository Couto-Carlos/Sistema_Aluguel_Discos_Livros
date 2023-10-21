package br.com.ufersa.lojaDudu.model.entity;

public class Usuario {
    private String login;
    private String senha;


    public Usuario(String login, String senha) {
        setLogin(login);
        setSenha(senha);
    }
    public Usuario() {}


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
    

    public void alterarSenha(String senha) {

        if (senha.length() < 3) {
            System.out.println("Valor Invalido");
        }
        else {
            this.senha = senha;
        }
    }

}
