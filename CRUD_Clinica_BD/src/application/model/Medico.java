package application.model;

public class Medico 
{
	private int IdMedico;
	private String crm;
	private String nome;
	private String logradouro;
	private String Numero;
	private String cep;
	private String bairro;
	private String telefone_Residencial;
	private String telefone_Celular;
	private String especialidade;
	
	public int getIdMedico() {
		return IdMedico;
	}
	public void setIdMedico(int idMedico) {
		IdMedico = idMedico;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getTelefone_Residencial() {
		return telefone_Residencial;
	}
	public void setTelefone_Residencial(String telefone_Residencial) {
		this.telefone_Residencial = telefone_Residencial;
	}
	public String getTelefone_Celular() {
		return telefone_Celular;
	}
	public void setTelefone_Celular(String telefone_Celular) {
		this.telefone_Celular = telefone_Celular;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	@Override
	public String toString() {
		return "Medico [IdMedico=" + IdMedico + ", crm=" + crm + ", nome=" + nome + ", logradouro=" + logradouro
				+ ", Numero=" + Numero + ", cep=" + cep + ", bairro=" + bairro + ", telefone_Residencial="
				+ telefone_Residencial + ", telefone_Celular=" + telefone_Celular + ", especialidade=" + especialidade
				+ "]";
	}
	
}
