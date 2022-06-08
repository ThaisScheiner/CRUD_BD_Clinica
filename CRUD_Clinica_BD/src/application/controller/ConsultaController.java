package application.controller;

import java.awt.TextArea;
import java.awt.TextField;
import java.sql.SQLException;
import java.util.List;
import application.model.Consulta;
import application.persistence.ConsultaDAO;
import javafx.scene.control.*;

public class ConsultaController implements ConsultaControllerImpl
{
	private TextField tfCodigoConsulta;
	private TextField tfNomeConsulta;
	private TextField tfDataConsulta;
	private TextField tfIDExame;
	private TextField tfIDMedico;
	private TextArea taListaConsultas;

	public ConsultaController(TextField tfCodigoConsulta, TextField tfNomeConsulta, TextField tfDataConsulta,
		   TextField tfIDExame, TextField tfIDMedico, TextArea taListaConsultas) {
		this.tfCodigoConsulta = tfCodigoConsulta;
		this.tfNomeConsulta = tfNomeConsulta;
		this.tfDataConsulta = tfDataConsulta;
		this.tfIDExame = tfIDExame;
		this.tfIDMedico = tfIDMedico;
		this.taListaConsultas = taListaConsultas;
	}

	public ConsultaController(javafx.scene.control.TextField tfCodigoConsulta2,
			javafx.scene.control.TextField tfNomeConsulta2, javafx.scene.control.TextField tfDataConsulta2, javafx.scene.control.TextField tfIDExame2,
			javafx.scene.control.TextField tfIDMedico2, javafx.scene.control.TextArea taListaConsultas2) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inserirConsulta(Consulta c) throws ClassNotFoundException, SQLException {
		ConsultaDAO cDAO = new ConsultaDAO();
		cDAO.insereConsulta(c);
		limpaCamposConsulta();
		buscarConsultas();
		
	}

	@Override
	public void atualizarConsulta(Consulta c) throws ClassNotFoundException, SQLException {
		ConsultaDAO cDAO = new ConsultaDAO();
		cDAO.atualizaConsulta(c);
		limpaCamposConsulta();
		buscarConsultas();
	}

	@Override
	public void excluirConsulta(Consulta c) throws ClassNotFoundException, SQLException {
		ConsultaDAO cDAO = new ConsultaDAO();
		cDAO.excluiConsulta(c);
		limpaCamposConsulta();
		buscarConsultas();
	}

	@Override
	public void buscarConsulta(Consulta c) throws ClassNotFoundException, SQLException {
		limpaCamposConsulta();
		
		ConsultaDAO cDAO = new ConsultaDAO();
		cDAO.buscaConsulta(c);
		tfCodigoConsulta.setText(String.valueOf(c.getConsId()));
		tfNomeConsulta.setText(c.getConsNome());
		tfDataConsulta.setText(c.conversorData());
		tfIDMedico.setText(String.valueOf(c.getConsIdMedico()));
	}

	@Override
	public void buscarConsultas() throws ClassNotFoundException, SQLException {
		limpaCamposConsulta();
		taListaConsultas.setText("");
		
		ConsultaDAO cDao = new ConsultaDAO();
		List <Consulta> listaConsultas = cDao.buscaConsultas();
		
		StringBuffer sb = new StringBuffer("ConsID\t\t\t\tConsNome\t\t\t\tConsIdPaciente\n");
		for (Consulta c : listaConsultas) {
			sb.append(c.getConsId() +"\t\t\t\t\t"+c.getConsNome()+"\t\t\t\t\t"+c.getConsIdMedico());
			
		}
	}
	
	private void limpaCamposConsulta() {
		tfCodigoConsulta.setText("");
		tfNomeConsulta.setText("");
		tfDataConsulta.setText("");
		tfIDExame.setText("");
		tfIDMedico.setText("");
	}
}
