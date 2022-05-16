package it.prova.gestioneappartamento.model;

import java.util.Date;

public class Appartamento {
	private Long id;
	private String quartiere;
	private int metriQuadrati;
	private int prezzo;
	private Date dataCostruzione;

	public Appartamento() {
	}

	public Appartamento(String quartiere, int metriQuadrati, int prezzo, Date dataCostruzione) {
		this.quartiere = quartiere;
		this.metriQuadrati = metriQuadrati;
		this.prezzo = prezzo;
		this.dataCostruzione = dataCostruzione;
	}

	public Appartamento(Long id, String quartiere, int metriQuadrati, int prezzo, Date dataCostruzione) {
		this.id = id;
		this.quartiere = quartiere;
		this.metriQuadrati = metriQuadrati;
		this.prezzo = prezzo;
		this.dataCostruzione = dataCostruzione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuartiere() {
		return quartiere;
	}

	public void setQuartiere(String quartiere) {
		this.quartiere = quartiere;
	}

	public int getMetriQuadrati() {
		return metriQuadrati;
	}

	public void setMetriQuadrati(int metriQuadrati) {
		this.metriQuadrati = metriQuadrati;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public Date getDataCostruzione() {
		return dataCostruzione;
	}

	public void setDataCostruzione(Date dataCostruzione) {
		this.dataCostruzione = dataCostruzione;
	}

	@Override
	public String toString() {
		return "Appartamento [id=" + id + ", quartiere=" + quartiere + ", metriquadrati=" + metriQuadrati + ", prezzo="
				+ prezzo + ", datacostruzione=" + dataCostruzione + "]";
	}

}
