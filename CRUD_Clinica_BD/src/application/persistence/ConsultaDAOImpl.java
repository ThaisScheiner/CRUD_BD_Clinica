package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Consulta;

public interface ConsultaDAOImpl 
{
	public void insereConsulta(Consulta c) throws SQLException;
	public void atualizaConsulta(Consulta c) throws SQLException;
	public void excluiConsulta(Consulta c) throws SQLException;
	public Consulta buscaConsulta(Consulta c) throws SQLException;
	public List<Consulta> buscaConsultas() throws SQLException;
}
