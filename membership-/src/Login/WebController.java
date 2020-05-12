package Login;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import Login.Data.IMembershipManage;
import Webpage.Service.CommonService;
import Webpage.Service.CommonServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class WebController extends Controller implements Initializable{
	
	final int NAME = 0;
	final int PW = 1;
	final int PWRE = 2;
	final int ID = 3;
	private Parent root;
	private CommonService comServ;
	private IMembershipManage memServ;
	private Web2 web2;
	
	private Parent getScene(ActionEvent e) {
		Parent btnObj = (Parent)e.getSource();
		return btnObj.getScene().getRoot();
	}
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
	}
	public void ProfileView(ActionEvent e) {
		BorderPane borderPane = (BorderPane)getScene(e);
		Parent loginScene = comServ.getScene("../mypage(회원정보).fxml");
		borderPane.setCenter(loginScene);
	}
	
	  public void basketView(ActionEvent e) { 
		  BorderPane borderPane = (BorderPane)getScene(e); 
		  Parent basketScene = comServ.getScene("/Webpage/shoppingbasket.fxml");
	  borderPane.setCenter(basketScene); 
	  
	  
	 }
	  public void orderlistView(ActionEvent e) { 
		  BorderPane borderPane = (BorderPane)getScene(e); 
		  Parent orderlistScene = comServ.getScene("/Webpage/orderlist.fxml");
	  borderPane.setCenter(orderlistScene); 
	  }
	  public void LogoutProc(ActionEvent e) { 
		  ; 
	  }
	  public void CancelProc(ActionEvent event) {comServ.WindowClose(event);	}
	  
	  
	  public void Updatemember() {
		  
			String []txtFldIdArr = {"#NameTxt", "#PwTxt"};
			Map<String, TextField> txtFldMap = 
					comServ.getTextFieldInfo(root, txtFldIdArr);
			
			
			Member member = new Member();
			member.setName(txtFldMap.get(txtFldIdArr[NAME]).getText());
			member.setPw(txtFldMap.get(txtFldIdArr[PW]).getText());


		
	
		}
		
	  
	  public void webpage(ActionEvent event) {
			web2.web2(); 
	  }
	  
	/* public void 
	 * MembershipView(ActionEvent e) { BorderPane borderPane =
	 * (BorderPane)getScene(e); Parent membershipScene =
	 * comServ.getScene("/Webpage/Membership.fxml");
	 * borderPane.setCenter(membershipScene); } public void
	 * MembershipView(ActionEvent e) { BorderPane borderPane =
	 * (BorderPane)getScene(e); Parent membershipScene =
	 * comServ.getScene("/Webpage/Membership.fxml");
	 * borderPane.setCenter(membershipScene); }
	 */
	
	
}













