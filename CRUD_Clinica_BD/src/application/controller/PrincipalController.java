package application.controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import application.model.Consulta;
import application.model.Exame;
import application.model.Fatura;
import application.model.Medico;
import application.model.Paciente;
import javafx.event.ActionEvent;

import javafx.scene.control.TextArea;

public class PrincipalController {
	@FXML
	private TextArea taListarFatura;
	@FXML
	private Button btnInserirFatura;
	@FXML
	private Button btnAtualizarFatura;
	@FXML
	private Button btnExcluirFatura;
	@FXML
	private Button btnListarFatura;
	@FXML
	private TextField txtFatCodigo;
	@FXML
	private TextField txtFatNome;
	@FXML
	private TextField txtFatDescricao;
	@FXML
	private Button btnBuscarFatura;
	@FXML
	private TextField txtFatValor;
	@FXML
	private TextField txtFatIdPaciente;
	@FXML
	private Label lblFatNomePaciente;    
	@FXML
	private Label lblPacCodigoExame;
	@FXML
	private TextField txtPacCodigoExame;
	@FXML
	private TextArea taListarExame;
	@FXML
	private Button btnInserirExame;
	@FXML
	private Button btnAtualizarExame;
	@FXML
	private Button btnExcluirExame;
	@FXML
	private Button btnListarExame;
	@FXML
	private TextField txtExaCodigo;
	@FXML
	private TextField txtExaNome;
	@FXML
	private TextField txtExaDescricao;
	@FXML
	private Button btnBuscarExame;
	@FXML
	private Button btnInserirPaciente;
	@FXML
	private Button btnAtualizarPaciente;
	@FXML
	private Button btnExcluirPaciente;
	@FXML
	private Button btnListarPaciente;
	@FXML
	private Button btnBuscarPaciente;
	@FXML
	private TextField txtPacCodigo;
	@FXML
	private TextField txtPacNome;
	@FXML
	private TextArea taListarPaciente;
	@FXML
	private TextField txtEspecialidade;
	@FXML
	private TextField txtIdMedico;
	@FXML
	private TextField txtNomeMedico;
	@FXML
	private TextField txtCrmMedico;
	@FXML
	private TextField txtLogradouroMedico;
	@FXML
	private TextField txtNumeroMedico;
	@FXML
	private TextField txtCepMedico;
	@FXML
	private TextField txtBairroMedico;
	@FXML
	private TextField txtTelResMedico;
	@FXML
	private TextField txtTelCelMedico;
	@FXML
	private Button btnInserirMedico;
	@FXML
	private Button btnAtualizarMedico;
	@FXML
	private Button btnExcluirMedico;
	@FXML
	private Button btnListarMedico;
	@FXML
	private Button btnBuscarMedico;
	@FXML
	private TextField txtId;
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtCpf;
	@FXML
	private TextField txtLogradouro;
	@FXML
	private TextField txtNumero;
	@FXML
	private TextField txtCep;
	@FXML
	private TextField txtBairro;
	@FXML
	private TextField txtTelRes;
	@FXML
	private TextField txtTelCel;
	@FXML
	private TextField txtEmail;
	@FXML
	private TextField txtSexo;
	@FXML
	private Button btnListarPacientes;
	@FXML
	private Button btnCopiarMedico;
	@FXML
	private TextArea ltPacientes;
	@FXML
	private TextArea ltMedicos;
	@FXML
	private Label lblNomeMedico;
	@FXML
	private TextField txtIDMedico;
	@FXML
	private TextField tfCodigoConsulta;
	@FXML
	private TextField tfNomeConsulta;
	@FXML
	private TextField tfDataConsulta;
	@FXML
	private TextField tfIDExame;
	@FXML
	private TextField tfIDMedico;
	@FXML
	private Button btnBuscarConsulta;
	@FXML
	private Button btnInserirConsulta;
	@FXML
	private Button btnAtualizarConsulta;
	@FXML
	private Button btnExcluirConsulta;
	@FXML
	private Button btnListarConsulta;
	@FXML
	private TextArea taListaConsultas;
	@FXML
	private Button btnCopiaConsulta;
	

