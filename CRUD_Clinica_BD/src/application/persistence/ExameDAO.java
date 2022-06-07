package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Exame;

public class ExameDAO implements IExameDAO
{

	private Connection c;
	
	public ExameDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		c = gDAO.getConnection();
	}
	
	@Override
	public void insereExame(Exame e) throws SQLException, ClassNotFoundException {
		String sql = "INSERT INTO exame (ExaId, ExaNome, ExaDescricao, ExaIdPaciente )";
		sql += " VALUES ('" + e.getExaId() + "', ";
		sql += " '" + e.getExaNome() + "', ";
		sql += " '" + e.getExaDescricao() + "', ";
		sql += " '" + e.getExaIdPaciente() + "') ";

		System.out.println("Query preparada: " + sql);
		try 
		{
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.executeUpdate();
		} 
		catch (SQLException s) 
		{
			s.printStackTrace();
		}
		
		
	}

	@Override
	public void atualizarExame(Exame e) throws SQLException, ClassNotFoundException {
		String sql = "UPDATE exame SET ExaNome = ?, ExaDescricao = ?, ExaIdPaciente = ? WHERE ExaId = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, e.getExaNome());
		ps.setString(2, e.getExaDescricao());
		ps.setInt(3, e.getExaId());
		ps.setInt(4, e.getExaIdPaciente());
		
		ps.execute();
		ps.close();
		
		
	}

	@Override
	public void excluiExame(Exame e) throws SQLException, ClassNotFoundException {
		String sql = "DELETE FROM exame WHERE ExaId = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, e.getExaId());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public Exame buscaExame(Exame e) throws SQLException 
	{
		String sql = "SELECT ExaId, ExaNome, ExaDescricao, ExaIdPaciente FROM exame WHERE ExaId = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, e.getExaId());
		
		int cont = 0;
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			e.setExaNome(rs.getString("ExaNome"));
			e.setExaDescricao(rs.getString("ExaDescricao"));
			e.setExaIdPaciente(rs.getInt("ExaIdPaciente"));
			cont++;
		}
		
		if(cont == 0)
		{
			e = new Exame();
		}
		
		rs.close();
		ps.close();
		return e;
	}

	@Override
	public List<Exame> buscaExames() throws SQLException {
		String sql = "SELECT ExaId, ExaNome, ExaDescricao, ExaIdPaciente FROM exame ";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Exame> listaExames = new ArrayList<Exame>();
		
		while (rs.next())
		{
			Exame e = new Exame();
			e.setExaId(rs.getInt("ExaId"));
			e.setExaNome(rs.getString("ExaNome"));
			e.setExaDescricao(rs.getString("ExaDescricao"));
			e.setExaIdPaciente(rs.getInt("ExaIdPaciente"));
			
			listaExames.add(e);
		}
	
		return listaExames;
	}
	
	
}
