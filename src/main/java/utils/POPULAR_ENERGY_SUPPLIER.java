package utils;

/**
 * Enum class for the major energy suppliers in the UK.
 * It has got a variable uiIconText which contains the text which is visible in the UI for the corresponding enums icon.
 * 
 * @author Thiru
 */
public enum POPULAR_ENERGY_SUPPLIER {
	
	BRITISH_GAS("british-gas"),
	EDF_ENERGY("edf-energy"),
	E_ON("eon"),
	NPOWER("npower"),
	SCOTTISH_POWER("scottish-power"),
	SSE("sse");
	
	private String uiIconText;
	
	private POPULAR_ENERGY_SUPPLIER(String uiIconText){
		this.uiIconText = uiIconText;
	}
	
	public String getUIIconText(){
		return uiIconText;
	}

}
