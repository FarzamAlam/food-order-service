package in.co.dhdigital.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import in.co.dhdigital.models.Bill;
import in.co.dhdigital.models.Cuisine;
import in.co.dhdigital.params.OrderRequest;
import in.co.dhdigital.params.OrderResponse;

public class TakeOrderProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		OrderRequest request = exchange.getIn().getBody(OrderRequest.class);
		OrderResponse response = new OrderResponse();
		Bill bill = new Bill();
		
		String name = request.getOrder().getName();
		System.out.println("name : "+name);
		
		List<Cuisine> cuisines = new ArrayList<Cuisine>();
		cuisines = request.getOrder().getCuisines();
		
		
		if(cuisines == null || cuisines.size() == 0) {
			bill.setRemarks("No Cuisines are selected, Invalid Order.");
			bill.setOrderNumber("-1");
		}else {
			System.out.println("cuisines size : "+ cuisines.size());
			double billWithoutTax = calculateBill(cuisines);
			double gst = 18;
			double billAmount = (billWithoutTax * gst)/100 + billWithoutTax;
			bill.setBillAmount(billAmount);
			bill.setBillAmountWithoutTax(billWithoutTax);
			bill.setGst(gst);
			bill.setMinutesToDilevery(1);
			bill.setName(name);
			bill.setRemarks("Your order has been placed. Please wait for the confirmation from the restaurant.");
			String orderNumber = ""+Math.round(Math.random() * 100000);
			bill.setOrderNumber(orderNumber);
			bill.setCuisines(cuisines);
		}
		response.setBill(bill);
		exchange.getIn().setBody(response);
	}
	
	public double calculateBill(List<Cuisine> cuisines) {
		
		double bill = 0;
		for(int i =0;i<cuisines.size();i++) {
			bill += (cuisines.get(i).getCost() * cuisines.get(i).getQuantity());
		}
		return bill;
	}

}
