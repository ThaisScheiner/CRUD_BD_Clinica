package application.model;

public class Exame 
{
	int ExameId;
	String ExameNome;
	String ExameDescricao;
	
	public int getExameId() {
		return ExameId;
	}
	public void setExameId(int exameId) {
		ExameId = exameId;
	}
	public String getExameNome() {
		return ExameNome;
	}
	public void setExameNome(String exameNome) {
		ExameNome = exameNome;
	}
	public String getExameDescricao() {
		return ExameDescricao;
	}
	public void setExameDescricao(String exameDescricao) {
		ExameDescricao = exameDescricao;
	}
	
	@Override
	public String toString() {
		return "Exame [ExameId=" + ExameId + ", ExameNome=" + ExameNome + ", ExameDescricao=" + ExameDescricao + "]";
	}
	
	
	
}
