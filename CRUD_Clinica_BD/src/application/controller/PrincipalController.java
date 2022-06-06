package application.controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import application.model.Exame;
import application.model.Fatura;
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
	//@FXML
	//private TextField txtFatIdPaciente;
	//@FXML
	private Label lblFatNomePaciente;
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

	// Event Listener on TextField[#txtFatNomePaciente].onAction
	@FXML
	public void acaoFatura(ActionEvent event) 
	{
		String cmd = event.getSource().toString();
		System.out.println(cmd);
		
		FaturaController faturaController = new FaturaController (txtFatCodigo, txtFatNome, txtFatDescricao, txtFatValor,  taListarFatura);
		
		if((cmd.contains("Inserir") || cmd.contains("Atualizar")) && (txtFatCodigo.getText().isEmpty() || txtFatNome.getText().isEmpty() || txtFatDescricao.getText().isEmpty() || txtFatValor.getText().isEmpty()))
		{
			JOptionPane.showMessageDialog(null, "Preencha o código da Fatura", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		else 
		{
			if(cmd.contains("Excluir") || cmd.contains("Buscar") && cmd.contains("txtFatCodigo") && txtFatCodigo.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Preencha o código da Fatura", "ERRO", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				try 
				{
					if(cmd.contains("Listar"))
					{
						faturaController.buscaFaturas();
					}
					else
					{
						Fatura f = new Fatura();
						f.setFatId((Integer.parseInt(txtFatCodigo.getText())));
						f.setFatNome(txtFatNome.getText());
						f.setFatDescricao(txtFatDescricao.getText());
						//f.setFatIdPaciente((Integer.parseInt(txtFatData.getText())));
						
						if(cmd.contains("Inserir"))
						{
							faturaController.insereFatura(f);
						}
						else if(cmd.contains("Atualizar"))
						{
							faturaController.atualizarFatura(f);
						}
						else if(cmd.contains("Excluir"))
						{
							faturaController.excluiFatura(f);
						}
						else if(cmd.contains("Buscar") || cmd.contains("txtFatId"))
						{
							faturaController.buscaFatura(f);
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
	
	// Event Listener on Button[#btnInserirExame].onAction
	@FXML
	public void acaoExame(ActionEvent event) 
	{
		String cmd = event.getSource().toString();
		System.out.println(cmd);
		
		ExameController exameController = new ExameController (txtExaCodigo, txtExaNome, txtExaDescricao, taListarExame);
		
		if((cmd.contains("Inserir") || cmd.contains("Atualizar")) && (txtExaCodigo.getText().isEmpty() || txtExaNome.getText().isEmpty() || txtExaDescricao.getText().isEmpty()))
		{
			JOptionPane.showMessageDialog(null, "Preencha o código do Exame", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		else 
		{
			if(cmd.contains("Excluir") || cmd.contains("Buscar") || cmd.contains("txtExaCodigo") && txtExaCodigo.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Preencha o código do Exame", "ERRO", JOptionPane.ERROR_MESSAGE);
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
						e.setExameId((Integer.parseInt(txtExaCodigo.getText())));
						e.setExameNome(txtExaNome.getText());
						e.setExameDescricao(txtExaDescricao.getText());
						//f.setFatIdPaciente((Integer.parseInt(txtFatData.getText())));
						
						if(cmd.contains("Inserir"))
						{
							exameController.insereExame(e);
						}
						else if(cmd.contains("Atualizar"))
						{
							exameController.atualizarExame(e);
						}
						else if(cmd.contains("Excluir"))
						{
							exameController.excluiExame(e);
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
}
