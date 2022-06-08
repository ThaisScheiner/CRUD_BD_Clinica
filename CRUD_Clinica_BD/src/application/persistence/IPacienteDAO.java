package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Fatura;
import application.model.Paciente;

public interface IPacienteDAO 
{
	public void cadastrarPaciente(Paciente p) throws SQLException;
	public void atualizarPaciente(Paciente p) throws SQLException;
	public void excluiPaciente(Paciente p) throws SQLException;
	public Paciente buscaPaciente(Paciente p) throws SQLException;
	public List<Paciente> listaPacientes() throws SQLException;
}
