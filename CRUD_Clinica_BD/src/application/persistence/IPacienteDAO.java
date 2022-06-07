package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Fatura;
import application.model.Paciente;

public interface IPacienteDAO 
{
	public void inserePaciente(Paciente p) throws SQLException, ClassNotFoundException;
	public void atualizarPaciente(Paciente p) throws SQLException, ClassNotFoundException;
	public void excluiPaciente(Paciente p) throws SQLException, ClassNotFoundException;
	public Paciente buscaPaciente(Paciente p) throws SQLException;
	public List<Paciente> buscaPacientes() throws SQLException;
}
