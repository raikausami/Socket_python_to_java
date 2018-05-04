import java.io.*;
import java.net.*;

public class Slash{

    public static void main(String[] args){
        runSample();
    }


    static void runSample() {
        try{
            Socket socket = new Socket("localhost", 6000);
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            DataInputStream dis = new DataInputStream(is);
            DataOutputStream dos = new DataOutputStream(os);
            /*
            String a="HELLO";
            dos.writeBytes(a);
            */

            byte message[] = {'H', 'E', 'L', 'L', 'O', '\0'};
            dos.write(message, 0, 6);
            System.out.println("send");
            char recv;
            StringBuffer sb = new StringBuffer();
            
            
            while(true){
                recv = (char)(dis.readByte());
                
                if(recv == '\0') break;

                System.out.print(recv);
                System.out.print(" ");
                sb.append(recv);
            }
            System.out.println("");
            System.out.print("sb : ");
            System.out.println(sb);
            //System.out.println(recv);
            dis.close();
            dos.close();
            os.close();
            is.close();
            socket.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
