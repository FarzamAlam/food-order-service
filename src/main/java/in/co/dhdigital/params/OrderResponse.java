package in.co.dhdigital.params;

import java.io.Serializable;

import in.co.dhdigital.models.Bill;

public class OrderResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Bill bill;

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	
}
