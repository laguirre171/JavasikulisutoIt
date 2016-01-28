import java.io.File;
import java.io.IOException;

import org.junit.Before;

import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;

public class CalcTest {
	
	public
	static String jvmBitVersion(){
	 return System.getProperty("sun.arch.data.model");
	}
	
	@Before
	public void setUp(){
		 try{
	            Runtime.getRuntime().exec("calc"); 
	            Runtime.getRuntime().exec("C:\\ProgramData\\Microsoft\\Windows\\Start Menu\\Programs\\Accessories\\calc.exe"); // ABRE CALCULADORA
	       }   
    		catch (IOException exc) {  
    			System.err.println(".");  
		 }
		 
	}
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		String saida = "";
		
		String jacobDllVersionToUse;
		if (jvmBitVersion().contains("32")){
		jacobDllVersionToUse = "jacob-1.18-x86.dll";
		}
		else {
		jacobDllVersionToUse = "jacob-1.18-x64.dll";
		}

		File file = new File("lib", jacobDllVersionToUse);
		System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());

		AutoItX x = new AutoItX();
		x.run("calc.exe");
		x.winActivate("Calculadora");
		x.winWaitActive("Calculadora");
		//Enter 3
		x.controlClick("Calculadora", "", "133") ;
		Thread.sleep(1000);
		//Enter +
		x.controlClick("Calculadora", "", "93") ;
		Thread.sleep(1000);
		//Enter 3
		x.controlClick("Calculadora", "", "133") ;		
		Thread.sleep(1000);
		//Enter =
		x.controlClick("Calculadora", "", "121") ;
		//saida = x.controlCommandGetCurrentLine("Calculadora", "", "150");
		saida = x.controlGetText("Calculadora", "", "150");
		if (saida.equals("6")){
			System.out.println("A Saída está correta");
		} else{
			System.err.println("A saída está incorreta");
		}
		
		
		

	}

}
