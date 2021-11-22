package model;

// TODO: Auto-generated Javadoc
/**
 * The Class JavaBeans.
 */
public class JavaBeans {
	
	/** The idtar. */
	private String idtar;
	
	/** The nome tarefa. */
	private String nomeTarefa;
	
	/** The prioridade. */
	private String prioridade;
	
	/** The data registro. */
	private String dataRegistro;
	
	/** The data conclusao. */
	private String dataConclusao;
	
	/** The descricao. */
	private String descricao;

	/**
	 * Instantiates a new java beans.
	 */
	public JavaBeans() {
		super();
	}

	/**
	 * Instantiates a new java beans.
	 *
	 * @param idtar the idtar
	 * @param nomeTarefa the nome tarefa
	 * @param prioridade the prioridade
	 * @param dataRegistro the data registro
	 * @param dataConclusao the data conclusao
	 * @param descricao the descricao
	 */
	public JavaBeans(String idtar, String nomeTarefa, String prioridade, String dataRegistro, String dataConclusao,
			String descricao) {
		super();
		this.idtar = idtar;
		this.nomeTarefa = nomeTarefa;
		this.prioridade = prioridade;
		this.dataRegistro = dataRegistro;
		this.dataConclusao = dataConclusao;
		this.descricao = descricao;
	}

	/**
	 * Gets the idtar.
	 *
	 * @return the idtar
	 */
	public String getIdtar() {
		return idtar;
	}

	/**
	 * Sets the idtar.
	 *
	 * @param idtar the new idtar
	 */
	public void setIdtar(String idtar) {
		this.idtar = idtar;
	}

	/**
	 * Gets the nome tarefa.
	 *
	 * @return the nome tarefa
	 */
	public String getNomeTarefa() {
		return nomeTarefa;
	}

	/**
	 * Sets the nome tarefa.
	 *
	 * @param nomeTarefa the new nome tarefa
	 */
	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	/**
	 * Gets the prioridade.
	 *
	 * @return the prioridade
	 */
	public String getPrioridade() {
		return prioridade;
	}

	/**
	 * Sets the prioridade.
	 *
	 * @param prioridade the new prioridade
	 */
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	/**
	 * Gets the data registro.
	 *
	 * @return the data registro
	 */
	public String getDataRegistro() {
		return dataRegistro;
	}

	/**
	 * Sets the data registro.
	 *
	 * @param dataRegistro the new data registro
	 */
	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	/**
	 * Gets the data conclusao.
	 *
	 * @return the data conclusao
	 */
	public String getDataConclusao() {
		return dataConclusao;
	}

	/**
	 * Sets the data conclusao.
	 *
	 * @param dataConclusao the new data conclusao
	 */
	public void setDataConclusao(String dataConclusao) {
		this.dataConclusao = dataConclusao;
	}

	/**
	 * Gets the descricao.
	 *
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * Sets the descricao.
	 *
	 * @param descricao the new descricao
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

