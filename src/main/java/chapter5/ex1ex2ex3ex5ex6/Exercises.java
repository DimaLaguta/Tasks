package chapter5.ex1ex2ex3ex5ex6;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Exercises {
    //1
    public List<Double> readValues(String filename) throws IOException, NumberFormatException {
        Reader reader = new FileReader(filename);
        BufferedReader buffReader = new BufferedReader(reader);

        String input = "";
        while (buffReader.ready()) {
            input = buffReader.readLine();
        }

        buffReader.close();
        reader.close();

        String[] arrayInput = input.split(" ");
        List<Double> doubleArray = new ArrayList<>();
        for (String s : arrayInput) {
            try {
                doubleArray.add(Double.parseDouble(s));
            } catch (NumberFormatException e) {
                throw new NumberFormatException();
            }
        }
        return doubleArray;
    }
    //2
    public double sumOfValues(String filename) throws IOException, NumberFormatException {
        List<Double> doubleArray;
        try {
            doubleArray = readValues(filename);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
        Double sum = 0.0;
        for (Double i : doubleArray) {
            sum += i;
        }
        return sum;
    }

    //ex5
    public void ScannerPrintWriter(String filename) {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get(filename));
            out = new PrintWriter("output.txt");
            while (in.hasNext())
                out.println(in.next().toLowerCase());
        } catch (IOException | IllegalStateException | NoSuchElementException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null)
                    in.close();
                if (out != null)
                    out.close();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }

    }

    //ex6
    public void d(Path path) {
        //1
        BufferedReader in1 = null;
        try {
            in1 = Files.newBufferedReader(path, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        } finally {
            if (in1 != null) {
                try {
                    in1.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }

        //2
        BufferedReader in2 = null;
        try {
            try {
                in2 = Files.newBufferedReader(path, StandardCharsets.UTF_8);
            } finally {
                if (in2 != null) {
                    in2.close();
                }
            }
        } catch (IOException ex) {
            System.err.println("Caught IOException: " + ex.getMessage());
        }

        //3
        try {
            try (BufferedReader in3 = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
                //do something
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
