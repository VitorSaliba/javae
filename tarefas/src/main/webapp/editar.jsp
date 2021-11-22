<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda de tarefas</title>
<link rel="icon" href="imagens/Logo.png">
<link rel="stylesheet" href="estilo.css">
</head>
<body>
	<h1>Editar tarefa</h1>
	<form name="frmTarefa" action="update">
		<table>
			<tr>
				<td><input type="text" name="idtar" id="caixa3" readonly
					value="<%out.print(request.getAttribute("idtar"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1"
					value="<%out.print(request.getAttribute("nomeTarefa"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="prioridade" class="Caixa1"
					value="<%out.print(request.getAttribute("prioridade"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="dataRegistro" class="Caixa1"
					value="<%out.print(request.getAttribute("dataRegistro"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="dataConclusao" class="Caixa1"
					value="<%out.print(request.getAttribute("dataConclusao"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="descricao" class="Caixa1"
					value="<%out.print(request.getAttribute("descricao"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>