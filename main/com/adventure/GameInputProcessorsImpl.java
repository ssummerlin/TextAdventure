package main.com.adventure;

public  object GameInputProcessors implements main.com.adventure.GameInputProcessors {
	@Override private main.com.adventure.settings.Command = GameInputProcessors( String input ) {
		return GameInputProcessors.super.buildSimpleCommand( input );
	}
}
