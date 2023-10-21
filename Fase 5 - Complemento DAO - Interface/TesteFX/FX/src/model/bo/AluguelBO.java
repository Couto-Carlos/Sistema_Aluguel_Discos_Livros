package model.bo;

import DAO.BaseDao;
import DAO.ClienteDAO;
import DAO.ObjetoDAO;

import java.util.ArrayList;
import java.util.List;

import DAO.AluguelDAO;
import model.entity.Aluguel;
import model.entity.Cliente;
import model.entity.Objeto;
import model.entity.Relatorio;
import model.entity.Venda;

public class AluguelBO {
	AluguelDAO conexaoAluguel = new AluguelDAO();
	ClienteDAO conexaoCliente = new ClienteDAO();
	ObjetoDAO conexaoObjeto = new ObjetoDAO();

	public AluguelBO() {
		try {
			conexaoAluguel.getConnection();
		} catch (Exception e) {
			System.out.println("Falha na conexão");
		}
	}

	public void criar(Aluguel alu) {

		Cliente cliente = new Cliente("00", "000000", alu.getCpfCliente());
		Objeto objeto = new Objeto(alu.getCodigoObjeto(), 0, 0);

		Cliente autenticarCliente = conexaoCliente.verificarCPF(cliente);
		if (autenticarCliente != null) {
			Objeto autenticarObjeto = conexaoObjeto.buscar(objeto);
			if (autenticarObjeto != null && autenticarObjeto.getQuantidadeExemplares() > 0) {
				System.out.println("PASSOU DA AUTENTICACAO");
				int quantidadeExemplaresReduzida = autenticarObjeto.getQuantidadeExemplares() - 1;
				autenticarObjeto.setQuantidadeExemplares(quantidadeExemplaresReduzida);
				conexaoObjeto.alterar(autenticarObjeto); // Reduz o total de exemplares em -1;
				System.out.println("DIMINUIU 1 LIVRO");

				conexaoAluguel.inserir(alu);
			} else {
				System.out.println("POP-UP OBJETO NAO EXISTENTE OU SEM EXEMPLARES");
				
			}
		} else {
			System.out.println("POP-UP CLIENTE NÃO EXISTENTE");
			
		}
	}

	public void deletar(Aluguel alu) {

		Aluguel autenticarAluguel = conexaoAluguel.buscar(alu);

		if (autenticarAluguel != null) {

			Objeto objeto = new Objeto(alu.getCodigoObjeto(), 0, 0);
			Objeto objetoAluguel = conexaoObjeto.buscar(objeto);

			if (objetoAluguel != null) {
				int quantidadeExemplaresDevolvida = objetoAluguel.getQuantidadeExemplares() + 1;// Faz a devolução do
																								// exemplar somando
																								// exemplares em +1;
				objetoAluguel.setQuantidadeExemplares(quantidadeExemplaresDevolvida);
				conexaoObjeto.alterar(objetoAluguel);
			} else {
				System.out.println("Objeto já apagado do sistema");
			}

			conexaoAluguel.deletar(alu);

		} else {
			System.out.println("POP-UP ALUGUEL NAO EXISTENTE");
		}

	}

	public Aluguel buscar(Aluguel alu) {

		Aluguel aluguel = conexaoAluguel.buscar(alu);
		if(aluguel  != null){
			return aluguel;
		}else{
			System.out.println("POP-UP ALUGUEL INEXISTENTE");
			return null;
		}

	}

	public List<Aluguel> buscarCPF(Aluguel alu) {
		List<Aluguel> autenticarAluguel = conexaoAluguel.pesquisaCliente(alu);
		if (autenticarAluguel != null) {
			return autenticarAluguel;
		} else {
			System.out.println("POP-UP CLIENTE NÃO TEM ALUGUEIS");
			return null;
		}
	}

	public List<Venda> listarVendas(){
		return conexaoAluguel.listarVendas();
	}
	public List<Venda> pesquisarVendas(Venda venda){
		if(venda != null){
			return conexaoAluguel.pesquisarVendas(venda);
		}else{
			return conexaoAluguel.listarVendas();
		}
		
	}

	public List<Relatorio> listarRelatorios(){
		return conexaoAluguel.listarRelatorio();
	}
	public List<Relatorio> pesquisarRelatorios(Relatorio relatorio){
		return conexaoAluguel.pesquisarRelatorio(relatorio);
	}
	public List<Relatorio> pesquisarRelatoriosNome(Relatorio relatorio){
		return conexaoAluguel.pesquisarRelatorioNome(relatorio);
	}

	public Float mostrarLucroSemanal(){
		return conexaoAluguel.lucroSemana();
	}

	public int mostrarDiscosSemanal(){
		return conexaoAluguel.discosSemana();
	}
	public int mostrarLivrosSemanal(){
		return conexaoAluguel.livrosSemana();
	}
}
