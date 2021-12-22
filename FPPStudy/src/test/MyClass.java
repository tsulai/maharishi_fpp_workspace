package test;
/*What happens when the following is compiled/run? You may assume that the
method permute is implemented correctly elsewhere, and that it has the effect 
of randomly rearranging the characters of a String (for instance, on different 
runs of permute with input “events”, the return values could be, for example, 
“evtsen”, “eestnv” and “evenst”).*/

class MyClass {
	public static void main(String[] args) {
		new MyClass();
		}
		MyClass() {
			recurse("Hello");
		}
		String recurse(String s){ 
			if(s==null || s.equals("")) return "";
			int n = s.length();
			String t = permute(s); //rearrange characters of s
				return recurse(t);
		}
		
		public static String permute(String text) {
		    char[] characters = text.toCharArray();
		    for (int i = 0; i < characters.length; i++) {
		        int randomIndex = (int)(Math.random() * characters.length);
		        char temp = characters[i];
		        characters[i] = characters[randomIndex];
		        characters[randomIndex] = temp;
		    }
		    return new String(characters);
		}
}