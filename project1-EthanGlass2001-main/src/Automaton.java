import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Ethan Glass
 *
 */
public class Automaton {
	private Rule rule;
	private ArrayList<Generation> generations;
	public char falseSymbol;
	public char trueSymbol;
	
	public Automaton(int ruleNum, Generation initial) {
		trueSymbol = '1';
		falseSymbol = '0';
		rule = new Rule(ruleNum);
		generations = new ArrayList<Generation>();
		generations.add(initial);
	}
	
	public Automaton(String filename) throws NumberFormatException, IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
			rule = new Rule(Integer.valueOf(br.readLine()));
			String trueFalse = br.readLine();
			falseSymbol = trueFalse.charAt(0);
			trueSymbol = trueFalse.charAt(2);
			generations = new ArrayList<Generation>();
			generations.add(new Generation(br.readLine(),trueSymbol));
			br.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		}
	}
	/**
	 * 
	 * @param numSteps	This is how many time the evolve method is going to run
	 * 
	 */
	public void evolve(int numSteps) {
		System.out.println(rule.getRuleNum());
		System.out.println(rule.toString());
		if(numSteps > 0) {
			for(int i =0; i < numSteps; i++) {
				generations.add(rule.evolve(generations.get(generations.size()-1)));
			}
		}
	}
	/**
	 * 
	 * @param stepNums	This is the Evolution we would like to return from the Arraylist
	 * @return A cell from generations in type Generation
	 */
	
	public Generation getGeneration(int stepNums) {
		if(stepNums > generations.size()-1) {
			evolve(stepNums-generations.size()+1);
			return generations.get(stepNums);
		} else {
			return generations.get(stepNums);
		}
	}
	/**
	 * 
	 * @return a int, Gets the rule Number from the rule variable
	 */
	
	public int getRuleNum() {
		return rule.getRuleNum();
	}
	/**
	 * 
	 * @return a int, Gets the total steps that Generations have evolved
	 */
	
	public int getTotalSteps() {
		return generations.size()-1;
	}
	/**
	 * 
	 * @param filename, This saves the current Generaions to a file of name Filename
	 */
	
	public void saveEvolution(String filename) {
		
		try {
			new FileWriter(filename, false).close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(filename));
			bw.write(toString());
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String toString() {
		String printing = "";
		for(int i = 0; i < generations.size(); i++) {
			if(i+2 > generations.size()) {
				printing += generations.get(i).getStates(falseSymbol, trueSymbol);
			}else {
				printing += generations.get(i).getStates(falseSymbol, trueSymbol);
				printing += System.lineSeparator();
			}
			
		}
		return printing;
	}
	
	


}
