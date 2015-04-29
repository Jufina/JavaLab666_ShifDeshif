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
    private static String _encodingTwo = "KOI8_R";
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
        File outfile2 = new File("outtext2.txt");

        Shifration(srcfile, outfile);
        De_Shifration(outfile, outfile2);

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
            OutputStreamWriter out = new OutputStreamWriter(outputStream, _encodingOne);
            BufferedReader reader = new BufferedReader(in);
            BufferedWriter writer=new BufferedWriter(out);
            //PrintWriter writer=new PrintWriter(outputStream);
            int c;
            try {
                while ((c = reader.read())!= -1)
                {
                    System.out.println(c);
                    writer.write(c);

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            writer.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist: " + filein);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


    static public void De_Shifration(File filein, File fileout) {
        InputStream inputStream;
        OutputStream outputStream;

        try {
            inputStream = new FileInputStream(filein);
            outputStream = new FileOutputStream(fileout);
            InputStreamReader in = new InputStreamReader(inputStream, _encodingOne);
            OutputStreamWriter out = new OutputStreamWriter(outputStream, _encodingSrc);
            BufferedReader reader = new BufferedReader(in);
            BufferedWriter writer=new BufferedWriter(out);
            //PrintWriter writer=new PrintWriter(outputStream);
            int c;
            try {
                while ((c = reader.read())!= -1)
                {
                    System.out.println(c);
                    writer.write(c);

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            writer.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist: " + filein);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


}

