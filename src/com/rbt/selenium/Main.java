package com.rbt.selenium;

import com.rbt.selenium.tests.testSuite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Result result= JUnitCore.runClasses(testSuite.class);
            Logger l = Logger.getLogger(Main.class.toString());

        for (Failure f: result.getFailures()) {
            l.warning(f.toString());
        }

        l.info("Vreme izvrsavanja:" + result.getRunTime());
        l.info("Broj testova:"+ result.getRunCount());

        l.info("Uspesno testova:" + (result.getRunCount()-result.getFailureCount()-result.getIgnoreCount()-result.getAssumptionFailureCount()));
        l.info("Broj palih testova:"+ result.getFailureCount());
        l.info("Broj preskocenih:"+ result.getIgnoreCount());
        l.info("Broj dinamicki preskocenih:" + result.getAssumptionFailureCount());

        if (result.wasSuccessful())
            l.info("Svi testovi su uspesno izvrseni");
        else
            l.warning("Postoje greske u testovima");
        try {
            File myObj = new File("test-reports.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("test-reports.txt");
            myWriter.write("Vreme izvrsavanja:" + result.getRunTime());
            myWriter.write("\nBroj testova:"+ result.getRunCount());
            myWriter.write("\nUspesno testova:" + (result.getRunCount()-result.getFailureCount()-result.getIgnoreCount()-result.getAssumptionFailureCount()));
            myWriter.write("\nBroj palih testova:"+ result.getFailureCount());
            myWriter.write("\nBroj preskocenih:"+ result.getIgnoreCount());
            myWriter.write("\nBroj dinamicki preskocenih:" + result.getAssumptionFailureCount());
            myWriter.write("\n\n");
            myWriter.write("JAGGERBRAND:\n");
            myWriter.write("SEDIŠTE FIRME\n" +
                    "Rada Končara 59d, Zemun, Beograd, Srbija\n");
            myWriter.write("KONTAKT TELEFON\n" +
                    "+381 (0)65 264 64 56\n" +
                    "(radnim danima od 09:00 do 13:00)");
            myWriter.write("\n" +
                    "EMAIL ADRESA\n" +
                    "shop@jaggerbrand.com");
            myWriter.write("\nMATIČNI BROJ / PIB\n" +
                    "20550899 / 106185570");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
