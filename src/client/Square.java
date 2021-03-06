package client;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import javafx.scene.shape.Rectangle;

public class Square implements objects
{
    private Rectangle square;

    public Square(int X, int Y, int sideSize)
    {
        square = new Rectangle(X,Y,sideSize,sideSize);
        square.setFill(Color.GRAY);
        square.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>()
        {
            @Override
            public void handle(MouseEvent event)
            {
                square.setFill(Color.RED);
            }
        });
    }

    @Override
    public void show(Pane anchorPane)
    {
        anchorPane.getChildren().add(square);
    }


}

