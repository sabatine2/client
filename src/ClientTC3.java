import java.io.FileNotFoundException;
import java.io.FileReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class ClientTC3 {

    public static void main(String... args){
        FileReader fileReader;
        try {
            fileReader = new FileReader("/Users/sabatine/Documents/workspace/TC3Simulator/999900000001/999900000001-1.xml");
            XStream xstream = new XStream(new DomDriver());    
            xstream.alias("packetTransfer", PacketTransfer.class);
            PacketTransfer packetTransfer = (PacketTransfer) xstream.fromXML(fileReader);
           
            byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(packetTransfer.packet.getBytes());
            for(int i=0;i < decoded.length;i++){
                System.out.print(decoded[i]);
            }
            
            System.out.print(decoded[1]);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }

}
