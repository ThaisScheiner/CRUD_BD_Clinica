package application.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.model.Fatura;
import application.model.Medico;
import application.model.Paciente;

public class PacienteDAO implements IPacienteDAO
{
private Connection conn;
	
	public PacienteDAO() throws ClassNotFoundException, SQLException {
		GenericDAO cdb = new GenericDAO();
		
		conn = cdb.getConnection();
	}

	@Override
	public void inserirPaciente(Paciente p) throws SQLException {
		String sql = "INSERT INTO paciente VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, p.getId());
		ps.setString(2, p.getNome());
		ps.setString(3, p.getCpf());
		ps.setString(4, p.getLogradouro());
		ps.setString(5, p.getNumero());
		ps.setString(6, p.getCep());
		ps.setString(7, p.getBairro());
		ps.setString(8, p.getTelRes());
		ps.setString(9, p.getTelCel());
		ps.setString(10, p.getEmail());
		ps.setString(11, p.getSexo());
		
		ps.execute();
		ps.close();
		

	}

	@Override
	public void atualizarPaciente(Paciente p) throws SQLException {
	String sql = "UPDATE paciente SET nome = ?, cpf = ?, logradouro = ?, numero = ?, cep = ?,bairro = ?,telres = ?, telcel = ?, email = ?, sexo = ? WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		
		ps.setString(1, p.getNome());
		ps.setString(2, p.getCpf());
		ps.setString(3, p.getLogradouro());
		ps.setString(4, p.getNumero());
		ps.setString(5, p.getCep());
		ps.setString(6, p.getBairro());
		ps.setString(7, p.getTelRes());
		ps.setString(8, p.getTelCel());
		ps.setString(9, p.getEmail());
		ps.setString(10, p.getSexo());
		ps.setInt(11, p.getId());
		
		ps.execute();
		ps.close();
		
	}

	@Override
	public void excluiPaciente(Paciente p) throws SQLException {
		String sql = "DELETE FROM paciente WHERE id = ?";
		
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setInt(1, p.getId());
		
		ps.execute();
		ps.close();
	}

	@Override
	public Paciente buscaPaciente(Paciente p) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT p.id AS idPaciente,"
				+ " p.nome AS nomePaciente,"
				+ " p.cpf As cpfPaciente,"
				+ " p.logradouro AS logradouroPaciente,"
				+ " p.numero AS numeroPaciente,"
				+ " p.cep AS cepPaciente,"
				+ " p.bairro AS bairroPaciente,"
				+ " p.telres AS telresPaciente,"
				+ " p.telcel AS telcelPaciente,"
				+ " p.email AS emailPaciente,"
				+ " p.sexo AS sexoPaciente");
		sql.append("SELECT IdMedico,"
				+ " m.nome AS nomeMedico,"
				+ " m.crm AS crmMedico,"
				+ " m.logradouro AS logradouroMedico,"
				+ " m.numero AS numeroMedico,"
				+ " m.cep AS cepMedico,"
				+ " m.bairro AS bairroMedico,"
				+ " m.telres AS telresMedico,"
				+ " m.telcel AS telcelMedico,"
				+ " m.especialidade AS especialidadeMedico");
		sql.append("FROM paciente p INNER JOIN medico m");
		sql.append("ON p.IdMedico = m.IdMedico");
		sql.append("WHERE p.Id = ?");
	PreparedStatement ps = conn.prepareStatement(sql.toString());
	ps.setInt(1, p.getId());	
	
	int cont = 0;
	ResultSet rs = ps.executeQuery();
	
	if(rs.next()) {	
		
		Medico m = new Medico();
		
		m.setIdMedico(rs.getInt("IdMedico"));
		m.setNome(rs.getString("nome"));
		m.setCrm(rs.getString("crm"));
		m.setLogradouro(rs.getString("logradouro"));
		m.setNumero(rs.getString("numero"));
		m.setCep(rs.getString("cep"));
		m.setBairro(rs.getString("bairro"));
		m.setTelefone_Residencial(rs.getString("telefone_Residencial"));
		m.setTelefone_Celular(rs.getString("telefone_Celular"));
		m.setEspecialidade(rs.getString("especialidade"));
		
		
		p.setId(rs.getInt("id"));
		p.setNome(rs.getString("nome"));
		p.setCpf(rs.getString("cpf"));
		p.setLogradouro(rs.getString("logradouro"));
		p.setNumero(rs.getString("numero"));
		p.setCep(rs.getString("cep"));
		p.setBairro(rs.getString("bairro"));
		p.setTelRes(rs.getString("telres"));
		p.setTelCel(rs.getString("telcel"));
		p.setEmail(rs.getString("email"));
		p.setSexo(rs.getString("sexo"));
		p.setMedico(m);
		cont++;
	}
	
	if(cont == 0) {
		p = new Paciente();
		Medico m = new Medico();
		p.setMedico(m);
	}
		rs.close();
		ps.close();
		return p;
	}
	
	@Override
	public List<Paciente> listaPacientes() throws SQLException {
		List<Paciente> listaPacientes = new ArrayList<Paciente>();
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT p.id AS idPaciente,"
				+ " p.nome AS nomePaciente,"
				+ " p.cpf As cpfPaciente,"
				+ " p.logradouro AS logradouroPaciente,"
				+ " p.numero AS numeroPaciente,"
				+ " p.cep AS cepPaciente,"
				+ " p.bairro AS bairroPaciente,"
				+ " p.telres AS telresPaciente,"
				+ " p.telcel AS telcelPaciente,"
				+ " p.email AS emailPaciente,"
				+ " p.sexo AS sexoPaciente");
		sql.append("SELECT IdMedico,"
				+ " m.nome AS nomeMedico,"
				+ " m.crm AS crmMedico,"
				+ " m.logradouro AS logradouroMedico,"
				+ " m.numero AS numeroMedico,"
				+ " m.cep AS cepMedico,"
				+ " m.bairro AS bairroMedico,"
				+ " m.telres AS telresMedico,"
				+ " m.telcel AS telcelMedico,"
				+ " m.especialidade AS especialidadeMedico");
		sql.append("FROM paciente p INNER JOIN medico m");
		sql.append("ON p.IdMedico = m.IdMedico");
		
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		
		ResultSet rs = ps.executeQuery();
		
		
		
		while (rs.next())
		{
			Medico m = new Medico();
			
			m.setIdMedico(rs.getInt("IdMedico"));
			m.setNome(rs.getString("nome"));
			m.setCrm(rs.getString("crm"));
			m.setLogradouro(rs.getString("logradouro"));
			m.setNumero(rs.getString("numero"));
			m.setCep(rs.getString("cep"));
			m.setBairro(rs.getString("bairro"));
			m.setTelefone_Residencial(rs.getString("telefone_Residencial"));
			m.setTelefone_Celular(rs.getString("telefone_Celular"));
			m.setEspecialidade(rs.getString("especialidade"));
			
			Paciente p = new Paciente();	
			p.setId(rs.getInt("id"));
			p.setNome(rs.getString("nome"));
			p.setCpf(rs.getString("cpf"));
			p.setLogradouro(rs.getString("logradouro"));
			p.setNumero(rs.getString("numero"));
			p.setCep(rs.getString("cep"));
			p.setBairro(rs.getString("bairro"));
			p.setTelRes(rs.getString("telres"));
			p.setTelCel(rs.getString("telcel"));
			p.setEmail(rs.getString("email"));
			p.setSexo(rs.getString("sexo"));
			
			listaPacientes.add(p);
		}
	
		return listaPacientes;
	}

}
