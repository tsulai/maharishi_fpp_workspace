class MyClass2 {
AnotherClass a;
public static void main(String[] args) {
int n = 0;
if(args[0] != null) {
n = Integer.parseInt(args[0]);
}
MyClass2 m = new MyClass2();
m.a = new AnotherClass(m);
m.a.anotherMethod(n);
}
void myMethod(int k) {
if(k == 0 || k == 1) {
System.out.println("hello");
return;
}
a.anotherMethod(--k);
}
}
class AnotherClass {
MyClass2 m;
AnotherClass(MyClass2 m) {
this.m = m;
}
void anotherMethod(int k){
m.myMethod(--k);
}
}
