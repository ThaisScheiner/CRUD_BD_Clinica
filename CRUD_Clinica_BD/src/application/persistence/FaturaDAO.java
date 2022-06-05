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
		String sql = "INSERT INTO fatura (FatId, FatNome, FatDescricao, FatValor)";
		sql += "VALUES ('" + f.getFatId() + "', ";
		sql += " '" + f.getFatNome() + "', ";
		sql += " '" + f.getFatDescricao() + "', ";
		sql += " '" + f.getFatValor() + "') ";
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
		String sql = "UPDDATE fatura SET fatNome = ?, fatDescricao = ?, fatValor = ? WHERE codigo = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		
		ps.setInt(1, f.getFatId());
		ps.setString(2, f.getFatNome());
		ps.setString(3, f.getFatDescricao());
		ps.setDouble(4, f.getFatValor());
		//ps.setInt(6, f.getFatIdPaciente());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluiFatura(Fatura f) throws SQLException 
	{
		String sql = "DELETE professor WHERE codigo = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, f.getFatId());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public Fatura buscaFatura(Fatura f) throws SQLException 
	{
		String sql = "SELECT fatId, fatNome, fatDescricao, fatValor FROM fatura WHERE fatId = ?";
		
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, f.getFatId());
		
		int cont = 0;
		ResultSet rs = ps.executeQuery();
		
		if(rs.next())
		{
			f.setFatNome(rs.getString("fatNome"));
			f.setFatDescricao(rs.getString("fatDescricao"));
			f.setFatValor(rs.getDouble("fatValor"));
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
		String sql = "SELECT fatId, fatNome, fatDescricao, fatValor FROM fatura";
		
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
			
			listaFaturas.add(f);
		}
	
		return listaFaturas;
	}
}
