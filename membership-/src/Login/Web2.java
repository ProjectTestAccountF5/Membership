package Login;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Web2 {
	public static void web2()
	{ try { Desktop.getDesktop().browse(new URI("https://service.epost.go.kr/iservice/usr/trace/usrtrc001k01.jsp")); } 
	catch (IOException e) { e.printStackTrace(); } 
	catch (URISyntaxException e) { e.printStackTrace(); } } }

	

