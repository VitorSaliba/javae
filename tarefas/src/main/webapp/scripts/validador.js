/**
 * Validação de Formulário
 */

function validar() {
	let nome = frmTarefa.nome.value
	let prioridade = frmTarefa.prioridade.value
	let dataRegistro = frmTarefa.dataRegistro.value
	let dataConclusao = frmTarefa.dataConclusao.value
	let descricao = frmTarefa.descricao.value
	if (nome === "") {
		alert("Preencha o campo Nome")
		frmTarefa.nome.focus()
		return false
	} else if (prioridade === "") {
		alert("Preencha o campo Prioridade")
		frmTarefa.prioridade.focus()
		return false
	} else if (dataRegistro === "") {
		alert("Preencha o campo Data registro")
		frmTarefa.dataRegistro.focus()
		return false
	} else if (dataConclusao === "") {
		alert("Preencha o campo Data conclusao")
		frmTarefa.dataConclusao.focus()
		return false
	} else{
		document.forms["frmTarefa"].submit()
	}
}