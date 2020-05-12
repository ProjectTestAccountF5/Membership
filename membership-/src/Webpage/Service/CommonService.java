package Webpage.Service;

import java.util.Map;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public interface CommonService {
	public void WindowClose(ActionEvent event);
	public Parent showWindow(Stage s, String formPath);
	
	public Parent getScene(String formPath);
	public Map<String, TextField> getTextFieldInfo(Parent root, String[] txtFldIdArr);

}
