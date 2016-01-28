import java.io.IOException;

import org.sikuli.script.*;
//import org.sikuli.script.Screen;

public class SikuliExample {
	
	 public static void main(String[] args) {
         
	   String valorFinal = "";	 
		 
       try{
	            Runtime.getRuntime().exec("calc"); //assim
	            Runtime.getRuntime().exec("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Accessories\\calc.exe"); // ABRE CALCULADORA
	       }   
       		catch (IOException exc) {  
       			System.err.println(".");  
		 }
		 
		 
		 
		 Screen s = new Screen();
         try{
                 s.click("imgs/1453824413944.png");
                 s.click("imgs/1453824558629.png");
                 s.click("imgs/1453824595232.png");
                 //s.find(s.capture().getFile())
                 s.wait("imgs/t1.png");
                /*
                 // valorFinal = s.find("imgs/1453900346105.png").text();
         
                 
                 if (s.exists("imgs/t1.png") == Yes {
                	 System.out.println("Sucesso!");
                 } else{
                	 System.err.println("Valor incorreto. O valor deveria ser " + valorFinal);
                 }
                */ 
         }
         catch(FindFailed e){
                 e.printStackTrace();
         }
 }

}
