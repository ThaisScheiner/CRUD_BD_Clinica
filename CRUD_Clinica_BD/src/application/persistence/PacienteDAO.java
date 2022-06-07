package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Fatura;
import application.model.Paciente;

public class PacienteDAO implements IPacienteDAO
{
	private Connection c;
	
	public PacienteDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO pDAO = new GenericDAO();
		c = pDAO.getConnection();
	}

	@Override
	public void inserePaciente(Paciente p) throws SQLException, ClassNotFoundException 
	{
		String sql = "INSERT INTO paciente (PacienteId, PacienteNome)";
		sql += "VALUES ('" + p.getPacienteId() + "', ";
		sql += " '" + p.getPacienteNome() + "') ";
	
		System.out.println("Query preparada: " + sql);
		try 
		{
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void atualizarPaciente(Paciente p) throws SQLException, ClassNotFoundException 
	{
		String sql = "UPDATE paciente SET PacienteNome = ? WHERE PacienteId = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, p.getPacienteNome());
		ps.setInt(2, p.getPacienteId());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluiPaciente(Paciente p) throws SQLException, ClassNotFoundException 
	{
		String sql = "DELETE FROM paciente WHERE PacienteId = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, p.getPacienteId());
		
		ps.execute();
		ps.close();
		
		
	}

	@Override
	public Paciente buscaPaciente(Paciente p) throws SQLException 
	{
		String sql = "SELECT * FROM paciente WHERE PacienteId = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, p.getPacienteId());
		
		int cont = 0;
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			p.setPacienteNome(rs.getString("PacienteNome"));
			cont++;
		}
		
		if(cont == 0)
		{
			p = new Paciente();
		}
		
		rs.close();
		ps.close();
		return p;
	}

	@Override
	public List<Paciente> buscaPacientes() throws SQLException 
	{
		String sql = "SELECT PacienteId, PacienteNome FROM paciente";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Paciente> listaPacientes = new ArrayList<Paciente>();
		
		while (rs.next())
		{
			Paciente p = new Paciente();
			p.setPacienteId(rs.getInt("PacienteId"));
			p.setPacienteNome(rs.getString("PacienteNome"));
			
			listaPacientes.add(p);
		}
	
		return listaPacientes;
	}

}
