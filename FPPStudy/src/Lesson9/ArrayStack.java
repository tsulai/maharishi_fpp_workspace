package Lesson9;

public class ArrayStack {
	/* Assumption: the stack will never become full */
	private static final int LEN = 500;
	private int top = -1;//top index
	private int nextOpen = 0;
	private Integer[] arr = new Integer[LEN];//ဒီ arr ထဲကိုလာထည့်မှာ - stack ပုံစံနဲ့ လာထည့်မှာ
	
	public void push(Integer x) {//always push to top stack
		if(x == null) return;
		arr[nextOpen] = x;
		top++;
		nextOpen++;
	}	
	public Integer peek() {//return value
		return (top == -1) ? null : arr[top];
	}
	public Integer pop() {//return remove item
		Integer ret = peek();
		if(ret != null) {
			arr[top] = null;
			top--;
			nextOpen --;
		}
		return ret;
	}
	@Override
	public String toString() {//stack arr တစ်ခုလုံးကို ထုတ်ပေးမှာ
		if(top == -1) return "<empty>";
		StringBuilder sb = new StringBuilder();
		for(Integer x: arr) {
			if(x != null) {//ဒါပါမှရ မပါရင် x is null error တက်
				sb.append(x.toString()).append(" ");	
			}			
		}
		return sb.toString();
	}	
	
	public static void main(String[] args) {
		ArrayStack st = new ArrayStack();
		st.push(1);
		st.push(2);
		System.out.println(st);
		st.pop();
		System.out.println(st);
		st.pop();
		System.out.println(st);
		

	}

}
