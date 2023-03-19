package util;

import javafx.scene.Node;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;

public class DraggableMaker {
    private double startX=0.0,startY=0.0;
    private boolean inRange(double l, double m, double r){
        return l<=m && m<=r;
    }
    public void makeDraggable(Node node, GridPane grid){

        node.setOnDragDetected(evt -> {
            System.out.println("DETECTED DRAG & DROP");
        });

        node.setOnMouseDragged(evt->{
            if(startX==0.0){
                startX= evt.getSceneX();
                startY= evt.getSceneY();
            }
            node.setLayoutX( evt.getSceneX()-20);
            node.setLayoutY( evt.getSceneY()-20);
        });

        node.setOnMouseReleased(evt->{

            System.out.println("RELEASED"+" | "+ evt.getX()+":"+evt.getY());

            double x = node.getLayoutX()+25;
            double y = node.getLayoutY()+25;
            if(!inRange(150,x,550) || !inRange(100,y,500)){
//            account for the node being outside the grid
                node.setLayoutX(startX);
                node.setLayoutY(startY);

            }else{

                int snapX =((int) Math.floor((x-150)/50))*50+154;
                int snapY =((int) Math.floor((y-100)/50))*50+104;
                node.setLayoutX(snapX);
                node.setLayoutY(snapY);
                startX = snapX;
                startY = snapY;


            }


        });

    }
}
