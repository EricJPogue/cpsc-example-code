// Hello World Plus including:
// 1 - Multiple classes in multiple files
// 2 - Initialization with Constructors
// 3 - Encapsulation using Getters and setters
// 4 - Over-riding toString()

class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello, World!");
		
		sayHelloClass sayHelloObject = new sayHelloClass();
		sayHelloObject.setHelloText("Hello, World - EJP!");
		System.out.println(sayHelloObject);
    }
}