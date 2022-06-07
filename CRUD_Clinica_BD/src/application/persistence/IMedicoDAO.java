package application.persistence;

import java.sql.SQLException;
import java.util.List;

import application.model.Medico;

public interface IMedicoDAO 
{
	public void cadastrarMedico(Medico m) throws SQLException;
	public void atualizarMedico(Medico m) throws SQLException;
	public void excluiMedico(Medico m) throws SQLException;
	public Medico buscaMedico(Medico m) throws SQLException;
	public List<Medico> listaMedicos() throws SQLException;
}
