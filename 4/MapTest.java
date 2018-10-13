import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * MapTest contains the main method to run the JUnitMapTest class.
 * @author Cristian Groza
 */
public class MapTest
{
    public static void main(String[] args)
    {
        // run tester class
        Result testRun = JUnitCore.runClasses(JUnitMapTest.class);
        // iterate and print failures
        for(Failure f : testRun.getFailures())
            {
                System.out.println(f.toString());
            }
        // all tests ok?
        System.out.println(testRun.wasSuccessful());
    }
}
