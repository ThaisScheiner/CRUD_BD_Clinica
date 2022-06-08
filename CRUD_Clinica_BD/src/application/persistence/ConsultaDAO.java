package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Consulta;

public class ConsultaDAO implements ConsultaDAOImpl 
{
private Connection con;
	
	public ConsultaDAO() throws ClassNotFoundException, SQLException {
		GenericDAO daoPadrao = new GenericDAO();
		con = daoPadrao.getConnection();
	}

	@Override
	public void insereConsulta(Consulta c) throws SQLException {
		String SQL = "INSERT INTO consulta VALUES (?, ?, ?)";
		
		PreparedStatement ps = con.prepareStatement(SQL);
		ps.setInt(1, c.getConsId());
		ps.setString(2, c.getConsNome());
		ps.setString(3, c.conversorData());
		ps.setInt(4, c.getConsIdMedico());
		ps.setInt(5, c.getConsIdExame());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public void atualizaConsulta(Consulta c) throws SQLException {
		String SQL = "UPDATE consulta SET ConsNome = ?, consData = ?"
				+ "ConsIdMedico = ?, ConsIdPaciente = ?, ConsIdExame = ? WHERE ConsId = ?";
		
		PreparedStatement ps = con.prepareStatement(SQL);
		ps.setInt(1, c.getConsId());
		ps.setString(2, c.getConsNome());
		ps.setString(3, c.conversorData());
		ps.setInt(4, c.getConsIdMedico());
		ps.setInt(5, c.getConsIdExame());
		
		ps.execute();
		ps.close();
	}

	@Override
	public void excluiConsulta(Consulta c) throws SQLException {
		String SQL = "DELETE consulta WHERE ConsId = ?";
		
		PreparedStatement ps = con.prepareStatement(SQL);
		ps.setInt(1, c.getConsId());
		ps.setString(2, c.getConsNome());
		ps.setString(3, c.conversorData());
		ps.setInt(4, c.getConsIdMedico());
		ps.setInt(5, c.getConsIdExame());
		ps.execute();
		ps.close();
		
	}

	@Override
	public Consulta buscaConsulta(Consulta c) throws SQLException {
		String SQL = "SELECT ConsNome, consData, ConsIdMedico, ConsIdExame FROM consulta WHERE ConsId = ?";
		
		PreparedStatement ps = con.prepareStatement(SQL);
		ps.setInt(1, c.getConsId());
		
		int i = 0;
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			c.setConsNome(rs.getString("ConsNome"));
			c.setConsIdMedico(rs.getInt("ConsIdMedico"));
			i++;
		}
		
		if (i == 0) {
			c = new Consulta();
		}
		rs.close();
		ps.close();
		return c;
	}

	@Override
	public List<Consulta> buscaConsultas() throws SQLException {
		String SQL = "SELECT ConsNome, consData, ConsIdMedico, ConsIdExame FROM consulta WHERE ConsId = ?";
		
		PreparedStatement ps = con.prepareStatement(SQL);
		
		ResultSet rs = ps.executeQuery();
		
		List<Consulta> listaConsultas = new ArrayList<Consulta>();
		
		while(rs.next()) {
			Consulta c = new Consulta();
			c.setConsID(rs.getInt("ConsId"));
			c.setConsNome(rs.getString("ConsNome"));
			c.setConsIdMedico(rs.getInt("ConsIdMedico"));
			listaConsultas.add(c);
		}
		
		rs.close();
		ps.close();
		return listaConsultas;
	}

}
