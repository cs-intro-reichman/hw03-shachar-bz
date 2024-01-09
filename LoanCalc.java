/**
* Computes the periodical payment necessary to re-pay a given loan.
*/
public class LoanCalc {
	
	static double epsilon = 0.001;  // The computation tolerance (estimation error)
	static int iterationCounter;    // Monitors the efficiency of the calculation
	
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan sum = " + loan + ", interest rate = " + rate + "%, periods = " + n);
		
		// Computes the periodical payment using brute force search
		System.out.print("Periodical payment, using brute force: ");
		System.out.printf("%.2f", bruteForceSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("Periodical payment, using bi-section search: ");
		System.out.printf("%.2f", bisectionSolver(loan, rate, n, epsilon));
		System.out.println();
		System.out.println("number of iterations: " + iterationCounter);
	}
	
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {  
    	double g = loan / n;
		iterationCounter = 0;
		while(endBalance(loan, rate, n, g) > 0){
			iterationCounter++;
			g += epsilon;
		}
    	return g;
    }
    
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
    	double L = loan / n ;
		double H = loan;
		double g = (H + L) / 2;
		// variable start from 1 because it includ the first count 
		iterationCounter = 0;

    	while( (H - L) > epsilon) {  
			if(endBalance(loan, rate, n, g) * endBalance(loan, rate, n, L) > 0){
				// the solution must be between g and H 
				L = g;
			}  
			else{
				// the solution must be between L and g 
				H = g;
			}
			iterationCounter++;
			// Computes the mid-value (𝑔) for the next iteration  
			g = (H + L) / 2;
			} 
			return g;
    }
	
	private static double endBalance(double loan, double rate, int n, double payment) {
		// Replace the following statement with your code
    	for(int i = 0; i < n; i++){
			loan = (loan - payment) * (1 + (rate / 100));
		}
		return loan;
	}
}