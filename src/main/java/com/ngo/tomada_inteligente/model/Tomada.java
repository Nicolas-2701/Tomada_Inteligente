package com.ngo.tomada_inteligente.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tomada {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private double watts;
	private double wh;//watt hora
	private double gt;//gasto total = wh durante o tempo que a tomada está no banco de dados
	private double gr;//gasto real, em caso de duvida perguntar pro sperati

	public Tomada() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Tomada(int id, double watts, double wh, double gt, double gr) {
		super();
		this.id = id;
		this.watts = watts;
		this.wh = wh;
		this.gt = gt;
		this.gr = gr;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getWatts() {
		return watts;
	}
	public void setWatts(double watts) {
		this.watts = watts;
	}
	public double getWh() {
		return wh;
	}
	public void setWh(double wh) {
		this.wh = wh;
	}
	public double getGt() {
		return gt;
	}
	public void setGt(double gt) {
		this.gt = gt;
	}
	public double getGr() {
		return gr;
	}
	public void setGr(double gr) {
		this.gr = gr;
	}
	

}
