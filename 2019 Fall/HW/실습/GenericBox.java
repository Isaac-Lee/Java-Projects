package �ǽ�;

public class GenericBox<T> {
	private T data;

	public T get() {
		return data;
	}

	public void set(String string) {
		this.data = (T) string;
	}

}
