import static org.junit.Assert.assertEquals;

import autoitx4java.AutoItX;
import com.jacob.com.LibraryLoader;
import org.sikuli.script.*;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class AppletLocal {
	

	public static String jvmBitVersion(){
	 return System.getProperty("sun.arch.data.model");
	}
	
	private WebDriver driver;
	/*
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	    String baseUrl = "http://localhost/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get(baseUrl);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
 */
		
	public static void main(String[] args){
		
		String saida = "";
		String saida2 = "";
		
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
		
		x.winActivate("Applet Swing Components - Mozilla Firefox");
		x.winWaitActive("Applet Swing Components - Mozilla Firefox");
		x.ControlSetText("Applet Swing Components - Mozilla Firefox", "", "1", "1");
		
		Screen s = new Screen();
        try{
                s.click("imgs/add.png");
                //saida = s.selectRegion("imgs/r2.png").text();
        }catch(FindFailed e){
            e.printStackTrace();
        }
		
        try{
        	TimeUnit.SECONDS.sleep(10);
        }catch (InterruptedException e){
        	e.printStackTrace();
        }
		
        
		saida2 = x.controlGetText("Applet Swing Components - Mozilla Firefox", "", "2");
		//System.out.println("A Saída é " + saida);
		System.out.println("A Saída é " + saida2);
		//saida = x
		//x.controlClick("Applet Swing Components - Mozilla Firefox", "","3");
		
		
		/*
		saida = x.controlGetText("Applet Swing Components - Mozilla Firefox", "", "2");
		if (saida.equals("1")){
			System.out.println("A Saída está correta");
		} else{
			System.err.println("A saída está incorreta");
		}
*/
		//Enter 3
		//x.controlClick("Java - AutoIt/src/AppletLocal.java - Eclipse", "", "133") ;
		//driver.findElement(By.id("1")).clear();
	    //driver.findElement(By.id("1")).sendKeys("1");
	    //driver.findElement(By.id("3")).click();
	    //driver.findElement(By.cssSelector("h4")).click();
	    //assertEquals("TV 43\" Plasma ED Samsung PL43F4000 com Fun��o Futebol, 600Hz Subfield Motion, ConnectShare Movie, Entradas HDMI e USB",driver.findElement(By.cssSelector("h4")).getText());
	}

}
