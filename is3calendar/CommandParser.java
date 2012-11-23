import java.util.Map;
import java.util.HashMap;

/**
 * Calendar command static class for parsing commands
 * 
 * @author Chamila Abeyratna
 *
 */
public class CommandParser {
	// holds the types of views and different view types (INSCEPTYPES!!)
	public static enum type { COMMAND, HASHTAG, SEARCH; }
	public static enum view { ERROR, SEARCH, DAY, WEEK, MONTH, YEAR, ADD, DEL, FILTER, CALC; }

	// holds a map of commands to their appropriate view type
	private static final Map<String, view> commands = new HashMap<String , view>() {
		private static final long serialVersionUID = -3374248550526581860L;
	{
	    put("/d", view.DAY);
	    put("/day", view.ADD);
	    put("/w", view.WEEK);
	    put("/week", view.WEEK);
	    put("/m", view.MONTH);
	    put("/month", view.MONTH);
	    put("/y", view.YEAR);
	    put("/year", view.YEAR);
	    put("/add", view.ADD);
	    put("/del", view.DEL);
	    put("/filter", view.FILTER);
	    put("/calc", view.CALC);
	}};
	
	/**
	 * ParserResults objects holds the parser results. Contains the
	 * type of command, the appropriate view and the arguments for 
	 * that command, if any.
	 * 
	 * commandType 	type of command
	 * commandView  type of view
	 * args 		a string array of arguments (if any)
	 */
	public static class ParserResults {
	   type commandType;
	   view commandView;
	   String [] args;
	   public ParserResults (type commandType, view commandView, String [] args) {
		   this.commandType = commandType;
		   this.commandView = commandView;
		   this.args = args;
	   }
	   
	   public String toString() {
		   String argsrting = "";
		   for (String a : args) { argsrting += a + " "; }
		   return commandType + " " + commandView + " " + argsrting;
	   }
	}
	
	/**
	 * Parse raw string and returns a ParserResults object
	 * @param raw
	 * @return
	 */
	public static ParserResults parse(String raw) {
		// check the type of raw command
		String [] rawParts;
		switch (raw.charAt(0)) {
		case '/':
			rawParts = raw.split(" ");
			// command, check which command it is exactly
			if (commands.get(rawParts[0]) != null) {
				return new ParserResults(type.COMMAND, commands.get(rawParts[0]), rawParts);
			} else {
				return new ParserResults(type.COMMAND, view.ERROR, rawParts);
			}
						
		case '#':
			rawParts = raw.split("#");
			return new ParserResults(type.HASHTAG, view.SEARCH, rawParts);
			
		default:
			if (raw.trim().length() > 0) {
				rawParts = raw.split(" ");
				return new ParserResults(type.SEARCH, view.SEARCH, rawParts);
			} else {
				rawParts = new String[] {""};
				return new ParserResults(type.SEARCH, view.ERROR, rawParts);
			}
		}
	}
}
