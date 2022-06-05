package application.controller;

import java.sql.SQLException;

import application.model.Fatura;

public interface IFaturaController 
{
	public void insereFatura(Fatura f) throws SQLException, ClassNotFoundException;
	public void atualizarFatura(Fatura f) throws SQLException, ClassNotFoundException;
	public void excluiFatura(Fatura f) throws SQLException, ClassNotFoundException;
	public void buscaFatura(Fatura f) throws SQLException, ClassNotFoundException;
	public void buscaFaturas() throws ClassNotFoundException, SQLException;
}
