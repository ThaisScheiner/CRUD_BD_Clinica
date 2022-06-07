package application.controller;

import java.sql.SQLException;

import application.model.Medico;

public interface IMedicoController 
{
	public void inserirMedico(Medico m) throws ClassNotFoundException, SQLException;
	public void atualizarMedico(Medico m) throws ClassNotFoundException, SQLException;
	public void excluirMedico(Medico m) throws ClassNotFoundException, SQLException;
	public void buscaMedico(Medico m) throws ClassNotFoundException, SQLException;
	public void listarMedicos() throws ClassNotFoundException, SQLException;

}
