package application.controller;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.JOptionPane;

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
	@FXML
	private TextField txtFatData;
	@FXML
	private TextField txtFatIdPaciente;
	@FXML
	private TextField txtFatNomePaciente;

	// Event Listener on Button[#btnInserirFatura].onAction
	@FXML
	public void acaoFatura(ActionEvent event) 
	{
		String cmd = event.getSource().toString();
		System.out.println(cmd);
		
		FaturaController faturaController = new FaturaController (txtFatCodigo, txtFatNome, txtFatDescricao, txtFatValor,txtFatData, txtFatIdPaciente, txtFatNomePaciente, taListarFatura);
		
		if((cmd.contains("Inserir") || cmd.contains("Atualizar")) && (txtFatCodigo.getText().isEmpty() || txtFatNome.getText().isEmpty() || txtFatDescricao.getText().isEmpty()))
		{
			JOptionPane.showMessageDialog(null, "Preencha o código", "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		else 
		{
			if(cmd.contains("Excluir") || cmd.contains("Buscar") || cmd.contains("txtCodigoProfessor") && txtFatCodigo.getText().isEmpty())
			{
				JOptionPane.showMessageDialog(null, "Preencha o código", "ERRO", JOptionPane.ERROR_MESSAGE);
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
						f.setFatValor((Double.parseDouble(txtFatValor.getText())));
						f.setFatData((LocalDate.parse(txtFatData.getText())));
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
}
