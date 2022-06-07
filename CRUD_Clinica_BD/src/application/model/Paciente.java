package application.model;

public class Paciente 
{
	private int pacienteId;
	private String PacienteNome;
	
	public int getPacienteId() {
		return pacienteId;
	}
	public void setPacienteId(int pacienteId) {
		this.pacienteId = pacienteId;
	}
	public String getPacienteNome() {
		return PacienteNome;
	}
	public void setPacienteNome(String pacienteNome) {
		PacienteNome = pacienteNome;
	}
	
	@Override
	public String toString() {
		return "[pacienteId=" + pacienteId + ", PacienteNome=" + PacienteNome + "]";
	}
	
	
}
