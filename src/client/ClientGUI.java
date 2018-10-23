package client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import server.Server_Interface;
import javafx.scene.shape.Rectangle;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class ClientGUI extends Application
{
    public boolean isActive;
    private Stage window;
    private Scene scene;
    private Pane layout;
    private Client client;
    private int squareSideSize = 10;
    private int lineLength = 60;
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        ArrayList<Square> squares = new ArrayList<Square>();
        ArrayList<Edge> lines = new ArrayList<Edge>();
        ArrayList<Field> fields = new ArrayList<Field>();
        int N = 3;
        window = primaryStage;
        window.setTitle("window");
        layout = new Pane();
        Registry reg = LocateRegistry.getRegistry("localhost");
        Server_Interface serv = (Server_Interface) reg.lookup(Server_Interface.name);
        client = new Client(serv);
        scene = new Scene(layout, 800,600);
        window.setScene(scene);

        Rectangle rectangle = new Rectangle();
        rectangle.setX(0);
        rectangle.setY(0);
        rectangle.setWidth(400);
        rectangle.setHeight(400);
        rectangle.setFill(Color.BLUE);

        layout.getChildren().addAll(rectangle);

        for(int i=0;i<=2*N;i++)
        {
            if(i%2==0)//квадрат-линия-квадрат
            {
                int cnt=0;
                for (int j=0;j<=2*N;j++)
                {

                    if(j%2==0)
                    {
                        Square tst = new Square(cnt*(squareSideSize+lineLength),(i/2)*(squareSideSize+lineLength),squareSideSize);
                        squares.add(tst);
                        squares.get(squares.size()-1).show(layout);
                        cnt=cnt+1;

                    }
                    else
                    {
                        //построить линию
                        Edge tmp = new Edge(cnt*squareSideSize+lineLength*(cnt-1)+squareSideSize/2,(i/2)*(squareSideSize+lineLength)+squareSideSize/2,
                                            cnt*squareSideSize+cnt*lineLength-squareSideSize/2,(i/2)*(squareSideSize+lineLength)+squareSideSize/2,
                                             squareSideSize);
                        lines.add(tmp);
                        lines.get(lines.size()-1).show(layout);
                    }
                }
            }

            else//линия-поле-линия
            {
                int cnt = 0;
                for (int j=0;j<=2*N;j++)
                {
                    if(j%2==0)//линию
                    {
                        Edge tmp = new Edge(cnt*(squareSideSize+lineLength)+squareSideSize/2,i/2*squareSideSize+(i/2)*lineLength+squareSideSize*3/2,
                                cnt*(squareSideSize+lineLength)+squareSideSize/2,(i/2+1)*(squareSideSize+lineLength)-squareSideSize/2,
                                squareSideSize);
                        lines.add(tmp);
                        lines.get(lines.size()-1).show(layout);
                        cnt=cnt+1;
                    }
                    else//поле
                    {
                        Field temp = new Field(cnt*squareSideSize+lineLength*(cnt-1),
                                i/2*squareSideSize+(i/2)*lineLength+squareSideSize*3/2-squareSideSize/2,
                                lineLength);
                        fields.add(temp);
                        fields.get(fields.size()-1).show(layout);

                    }
                }
            }

        }
        window.show();
        Loop loop = new Loop(client,rectangle);
        loop.start();
    }
}
