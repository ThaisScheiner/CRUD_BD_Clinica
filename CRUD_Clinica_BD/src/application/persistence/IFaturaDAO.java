package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Fatura;

public interface IFaturaDAO 
{
	public void insereFatura(Fatura f) throws SQLException, ClassNotFoundException;
	public void atualizarFatura(Fatura f) throws SQLException, ClassNotFoundException;
	public void excluiFatura(Fatura f) throws SQLException, ClassNotFoundException;
	public Fatura buscaFatura(Fatura f) throws SQLException;
	public List<Fatura> buscaFaturas() throws SQLException;
}
