package application.model;

public class Exame 
{
	private int ExaId;
	private String ExaNome;
	private String ExaDescricao;
	private int ExaIdPaciente;
	
	public int getExaId() {
		return ExaId;
	}
	public void setExaId(int exaId) {
		ExaId = exaId;
	}
	public String getExaNome() {
		return ExaNome;
	}
	public void setExaNome(String exaNome) {
		ExaNome = exaNome;
	}
	public String getExaDescricao() {
		return ExaDescricao;
	}
	public void setExaDescricao(String exaDescricao) {
		ExaDescricao = exaDescricao;
	}
	public int getExaIdPaciente() {
		return ExaIdPaciente;
	}
	public void setExaIdPaciente(int exaIdPaciente) {
		ExaIdPaciente = exaIdPaciente;
	}
	
	@Override
	public String toString() {
		return "Exame [ExaId=" + ExaId + ", ExaNome=" + ExaNome + ", ExaDescricao=" + ExaDescricao + ", ExaIdPaciente="
				+ ExaIdPaciente + "]";
	}
	
	
}
