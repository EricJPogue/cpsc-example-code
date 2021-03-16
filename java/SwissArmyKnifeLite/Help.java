class Help {
	public static void printHelp() {
		// Todo: Implement full help system. 
		System.out.println("\nHttpRequest [URL] examples:");
		System.out.println("java sakl -HttpRequest https://www.slashdot.com");
		System.out.println("java sakl -HttpRequest https://thunderbird-index.azurewebsites.net/w0a6zk195e.json");
		System.out.println("\nHttpRequestIndex [URL] example:");
		System.out.println("java sakl -HttpRequestIndex https://thunderbird-index.azurewebsites.net/w0a6zk195d.json");
		System.out.println("\nDoMagicStuff example:");
		System.out.println("java sakl -DoMagicStuff");
	}
}