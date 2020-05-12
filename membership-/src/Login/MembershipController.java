package Login;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import Login.Data.IMembershipManage;
import Login.Data.MembershipManageImpl;
import Login.Service.CommonService;
import Login.Service.CommonServiceImpl;
import Login.Service.MembershipService;
import Login.Service.MembershipServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class MembershipController extends Controller implements Initializable{

	final int ID = 0;
	final int NAME = 1;
	final int PW = 2;
	final int PWRE = 3;
	final int PHONENUM = 4;
	final int EMAIL = 5;

	private Parent root;
	private CommonService comServ;
	private MembershipService membershipServ;
	private IMembershipManage imembershipServ;
	@FXML TextField IdTxt;
	@FXML TextField NameTxt;
	@FXML TextField PwTxt;
	
	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		comServ = new CommonServiceImpl();
		membershipServ = new MembershipServiceImpl();
	}
	public void CancelProc(ActionEvent event) {
		comServ.WindowClose(event);
	}
	private boolean isCheck(Map<String, TextField> txtFldMap, String [] txtFldIdArr) {
		
		
		if(comServ.isEmpty(txtFldMap, txtFldIdArr)) {
			comServ.ErrorMsg("����", "ȸ������ ����", "��ĭ�� �Է����ּ���");
			return false;
		}
		String pw = txtFldMap.get(txtFldIdArr[PW]).getText();
		String pwre = txtFldMap.get(txtFldIdArr[PWRE]).getText();
		
		if(!membershipServ.comparePW(pw, pwre)) {
			comServ.ErrorMsg("����", "ȸ������ ����","�н����尡 �ٸ��ϴ�.");
			return false;
		}
		return true;
		
	}
	
	
	public void MembershipProc() {
		String []txtFldIdArr = {"#IdTxt", "#NameTxt", "#PwTxt", "#PwTxtre", "#PhoneNumberTxt",  "#UserEmailTxt"};
	
		Map<String, TextField> txtFldMap = 
				comServ.getTextFieldInfo(root, txtFldIdArr);
	
		
		
		if(!isCheck(txtFldMap, txtFldIdArr))
			return;
		
		Member member = new Member();
		member.setName(	txtFldMap.get(txtFldIdArr[NAME]).getText());
		member.setId(txtFldMap.get(txtFldIdArr[ID]).getText());
		member.setPw(txtFldMap.get(txtFldIdArr[PW]).getText());
		member.setPwre(txtFldMap.get(txtFldIdArr[PWRE]).getText());
		member.setPhonenum(txtFldMap.get(txtFldIdArr[PHONENUM]).getText());
		member.setEmail(txtFldMap.get(txtFldIdArr[EMAIL]).getText());
		
		
	
		
		if(membershipServ.MembershipProc(member))
			comServ.ErrorMsg("ȸ������", "����", "������ ���ϵ帳�ϴ�.");
	
		
		
		else
			comServ.ErrorMsg("ȸ������", "����", "�ߺ��� ���̵��Դϴ�.");
	}
	
	 public void Updatemember(ActionEvent e) {
		 IMembershipManage memberserv = new MembershipManageImpl();
		    Parent uproot = (Parent)e.getSource();
		 	TextField idTfld = (TextField)uproot.getScene().lookup("#IdTxt");
		 	TextField pwTfld = (TextField)uproot.getScene().lookup("#PwTxt");
		 	TextField nameTfld = (TextField)uproot.getScene().lookup("#NameTxt");
		 
			String id = idTfld.getText();
			String pw = pwTfld.getText();
			String name = nameTfld.getText();
			System.out.println(id);
			System.out.println(name);
			System.out.println(pw);
			
			Check(memberserv.Updatemember(name, pw, id));
		
	
	 }
	 public void Check(Boolean checkin) {
		    if (checkin) {
		        System.out.println("ȸ������ ������ �����Ͽ����ϴ�.");

		    } else {
		        System.out.println("ȸ������ ������ �����Ͽ����ϴ�.");
		    }
			

			}
	
}














