package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Medico;

public class MedicoDAO 
{
private Connection conn;
	
	public MedicoDAO() throws ClassNotFoundException, SQLException {
		GenericDAO cdb = new GenericDAO();
		
		conn = cdb.getConnection();
	}

	public void cadastrarMedico(Medico m) throws SQLException {
		String sql = "INSERT INTO medico VALUES (?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, m.getId());
		ps.setString(2, m.getNome());
		ps.setString(3, m.getCrm());
		ps.setString(4, m.getLogradouro());
		ps.setString(5, m.getNumero());
		ps.setString(6, m.getCep());
		ps.setString(7, m.getBairro());
		ps.setString(8, m.getTelRes());
		ps.setString(9, m.getTelCel());
		ps.setString(10, m.getEspecialidade());
		
		ps.execute();
		ps.close();
		

	}

	public void atualizarMedico(Medico m) throws SQLException {
	String sql = "UPDATE medico SET nome = ?, crm = ?, logradouro = ?, numero = ?, cep = ?,bairro = ?,telres = ?, telcel = ?, especialidade = ? WHERE IdMedico = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		ps.setString(1, m.getNome());
		ps.setString(2, m.getCrm());
		ps.setString(3, m.getLogradouro());
		ps.setString(4, m.getNumero());
		ps.setString(5, m.getCep());
		ps.setString(6, m.getBairro());
		ps.setString(7, m.getTelRes());
		ps.setString(8, m.getTelCel());
		ps.setString(10, m.getEspecialidade());
		ps.setInt(11, m.getId());
		
		ps.execute();
		ps.close();
		
	}

	public void excluiMedico(Medico m) throws SQLException {
		String sql = "DELETE FROM medico WHERE IdMedico = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, m.getId());
		
		ps.execute();
		ps.close();
	}

	public Medico buscaMedico(Medico m) throws SQLException {
		String sql = "SELECT IdMedico, nome, crm,logradouro, numero, cep, bairro, telres, telcel, especialidade FROM medico WHERE IdMedico = ?";
		
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1, m.getId());	
	
	int cont = 0;
	ResultSet rs = ps.executeQuery();
	
	if(rs.next()) {	

		m.setId(rs.getInt("IdMedico"));
		m.setNome(rs.getString("nome"));
		m.setCrm(rs.getString("crm"));
		m.setLogradouro(rs.getString("logradouro"));
		m.setNumero(rs.getString("numero"));
		m.setCep(rs.getString("cep"));
		m.setBairro(rs.getString("bairro"));
		m.setTelRes(rs.getString("telres"));
		m.setTelCel(rs.getString("telcel"));
		m.setEspecialidade(rs.getString("especialidade"));
		cont++;
	}
	
	if(cont == 0) {
		m = new Medico();
	}
		rs.close();
		ps.close();
		return m;
	}
	
	public List<Medico> listaMedicos() throws SQLException {
String sql = "select IdMedico,nome, crm, logradouro, numero, cep, bairro,telres, telcel, especialidade FROM medico";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Medico> listaMedicos = new ArrayList<Medico>();
		
		while (rs.next())
		{
			Medico m = new Medico();	
			m.setId(rs.getInt("IdMedico"));
			m.setNome(rs.getString("nome"));
			m.setCrm(rs.getString("crm"));
			m.setLogradouro(rs.getString("logradouro"));
			m.setNumero(rs.getString("numero"));
			m.setCep(rs.getString("cep"));
			m.setBairro(rs.getString("bairro"));
			m.setTelRes(rs.getString("telres"));
			m.setTelCel(rs.getString("telcel"));
			m.setEspecialidade(rs.getString("especialidade"));
			listaMedicos.add(m);
		}
	
		return listaMedicos;
	}
}
