package in.co.dhdigital.models;

import java.io.Serializable;
import java.util.List;

public class Bill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private double billAmount;
	private double billAmountWithoutTax;
	private double gst;
	private String orderNumber;
	private double minutesToDilevery;
	private String remarks;
	private List<Cuisine> cuisines;
	
	// Getters and Setters.
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Cuisine> getCuisines() {
		return cuisines;
	}
	public void setCuisines(List<Cuisine> cuisines) {
		this.cuisines = cuisines;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public double getBillAmountWithoutTax() {
		return billAmountWithoutTax;
	}
	public void setBillAmountWithoutTax(double billAmountWithoutTax) {
		this.billAmountWithoutTax = billAmountWithoutTax;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public double getMinutesToDilevery() {
		return minutesToDilevery;
	}
	public void setMinutesToDilevery(double minutesToDilevery) {
		this.minutesToDilevery = minutesToDilevery;
	}
	
	
}
