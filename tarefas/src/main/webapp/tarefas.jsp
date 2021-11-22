<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>
<%
@ SuppressWarnings ("unchecked")
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("tarefas");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agenda de Tarefas</title>
<link rel="icon" href="imagens/Logo.png">
<link rel="stylesheet" href="estilo.css">

</head>
<body>
	<h1>Agenda de Tarefas</h1>
	<a href="novo.html" class="Botao1">Nova tarefa</a>
	<a href="report" class="Botao2">Relatório</a>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome da Tarefa</th>
				<th>Prioridade</th>
				<th>Data de Registro</th>
				<th>Dara de Conclusão</th>
				<th>Descrição</th>
				<th>Opções</th>
			</tr>
		</thead>

		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getIdtar()%></td>
				<td><%=lista.get(i).getNomeTarefa()%></td>
				<td><%=lista.get(i).getPrioridade()%></td>
				<td><%=lista.get(i).getDataRegistro()%></td>
				<td><%=lista.get(i).getDataConclusao()%></td>
				<td><%=lista.get(i).getDescricao()%></td>
				<td><a href="select?idtar=<%=lista.get(i).getIdtar()%>"
					class="Botao1">Editar</a> <a
					href="javascript: confirmar(<%=lista.get(i).getIdtar()%>)"
					class="Botao2">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>