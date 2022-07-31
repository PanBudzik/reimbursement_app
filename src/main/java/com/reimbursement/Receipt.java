package com.reimbursement;

public class Receipt {
	
	int receiptId; //primary key
	int tripId; //foreign key
	String receiptChosen;
	int receiptAmount;
	String receiptFile;
	
	
	public Receipt(int receiptId, int tripId, String receiptChosen, int receiptAmount, String receiptFile) {
		super();
		this.receiptId = receiptId;
		this.tripId = tripId;
		this.receiptChosen = receiptChosen;
		this.receiptAmount = receiptAmount;
		this.receiptFile = receiptFile;
	}
	
	public int getReceiptId() {
		return receiptId;
	}
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
	public int getTripId() {
		return tripId;
	}
	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
	public String getReceiptChosen() {
		return receiptChosen;
	}
	public void setReceiptChosen(String receiptChosen) {
		this.receiptChosen = receiptChosen;
	}
	public int getReceiptAmount() {
		return receiptAmount;
	}
	public void setReceiptAmount(int receiptAmount) {
		this.receiptAmount = receiptAmount;
	}
	public String getReceiptFile() {
		return receiptFile;
	}
	public void setReceiptFile(String receiptFile) {
		this.receiptFile = receiptFile;
	}
	@Override
	public String toString() {
		return "Receipt [receiptId=" + receiptId + ", tripId=" + tripId + ", receiptChosen=" + receiptChosen
				+ ", receiptAmount=" + receiptAmount + ", receiptFile=" + receiptFile + "]";
	}
	
	

}
