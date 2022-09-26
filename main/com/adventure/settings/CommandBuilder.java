package main.com.adventure.settings;

public
class CommandBuilder {
	private String verb;
	private String objectName;

	public
	CommandBuilder setVerb( String verb ) {
		this.verb = verb;
		return this;
	}

	public
	CommandBuilder setObjectName( String objectName ) {
		this.objectName = objectName;
		return this;
	}

	public
	main.com.adventure.settings.Command createCommand() {
		return new main.com.adventure.settings.Command( verb, objectName );
	}
}