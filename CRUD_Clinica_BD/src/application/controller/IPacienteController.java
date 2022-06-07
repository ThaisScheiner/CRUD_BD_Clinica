package application.controller;

import java.sql.SQLException;
import application.model.Paciente;

public interface IPacienteController
{
	public void inserePaciente(Paciente p) throws SQLException, ClassNotFoundException;
	public void atualizarPaciente(Paciente p) throws SQLException, ClassNotFoundException;
	public void excluiPaciente(Paciente p) throws SQLException, ClassNotFoundException;
	public void buscaPaciente(Paciente p) throws SQLException, ClassNotFoundException;
	public void buscaPacientes() throws ClassNotFoundException, SQLException;
}
