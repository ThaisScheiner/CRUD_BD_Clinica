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
		String sql = "INSERT INTO exame (ExameId, ExameNome, ExameDescricao)";
		sql += " VALUES ('" + e.getExameId() + "', ";
		sql += " '" + e.getExameNome() + "', ";
		sql += " '" + e.getExameDescricao() + "') ";

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
		String sql = "UPDATE exame SET ExameNome = ?, ExameDescricao = ? WHERE ExameId = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, e.getExameNome());
		ps.setString(2, e.getExameDescricao());
		ps.setInt(3, e.getExameId());
		//ps.setInt(6, f.getFatIdPaciente());
		
		ps.execute();
		ps.close();
		
		
	}

	@Override
	public void excluiExame(Exame e) throws SQLException, ClassNotFoundException {
		String sql = "DELETE exame WHERE ExameId = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, e.getExameId());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public Exame buscaExame(Exame e) throws SQLException 
	{
		String sql = "SELECT ExameId, ExameNome, ExameDescricao FROM exame WHERE ExameId = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, e.getExameId());
		
		int cont = 0;
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			e.setExameNome(rs.getString("ExameNome"));
			e.setExameDescricao(rs.getString("ExameDescricao"));
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
		String sql = "SELECT ExameId, ExameNome, ExameDescricao FROM exame ";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Exame> listaExames = new ArrayList<Exame>();
		
		while (rs.next())
		{
			Exame e = new Exame();
			e.setExameId(rs.getInt("ExameId"));
			e.setExameNome(rs.getString("ExameNome"));
			e.setExameDescricao(rs.getString("ExameDescricao"));
			
			listaExames.add(e);
		}
	
		return listaExames;
	}
	
	
}
