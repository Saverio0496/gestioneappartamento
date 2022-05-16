package it.prova.gestioneappartamento.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import it.prova.gestioneappartamento.dao.AppartamentoDAO;
import it.prova.gestioneappartamento.model.Appartamento;

public class TestGestioneAppartamento {

	public static void main(String[] args) {
		AppartamentoDAO appartamentoDAOInstance = new AppartamentoDAO();

		System.out.println("Inizio testList");
		System.out
				.println("In tabella appartamento ci sono " + appartamentoDAOInstance.list().size() + " appartamenti.");
		System.out.println("Fine testList");

		testInsertAppartamento(appartamentoDAOInstance);
		System.out.println("Adesso in tabella ci sono " + appartamentoDAOInstance.list().size() + " appartamenti.");

	}

	private static void testInsertAppartamento(AppartamentoDAO appartamentoDAOInstance) {
		System.out.println("Inizio testInsertAppartamento");
		Date dataPerTest = null;

		try {
			dataPerTest = new SimpleDateFormat("dd/MM/yyyy").parse("10/02/2018");
		} catch (ParseException exc) {
		}
		int quantiAppartamentiInseriti = appartamentoDAOInstance
				.insert(new Appartamento("Toscanini", 60, 90000, dataPerTest));
		if (quantiAppartamentiInseriti < 1)
			throw new RuntimeException("Inserimento fallito!");

		System.out.println("Fine testInserimentoNegozio!");
	}

}
