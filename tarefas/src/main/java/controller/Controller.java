package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The tarefa. */
	JavaBeans tarefa = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/main")) {
			tarefas(request, response);
		} else if (action.equals("/insert")) {
			novaTarefa(request, response);
		} else if (action.equals("/select")) {
			listarTarefa(request, response);
		} else if (action.equals("/update")) {
			editarTarefa(request, response);
		} else if (action.equals("/delete")) {
			removerTarefa(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("index.html");
		}
	}

	/**
	 * Tarefas.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Listar tarefas
	protected void tarefas(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que irá receber os dados JavaBeans
		ArrayList<JavaBeans> lista = dao.listarTarefas();
		// Encaminhar a lista ao documento tarefas.jsp
		request.setAttribute("tarefas", lista);
		RequestDispatcher rd = request.getRequestDispatcher("tarefas.jsp");
		rd.forward(request, response);
	}

	/**
	 * Nova tarefa.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Nova tarefa
	protected void novaTarefa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variáveis JavaBeans
		tarefa.setNomeTarefa(request.getParameter("nome"));
		tarefa.setPrioridade(request.getParameter("prioridade"));
		tarefa.setDataRegistro(request.getParameter("dataRegistro"));
		tarefa.setDataConclusao(request.getParameter("dataConclusao"));
		tarefa.setDescricao(request.getParameter("descricao"));
		// invocar o método inserirTarefa passando o objeto tarefa
		dao.inserirTarefa(tarefa);
		// redirecionar para o documento tarefas.jsp
		response.sendRedirect("main");
	}

	/**
	 * Listar tarefa.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Editar tarefa
	protected void listarTarefa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id da tarefa que será editada
		String idtar = request.getParameter("idtar");
		// Setar a variável JavaBeans
		tarefa.setIdtar(idtar);
		// Executar o método selecionarTarefa (DAO)
		dao.selecionarTarefa(tarefa);
		// Setar os atributos do formulário com o conteúdo JavaBeans
		request.setAttribute("idtar", tarefa.getIdtar());
		request.setAttribute("nomeTarefa", tarefa.getNomeTarefa());
		request.setAttribute("prioridade", tarefa.getPrioridade());
		request.setAttribute("dataRegistro", tarefa.getDataRegistro());
		request.setAttribute("dataConclusao", tarefa.getDataConclusao());
		request.setAttribute("descricao", tarefa.getDescricao());
		// Encaminhar ao documento editar.jsp
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar tarefa.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarTarefa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// setar as variáveis JavaBeans
		tarefa.setIdtar(request.getParameter("idtar"));
		tarefa.setNomeTarefa(request.getParameter("nome"));
		tarefa.setPrioridade(request.getParameter("prioridade"));
		tarefa.setDataRegistro(request.getParameter("dataRegistro"));
		tarefa.setDataConclusao(request.getParameter("dataConclusao"));
		tarefa.setDescricao(request.getParameter("descricao"));
		// executar o método alterarTarefa
		dao.alterarTarefa(tarefa);
		// redirecionar para o documento tarefas.jsp (atualizando as informações)
		response.sendRedirect("main");
	}

	/**
	 * Remover tarefa.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Remover uma tarefa
	protected void removerTarefa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Recebimento do id da tarefa a ser excluida (validador.js)
		String idtar = request.getParameter("idtar");
		// Setar a variável idtar no JavaBeans
		tarefa.setIdtar(idtar);
		// Executar o método deletarTarefa (DAO) passando o objeto tarefa como parâmetro
		dao.deletarTarefa(tarefa);
		// redirecionar para o documento tarefas.jsp (atualizando as informações)
		response.sendRedirect("main");

	}

	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	// Gerar relatório em PDF
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Document documento = new Document();
		try {
			// tipo de conteúdo
			response.setContentType("apllication/pdf");
			// nome do documento
			response.addHeader("Content-Disposition", "inline; filename=" + "tarefas.pdf");
			// criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// abrir o documento -> conteudo
			documento.open();
			documento.add(new Paragraph("Lista de tarefas:"));
			documento.add(new Paragraph(" "));
			// criar uma tabela
			PdfPTable tabela = new PdfPTable(5);
			// cabeçalho
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome da tarefa"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Prioridade"));
			PdfPCell col3 = new PdfPCell(new Paragraph("Data de registro"));
			PdfPCell col4 = new PdfPCell(new Paragraph("Data de conclusão"));
			PdfPCell col5 = new PdfPCell(new Paragraph("Descrição"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			// popular a tabela com os contatos
			ArrayList<JavaBeans> lista = dao.listarTarefas();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNomeTarefa());
				tabela.addCell(lista.get(i).getPrioridade());
				tabela.addCell(lista.get(i).getDataRegistro());
				tabela.addCell(lista.get(i).getDataConclusao());
				tabela.addCell(lista.get(i).getDescricao());
			}
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}

}

