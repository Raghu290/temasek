package com.hackathon.temasek.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class CreditCard {

	@NotNull(message = "Pelase enter the card number")
	@NotEmpty(message = "Please enter your password.")
	@Size(min=16,max=16 , message = "Card number must be 16 digits")
	private String cardNumber;

	@NotNull(message = "Please enter the card holder name")
	private String cardHolderName;
	
	@NotNull(message = "Please enter cvv")
	@Size(min=3,max=3 , message = "CVV must be 3 digits")
	private String cvv;
	
	@NotNull(message = "Please enter the 3D secure pin")
	@Size(min=6,max=6 , message = "Secure PIN must be 6 digits")
	private String securePin;
	@NotNull(message = "Please enter the card expiry month")
	private String expiryMonth;
	@NotNull(message = "Please enter the card expiry year ")
	private String expiryYear;
	private String totalBill;
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getSecurePin() {
		return securePin;
	}
	public void setSecurePin(String securePin) {
		this.securePin = securePin;
	}
	public String getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(String expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(String expiryYear) {
		this.expiryYear = expiryYear;
	}
	public String getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(String totalBill) {
		this.totalBill = totalBill;
	}
	
	

}
