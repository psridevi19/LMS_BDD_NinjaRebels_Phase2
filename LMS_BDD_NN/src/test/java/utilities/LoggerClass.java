package utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class LoggerClass {
public static Logger logger=(Logger) LogManager.getLogger();
	
	public static void info(String msg)
	{
		logger.info("info :"+msg);
	}
	
	public static void warn(String msg)
	{
		logger.warn("warn :"+msg);
	}
	
	public static void debug(String msg)
	{
		logger.debug("debug :"+msg);
	}
	public static void error(String msg)
	{
		logger.error("error :"+msg);
	}
}
