package br.com.assistenciaTecnica.cadastral.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name = "Type Product")
	private String typeProduct;//decktop, nootebook, neetbook
	@Column(name = "Mark")
	private String mark;
	@Column(name="Model")
	private String model;
	@Column(name = "Number Serial")
	private String numberSerial;//nem sempre um número de série é só composto de números
	
	public Product() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTypeProduct() {
		return typeProduct;
	}
	public void setTypeProduct(String typeProduct) {
		this.typeProduct = typeProduct;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getNumberSerial() {
		return numberSerial;
	}
	public void setNumberSerial(String numberSerial) {
		this.numberSerial = numberSerial;
	}
}
