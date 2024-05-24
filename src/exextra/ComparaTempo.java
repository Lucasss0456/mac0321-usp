package exextra;


public class ComparaTempo {
	
	public static long concatenaBruteForce() {
		long tStart, tEnd;
		String generic = "";
		
		tStart = System.currentTimeMillis();
		
		for (int i = 0; i<100000; i++) 
			generic += "a";
		
		tEnd = System.currentTimeMillis();
		
		return tEnd - tStart;
	}
	
	public static long concatenaStringBuffer() {
		long tStart, tEnd;
		StringBuffer string = new StringBuffer(); 
		
		tStart = System.currentTimeMillis();
		
		for (int i = 0; i<100000; i++) {
			string.append("a");
		}
		
		tEnd = System.currentTimeMillis();
		
		return tEnd - tStart;
	}
	
	
	public static void main(String args[]) {
		long t1 = concatenaBruteForce();
		long t2 = concatenaStringBuffer();
		double ratio = t1/t2;
		System.out.println("Tempo de execução BruteForce: " + t1);
		System.out.println("Tempo de execução StringBuffer: " + t2);
		System.out.println("O tempo de BruteForce é aproximadamente" + ratio + " maior do que StringBuffer");
		
	}

	}