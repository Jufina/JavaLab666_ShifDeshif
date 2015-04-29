package com.miet.mp34.samoshchenko.lab6;



import java.io.*;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

/**
 * Created by Julia on 29.04.2015.
 */
public class TestConvert {
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
       // De_Shifration(outfile, outfile2);

    }


    static public void Shifration(File filein, File fileout) {
        InputStream inputStream;
        OutputStream outputStream;

        try {
            inputStream = new FileInputStream(filein);
            outputStream = new FileOutputStream(fileout);
            InputStreamReader in = new InputStreamReader(inputStream, _encodingSrc);
            OutputStreamWriter out1 = new OutputStreamWriter(outputStream, _encodingOne);
            OutputStreamWriter out2 = new OutputStreamWriter(outputStream, _encodingOne);


        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist: " + filein);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}


