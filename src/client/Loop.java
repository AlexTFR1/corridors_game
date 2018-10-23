package client;

import javafx.scene.control.TextArea;
import javafx.scene.shape.Rectangle;

public class Loop extends Thread{
    Client client;
    TextArea textArea;
    Rectangle rect;

    public Loop(Client client, Rectangle rect) {
        this.client = client;
        //this.textArea = textArea;
        this.rect = rect;
    }

    public void run(){
        while(true){
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String str = client.getMessage();
            if(str!=null){
                textArea.setText(str);
            }
        }
    }
}
