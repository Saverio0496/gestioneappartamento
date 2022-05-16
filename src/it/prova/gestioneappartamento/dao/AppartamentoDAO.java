package it.prova.gestioneappartamento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.prova.gestioneappartamento.connection.MyConnection;
import it.prova.gestioneappartamento.model.Appartamento;

public class AppartamentoDAO {
	public List<Appartamento> list() {

		List<Appartamento> result = new ArrayList<>();
		Appartamento appartamentoTemp = null;

		try (Connection c = MyConnection.getConnection();
				Statement s = c.createStatement();
				ResultSet rs = s.executeQuery("select * from appartamento a ")) {

			while (rs.next()) {
				appartamentoTemp = new Appartamento();
				appartamentoTemp.setId(rs.getLong("id"));
				appartamentoTemp.setQuartiere(rs.getString("quartiere"));
				appartamentoTemp.setMetriQuadrati(rs.getInt("metriquadrati"));
				appartamentoTemp.setPrezzo(rs.getInt("prezzo"));
				appartamentoTemp.setDataCostruzione(rs.getDate("datacostruzione"));

				result.add(appartamentoTemp);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}
	public int insert(Appartamento appartamentoInput) {

		if (appartamentoInput == null)
			throw new RuntimeException("Impossibile inserire l'appartamento: input mancante!");

		int result = 0;
		try (Connection c = MyConnection.getConnection();
				PreparedStatement ps = c.prepareStatement(
						"INSERT INTO appartamento (quartiere,metriquadrati,prezzo,datacostruzione) VALUES (?, ?, ?, ?)")) {

			ps.setString(1, appartamentoInput.getQuartiere());
			ps.setInt(2, appartamentoInput.getMetriQuadrati());
			ps.setInt(3, appartamentoInput.getPrezzo());
			ps.setDate(4, new java.sql.Date(appartamentoInput.getDataCostruzione().getTime()));
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return result;
	}

	

}
