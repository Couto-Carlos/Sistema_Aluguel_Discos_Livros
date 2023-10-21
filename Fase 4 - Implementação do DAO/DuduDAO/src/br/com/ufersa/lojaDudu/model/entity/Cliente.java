package br.com.ufersa.lojaDudu.model.entity;

public class Cliente {
    // private Long id;
    private String nome;
    private String endereco;
    private String cpf; // primary key
    private String telefone;


    public String getTelefone() { return telefone; }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    // public Long getId() {
	// 	return id;
	// }
	// public void setId(Long id) {
	// 	this.id = id;
	// }
    public Cliente(String nome, String endereco, String cpf, String telefone) {
      setNome(nome);
      setEndereco(endereco);
      setCpf(cpf);
      setTelefone(telefone);
    }   
    public String getNome() { return nome; }
    public void setNome(String nome){
        if(nome.length() < 1){
            System.out.println("Valor Nulo, Coloque um nome válido");
        }else{
            this.nome = nome;
        }
    }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco){
        if(endereco.length() < 1){
            System.out.println("Valor Nulo, Coloque um endereco válido");
        }else{
            this.endereco = endereco;
        }
    }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf){
        if(cpf.length() < 11){
            System.out.println("Valor inválido, Coloque um cpf válido");
        }else{
            this.cpf = cpf;
        }
    }

    //nome, endereço e
    //cpf
}