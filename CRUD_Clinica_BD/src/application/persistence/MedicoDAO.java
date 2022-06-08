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
		ps.setInt(1, m.getIdMedico());
		ps.setString(2, m.getNome());
		ps.setString(3, m.getCrm());
		ps.setString(4, m.getLogradouro());
		ps.setString(5, m.getNumero());
		ps.setString(6, m.getCep());
		ps.setString(7, m.getBairro());
		ps.setString(8, m.getTelefone_Residencial());
		ps.setString(9, m.getTelefone_Celular());
		ps.setString(10, m.getEspecialidade());
		
		ps.execute();
		ps.close();
		

	}

	public void atualizarMedico(Medico m) throws SQLException {
	String sql = "UPDATE Medico SET crm = ?, nome = ?, logradouro = ?, Numero = ?, cep = ?,bairro = ?,telefone_Residencial = ?, telefone_Celular = ?, especialidade = ? WHERE IdMedico = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, m.getCrm());
		ps.setString(2, m.getNome());
		ps.setString(3, m.getLogradouro());
		ps.setString(4, m.getNumero());
		ps.setString(5, m.getCep());
		ps.setString(6, m.getBairro());
		ps.setString(7, m.getTelefone_Residencial());
		ps.setString(8, m.getTelefone_Celular());
		ps.setString(10, m.getEspecialidade());
		ps.setInt(11, m.getIdMedico());
		
		ps.execute();
		ps.close();
		
	}

	public void excluiMedico(Medico m) throws SQLException {
		String sql = "DELETE FROM medico WHERE IdMedico = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, m.getIdMedico());
		
		ps.execute();
		ps.close();
	}

	public Medico buscaMedico(Medico m) throws SQLException {
		String sql = "SELECT IdMedico, crm, nome,logradouro, Numero, cep, bairro, telefone_Residencial, telefone_Celular, especialidade FROM medico WHERE IdMedico = ?";
		
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1, m.getIdMedico());	
	
	int cont = 0;
	ResultSet rs = ps.executeQuery();
	
	if(rs.next()) {	

		m.setIdMedico(rs.getInt("IdMedico"));
		m.setCrm(rs.getString("crm"));
		m.setNome(rs.getString("nome"));
		m.setLogradouro(rs.getString("logradouro"));
		m.setNumero(rs.getString("numero"));
		m.setCep(rs.getString("cep"));
		m.setBairro(rs.getString("bairro"));
		m.setTelefone_Residencial(rs.getString("telefone_Residencial"));
		m.setTelefone_Celular(rs.getString("telefone_Celular"));
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
String sql = "select IdMedico,crm, nome, logradouro, Numero, cep, bairro,telefone_Residencial, telefone_Celular, especialidade FROM medico";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ResultSet rs = ps.executeQuery();
		
		List<Medico> listaMedicos = new ArrayList<Medico>();
		
		while (rs.next())
		{
			Medico m = new Medico();	
			
			m.setIdMedico(rs.getInt("IdMedico"));
			m.setCrm(rs.getString("crm"));
			m.setNome(rs.getString("nome"));
			m.setLogradouro(rs.getString("logradouro"));
			m.setNumero(rs.getString("Numero"));
			m.setCep(rs.getString("cep"));
			m.setBairro(rs.getString("Bairro"));
			m.setTelefone_Residencial(rs.getString("Telefone_Residencial"));
			m.setTelefone_Celular(rs.getString("Telefone_Celular"));
			m.setEspecialidade(rs.getString("Especialidade"));
			listaMedicos.add(m);
		}
	
		return listaMedicos;
	}
}
