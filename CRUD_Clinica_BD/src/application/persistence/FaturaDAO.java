package application.persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import application.model.Fatura;

public class FaturaDAO implements IFaturaDAO
{
private Connection c;
	
	public FaturaDAO() throws ClassNotFoundException, SQLException
	{
		GenericDAO gDAO = new GenericDAO();
		c = gDAO.getConnection();
	}
	
	@Override
	public void insereFatura(Fatura f) throws SQLException 
	{
		
		String sql = "INSERT INTO fatura (FatId, FatNome, FatDescricao, FatValor, FatIdPaciente)";
		sql += "VALUES ('" + f.getFatId() + "', ";
		sql += " '" + f.getFatNome() + "', ";
		sql += " '" + f.getFatDescricao() + "', ";
		sql += " '" + f.getFatValor() + "', ";
		sql += " '" + f.getFatIdPaciente() + "') ";
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
	public void atualizarFatura(Fatura f) throws SQLException 
	{
		String sql = "UPDATE fatura SET FatNome = ?, FatDescricao = ?, FatValor = ? WHERE FatId = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setString(1, f.getFatNome());
		ps.setString(2, f.getFatDescricao());
		ps.setDouble(3, f.getFatValor());
		ps.setInt(4, f.getFatId());
		//ps.setInt(6, f.getFatIdPaciente());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluiFatura(Fatura f) throws SQLException 
	{
		String sql = "DELETE FROM fatura WHERE FatId = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, f.getFatId());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public Fatura buscaFatura(Fatura f) throws SQLException 
	{
		String sql = "SELECT * FROM fatura WHERE FatId = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, f.getFatId());
		
		int cont = 0;
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			//f.setFatId(rs.getInt("FatId"));
			f.setFatNome(rs.getString("fatNome"));
			f.setFatDescricao(rs.getString("fatDescricao"));
			f.setFatValor(rs.getDouble("fatValor"));
			f.setFatIdPaciente(rs.getInt("fatIdPaciente"));
			cont++;
		}
		
		if(cont == 0)
		{
			f = new Fatura();
		}
		
		rs.close();
		ps.close();
		return f;
		
	}

	@Override
	public List<Fatura> buscaFaturas() throws SQLException
	{
		String sql = "SELECT fatId, fatNome, fatDescricao, fatValor, fatIdPaciente FROM fatura";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Fatura> listaFaturas = new ArrayList<Fatura>();
		
		while (rs.next())
		{
			Fatura f = new Fatura();
			f.setFatId(rs.getInt("fatId"));
			f.setFatNome(rs.getString("fatNome"));
			f.setFatDescricao(rs.getString("fatDescricao"));
			f.setFatValor(rs.getDouble("fatValor"));
			f.setFatIdPaciente(rs.getInt("fatIdPaciente"));
			
			listaFaturas.add(f);
		}
	
		return listaFaturas;
	}
}
