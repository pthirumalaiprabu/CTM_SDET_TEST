package utils;

/**
 * Enum class for different types of payment usage in CTM.
 * It has got a variable visibleText which contains the visible text option for the enum under the dropdown.
 * 
 * @author Thiru
 */
public enum PAYMENT_TYPE {
	
	MONTHLY_DIRECT_DEBIT("Monthly Direct Debit"),
	PAY_ON_RECEIPT_OF_BILL("Pay On Receipt Of Bill"),
	PREPAYMENT_METER("Prepayment Meter"),
	QUATERLY_DIRECT_DEBIT("Quarterly Direct Debit"),
	ALL_PAYMENT_TYPES("All payment types");
	
	private String visibleText;
	
	private PAYMENT_TYPE(String visibleText){
		this.visibleText = visibleText;
	}
	
	
	public String getVisibleText(){
		return visibleText;
	}

}
