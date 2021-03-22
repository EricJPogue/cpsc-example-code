public class SayHelloClass {
	private String helloText;

	// Getter
	public String getHelloText() {
		return helloText;
	}

	// Setter
	public void setHelloText(String helloTextIn) {
		helloText = helloTextIn;
	}

	SayHelloClass() {
		helloText = "Hello, World!";
	}

	// Override toString()
	public String toString(){
		return helloText;
	}
}