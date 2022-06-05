package application.controller;

import java.sql.SQLException;
import java.util.List;

import application.model.Exame;
import application.persistence.ExameDAO;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ExameController implements IExameController
{
	private TextField txtExaId;
	private TextField txtExaNome;
	private TextField txtExaDescricao;
	private TextArea taListarExame;
	
	public ExameController(TextField txtExaId, TextField txtExaNome, TextField txtExaDescricao, TextArea taListarExame) {
		super();
		this.txtExaId = txtExaId;
		this.txtExaNome = txtExaNome;
		this.txtExaDescricao = txtExaDescricao;
		this.taListarExame = taListarExame;
	}

	@Override
	public void insereExame(Exame e) throws SQLException, ClassNotFoundException {
		ExameDAO eDAO = new ExameDAO();
		eDAO.insereExame(e);
		limpaCamposExame();
		buscaExames();
		
	}

	@Override
	public void atualizarExame(Exame e) throws SQLException, ClassNotFoundException {
		ExameDAO eDAO = new ExameDAO();
		eDAO.atualizarExame(e);
		limpaCamposExame();
		buscaExames();
		
	}

	@Override
	public void excluiExame(Exame e) throws SQLException, ClassNotFoundException {
		ExameDAO eDAO = new ExameDAO();
		eDAO.excluiExame(e);
		limpaCamposExame();
		buscaExames();
		
	}

	@Override
	public void buscaExame(Exame e) throws SQLException, ClassNotFoundException {
		limpaCamposExame();
		
		ExameDAO eDAO = new ExameDAO();
		e = eDAO.buscaExame(e);
		
		txtExaId.setText(String.valueOf(e.getExameId()));
		txtExaNome.setText(e.getExameNome());
		txtExaDescricao.setText(e.getExameDescricao());
		
	}

	
	@Override
	public void buscaExames() throws ClassNotFoundException, SQLException {
		limpaCamposExame();
		taListarExame.setText("");
		
		ExameDAO eDAO = new ExameDAO();
		List<Exame> listaExames = eDAO.buscaExames();
		
		StringBuffer buffer = new  StringBuffer("Código\t\t\t\t\t\t\t\tNome do Exame\t\t\t\t\t\t\t\t\t\t\tDescrição\n");
		for(Exame e: listaExames)
		{
			buffer.append(e.getExameId()+"\t\t\t\t\t\t\t\t"+e.getExameNome()+"\t\t\t\t\t\t\t\t\t\t\t"+e.getExameDescricao()+"\n");
		}
		
		taListarExame.setText(buffer.toString());
		
	}
	
	private void limpaCamposExame()
	{
		txtExaId.setText("");
		txtExaNome.setText("");
		txtExaDescricao.setText("");
	}

	@Override
	public void buscaFaturas() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
	}
	
}
