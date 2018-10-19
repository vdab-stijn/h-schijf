package be.vdab.util;

public class Logger {

	private static Logger instance;
	
	public static final int LOG_THRESHOLD = 100;
	
	public Logger() {}
	
	public static final Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		
		return instance;
	}
	
	public static final void log(final String message) {
		getInstance().logMessage(message);
	}
	
	public static final void log(final String message, final int level) {
		getInstance().logMessage(message, level);
	}

	public final void logMessage(final String message) {
		logMessage(message, 1);
	}
	public final void logMessage(final String message, final int level) {
		if (level >= LOG_THRESHOLD) {
			System.out.println(message);
		}
	}
}
