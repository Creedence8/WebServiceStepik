//package l7.worker;
//
//import java.io.*;
//import java.net.Socket;
//import java.util.Scanner;
//
///**
// * Created by Cole S' Offe on 19.05.2017.
// */
//public class WorkerRunnable implements Runnable{
//
//    protected Socket clientSocket = null;
//    private String answer=null;
//    private static final String STOP_WORD="Bue.";
//
//    public WorkerRunnable(Socket clientSocket) {
//        this.clientSocket = clientSocket;
//    }
//
//    public void run() {
//        try {
//            InputStream input  = clientSocket.getInputStream();
//            OutputStream output = clientSocket.getOutputStream();
//
//            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
//            PrintWriter printWriter = new PrintWriter(output);
//
//            answer = reader.readLine();
//            if (answer.equals(STOP_WORD)) {return;}
//            printWriter.write(answer);
//            output.close();
//            input.close();
//        } catch (IOException e) {
//            //report exception somewhere.
//            e.printStackTrace();
//        }
//    }
//}
