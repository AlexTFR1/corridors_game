package client;

import server.Server_Interface;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class Edge implements objects
{
    private Line line;


    public Edge(int startX, int startY, int endX, int endY, double width )
    {
        line = new Line(startX,startY,endX,endY);
        line.setStrokeWidth(width);
        line.setStroke(Color.BLACK);
        line.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                line.setStroke(Color.GREEN);
            }
        });
    }

    @Override
    public void show(Pane pane)
    {
        pane.getChildren().add(line);
    }


}
