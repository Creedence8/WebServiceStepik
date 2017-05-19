package l7.main;

//import l7.server.ThreadPooledServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by Cole S' Offe on 18.05.2017.
 */
public class Main {
    private static final long TIME_TO_WORK = TimeUnit.SECONDS.toMillis(10);
    private static final int CLIENTS_NUMBER = 10;

    public static void main(String[] args) throws Exception {
        int port = 5050;
        ExecutorService executor = Executors.newFixedThreadPool(CLIENTS_NUMBER);

        System.out.println("Server started");

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started on port: " + port);
            long startTime = new Date().getTime();

//                Socket socket = serverSocket.accept();
//                SocketChannel socketChannel = socket.getChannel();
//                ByteBuffer buf = ByteBuffer.allocate(1024);

            while (new Date().getTime() < startTime + TIME_TO_WORK) {

                executor.submit(new MirrorSocketRunnable(serverSocket.accept()));

//                while (socketChannel.read(buf)!=-1) {
//                    buf.flip();
//                    if ((new String( buf.array())).equals("Bue.")) {break;}
//                    socketChannel.write(buf);
//                    buf.clear();
//                }
            }
        }
        executor.awaitTermination(1, TimeUnit.MINUTES);
        executor.shutdown();
        System.out.println("Bye.");
    }

    private static class MirrorSocketRunnable implements Runnable {
        private final Socket clientSocket;

        private MirrorSocketRunnable(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
                String inputLine;
                String outputLine;
                int lineIndex = 0;
                while ((inputLine = in.readLine()) != null) {
                    //System.out.println("Message from client: " + inputLine);

                    if (inputLine.equals("Bue."))
                        break;

                    outputLine = inputLine;
                    out.println(outputLine);
                    ++lineIndex;

                }
                System.out.println("Lines processed: " + lineIndex);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }
        }
    }
}
