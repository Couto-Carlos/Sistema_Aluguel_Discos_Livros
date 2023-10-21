package model.entity;

public class Cliente {
    private Long id;
    private String nome;
    private String endereco;
    private String cpf;

    public Cliente(String nome, String endereco, String cpf) {
        setNome(nome);
        setEndereco(endereco);
        setCpf(cpf);
    }

    public Cliente(long id, String nome, String endereco, String cpf) {
        setId(id);
        setNome(nome);
        setEndereco(endereco);
        setCpf(cpf);
    }

    public Cliente() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() < 1) {
            System.out.println("Valor Nulo, Coloque um nome válido");
        } else {
            this.nome = nome;
        }
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if (endereco.length() < 1) {
            System.out.println("Valor Nulo, Coloque um endereco válido");
        } else {
            this.endereco = endereco;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf.length() < 11) {
            System.out.println("Valor inválido, Coloque um cpf válido");
        } else {
            this.cpf = cpf;
        }
    }
}