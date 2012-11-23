/**
 * Driver class for CommandParser used for testing.
 * @author Chamila Abeyratna
 */
public class CommandDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// day command
		String firstCmd = "/day 20";
		CommandParser.ParserResults firstCmdResults = CommandParser.parse(firstCmd);
		System.out.println(firstCmdResults);
		
		String errorCmd = "/foo 1 2";
		CommandParser.ParserResults errorCmdResults = CommandParser.parse(errorCmd);
		System.out.println(errorCmdResults);
		
		String hashCmd = "#zac #efron";
		CommandParser.ParserResults hashCmdResults = CommandParser.parse(hashCmd);
		System.out.println(hashCmdResults);
		
		String searchCmd = "meeting";
		CommandParser.ParserResults searchCmdResults = CommandParser.parse(searchCmd);
		System.out.println(searchCmdResults);
	}

}
