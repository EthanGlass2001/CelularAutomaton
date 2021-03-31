/**
 * 
 * @author Ethan Glass
 *
 */
public class Rule {
	/**
	 * @param binaryRule	The int rule number turned into a string flipped
	 */
	
	private String binaryRule;
	

	public Rule(int ruleNum) {
		if(ruleNum < 0) {
			ruleNum = 0;
		} else if(ruleNum > 255) {
			ruleNum = 255;
		}
		String rlRule = String.valueOf(Integer.toBinaryString(ruleNum));
		while(rlRule.length() < 8) {
			rlRule = "0" + rlRule;
		}
		String lrRule = "";
		for(int i = rlRule.length()-1; i > 0; i--) {
			lrRule =  lrRule + rlRule.charAt(i);
		}
		
		
		binaryRule = rlRule;
		
	}
	/**
	 * 
	 * @param gen 	This is the base generation that you will be evolving
	 * @return Returns type Generation, Evolves gen by calling the other evolve method and using getNeighborhood
	 */
	public Generation evolve(Generation gen) {
		boolean[] nextGen = new boolean[gen.size()];
		
		for(int i = 0; i < gen.size(); i ++) {
			nextGen[i] = evolve(getNeighborhood(i, gen));
		}

		return new Generation(nextGen);
		
	}
	/**
	 * 
	 * @param neighborhood	This is an array of booleans thats length is 3
	 * @return Returns type boolean, This determines what the new cell on the new generation is going to be from neighborhood
	 */
	public boolean evolve(boolean[] neighborhood) {
		
		String strNei = "";
		for(int i = 0; i < 3; i++) {
			if(neighborhood[i]) {
				strNei = strNei + "1";
			} else {
				strNei = strNei + "0";
			}
			
		}

		switch(Integer.parseInt(strNei,2)) {
		case 0:
			if(String.valueOf(binaryRule.charAt(7)).equals("1")) {
				return true;
			}
			return false;
		case 1:
			if(String.valueOf(binaryRule.charAt(6)).equals("1")) {
				return true;
			}
			return false;
		case 2:
			if(String.valueOf(binaryRule.charAt(5)).equals("1")) {
				return true;
			}
			return false;
		case 3:
			if(String.valueOf(binaryRule.charAt(4)).equals("1")) {
				return true;
			}
			return false;
		case 4:
			if(String.valueOf(binaryRule.charAt(3)).equals("1")) {
				return true;
			}
			return false;
		case 5:
			if(String.valueOf(binaryRule.charAt(2)).equals("1")) {
				return true;
			}
			return false;
		case 6:
			if(String.valueOf(binaryRule.charAt(1)).equals("1")) {
				return true;
			}
			return false;
		case 7:
			if(String.valueOf(binaryRule.charAt(0)).equals("1")) {
				return true;
			}
			return false;
		default:
			return false;
			
		}
		

	}
	/**
	 * 
	 * @param idx	This is the index location of gen that we want to get neighborhood from
	 * @param gen	This is the generation that we want to get the neighborhood from
	 * @return Returns type boolean[], Returns a boolean array of 3 values to represent the neighborhood to later be evolved
	 */
	
	public static boolean[] getNeighborhood(int idx, Generation gen) {
		boolean[] neighborhood = new boolean[3];
		if(gen.size() == 1) {
			neighborhood[0] = gen.getState(0);
			neighborhood[1] = gen.getState(0);
			neighborhood[2] = gen.getState(0);
			return(neighborhood);
		}
		if(idx == 0) {
			neighborhood[0] = gen.getState(gen.size()-1);
			neighborhood[1] = gen.getState(0);
			neighborhood[2] = gen.getState(1);
		} else if(idx == gen.size()-1) {
			neighborhood[0] = gen.getState(gen.size()-2);
			neighborhood[1] = gen.getState(gen.size()-1);
			neighborhood[2] = gen.getState(0);
		} else {
			neighborhood[0] = gen.getState(idx-1);
			neighborhood[1] = gen.getState(idx);
			neighborhood[2] = gen.getState(idx+1);
		}
		return neighborhood;
	}
	/**
	 * 
	 * @return returns type int, Converts the binary into base 10
	 */
	
	public int getRuleNum() {
		return Integer.parseInt(binaryRule,2);
	}
	/**
	 * 
	 * @return type returns String, returns the binaryRule Variable
	 */
	public String getRuleString() {
		return binaryRule;
	}


}
