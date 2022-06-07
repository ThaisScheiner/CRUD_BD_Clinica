package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Fatura;
import application.model.Paciente;
import application.persistence.FaturaDAO;
import application.persistence.PacienteDAO;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PacienteController implements IPacienteController
{
	private TextField txtPacCodigo;
	private TextField txtPacNome;
	private TextArea taListarPaciente;
	
	public PacienteController(TextField txtPacCodigo, TextField txtPacNome, TextArea taListarPaciente) 
	{
		this.txtPacCodigo = txtPacCodigo;
		this.txtPacNome = txtPacNome;
		this.taListarPaciente = taListarPaciente;
	}

	@Override
	public void inserePaciente(Paciente p) throws SQLException, ClassNotFoundException 
	{
		PacienteDAO pDAO = new PacienteDAO();
		pDAO.inserePaciente(p);
		LimpaCamposPaciente();
		buscaPacientes();
		
	}

	@Override
	public void atualizarPaciente(Paciente p) throws SQLException, ClassNotFoundException
	{
		PacienteDAO pDAO = new PacienteDAO();
		pDAO.atualizarPaciente(p);
		LimpaCamposPaciente();
		buscaPacientes();
		
	}

	@Override
	public void excluiPaciente(Paciente p) throws SQLException, ClassNotFoundException 
	{
		PacienteDAO pDAO = new PacienteDAO();
		pDAO.excluiPaciente(p);
		LimpaCamposPaciente();
		buscaPacientes();
	
	}

	@Override
	public void buscaPaciente(Paciente p) throws SQLException, ClassNotFoundException 
	{
		LimpaCamposPaciente();
		
		PacienteDAO pDAO = new PacienteDAO();
		p = pDAO.buscaPaciente(p);
		
		txtPacCodigo.setText(String.valueOf(p.getPacienteId()));
		txtPacNome.setText(p.getPacienteNome());
	}

	@Override
	public void buscaPacientes() throws ClassNotFoundException, SQLException 
	{
		LimpaCamposPaciente();
		taListarPaciente.setText("");
		
		PacienteDAO pDAO = new PacienteDAO();
		List<Paciente> listaPacientes = pDAO.buscaPacientes();
		
		StringBuffer buffer = new  StringBuffer("Código\t\t\t\t\t\t\tNome\n");
		for(Paciente p: listaPacientes)
		{
			buffer.append(p.getPacienteId()+"\t\t\t\t\t\t\t\t\t"+p.getPacienteNome() +"\n");
		}
		
		taListarPaciente.setText(buffer.toString());
		
	}
	
	private void LimpaCamposPaciente()
	{
		txtPacCodigo.setText("");
		txtPacNome.setText("");
	}

}
