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
    private static String _encodingTwo = "KOI8-R";
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
        File srcfile2 = new File("srctext2.txt");
        File outfile2 = new File("outtext2.txt");

        Shifration(srcfile, outfile);
        De_Shifration(outfile, outfile2);

    }



    static public void Shifration(File filein, File fileout) {
        InputStream inputStream;
        OutputStream outputStream;

        boolean kod1=true;
        boolean kod2=false;
        try {
            inputStream = new FileInputStream(filein);
            outputStream = new FileOutputStream(fileout);

            InputStreamReader in = new InputStreamReader(inputStream,_encodingSrc);
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
                    c = reader.read();
                    if(kod1)
                    {
                        System.out.print(1);
                        writer1.write(c);

                        kod1=false;
                        kod2=true;
                    }
                    else if(kod2)
                    {
                        writer2.write(c);
                        System.out.print(2);
                        kod2=false;
                        kod1=true;
                    }
                }

            }

            catch (IOException e) {
                throw new RuntimeException(e);
            }

            writer1.flush();
            writer2.flush();
            reader.close();
            System.out.println();


        }

        catch (FileNotFoundException ex) {
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

            OutputStreamWriter out = new OutputStreamWriter(outputStream,_encodingSrc);
            BufferedReader reader1 = new BufferedReader(in1);
            BufferedReader reader2 = new BufferedReader(in2);

            BufferedWriter writer=new BufferedWriter(out);

            int c=0;
            boolean kod1=true;
            boolean kod2=false;

            try {
                while (c != -1) {

                        if(kod1)
                        {

                           reader2.read();
                            c=reader1.read();

                            kod1=false;
                            kod2=true;

                            writer.write(c);
                        }
                        else {
                            if(kod2)
                            {

                              reader1.read();
                                c=reader2.read();

                                kod2=false;
                                kod1=true;

                                writer.write(c);
                            }
                        }



            }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            writer.close();
            reader1.close();
            reader2.close();




        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist: " + filein);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }


}

