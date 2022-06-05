package application.model;

import java.sql.Date;
import java.time.LocalDate;


public class Fatura 
{
	private int fatId;
	private String fatNome;
	private String fatDescricao;
	private double fatValor;
	private LocalDate fatData;
	//private int fatIdPaciente;
	
	public int getFatId() {
		return fatId;
	}
	public void setFatId(int fatId) {
		this.fatId = fatId;
	}
	public String getFatNome() {
		return fatNome;
	}
	public void setFatNome(String fatNome) {
		this.fatNome = fatNome;
	}
	public String getFatDescricao() {
		return fatDescricao;
	}
	public void setFatDescricao(String fatDescricao) {
		this.fatDescricao = fatDescricao;
	}
	public double getFatValor() {
		return fatValor;
	}
	public void setFatValor(double fatValor) {
		this.fatValor = fatValor;
	}
	public LocalDate getFatData() {
		return fatData;
	}
	public void setFatData(LocalDate fatData) {
		this.fatData = fatData;
	}
	//public int getFatIdPaciente() {
	//	return fatIdPaciente;
	//}
	//public void setFatIdPaciente(int fatIdPaciente) {
	//	this.fatIdPaciente = fatIdPaciente;
	//}
	@Override
	public String toString() {
		return "[fatId=" + fatId + ", fatNome=" + fatNome + ", fatDescricao=" + fatDescricao + ", fatValor="
				+ fatValor + ", fatData=" + fatData + ", fatIdPaciente= ]";
	}
	
	
}
