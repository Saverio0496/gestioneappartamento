package it.prova.gestioneappartamento.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

		testUpdateAppartamento(appartamentoDAOInstance);

		testDeleteAppartamento(appartamentoDAOInstance);

		testFindById(appartamentoDAOInstance);

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

	private static void testUpdateAppartamento(AppartamentoDAO appartamentoDAOInstance) {
		System.out.println("Inizio testUpdateAppartamento");

		Appartamento appartamentoDaAggiornare = appartamentoDAOInstance.list().get(6);
		appartamentoDaAggiornare.setQuartiere("Parco Friuli");

		appartamentoDAOInstance.update(appartamentoDaAggiornare);

		System.out.println(appartamentoDaAggiornare);
		System.out.println("Fine testUpdateNegozio!");
	}

	private static void testDeleteAppartamento(AppartamentoDAO appartamentoDAOInstance) {
		System.out.println("Inizio testDeleteAppartamento");

		Appartamento appartamentoDaEliminare = appartamentoDAOInstance.list().get(4);

		int quantiAppartamentiEliminati = appartamentoDAOInstance.delete(appartamentoDaEliminare);
		if (quantiAppartamentiEliminati < 1)
			throw new RuntimeException("Cancellazione fallita!");
		System.out.println("Sono stati eleminati " + quantiAppartamentiEliminati + " appartamenti!");
		System.out.println("Fine testDeleteAppartamento!");
	}

	private static void testFindById(AppartamentoDAO appartamentoDAOInstance) {
		System.out.println("Inizio testFindById");
		List<Appartamento> elencoAppartamentoPresenti = appartamentoDAOInstance.list();
		if (elencoAppartamentoPresenti.size() < 1)
			throw new RuntimeException("testFindById fallito! Non ci sono appartamenti sul database!");

		Appartamento primoAppartamentoDellaLista = elencoAppartamentoPresenti.get(0);

		Appartamento appartamentoCheRicercoColDAO = appartamentoDAOInstance
				.findById(primoAppartamentoDellaLista.getId());
		if (appartamentoCheRicercoColDAO == null)
			throw new RuntimeException("testFindByIdArticolo fallito! Non c'e' questo appartamento!");
		System.out.println(appartamentoCheRicercoColDAO);
		System.out.println("Fine testFindByIdArticolo!");
	}

}
