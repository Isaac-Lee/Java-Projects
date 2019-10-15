package °úÁ¦;

public class Triple<T> {
	private T first, second, third;
	
	public T getFirst() {
		return first;
	}
	public void setFirst(T first) {
		this.first = first;
	}
	public T getSecond() {
		return second;
	}
	public void setSecond(T second) {
		this.second = second;
	}
	public T getThird() {
		return third;
	}
	public void setThird(T third) {
		this.third = third;
	}
	
	public String toString() {
		return ("First: "+ (String) this.getFirst()+", Second: "+(String) this.getSecond()+", Third: "+(String) this.getThird());
	}
	
	public Triple(T f, T s, T t) {
		this.first = f;
		this.second = s;
		this.third = t;
	}
	

}
