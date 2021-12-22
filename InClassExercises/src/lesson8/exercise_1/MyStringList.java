package lesson8.exercise_1;

public class MyStringList {
	private final int INITIAL_LENGTH = 2;
	private String[] strArray; 
	private int size;
	
	public MyStringList() {
		strArray = new String[INITIAL_LENGTH];
		size = 0;
	}
	
	public void minSort() {
		if(strArray == null || size <= 1) return;
		for(int i = 0; i<size; ++i) {
			int nextMinPos = minpos(i, size-1);//0 ကစလို့ size -1 
			swap(i,nextMinPos);
			//bottom တိုးတိုးသွားပြီး swap သွားမှာ
		}
	}
	//bottom ကောင် နဲ့ တွေ့တဲ့ကောင် နေရာချင်းလဲ
	void swap(int i, int j) {
		String temp = strArray[i];
		strArray[i] = strArray[j];
		strArray[j] = temp;
	}
	
	//find minimum of arr betweeen the indices bottom and top
	//ရှေ့ဆုံး bottom နေရာက တစ်ကောင်နဲ့ပဲ ကျန်တာတွေကို လိုက် compare တာ
	//bottom ကောင်ထက်ငယ်တဲ့ကောင်ထွက်လာမှာ
	public int minpos(int bottom, int top) {
		String min = strArray[bottom];//set first bottom one as min
		int index = bottom;//ရှေ့ဆုံး bottom နေရာကကောင်နဲ့ပဲ ကျန်တာတွေကို လိုက် compare တာ
		for(int i = bottom+1; i<=top; ++i) {//bottom+1 နဲ့ top နဲ့ကြားသေးတာကို compareTo လုပ်ပြီးရှာမယ်
			if(strArray[i].compareTo(min) < 0) {//ရှေ့ကကောင် ငယ်ရင် -1 ထွက်မှာ 
				min = strArray[i];
				index = i;
			}
		}
		return index;//အငယ်ဆုံးကောင် pos index ထွက်လာမှာ
	}
	
	public void add(String s){
		if(size == strArray.length) resize();
		strArray[size++] = s;
	}
	
	public String get(int i){
		if(i < 0 || i >= size){
			return null;
		}
		return strArray[i];
	}
	
	public boolean find(String s){
		for(String test : strArray){
			if(test.equals(s)) return true;
		}
		return false;
	}
	
	public void insert(String s, int pos){
		if(pos > size) return;
		if(pos >= strArray.length || size + 1 > strArray.length) {
			resize();
		}
		String[] temp = new String[strArray.length + 1];
		System.arraycopy(strArray, 0, temp, 0, pos);
		temp[pos] = s;
		
		System.arraycopy(strArray,pos,temp,pos+1, strArray.length - pos);
		strArray = temp;
		++size;
		
	}
	
	public boolean remove(String s){
		if(size == 0) return false;
		int index = -1;
		for(int i = 0; i < size; ++i ){
			if(strArray[i].equals(s)){
				index = i;
				break;
			}
		}
		if(index==-1) return false;
		String[] temp = new String[strArray.length];
		System.arraycopy(strArray, 0, temp, 0, index);
		System.arraycopy(strArray, index + 1, temp, index, strArray.length-(index+1));
		strArray = temp;
		--size;
		return true;
	}
	
	
	private void resize(){
		System.out.println("resizing");
		int len = strArray.length;
		int newlen = 2*len;
		String[] temp = new String[newlen];
		System.arraycopy(strArray, 0, temp, 0, len);
		strArray = temp;
	}
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < size-1; ++i){
			sb.append(strArray[i] + ", ");
		}
		sb.append(strArray[size-1] + "]");
		return sb.toString();
	}
	public int size() {
		return size;
	}

	public static void main(String[] args){
		MyStringList l = new MyStringList();
		l.add("Bob");
		l.add("Steve");
		l.add("Susan");
		l.add("Mark");
		l.add("Dave");
		l.minSort();
		//System.out.print(l.toString());
		String[] testArr = {"big", "small", "tall", "short", "round", "square", "enormous", "tiny","gargantuan", "lilliputian", "numberless", "none", "vast", "miniscule"};
		MyStringList list = new MyStringList();
		for(int i = 0; i < testArr.length; ++i) {
			list.add(testArr[i]);
		}
		list.minSort();
		System.out.println("The list in sorted order:");
		System.out.println(list.toString());
	}

}
