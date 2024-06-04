package gr.aueb.cf.ch8;

import java.io.*;

/**
 * Exercise on IO notes
 *
 * @author Michalis Koutrakis
 */
public class CoordinatesFileApp {
    public static void main(String[] args) {
        String inputFileName = "/home/michalis/locations.txt";
        String outputFileName = "/home/michalis/locationsOut.txt";
        transformFile(inputFileName, outputFileName);
    }

    public static void transformFile(String inputFileName, String outputFileName) {
        try (BufferedReader bfin = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bfout = new BufferedWriter(new FileWriter(outputFileName))) {

            String line = null;
            String[] colNames = new String[3];
            String[] dataTokens = new String[3];

            StringBuilder sb = new StringBuilder();

            // Read the first line and transform it to lowercase
            line = bfin.readLine();
            colNames = line.split(",");
            for (int i = 0; i < colNames.length; i++){
                colNames[i] = colNames[i].toLowerCase();
            }

            // Scan every line till the end
            while((line = bfin.readLine()) != null) {
                dataTokens = line.split(",");

                sb.append("{ ");
                for (int i = 0; i < colNames.length; i++) {
                    if (i > 0) sb.append(", ");
                    sb.append(colNames[i]).append(": ").append(dataTokens[i]);
                }
                sb.append(" },\n");
            }

            // Remove the last comma
            sb.setLength(sb.length() - 2);
            sb.append("\n");

            // Write to output file
            bfout.write(sb.toString());
        } catch (IOException e) {
            System.out.println("IOException.");
        }
    }
}
