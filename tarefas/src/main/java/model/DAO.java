package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 */
public class DAO {
	
	/**  Módulo de Conexão *. */
	// Parâmetros de Conexão
	private String driver = "com.mysql.cj.jdbc.Driver";
	
	/** The url. */
	private String url = "jdbc:mysql://127.0.0.1:3306/dbtarefas?useTimezone=true&serverTimezone=UTC";
	
	/** The user. */
	private String user = "root";
	
	/** The password. */
	private String password = "vitor1640";

	/**
	 * Conectar.
	 *
	 * @return the connection
	 */
	// Métodos de Conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 *  CRUD CREATE *.
	 *
	 * @param tarefa the tarefa
	 */
	public void inserirTarefa(JavaBeans tarefa) {
		String create = "insert into tarefas (nomeTarefa, prioridade, dataRegistro, dataConclusao, descricao) values(?,?,?,?,?)";
		try {
			// abrir a conexão
			Connection con = conectar();
			// preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(create);
			// substituir os parâmetros pelos conteúdos das variáveis JavaBeans
			pst.setString(1, tarefa.getNomeTarefa());
			pst.setString(2, tarefa.getPrioridade());
			pst.setString(3, tarefa.getDataRegistro());
			pst.setString(4, tarefa.getDataConclusao());
			pst.setString(5, tarefa.getDescricao());
			// executar a query
			pst.executeUpdate();
			// encerrar a conexão com o banco
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 *  CRUD READ *.
	 *
	 * @return the array list
	 */
	public ArrayList<JavaBeans> listarTarefas() {
		// Criando um objeto para acessar a classe JavaBeans
		ArrayList<JavaBeans> tarefas = new ArrayList<>();
		String read = "select * from tarefas order by prioridade";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// o laço abaixo será executado enquanto houver tarefas
			while (rs.next()) {
				// variáveis de apoio que recebem os dados do banco
				String idtar = rs.getString(1);
				String nomeTarefa = rs.getString(2);
				String prioridade = rs.getString(3);
				String dataRegistro = rs.getString(4);
				String dataConclusao = rs.getString(5);
				String descricao = rs.getString(6);
				// populando o ArrayList
				tarefas.add(new JavaBeans(idtar, nomeTarefa, prioridade, dataRegistro, dataConclusao, descricao));
			}
			con.close();
			return tarefas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/**
	 *  CRUD UPDATE *.
	 *
	 * @param tarefa the tarefa
	 */
	// Selecionar a tarefa
	public void selecionarTarefa(JavaBeans tarefa) {
		String read2 = "select * from tarefas where idtar = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, tarefa.getIdtar());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				tarefa.setIdtar(rs.getString(1));
				tarefa.setNomeTarefa(rs.getString(2));
				tarefa.setPrioridade(rs.getString(3));
				tarefa.setDataRegistro(rs.getString(4));
				tarefa.setDataConclusao(rs.getString(5));
				tarefa.setDescricao(rs.getString(6));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Alterar tarefa.
	 *
	 * @param tarefa the tarefa
	 */
	// editar a tarefa
	public void alterarTarefa(JavaBeans tarefa) {
		String create = "update tarefas set nomeTarefa = ?, prioridade = ?, dataRegistro = ?, dataConclusao = ?, descricao=? where idtar = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, tarefa.getNomeTarefa());
			pst.setString(2, tarefa.getPrioridade());
			pst.setString(3, tarefa.getDataRegistro());
			pst.setString(4, tarefa.getDataConclusao());
			pst.setString(5, tarefa.getDescricao());
			pst.setString(6, tarefa.getIdtar());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 *  CRUD DELETE *.
	 *
	 * @param tarefa the tarefa
	 */
	public void deletarTarefa(JavaBeans tarefa) {
		String delete = "delete from tarefas where idtar = ?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, tarefa.getIdtar());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/*
	 * Teste de Conexão public void testeConexao() { try { Connection con =
	 * conectar(); System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); } }
	 */
}

