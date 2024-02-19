package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import java.io.File;
import java.util.Objects;

public class CustomLogger {

    private static final Logger logger = LogManager.getLogger();

    public static synchronized void startTestCase(String testCaseName) {
        testCaseName = testCaseName.replaceAll("[^a-zA-Z0-9]", "_").replaceAll("_+", "_");
        startLog(System.getProperty("user.dir")+"/src/test/resources/logs/", testCaseName);
        info("\n***** Execution Started For : " + testCaseName + "*****");
    }

    public static void endTestCase(String testCaseName){
        info("\n***** Execution Ended For : " + testCaseName + "*****");
    }

    private static void startLog(String fileDirPath, String testCaseName) {
        int numOfFiles = 0;
        File directory = new File(fileDirPath);
        if (directory.exists()) {
            int count = 0;
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                if (file.isFile() && file.getName().endsWith(".log") && file.getName().contains(testCaseName)) {
                    count++;
                }
            }
            numOfFiles = count;
        }
        numOfFiles++;
        String logFileName = testCaseName + "_" + numOfFiles;
        ThreadContext.put("logFileName", logFileName);
    }

    public static Logger getCurrentLog() {
        return logger;
    }

    public static String getCallerInfo() {
        String callerInfo;
        String className = Thread.currentThread().getStackTrace()[3].getClassName();
        String methodName = Thread.currentThread().getStackTrace()[3].getMethodName();
        int lineNumber = Thread.currentThread().getStackTrace()[3].getLineNumber();
        callerInfo = className + ":" + methodName + ":" + lineNumber + "->";
        return callerInfo;
    }

    public static void trace(Object message) {
        getCurrentLog().trace(getCallerInfo() + message);
    }

    public static void trace(Object message, Throwable throwable) {
        getCurrentLog().trace(getCallerInfo() + message, throwable);
    }

    public static void debug(Object message) {
        getCurrentLog().debug(getCallerInfo() + message);
    }

    public static void debug(Object message, Throwable throwable) {
        getCurrentLog().debug(getCallerInfo() + message, throwable);
    }

    public static void error(Object message) {
        getCurrentLog().error(getCallerInfo() + message);
    }

    public static void error(Object message, Throwable throwable) {
        getCurrentLog().error(getCallerInfo() + message, throwable);
    }

    public static void fatal(Object message) {
        getCurrentLog().fatal(getCallerInfo() + message);
    }

    public static void fatal(Object message, Throwable throwable) {
        getCurrentLog().fatal(getCallerInfo() + message, throwable);
    }

    public static void info(Object message) {
        getCurrentLog().info(getCallerInfo() + message);
    }

    public static void info(Object message, Throwable throwable) {
        getCurrentLog().info(getCallerInfo() + message, throwable);
    }

    public static void warn(Object message) {
        getCurrentLog().warn(getCallerInfo() + message);
    }

    public static void warn(Object message, Throwable throwable) {
        getCurrentLog().warn(getCallerInfo() + message, throwable);
    }

}
