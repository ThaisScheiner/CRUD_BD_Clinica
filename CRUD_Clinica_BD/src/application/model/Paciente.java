package application.model;

public class Paciente 
{
	private int id;
	private String nome;
	private String cpf;
	private String logradouro;
	private String numero;
	private String cep;
	private String bairro;
	private String telefone_residencial;
	private String telefone_celular;
	private String email;
	private String sexo;
	private int Idmedico;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
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
	public String getTelefone_residencial() {
		return telefone_residencial;
	}
	public void setTelefone_residencial(String telefone_residencial) {
		this.telefone_residencial = telefone_residencial;
	}
	public String getTelefone_celular() {
		return telefone_celular;
	}
	public void setTelefone_celular(String telefone_celular) {
		this.telefone_celular = telefone_celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getIdmedico() {
		return Idmedico;
	}
	public void setIdmedico(int idmedico) {
		Idmedico = idmedico;
	}
	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", logradouro=" + logradouro + ", numero="
				+ numero + ", cep=" + cep + ", bairro=" + bairro + ", telefone_residencial=" + telefone_residencial
				+ ", telefone_celular=" + telefone_celular + ", email=" + email + ", sexo=" + sexo + ", Idmedico="
				+ Idmedico + "]";
	}
	
	

}
