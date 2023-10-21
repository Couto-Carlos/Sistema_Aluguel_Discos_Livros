package model.entity;

import java.sql.Date;
import java.time.LocalDate;

public class Aluguel {

  private Long id;
  private String cpfCliente;
  private int codigoObjeto;
  private Date dataAquisicao;
  private Date dataDevolucao;

  public Aluguel(String cpfCliente, int codigoObjeto, Date dataAquisicao, Date dataDevolucao) {
    setCpfCliente(cpfCliente);
    setCodigoObjeto(codigoObjeto);
    setDataAquisicao(dataAquisicao);
    setDataDevolucao(dataDevolucao);
  }

  public Aluguel(long id, String cpfCliente, int codigoObjeto, Date dataAquisicao, Date dataDevolucao) {
    setId(id);
    setCpfCliente(cpfCliente);
    setCodigoObjeto(codigoObjeto);
    setDataAquisicao(dataAquisicao);
    setDataDevolucao(dataDevolucao);
  }

  public Aluguel() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCpfCliente() {
    return cpfCliente;
  }

  public void setCpfCliente(String cpf) {
    if (cpf.length() < 11) {
      System.out.println("cpf inválido, coloque o numero com 11 digitos");
    } else {
      this.cpfCliente = cpf;
    }
  }

  public int getCodigoObjeto() {
    return codigoObjeto;
  }

  public void setCodigoObjeto(int codigoObjeto) {
    if (codigoObjeto < 0) {
      System.out.println("Codigo Inválido");
    } else {
      this.codigoObjeto = codigoObjeto;
    }
  }

  public Date getDataAquisicao() {
    return dataAquisicao;
  }

  public void setDataAquisicao(Date dataAquisicao) {
    this.dataAquisicao = dataAquisicao;
  }

  public Date getDataDevolucao() {
    return dataDevolucao;
  }

  public void setDataDevolucao(Date dataDevolucao) {
    this.dataDevolucao = dataDevolucao;
  }

  public Boolean verificarDevolucao(Date dataDevolucao) {

    Date dataAtual = Date.valueOf(LocalDate.now());
    int comparacao = dataDevolucao.compareTo(dataAtual);

    if (comparacao == 0) {
      System.out.println("Data de devolução é hoje");
      return true;
    } else if (comparacao < 0) {
      System.out.println("Data de Devolução já passou");
      return true;
    } else {
      System.out.println("Ainda não chegou a data de devolução");
      return false;
    }

  }

}