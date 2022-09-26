package main.com.adventure;

import main.com.adventure.settings.Command;

public interface GameInputProcessors() {
	public
	processInput( java.util.Scanner scanner );

	String prompt();
}

	/**
	 * Inputs that come into this method represent single action with no object. When building the command, you'll want
	 * to supply the first word as the verb and leave the objectName blank.
	 * Example input:
	 * "help"
	 * "look"
	 * <p>
	 * Note: this command must stay private when running the tests
	 *
	 * @param input - the input from the user
	 * @return - the Command object with the proper verb and blank object
	 */
	private
	Command buildSimpleCommand( String input ) {
		return buildCommandWithObject( input, objectName );
	}

	default
	main.com.adventure.settings.Command buildCommandWithObject( String input, String objectName ) {
		return null;
	}

	{
        Command command = new Command();
		return buildSimpleCommand( "look" );
	}
}
