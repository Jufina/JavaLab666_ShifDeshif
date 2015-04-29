package com.miet.mp34.samoshchenko.lab6;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

/**
 * Created by Julia on 29.04.2015.
 */
public class Convertion {
    private static String _encodingSrc = "UTF8";
    private static String _encodingOne = "Cp866";

    public static void main(String[] args) {
        /*
        if (args.length != 2)
        {
            System.out.println("Wrong number of input arguments");
            return;
        }
        */
        File srcfile = new File("srctext.txt");
        File outfile = new File("outtext.txt");
        String contents = GetContents(srcfile);
        System.out.print("File contents:\r\n" + contents);
        System.out.println("--------------------------------------------");

        Shifration(srcfile, outfile);

        String contents2 = GetContents(outfile);
        System.out.print("File contents:\r\n" + contents);
        System.out.println("--------------------------------------------");
    }

    static public String GetContents(File file) {
        StringBuilder contents = new StringBuilder();

        try {
            if (file == null) {
                throw new IllegalArgumentException("File should not be null.");
            }

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            if (!file.canRead()) {
                throw new IllegalArgumentException("File cannot be written: " + file);
            }

            if (!file.isFile()) {
                throw new IllegalArgumentException("Should not be a directory: " + file);
            }

            FileInputStream src = new FileInputStream(file);
            InputStreamReader in = new InputStreamReader(src, _encodingSrc);
            BufferedReader input = new BufferedReader(in);
            try {
                String line = null;

                while ((line = input.readLine()) != null) {
                    contents.append(line + "\r\n");
                }
            } finally {
                input.close();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist: " + file);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return contents.toString();
    }

    static public void Shifration(File filein, File fileout) {
        InputStream inputStream;
        OutputStream outputStream;

        try {
            inputStream = new FileInputStream(filein);
            outputStream = new FileOutputStream(fileout);
            InputStreamReader in = new InputStreamReader(inputStream, _encodingSrc);
            BufferedReader reader = new BufferedReader(in);
            PrintWriter out = new PrintWriter(outputStream);
            try {
                while (reader.ready()) {
                    StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                    String str = tokenizer.nextToken();
                    out.print(str+" ");
                    while (tokenizer.hasMoreTokens())
                    {
                        str = tokenizer.nextToken();
                        out.print(str+" ");

                    }

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            out.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist: " + filein);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}

