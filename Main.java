package application;
	
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
 
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
  
public class Main extends Application{
     
    public static void main(String[] args) {
          
        Application.launch(args);
    }
      
    public String transformer(String text1) {
    	String text = text1.toUpperCase();;
    	
    	
    	char[] characters = new char[] { 'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ж', 'З', 'И',
                'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 
                'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ы', 'Ь',
                'Э', 'Ю', 'Я', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', '0' };

String[] codeMorse = new String[] { "*–", "–***", "*––", "––*", 
                "–**", "*", "***–", "––**",
                "**", "*–––", "–*–", "*–**",
                "––", "–*", "–––", "*––*", 
                "*–*", "***", "–", "**–", 
                "**–*", "****", "–*–*",
                "–––*", "––––", "−−*−",
                "−*−−", "−**−", "**−**",
                "**−−", "*−*−", "*−−−−",
                "**−−−", "***−−", "****−",
                "*****", "−****", "−−***",
                "−−−**", "−−−−*", "−−−−−" };

/*String output = "";
int index;
char c;
while(text)
{
    if (c != ' ')
    {
        index = Array.IndexOf(characters, c);
        output += codeMorse[index] + " ";
    }
}
output = output.Remove(output.Length - 1);*/

char[] x  = text.toCharArray();
int k= x.length;
String[] y= new String[k];
int i=0;
while(i!=x.length) {
	int j=0;
		while(x[i]!=characters[j]) {
			j++;
		}
		y[i]=codeMorse[j];
	i++;
}
String textEnd = String.join(" ", y);
   //String textEnd; 	
    	return textEnd;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
          
        Label lbl = new Label();
       //
        Image image = new Image(new FileInputStream("//home/nrumak/eclipse-workspace/secndTry/example/telegraf-dlya-morze.jpg"));  
        
        //Setting the image view 
        ImageView imageView = new ImageView(image); 
        
        //Setting the position of the image 
        imageView.setX(50); 
        imageView.setY(25); 
        
        //setting the fit height and width of the image view 
        imageView.setFitHeight(455); 
        imageView.setFitWidth(500); 
        
        //Setting the preserve ratio of the image view 
        imageView.setPreserveRatio(true);  
        
        //Creating a Group object  
        Group roo = new Group(imageView); 
        
        
        
        
        //
        TextArea textArea = new TextArea();
        textArea.setPrefColumnCount(15);
        textArea.setPrefRowCount(5);
        
        Button btn = new Button("transform");
        
        btn.setOnAction(event -> lbl.setText("Input: " + transformer(textArea.getText())));
        
        //
        //
        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10,roo, textArea, btn, lbl);
        root.setAlignment(Pos.TOP_LEFT);
        Scene scene = new Scene(root, 500, 500);
          
        stage.setScene(scene);
        stage.setTitle("Morse translator");
        stage.show();
    }
}