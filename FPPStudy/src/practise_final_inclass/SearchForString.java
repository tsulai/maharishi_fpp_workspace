package practise_final_inclass;

//this answer is provided by professor
public class SearchForString {
private String[] arr;
	public SearchForString(String[] arr) {
		this.arr = arr;
	}
	public boolean search(String s){
		return recurSearch(s, arr.length -1);
	}
	
	private boolean recurSearch(String s, int upperIndex){
		if(upperIndex < 0) return false;
		if(arr[upperIndex].equals(s)) return true;
		return recurSearch(s, upperIndex -1);
	}	
	public static void main(String[] args) {
		String[] str = {"Aaron", "Cloryse", "Bob", "Smith", "John", "Henry"};
		SearchForString ss = new SearchForString(str);
		System.out.println(ss.search("Bob"));
	}
}