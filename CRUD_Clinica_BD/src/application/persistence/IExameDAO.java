package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Exame;
import application.model.Fatura;

public interface IExameDAO 
{
	public void insereExame(Exame e) throws SQLException, ClassNotFoundException;
	public void atualizarExame(Exame e) throws SQLException, ClassNotFoundException;
	public void excluiExame(Exame e) throws SQLException, ClassNotFoundException;
	public Exame buscaExame(Exame e) throws SQLException;
	public List<Exame> buscaExames() throws SQLException;
}
