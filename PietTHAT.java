//Name: Alexandra Plukis
//Date: October 11, 2018
//Purpose: a fun game just because I love Piet Mondrian so much

import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import java.util.ArrayList;

public class PietTHAT extends BorderPane {
	
	
	//piet's yellow = r: 219 g:185 b:63
	//piet's red = r: 169 g:48 b:33
	//piet's white = r: 225 g:224 b:220
	//piet's black = r: 30 g:29 b:36
	//piet's blue = r: 56 g:83 b:179

	//declaring all GUI variables
	private Pane paintingArea;
	private Label messageLb;
	private ComboBox<String> colorCombo;
	private Button erase;
	private ArrayList<Rectangle> rectList;
	private HBox topBox;
	private GridPane optionsGp;
	private Color colorChoice;
	private Color pietBlack;
	private Color pietWhite;
	private Color pietYellow;
	private Color pietBlue;
	private Color pietRed;
	private double x;
	private double y;
	
	public PietTHAT() {

		//setting the colors to match piet mondrian's color scheme
		pietBlack = new Color(0.133, 0.129, 0.160, 1.0);
		pietWhite = new Color(1.0, 0.996, 0.978, 1.0);
		pietYellow = new Color(0.973, 0.822, 0.28, 1.0);
		pietBlue = new Color(0.249, 0.369, 0.796, 1.0);
		pietRed = new Color(0.751, 0.213, 0.147, 1.0);
		
		//setting up the gui components
		paintingArea = new Pane();
		rectList = new ArrayList<Rectangle>();
		messageLb = new Label("Choose a color, and click away!");
		erase = new Button("Erase");
		topBox = new HBox();
		optionsGp = new GridPane();
		
		colorCombo = new ComboBox<String>();
		colorCombo.setValue("Colors");
		colorCombo.getItems().addAll("Black", "Red", "Blue", "Yellow", "White");
	
		optionsGp.add(messageLb, 0, 0);
		optionsGp.add(colorCombo, 1, 0);
		optionsGp.add(erase, 2, 0);
		optionsGp.setAlignment(Pos.BASELINE_CENTER);
		optionsGp.setPadding(new Insets(10, 10, 10, 40));
		optionsGp.setHgap(10);
		
		topBox.setStyle("-fx-border-color: black;"); //css
		topBox.getChildren().addAll(optionsGp);
		
		rectList.add(new Rectangle(3, 0, 110, 50)); //0 top left corner
		rectList.add(new Rectangle(113, 0, 333, 290)); //1 upper right
		rectList.add(new Rectangle(3, 52, 110, 370)); //2 border right upper
		rectList.add(new Rectangle(113, 290, 325, 132)); //3 middle long
		rectList.add(new Rectangle(113, 423, 325, 160)); //4 middle thiccer
		rectList.add(new Rectangle(3, 423, 30, 40)); //5 right border thin short
		rectList.add(new Rectangle(3, 463, 30, 260)); //6 right border thin long
		rectList.add(new Rectangle(33, 423, 80, 300)); //7 right near border beside skinny
		rectList.add(new Rectangle(113, 583, 250, 140)); //8 bottom border middle
		rectList.add(new Rectangle(363, 583, 83, 140)); //9 bottom right corner
		rectList.add(new Rectangle(438, 290, 20, 293)); //10 that last tiny little baby
		
		resetPainting();
		
		this.setTop(topBox);
		this.setCenter(paintingArea);
		
		paintingArea.setOnMouseClicked(new MouseHandler());
		erase.setOnAction(new ButtonHandler());
		colorCombo.setOnAction(new ColorHandler());
		
	}//end of constructor
	
	private class MouseHandler implements EventHandler<MouseEvent>
	   {
	      public void handle(MouseEvent event)
	      {		
	    	  		int chosen = 0;
	  			
	    	  		if (event.getEventType() == MouseEvent.MOUSE_CLICKED)
	    	  		{
	    	  			x = event.getX();
	    	  			y = event.getY();
	    	  			
	    	  			for (int i = 0; i < rectList.size(); i++)
	    	  			{
	    	  				
	    	  				if (colorCombo.getValue().equals("Colors"))
	    	  				{
	    	  					messageLb.setText("Please choose a color!");
		    	  				messageLb.setTextFill(pietRed);
	    	  				}
	    	 
	    	  				else if (((rectList.get(i).getX() + 3) < x && x< (rectList.get(i).getX() + rectList.get(i).getWidth()-3) 
	    	  				&& (rectList.get(i).getY() + 3) < y && y < (rectList.get(i).getY() + rectList.get(i).getHeight())))
	    	  				{
	    	  					chosen = i;
	    	  					messageLb.setText("Choose a color, and click away!");
		    	  				messageLb.setTextFill(Color.BLACK);		    	  		
		    	  				rectList.get(chosen).setFill(colorChoice);
		    	  				break;
	    	  				}//close if block for checking rectangles
	    	  				
	    	  				else 
	    	  				{
	    	  					messageLb.setText("Please choose a rectangle!");
	    	  					messageLb.setTextFill(pietRed);
	    	  				}
	    	  					
	    	  			}//close for loop
	    	  		}//close MOUSE_CLICKED
	    	  		
	    	  		if (doesPietApprove())
	    	  		{
	    	  			messageLb = new Label("Piet Mondrian approves B)");
	    	  		}
	    	  		
	      }//end of MouseEvent
	   }//end of MouseHandler
	
	private class ColorHandler implements EventHandler<ActionEvent>
	   {
	      public void handle(ActionEvent event)
	      {
	    	  		if (colorCombo.getValue().equals("Black"))
	    	  			colorChoice = pietBlack;
	    	  		else if (colorCombo.getValue().equals("Red"))
	    	  			colorChoice = Color.RED;
	    	  		
	    	  		else if (colorCombo.getValue().equals("Blue"))
	    	  			colorChoice = pietBlue;
	    	  			    	  		
	    	  		else if (colorCombo.getValue().equals("Yellow"))
	    	  			colorChoice = pietYellow;
	    	  		
	    	  		else if (colorCombo.getValue().equals("White"))
	    	  			colorChoice = pietWhite;
	    	  		
	      }//closes handle
	      
	   }//closes ColorHandler
	
	private class ButtonHandler implements EventHandler<ActionEvent>
	{
		public void handle(ActionEvent event)
		{
			resetPainting();
		}
	}

	//checks if the user entered the same colors that Piet Mondrian used in Tableau I
	private boolean doesPietApprove()
	{	
	
		if (rectList.get(0).getFill() == pietBlack && rectList.get(1).getFill() == pietRed
			&& rectList.get(2).getFill() == pietWhite && rectList.get(3).getFill() == pietWhite
			&& rectList.get(4).getFill() == pietWhite && rectList.get(5).getFill() == pietBlack
			&& rectList.get(6).getFill() == pietYellow && rectList.get(7).getFill() == pietWhite
			&& rectList.get(8).getFill() == pietWhite && rectList.get(9).getFill() == pietBlue
			&& rectList.get(10).getFill() == pietWhite)	
		{
			return true;
		} 
		
		else
		{
			return false;
		}
	}
	
	private void resetPainting()
	{
		paintingArea.getChildren().clear();
		
		for (int i = 0; i < rectList.size(); i++)
		{
			rectList.get(i).setFill(pietWhite);
			rectList.get(i).setStroke(pietBlack);
			rectList.get(i).setStrokeWidth(8);
			paintingArea.getChildren().add(rectList.get(i));
		}
	}
}
