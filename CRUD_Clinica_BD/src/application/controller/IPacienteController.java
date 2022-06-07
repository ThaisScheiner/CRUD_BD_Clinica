package application.controller;

import java.sql.SQLException;
import application.model.Paciente;

public interface IPacienteController
{
	public void inserePaciente(Paciente p) throws ClassNotFoundException, SQLException;
	public void atualizarPaciente(Paciente p) throws ClassNotFoundException, SQLException;
	public void excluiPaciente(Paciente p) throws ClassNotFoundException, SQLException;
	public void buscaPacientes(Paciente p) throws ClassNotFoundException, SQLException;
	public void listarPacientes() throws ClassNotFoundException, SQLException;
	
	
}
