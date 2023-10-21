

import java.util.List;
import java.util.Arrays;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.time.LocalDate;

import DAO.ObjetoDAO;
import DAO.LivroDAO;
import DAO.DiscoDAO;
import DAO.ClienteDAO;
import DAO.BaseDao;

import model.entity.Objeto;
import model.entity.Livro;
import model.entity.Disco;
import model.entity.Cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        ClienteDAO conexaoCliente = new ClienteDAO();

        try {
            conexaoCliente.getConnection();
            System.out.println("Conexão com sucesso");

            Date test = Date.valueOf(LocalDate.now());
            Date test2 = new Date(100,10,10);
            System.out.println(test2 );

            Cliente cli = new Cliente("Carlos4", "Rua sem fim", "00100200348");
            //conexaoCliente.inserir(cli);
            System.out.println("Inserido com sucesso");

            List<Cliente> clientes = conexaoCliente.listar();

            for (Cliente cliente : clientes) {
                System.out.println("-----------------------------------" +
                        "\nCliente id: " + cliente.getId() +
                        "\nNome: " + cliente.getNome() +
                        "\nCPF: " + cliente.getCpf() +
                        "\nEndereço : " + cliente.getEndereco());

            }

            conexaoCliente.closeConnection();
        } catch (Exception e) {
            System.out.println("Falha na Conexão");
        }

    }

}
