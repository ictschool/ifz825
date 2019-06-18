package ch.wiss.swing.calculator;

public enum CalcType {

	SELECT("Auswahl..."), ADD("+"), SUB("-"), MUL("*"), DIV("/");
	
	private String value;
	
	private CalcType(String value) {
		this.value=value;
	}
	
	public String getValue() {
		return value;
	}
	
	public String toString() {
		return value;
	}
	
}
