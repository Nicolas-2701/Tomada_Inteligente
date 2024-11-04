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
	
	public Tomada(double watts, double wh, double gt) {
		super();
		this.watts = watts;
		this.wh = wh;
		this.gt = gt;
	}
	
	public Tomada() {
		super();
		// TODO Auto-generated constructor stub
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

}
