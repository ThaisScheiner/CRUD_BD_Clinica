package application.controller;

import java.sql.SQLException;

import application.model.Consulta;

public interface ConsultaControllerImpl 
{
	public void inserirConsulta(Consulta c) throws ClassNotFoundException, SQLException;
	public void atualizarConsulta(Consulta c) throws ClassNotFoundException, SQLException;
	public void excluirConsulta(Consulta c) throws ClassNotFoundException, SQLException;
	public void buscarConsulta(Consulta c) throws ClassNotFoundException, SQLException;
	public void buscarConsultas() throws ClassNotFoundException, SQLException;
}