	// Event Listener on TextField[#txtFatNomePaciente].onAction
	@FXML
	public void acaoFatura(ActionEvent event) 
	{
		String cmd = event.getSource().toString();
		System.out.println(cmd);

		FaturaController faturaController = new FaturaController(txtFatCodigo, txtFatNome, txtFatDescricao, txtFatValor,
				txtFatIdPaciente, taListarFatura);

		if ((cmd.contains("Inserir") || cmd.contains("Atualizar")) && (txtFatCodigo.getText().isEmpty()
				|| txtFatNome.getText().isEmpty() || txtFatDescricao.getText().isEmpty()
				|| txtFatValor.getText().isEmpty() || txtFatIdPaciente.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Preencha o c�digo da Fatura", "ERRO", JOptionPane.ERROR_MESSAGE);
		} else {
			if ((cmd.contains("Excluir") || cmd.contains("Buscar")) && (txtFatCodigo.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha o c�digo da Fatura", "ERRO", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					if (cmd.contains("Listar")) {
						faturaController.buscaFaturas();
					} else {
						Fatura f = new Fatura();
						f.setFatId((Integer.parseInt(txtFatCodigo.getText())));
						f.setFatNome(txtFatNome.getText());
						f.setFatDescricao(txtFatDescricao.getText());
						f.setFatValor(Double.valueOf(txtFatValor.getText()));
						;
						f.setFatIdPaciente((Integer.parseInt(txtFatIdPaciente.getText())));

						if (cmd.contains("Inserir")) {
							faturaController.insereFatura(f);
							JOptionPane.showMessageDialog(null, "Fatura inserida com sucesso");
						} else if (cmd.contains("Atualizar")) {
							faturaController.atualizarFatura(f);
							JOptionPane.showMessageDialog(null, "Fatura atualizada com sucesso");
						} else if (cmd.contains("Excluir")) {
							faturaController.excluiFatura(f);
							JOptionPane.showMessageDialog(null, "Fatura excluida com sucesso");
						} else if (cmd.contains("Buscar") || cmd.contains("txtFatId")) {
							faturaController.buscaFatura(f);
						}
					}
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		}
		
	}
	
	// Event Listener on Button[#btnBuscarMedico].onAction
		@FXML
		public void acaoMedico(ActionEvent event) {
			String cmd = event.getSource().toString();
			System.out.println(cmd);

			MedicoController medicoController = new MedicoController(txtIdMedico, txtNomeMedico, txtCrmMedico, txtLogradouroMedico, txtNumeroMedico,
					txtCepMedico, txtBairroMedico, txtTelResMedico, txtTelCelMedico, txtEspecialidade, ltMedicos);

			if ((cmd.contains("btnInserirMedico") || cmd.contains("btnAtualizarMedico")) && (txtIdMedico.getText().isEmpty()
					|| txtNomeMedico.getText().isEmpty() || txtCrmMedico.getText().isEmpty() || txtLogradouroMedico.getText().isEmpty()
					|| txtNumeroMedico.getText().isEmpty() || txtCepMedico.getText().isEmpty() || txtBairroMedico.getText().isEmpty()
					|| txtTelResMedico.getText().isEmpty() || txtTelCelMedico.getText().isEmpty() || txtEspecialidade.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha o todos os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
			} else {
				if ((cmd.contains("btnExcluirMedico") || cmd.contains("btnBuscarMedico")) && (txtIdMedico.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Preencha o ID do medico", "ERRO", JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						if (cmd.contains("Listar")) {
							medicoController.listarMedicos();
						} else {
							Medico m = new Medico();
							m.setIdMedico(Integer.parseInt(txtIdMedico.getText()));
							m.setNome(txtNomeMedico.getText());
							m.setCrm(txtCrmMedico.getText());
							m.setLogradouro(txtLogradouroMedico.getText());
							m.setNumero(txtNumeroMedico.getText());
							m.setCep(txtCepMedico.getText());
							m.setBairro(txtBairroMedico.getText());
							m.setTelefone_Residencial(txtTelRes.getText());
							m.setTelefone_Celular(txtTelCelMedico.getText());
							m.setEspecialidade(txtEspecialidade.getText());

							if (cmd.contains("btnInserirMedico")) 
							{
								medicoController.inserirMedico(m);
								JOptionPane.showMessageDialog(null, "M�dico inserido com sucesso");
							} 
							else if (cmd.contains("btnAtualizarMedico"))
							{
								medicoController.atualizarMedico(m);
								JOptionPane.showMessageDialog(null, "M�dico atualizado com sucesso");
							} 
							else if (cmd.contains("btnExcluirMedico"))
							{
								medicoController.excluirMedico(m);
								JOptionPane.showMessageDialog(null, "M�dico excluido com sucesso");
							} 
							else if (cmd.contains("btnBuscarMedico") || cmd.contains("txtIdMedico")) {
								medicoController.buscaMedico(m);
							}
						}
					} catch (ClassNotFoundException | SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();
					}

				}
			}
		}
		
		
		// Event Listener on Button[#btnCopiarPaciente].onAction
		@FXML
		public void copiaMedico(ActionEvent event) 
		{
			 if (txtIdMedico.getText().isEmpty() || txtIdMedico.getText().isEmpty()) 
			 {
		            JOptionPane.showMessageDialog(null, "Preencha os campos", "Erro", JOptionPane.ERROR_MESSAGE);
		     } 
			 else 
			 {
		            txtFatIdPaciente.setText(txtIdMedico.getText());
		            lblFatNomePaciente.setText(txtIdMedico.getText());

		            txtIDMedico.setText(txtIdMedico.getText());
		            lblNomeMedico.setText(txtNomeMedico.getText());
		     }
		}
	
	// Event Listener on Button[#btnInserirExame].onAction
	@FXML
	public void acaoExame(ActionEvent event) 
	{
		String cmd = event.getSource().toString();
		System.out.println(cmd);
		
		ExameController exameController = new ExameController (txtExaCodigo, txtExaNome, txtExaDescricao, taListarExame);
		
		if((cmd.contains("Inserir") || cmd.contains("Atualizar")) && (txtExaCodigo.getText().isEmpty() && txtExaNome.getText().isEmpty() || txtExaDescricao.getText().isEmpty()))
		{
			JOptionPane.showMessageDialog(null, "Preencha o c�digo do Exame", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		else 
		{
			if(cmd.contains("Excluir") && cmd.contains("Buscar") && cmd.contains("txtExaCodigo") || txtExaCodigo.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Preencha o c�digo do Exame", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				try 
				{
					if(cmd.contains("Listar"))
					{
						exameController.buscaExames();
					}
					else
					{
						Exame e = new Exame();
						e.setExaId((Integer.parseInt(txtExaCodigo.getText())));
						e.setExaNome(txtExaNome.getText());
						e.setExaDescricao(txtExaDescricao.getText());
						//f.setFatIdPaciente((Integer.parseInt(txtFatData.getText())));
						
						if(cmd.contains("Inserir"))
						{
							exameController.insereExame(e);
							JOptionPane.showMessageDialog(null, "Exame inserido com sucesso");
						}
						else if(cmd.contains("Atualizar"))
						{
							exameController.atualizarExame(e);
							JOptionPane.showMessageDialog(null, "Exame atualizado com sucesso");
						}
						else if(cmd.contains("Excluir"))
						{
							exameController.excluiExame(e);
							JOptionPane.showMessageDialog(null, "Exame excluido com sucesso");
						}
						else if(cmd.contains("Buscar") || cmd.contains("txtExaCodigo"))
						{
							exameController.buscaExame(e);
						}
					}
				} 
				catch (ClassNotFoundException | SQLException e) 
				{
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	@FXML
	public void acaoPaciente(ActionEvent event) {
		String cmd = event.getSource().toString();
		System.out.println(cmd);

		PacienteController pacienteController = new PacienteController(txtId, txtNome, txtCpf, txtLogradouro, txtNumero,
				txtCep, txtBairro, txtTelRes, txtTelCel, txtEmail, txtSexo, ltPacientes);

		if ((cmd.contains("Inserir") || cmd.contains("Atualizar")) && (txtId.getText().isEmpty()
				|| txtNome.getText().isEmpty() || txtCpf.getText().isEmpty() || txtLogradouro.getText().isEmpty()
				|| txtNumero.getText().isEmpty() || txtCep.getText().isEmpty() || txtBairro.getText().isEmpty()
				|| txtTelRes.getText().isEmpty() || txtTelCel.getText().isEmpty() || txtEmail.getText().isEmpty()
				|| txtSexo.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Preencha o todos os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
		} else {
			if ((cmd.contains("Excluir") || cmd.contains("Buscar")) && (txtId.getText().isEmpty())) {
				JOptionPane.showMessageDialog(null, "Preencha o ID do Paciente", "ERRO", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					if (cmd.contains("Listar")) {
						pacienteController.listarPacientes();
					} else {
						Paciente p = new Paciente();
						p.setId((Integer.parseInt(txtId.getText())));
						p.setNome(txtNome.getText());
						p.setCpf(txtCpf.getText());
						p.setLogradouro(txtLogradouro.getText());
						p.setNumero(txtNumero.getText());
						p.setCep(txtCep.getText());
						p.setBairro(txtBairro.getText());
						p.setTelefone_residencial(txtTelRes.getText());
						p.setTelefone_celular(txtTelCel.getText());
						p.setEmail(txtEmail.getText());
						p.setSexo(txtSexo.getText());
						p.setPacIdMedico((Integer.parseInt(txtIdMedico.getText())));

						if (cmd.contains("Inserir")) 
						{
							pacienteController.inserirPaciente(p);
							JOptionPane.showMessageDialog(null, "Paciente inserido com sucesso");
						} 
						else if (cmd.contains("Atualizar"))
						{
							pacienteController.atualizarPaciente(p);
							JOptionPane.showMessageDialog(null, "Paciente atualizado com sucesso");
						}
						else if (cmd.contains("Excluir")) 
						{
							pacienteController.excluiPaciente(p);
							JOptionPane.showMessageDialog(null, "Paciente excluido com sucesso");
						}
						else if (cmd.contains("Buscar") || cmd.contains("txtId")) {
							pacienteController.buscaPacientes(p);
						}
					}
				} catch (ClassNotFoundException | SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				}

			}
		}
	}
	
	// Event Listener on TextField[#tfCodigoConsulta].onAction
		@FXML
		public void acaoConsulta(ActionEvent event) {
			String cmd = event.getSource().toString();
			ConsultaController control = new ConsultaController(tfCodigoConsulta, tfNomeConsulta, tfDataConsulta,
					           tfIDExame, tfIDMedico, taListaConsultas);	
			
			if ((cmd.contains("Inserir")|| cmd.contains("Atualizar"))
			&& (tfCodigoConsulta.getText().isEmpty())
			|| tfNomeConsulta.getText().isEmpty()
			|| tfDataConsulta.getText().isEmpty()
			|| tfIDExame.getText().isEmpty()
			|| tfIDMedico.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
			} else {
				if (cmd.contains("Excluir") || cmd.contains("Buscar") || cmd.contains("tfCodigoConsulta")
					&& tfCodigoConsulta.getText().isEmpty()){
						JOptionPane.showMessageDialog(null, "Preencha o c�digo", "ERRO", JOptionPane.ERROR_MESSAGE);
					} else
						try {
							if(cmd.contains("Listar")){
							control.buscarConsultas();		
						} else {
							Consulta c = new Consulta();
							c.setConsID(Integer.parseInt(tfCodigoConsulta.getText()));
							c.setConsNome(tfNomeConsulta.getText());
							c.setConsIdExame(Integer.parseInt(tfIDExame.getText()));
							c.setConsIdMedico(Integer.parseInt(tfIDMedico.getText()));
							if (cmd.contains("Inserir")) {
								control.inserirConsulta(c);
							} else if (cmd.contains("Atualizar")) {
								control.atualizarConsulta(c);
							} else if (cmd.contains("Excluir")) {
								control.excluirConsulta(c);
							} else if (cmd.contains("Buscar") || cmd.contains("tfCodigoConsulta")) {
								control.buscarConsulta(c);
							}
						}
			} catch (ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			}
		}
		
		@FXML
		public void copiaConsulta(ActionEvent event) {
			if (tfCodigoConsulta.getText().isEmpty() || tfNomeConsulta.getText().isEmpty()){
				JOptionPane.showMessageDialog(null, "Preencha os campos", "ERRO", JOptionPane.ERROR_MESSAGE);
			} else {
				tfCodigoConsulta.setText(tfCodigoConsulta.getText());
				tfNomeConsulta.setText(tfNomeConsulta.getText());
			}
			
		}
	
	@FXML
	public void copiaPaciente(ActionEvent event) 
	{
		if(txtPacCodigo.getText().isEmpty() || txtPacCodigo.getText().isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Preencha os campos", "Erro", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			txtFatIdPaciente.setText(txtPacCodigo.getText());
			lblFatNomePaciente.setText(txtPacNome.getText());
			
			txtPacCodigoExame.setText(txtPacCodigo.getText());
			lblPacCodigoExame.setText(txtPacNome.getText());
			
			
		}
		
	}
	
	
	
}
