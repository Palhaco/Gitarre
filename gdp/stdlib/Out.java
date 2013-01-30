package gdp.stdlib;

/*************************************************************************
 * 
 *  Writes data of various types to: stdout, file, or socket.
 *
 *************************************************************************/


import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Out {

    // assume Unicode UTF-8 encoding
    private static final String charsetName = "UTF-8";

    private PrintWriter out;


    // for stdout
    public Out(OutputStream os) {
        try {
            OutputStreamWriter osw = new OutputStreamWriter(os, charsetName);
            out = new PrintWriter(osw, true);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public Out() { this(System.out); }

    // for Socket output
    public Out(Socket socket) {
        try {
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os, charsetName); 
            out = new PrintWriter(osw, true);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    // for file output
    public Out(String s) {
        try {
            OutputStream os = new FileOutputStream(s);
            OutputStreamWriter osw = new OutputStreamWriter(os, charsetName); 
            out = new PrintWriter(osw, true);
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public void close() { out.close(); }


    public void println()          { out.println();  }
    public void println(Object x)  { out.println(x); }
    public void println(boolean x) { out.println(x); }
    public void println(char x)    { out.println(x); }
    public void println(double x)  { out.format(java.util.Locale.US, "%f\n", x); }
    public void println(float x)   { out.format(java.util.Locale.US, "%f\n", x); }
    public void println(int x)     { out.println(x); }
    public void println(long x)    { out.println(x); }

    public void print()            {                 out.flush(); }
    public void print(Object x)    { out.print(x);   out.flush(); }
    public void print(boolean x)   { out.print(x);   out.flush(); }
    public void print(char x)      { out.print(x);   out.flush(); }
    public void print(double x)    { out.format(java.util.Locale.US, "%f", x);   out.flush(); }
    public void print(float x)     { out.format(java.util.Locale.US, "%f", x);   out.flush(); }
    public void print(int x)       { out.print(x);   out.flush(); }
    public void print(long x)      { out.print(x);   out.flush(); }

    public void printf(String format, Object... args) {
        out.printf(format, args);
        out.format(java.util.Locale.US, format, args);
        out.flush();
    }


    // This method is just here to test the class
    public static void main(String[] args) {
        Out out;

        // write to stdout
        out = new Out();
        out.println("Test 1");
        out.close();

        // write to a file
        out = new Out("test.txt");
        out.println("Test 2");
        out.close();
    }
}

