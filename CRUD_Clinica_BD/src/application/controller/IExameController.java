package application.controller;

import java.sql.SQLException;

import application.model.Exame;

public interface IExameController 
{
	
	void atualizarExame(Exame e) throws SQLException, ClassNotFoundException;
	void excluiExame(Exame e) throws SQLException, ClassNotFoundException;
	void insereExame(Exame e) throws SQLException, ClassNotFoundException;
	void buscaExame(Exame e) throws SQLException, ClassNotFoundException;
	void buscaExames() throws ClassNotFoundException, SQLException;
}
