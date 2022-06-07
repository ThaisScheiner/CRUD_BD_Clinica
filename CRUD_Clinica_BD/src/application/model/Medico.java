package application.model;

public class Medico 
{
	private int id;
	private String nome;
	private String crm;
	private String logradouro;
	private String numero;
	private String cep;
	private String bairro;
	private String telRes;
	private String telCel;
	private String especialidade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
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
	public String getTelRes() {
		return telRes;
	}
	public void setTelRes(String telRes) {
		this.telRes = telRes;
	}
	public String getTelCel() {
		return telCel;
	}
	public void setTelCel(String telCel) {
		this.telCel = telCel;
	}
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", nome=" + nome + ", crm=" + crm + ", logradouro=" + logradouro + ", numero="
				+ numero + ", cep=" + cep + ", bairro=" + bairro + ", telRes=" + telRes + ", telCel=" + telCel
				+ ", especialidade=" + especialidade + "]";
	}

}
