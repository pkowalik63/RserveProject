package pkg;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class Temp {

    public static void main(String a[]) {
        RConnection connection = null;

        try {
            /* Create a connection to Rserve instance running on default port
             * 6311
             */
            connection = new RConnection();
            connection.eval("library(ForecastJacek)");
            connection.eval("helo()");
            /* Note four slashes (\\\\) in the path */
            connection.eval("source('D:\\\\MyScript.R')");
            int num1=10;
            int num2=20;
            int sum=connection.eval("myAdd("+num1+","+num2+")").asInteger();
            System.out.println("The sum is=" + sum);
        } catch (RserveException e) {
            e.printStackTrace();
        } catch (REXPMismatchException e) {
            e.printStackTrace();
        }
    }
}