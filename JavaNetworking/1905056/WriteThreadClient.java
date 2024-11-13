package tcpforward;

import util.NetworkUtil;

import java.io.IOException;
import java.util.Scanner;

public class WriteThreadClient implements Runnable {

    private Thread thr;
    private NetworkUtil networkUtil;
    String name;

    public WriteThreadClient(NetworkUtil networkUtil, String name) {
        this.networkUtil = networkUtil;
        this.name = name;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run() {
        try {
            Scanner input = new Scanner(System.in);
            while (true) {
                String from = name;
                networkUtil.write(name);
                System.out.println("Enter Request type :");
                String requestType=input.nextLine();
                if(requestType.equalsIgnoreCase("GetList")){
                    networkUtil.write(requestType);
                    networkUtil.write(from);
                }
                else if(requestType.equalsIgnoreCase("SendMessage")){

                    System.out.print("Enter name of the client to send: ");
                    String to = input.nextLine();
                    System.out.print("Enter the message: ");
                    String text = input.nextLine();
                    Message message = new Message();
                    message.setFrom(from);
                    message.setTo(to);
                    message.setText(text);
                    networkUtil.write(message);
                }
                else if(requestType.equalsIgnoreCase("Broadcast")){

                    System.out.print("Enter the message to broadcast ");
                    String broadcast=input.nextLine();
                    networkUtil.write(requestType);
                    String message=input.nextLine();
                    networkUtil.write(message);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                networkUtil.closeConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}