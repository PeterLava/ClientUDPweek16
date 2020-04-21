import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        boolean run = true;
        String msg;
        byte[] outArr;
        Scanner sc = new Scanner(System.in);
        byte[] inArr = new byte[1000];
        DatagramSocket dgs = new DatagramSocket();

        while (run) {
                System.out.print("skriv din besked: ");
                msg = sc.nextLine();
                outArr = msg.getBytes();
                InetAddress address = InetAddress.getByName("localhost");
                DatagramPacket outPacket = new DatagramPacket(outArr,outArr.length, address, 6780);
                dgs.send(outPacket);
                DatagramPacket inPacket = new DatagramPacket(inArr, inArr.length);
                dgs.receive(inPacket);
                String inMgs = new String(inArr, 0, inPacket.getLength());
                System.out.println("Server: " + inMgs);
            }
    }
}