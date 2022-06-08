package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Fatura;
import application.model.Medico;
import application.model.Paciente;
import application.persistence.FaturaDAO;
import application.persistence.PacienteDAO;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PacienteController implements IPacienteController
{
	private TextField txtId;
	private TextField txtNome;
	private TextField txtCpf;
	private TextField txtLogradouro;
	private TextField txtNumero;
	private TextField txtCep;
	private TextField txtBairro;
	private TextField txtTelRes;
	private TextField txtTelCel;
	private TextField txtEmail;
	private TextField txtSexo;
	private TextField txtIDMedico;
	private TextArea ltPaciente;

	public PacienteController(TextField txtId, TextField txtNome, TextField txtCpf, TextField txtLogradouro,
			TextField txtNumero, TextField txtCep, TextField txtBairro, TextField txtTelRes, TextField txtTelCel,
			TextField txtEmail, TextField txtSexo, TextArea ltPaciente) {

		this.txtId = txtId;
		this.txtNome = txtNome;
		this.txtCpf = txtCpf;
		this.txtLogradouro = txtLogradouro;
		this.txtNumero = txtNumero;
		this.txtCep = txtCep;
		this.txtBairro = txtBairro;
		this.txtTelRes = txtTelRes;
		this.txtTelCel = txtTelCel;
		this.txtEmail = txtEmail;
		this.txtSexo = txtSexo;
		this.ltPaciente = ltPaciente;
	}

	public void inserirPaciente(Paciente p) throws ClassNotFoundException, SQLException  
	{
		PacienteDAO pDAO = new PacienteDAO();
		pDAO.inserirPaciente(p);
		limpaCamposPaciente();
		listarPacientes();
		
	}

	@Override
	public void atualizarPaciente(Paciente p) throws SQLException, ClassNotFoundException 
	{
		PacienteDAO pDAO = new PacienteDAO();
		pDAO.atualizarPaciente(p);
		limpaCamposPaciente();
		listarPacientes();
		
		
	}

	@Override
	public void excluiPaciente(Paciente p) throws SQLException, ClassNotFoundException 
	{
		PacienteDAO pDAO = new PacienteDAO();
		pDAO.excluiPaciente(p);
		limpaCamposPaciente();
		listarPacientes();
	}

	@Override
	public void buscaPacientes(Paciente p) throws SQLException, ClassNotFoundException 
	{
		limpaCamposPaciente();
		
		PacienteDAO pDAO = new PacienteDAO();
		p = pDAO.buscaPaciente(p);
		
		txtId.setText(String.valueOf(p.getId()));
		txtNome.setText(p.getNome());
		txtCpf.setText(p.getCpf());
		txtLogradouro.setText(p.getLogradouro());
		txtNumero.setText(p.getNumero());
		txtCep.setText(p.getCep());
		txtBairro.setText(p.getBairro());
		txtTelRes.setText(p.getTelefone_residencial());
		txtTelCel.setText(p.getTelefone_celular());
		txtEmail.setText(p.getEmail());
		txtSexo.setText(p.getSexo());
		
		
	}
	@Override
	public void listarPacientes() throws ClassNotFoundException, SQLException {
		limpaCamposPaciente();
		ltPaciente.setText("");
		Medico m = new Medico();
		PacienteDAO pDAO = new PacienteDAO();
		List<Paciente> listarPacientes = pDAO.listaPacientes();

		StringBuffer buffer = new StringBuffer(
				"Id\t\t\t\tNome\t\tCpf\t\tLogradouro\t\tNumero\nCep\t\tBairro\t\tTelRes\t\tTelCel\t\tEmail\t\tSexo\t\tProfessor\n");
		for (Paciente p : listarPacientes) {
			buffer.append(p.getId() + "\t\t" + p.getNome() + "\t\t" + p.getCpf() + "\t\t"
					+ p.getLogradouro() + "\t\t" + p.getNumero() + "\n" + p.getCep() + "\t\t"
					+ p.getBairro() + "\t\t" + p.getTelefone_residencial() + "\t\t" + p.getTelefone_celular() + "\t\t"
					+ p.getEmail() + "\t\t" + p.getSexo() + "\t\t" + "\n");
		}
		ltPaciente.setText(buffer.toString());
	}

	private void limpaCamposPaciente() {
		txtId.setText("");
		txtNome.setText("");
		txtCpf.setText("");
		txtLogradouro.setText("");
		txtNumero.setText("");
		txtCep.setText("");
		txtBairro.setText("");
		txtTelRes.setText("");
		txtTelCel.setText("");
		txtEmail.setText("");
		txtSexo.setText("");

	}

	@Override
	public void inserePaciente(Paciente p) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}


	

}
