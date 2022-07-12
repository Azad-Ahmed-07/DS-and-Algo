package dsa.algo.recursion.sodukoSolver;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SodukoSolver {
	
	private static void convertToCharMatrix(String board) {
		String input = board.substring(1, board.length()-2);
		//System.out.print(input);
		char[][] boardArr = new char[9][9];
		final String regex = "(\\[(((\\\".\\\")\\,?){9})\\])";
        
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(input);
        if(true) {
        	System.out.println("Insert Input in valid format"+pattern.matches(regex, input));
        }else {
        	//matcher.reset();
        	while (matcher.find()) {
        		System.out.println("Full match: " + matcher.group(0));
        		
        	}
        }
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		convertToCharMatrix(input);
		
	}

}
