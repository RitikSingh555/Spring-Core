package LoggerProblem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppLogger {

    static {
        // Initialize Log4j configuration
        Configurator.initialize(null, "src/main/resources/log4j2.xml");
    }

    private static final Logger logger = LogManager.getLogger(AppLogger.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        logger.info("Starting the program at {}", getCurrentDateTime());

        // Your program logic here...

        logProgress("Step 1 completed.");
        // More progress updates...

        logger.info("Program completed successfully at {}", getCurrentDateTime());
    }

    private static String getCurrentDateTime() {
        return dateFormat.format(new Date());
    }

    private static void logProgress(String message) {
        logger.info("INFO | {} | {}", getCurrentDateTime(), message);
    }
}
