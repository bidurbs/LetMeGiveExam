package cs544.letmegiveexam.aspect;


public class Logger implements ILogger {

    public void log(String logstring) {
        java.util.logging.Logger.getLogger("BankLogger").info(logstring);
    }

    

}
