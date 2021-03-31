/**
 * 
 * @author Ethan Glass
 *
 */

public class Generation {

	private boolean[] cellStates;
	
	public Generation(boolean... states) {
		if(states == null || states.length == 0) {
			cellStates = new boolean[1];
			cellStates[0] = false;
		}else {
			cellStates = new boolean[states.length];
			
			for(int i = 0; i < states.length; i++) {
				cellStates[i] = states[i];
			}
		}
		
	}
	
	public Generation(String states,char trueSymbol) {
		if(states == null || states.isEmpty()) {
			cellStates = new boolean[1];
			cellStates[0] = false;
		}else {
			cellStates = new boolean[states.length()];
			String charString = String.valueOf(trueSymbol);
			for(int i = 0; i < states.length(); i++) {
				if((String.valueOf(states.charAt(i)).equals(charString))) {
					cellStates[i] = true;
				} else {
					cellStates[i] = false;
				}
			}
		}
	}
	
	/**
	 * 
	 * @param idx	This is the index of the cell you want the value from
	 * @return Returns a boolean, This returns the states of a given cell from cellStates[]
	 */
	public boolean getState(int idx) {
		return cellStates[idx];
	}
	
	/**
	 * 
	 * @return Returns a boolean array, Returns a immutable array of cellStates[]
	 */
	public boolean[] getStates() {
		return cellStates.clone();
		
	}
	/**
	 * 
	 * @param falseSymbol	This is the false symbol that the method will be using
	 * @param trueSymbol	This is the true symbol that the method will be using
	 * @return Returns a String, Interprets the boolean array cellStates and return a string with True and False Symbols
	 */
	public String getStates(char falseSymbol, char trueSymbol) {
		String states = "";
		for(int i = 0; i < cellStates.length; i++) {
			if(cellStates[i]) {
				states += trueSymbol;
			} else {
				states += falseSymbol;
			}
		}
		return states;
	}
	/**
	 * 
	 * @return Returns a int, Returns the size of the boolean array cellStates
	 */
	public int size() {
		return cellStates.length;
	}
	
	

}
