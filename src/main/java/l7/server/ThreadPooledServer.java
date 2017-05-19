//package l7.server;
//
//import l7.worker.WorkerRunnable;
//
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * Created by Cole S' Offe on 18.05.2017.
// */
//public class ThreadPooledServer implements Runnable{
//
//    protected int serverPort = 5050;
//    protected ServerSocket serverSocket = null;
//    protected boolean isStopped = false;
//    protected Thread runningThread = null;
//    protected ExecutorService threadPool = Executors.newFixedThreadPool(10);
//
//    public ThreadPooledServer(int port){
//        this.serverPort = port;
//    }
//
//    public void run(){
//        synchronized(this){
//            this.runningThread = Thread.currentThread();
//        }
//        openServerSocket();
//        while(!isStopped()){
//            Socket clientSocket = null;
//            try {
//                clientSocket = this.serverSocket.accept();
//            } catch (IOException e) {
//                if(isStopped()) {
//                    break;
//                }
//                throw new RuntimeException(
//                        "Error accepting client connection", e);
//            }
//            this.threadPool.execute(
//                    new WorkerRunnable(clientSocket));
//        }
//        this.threadPool.shutdown();
//    }
//
//
//    private synchronized boolean isStopped() {
//        return this.isStopped;
//    }
//
//    public synchronized void stop(){
//        this.isStopped = true;
//        try {
//            this.serverSocket.close();
//        } catch (IOException e) {
//            throw new RuntimeException("Error closing server", e);
//        }
//    }
//
//    private void openServerSocket() {
//        try {
//            this.serverSocket = new ServerSocket(this.serverPort);
//        } catch (IOException e) {
//            throw new RuntimeException("Cannot open port 5050", e);
//        }
//    }
//}