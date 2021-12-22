package prog9_2_soln;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

public class SymbolBalancer {
	String filename;
	String text;
	char[] left;
	char[] right;
	public SymbolBalancer(String filename) {
		this.filename = filename;
		readFile();
	}
	public void setText(String text) {
		this.text = text;
	}
	
	boolean symbolsBalanced(String delimiters){
		fillDelimArrays(delimiters);
		return checkDelimiters();
		
	}
	boolean checkDelimiters() {
		if(text == null) return true;
		int len = text.length();
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < len; ++i){
			char next = text.charAt(i);
			if(isOpen(next)){
				stack.push(next);
			}
			if(isClosed(next)){
				if(stack.isEmpty()) return false;
				char c = stack.pop();
				if(!match(c, next)) return false;
			}
		}
		if(!stack.isEmpty()){ 
			return false;
		}
		return true;
	}
	boolean isOpen(char c){
		return (open(c) > -1);
	}
	boolean isClosed(char c){
		return (closed(c) > -1);
	}
	int open(char c){
		for(int i = 0; i < left.length; ++i){
			if(c == left[i]) return i;
		}
		return -1;
	}
	int closed(char c){
		for(int i = 0; i < right.length; ++i){
			if(c == right[i]) return i;
		}
		return -1;
	}
	boolean match(char c, char d){
		if(isOpen(c) && isClosed(d)){
			return (open(c)==closed(d));
		}
		if(isClosed(c) && isOpen(d)){
			return (closed(c) == open(d));
		}
		return false;
	}
	
	void fillDelimArrays(String delims){
		int len = delims.length();
		left = new char[len/2];
		right = new char[len/2];
		for(int i = 0; i < len; ++i){
			if(i % 2 == 0){
				left[i/2]=delims.charAt(i);
			}
			else {
				right[i/2]=delims.charAt(i);
			}
		}
	}
	public static void main(String[] args) {
		SymbolBalancer sb = new SymbolBalancer("prog9_2_soln\\Employee.java");
		System.out.println(sb.symbolsBalanced("[]{}<>()"));
	}
	void readFile() {
		String prefix = System.getProperty("user.dir") + "\\src\\";
		System.out.println(prefix);
		try {
			List<String> lines = Files.readAllLines(Paths.get(prefix, filename));
			StringBuilder textsb = new StringBuilder();
			for(String line : lines) {
				textsb.append(line + "\n");
			}
			text = textsb.toString();
		} catch(IOException e) {
			System.out.println("File not found: " + e.getMessage());
		}
		System.out.println(text);
	}
	
}



