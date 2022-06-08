package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Medico;
import application.persistence.MedicoDAO;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class MedicoController implements IMedicoController
{
	private TextField txtIdMedico;
	private TextField txtNomeMedico;
	private TextField txtCrmMedico;
	private TextField txtLogradouroMedico;
	private TextField txtNumeroMedico;
	private TextField txtCepMedico;
	private TextField txtBairroMedico;
	private TextField txtTelResMedico;
	private TextField txtTelCelMedico;
	private TextField txtEspecialidade;
	private TextArea ltMedicos;

	public MedicoController(TextField txtIdMedico, TextField txtNomeMedico, TextField txtCrmMedico, TextField txtLogradouroMedico,
			TextField txtNumeroMedico, TextField txtCepMedico, TextField txtBairroMedico, TextField txtTelResMedico, TextField txtTelCelMedico, TextField txtEspecialidade,
		    TextArea ltMedicos) {

		this.txtIdMedico = txtIdMedico;
		this.txtNomeMedico = txtNomeMedico;
		this.txtCrmMedico = txtCrmMedico;
		this.txtLogradouroMedico = txtLogradouroMedico;
		this.txtNumeroMedico = txtNumeroMedico;
		this.txtCepMedico = txtCepMedico;
		this.txtBairroMedico = txtBairroMedico;
		this.txtTelResMedico = txtTelResMedico;
		this.txtTelCelMedico = txtTelCelMedico;
		this.txtEspecialidade = txtEspecialidade;
		this.ltMedicos = ltMedicos;
	}

	public void inserirMedico(Medico m) throws ClassNotFoundException, SQLException  
	{
		MedicoDAO mDAO = new MedicoDAO();
		mDAO.cadastrarMedico(m);
		limpaCamposMedico();
		listarMedicos();
		
	}

	@Override
	public void atualizarMedico(Medico m) throws SQLException, ClassNotFoundException 
	{
		MedicoDAO mDAO = new MedicoDAO();
		mDAO.atualizarMedico(m);
		limpaCamposMedico();
		listarMedicos();
		
		
	}

	@Override
	public void excluirMedico(Medico m) throws SQLException, ClassNotFoundException 
	{
		MedicoDAO mDAO = new MedicoDAO();
		mDAO.excluiMedico(m);
		limpaCamposMedico();
		listarMedicos();
	}

	@Override
	public void buscaMedico(Medico m) throws SQLException, ClassNotFoundException 
	{
		limpaCamposMedico();
		
		MedicoDAO mDAO = new MedicoDAO();
		m = mDAO.buscaMedico(m);
		
		txtIdMedico.setText(String.valueOf(m.getIdMedico()));
		txtNomeMedico.setText(m.getNome());
		txtCrmMedico.setText(m.getCrm());
		txtLogradouroMedico.setText(m.getLogradouro());
		txtNumeroMedico.setText(m.getNumero());
		txtCepMedico.setText(m.getCep());
		txtBairroMedico.setText(m.getBairro());
		txtTelResMedico.setText(m.getTelefone_Residencial());
		txtTelCelMedico.setText(m.getTelefone_Celular());
		txtEspecialidade.setText(m.getEspecialidade());
		
		
	}
	@Override
	public void listarMedicos() throws ClassNotFoundException, SQLException {
		limpaCamposMedico();
		ltMedicos.setText("");

		MedicoDAO pDAO = new MedicoDAO();
		List<Medico> listarMedicos = pDAO.listaMedicos();

		StringBuffer buffer = new StringBuffer(
				"Id\t\t\t\tNome\t\tCrm\t\tLogradouro\t\tNumero\t\tCep\t\tBairro\t\tTelRes\t\tTelCel\t\tEspecialidade\n");
		for (Medico m : listarMedicos) {
			buffer.append(m.getIdMedico() + "\t\t" + m.getNome() + "\t\t" + m.getCrm() + "\t\t"
					+ m.getLogradouro() + "\t\t" + m.getNumero() + "\t\t" + m.getCep() + "\t\t"
					+ m.getBairro() + "\t\t" + m.getTelefone_Residencial() + "\t\t" + m.getTelefone_Celular() + "\t\t" + m.getEspecialidade() + "\n");
		}
		ltMedicos.setText(buffer.toString());
	}

	private void limpaCamposMedico() {
		txtIdMedico.setText("");
		txtNomeMedico.setText("");
		txtCrmMedico.setText("");
		txtLogradouroMedico.setText("");
		txtNumeroMedico.setText("");
		txtCepMedico.setText("");
		txtBairroMedico.setText("");
		txtTelResMedico.setText("");
		txtTelCelMedico.setText("");
		txtEspecialidade.setText("");

	}
}
