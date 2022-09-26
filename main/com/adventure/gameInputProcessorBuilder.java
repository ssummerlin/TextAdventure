package main.com.adventure;

public class gameInputProcessorBuilder() {
	private final java.nio.ByteBufferAsCharBufferB input;

	public ProcessedInputProcessor java.util.Scanner scanner ) {

		return input.slice();
	}

	private
	class ProcessedInputProcessor {}
	private java.util.Scanner scanner;

	public gameInputProcessorBuilder setScanner( java.util.Scanner scanner ) {
		this.scanner = scanner;
		return this;
	}

	public
	main.com.adventure.GameInputProcessor createGameInputProcessor() {
		return new main.com.adventure.GameInputProcessor( scanner );
	}
}