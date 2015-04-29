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


    static public void Shifration(File filein, File fileout) {
        InputStream inputStream;
        OutputStream outputStream;

        try {
            inputStream = new FileInputStream(filein);
            outputStream = new FileOutputStream(fileout);
            InputStreamReader in = new InputStreamReader(inputStream);
            OutputStreamWriter out1 = new OutputStreamWriter(outputStream, _encodingOne);
            OutputStreamWriter out2 = new OutputStreamWriter(outputStream, _encodingTwo);
            BufferedReader reader = new BufferedReader(in);
            BufferedWriter writer1=new BufferedWriter(out1);
            BufferedWriter writer2=new BufferedWriter(out2);
            //PrintWriter writer=new PrintWriter(outputStream);
            int c=0;
            reader.read();
            try {
                while (c != -1)
                {
                    c=reader.read();
                    if(c == -1)
                    {break;}
                    System.out.println(c);
                    writer2.write(c >> 8); //(лев. старш байт)

                    writer2.flush();

                    writer1.write(c & 255); //(прав. младш байт)
                    writer1.flush();
                }
            } catch (Exception ex)
            {
                ex.printStackTrace();
            }




        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist: " + filein);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


    static public void De_Shifration(File filein, File fileout) {
        InputStream inputStream1;
        InputStream inputStream2;
        OutputStream outputStream;

        try {
            inputStream1 = new FileInputStream(filein);
            inputStream2 = new FileInputStream(filein);
            outputStream = new FileOutputStream(fileout);
            InputStreamReader in1 = new InputStreamReader(inputStream1, _encodingOne);
            InputStreamReader in2 = new InputStreamReader(inputStream2, _encodingTwo);
            OutputStreamWriter out = new OutputStreamWriter(outputStream);
            BufferedReader reader1 = new BufferedReader(in1);
            BufferedReader reader2 = new BufferedReader(in2);
            BufferedWriter writer=new BufferedWriter(out);
            //PrintWriter writer=new PrintWriter(outputStream);
            int c=0;
            System.out.println();
            try {
                while (c != -1)
                {
                    //
                    c=reader1.read();
                    reader2.read();

                    if(c == -1)
                    {break;}
                    System.out.println(c);


                    c <<= 8; //Старший б
                    int temp = reader2.read();
                    if(temp == -1)
                    {break;}
                    c|=temp; //Младший б.
                    reader1.read();

                    System.out.println(c);
                    writer.write(c);

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            writer.flush();

        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist: " + filein);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


}