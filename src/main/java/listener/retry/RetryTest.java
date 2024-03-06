package listener.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import utils.FileReader;

public class RetryTest implements IRetryAnalyzer {

    int counter = 1;
    int retryMaxLimit = Integer.parseInt(FileReader.getDataFromPropFile("retryCount"));

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (!(iTestResult.isSuccess())) {
            if (counter < retryMaxLimit) {
                counter++;
                return true;
            }
        }
        return false;
    }
}
