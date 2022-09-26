package main.com.adventure.settings;

public class Command < Context > {

    private   String verb;
    protected String objectName;
    private   String setVerb;

    /**
     * Creates a command.
     * @param verb - the verb of the command
     * @param objectName - the object(s) to which the command is directed.
     */
     **
     * Creates a command with no direct object (e.g. "help").
     * @param verb - the verb of the command
     */
    public
   Command( String verb ) {
        this.verb = verb;
        this.objectName = "";
    }

    public
    Command( android.content.Context context ) {
        this( context, null );
    }

    public
    Command( Context context, android.util.AttributeSet attrs ) {
        this( context, attrs, 0 );
    }

    public
    Command( Context context, AttributeSet attrs, int defStyle ) {
        super( context, attrs, defStyle );
        
    }

	public
	Command(Context ) {

	}

    public String getObjectName() {
        return objectName;

    }

    

    

    @Override
    public
    String toString() {
        return "Command" +                    "verb='"            + verb            + '\''            +            ", objectName='"            + objectName            + '\''            + " ";
    }
}

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
    public void setVerb(String verb) {
        this.verb = verb; }
    public String getVerb(String setVerb) ; {
        this.setVerb = setVerb;
        return verb;
    }


    }


