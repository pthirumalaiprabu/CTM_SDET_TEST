package utils;

/**
 * Enum class for different usage cycles in CTM.
 * It has got a variable visibleText which contains the visible text option for the enum under the dropdown.
 * 
 * @author Thiru
 *
 */
public enum USAGE_CYCLE {
	
	ANNUALLY("Annually"),
	QUARTERLY("Quarterly"),
	SIX_MONTHLY("Six monthly"),
	MONTHLY("Monthly");
	
	private String visibleText;
	
	private USAGE_CYCLE(String visibleText){
		this.visibleText = visibleText;
	}
	
	
	public String getVisibleText(){
		return visibleText;
	}

}
