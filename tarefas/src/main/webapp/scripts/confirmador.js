/**
 * Confirmação de exclusão de uma tarefa
 * @param idtar
 */

function confirmar(idtar) {
	let resposta = confirm("Confirma a exclusão desta tarefa?")
	if (resposta === true) {
		window.location.href = "delete?idtar=" + idtar
	}
}