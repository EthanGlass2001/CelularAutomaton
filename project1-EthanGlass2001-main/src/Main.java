
public class Main {
	public static void main(String[] args) {
		Generation gen = new Generation("0001000", '1');
		Rule rule = new Rule(1);
		//System.out.println("Rule Number in base 10: " + rule.getRuleNum());
		//System.out.println("Rule Number in base 2: " + rule.getRuleString());
		//System.out.println("Generation: " + gen.getStates('0', '1'));
		//Boolean[] array = {false, false, false};
		System.out.println(rule.evolve(rule.getNeighborhood(2, gen)));
		//0 1 1 0 1 1 1 0

		
		


	}
	


}
