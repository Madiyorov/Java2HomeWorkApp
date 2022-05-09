package geekbrains.com.Java2HomeWorkApp.HomeWork6.HomeWork;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private DataInputStream inputStream;
    private DataOutputStream outputStream;

    public static void main(String[] args) throws IOException {
        new Client().start(Network.HOST, Network.PORT);
    }

    public void start(String host, int port) throws IOException {
        try {
            Socket socket = new Socket(host, port);
            System.out.println("Клиент запущен");
            inputStream = new DataInputStream(socket.getInputStream());
            outputStream = new DataOutputStream(socket.getOutputStream());

            readMessage();
            sendMessage();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            outputStream.close();
            inputStream.close();
        }
    }

    private void readMessage() {
        new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = inputStream.readUTF();
                    if (message.toLowerCase().startsWith("/end")) {
                        System.out.println("Сервер завершил свою работу");
                        System.exit(0);
                    }
                    System.out.println("From client: " + message);
                } catch (IOException e) {
                    System.out.println("подключение прервано");
                    System.exit(0);
                    break;
                }
            }
        }).start();
    }

    private void sendMessage() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            outputStream.writeUTF(message);
            if (message.startsWith("/end")) {
                break;
            }
        }
    }
}