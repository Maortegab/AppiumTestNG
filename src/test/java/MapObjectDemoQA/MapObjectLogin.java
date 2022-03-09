package MapObjectDemoQA;



import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import semilleros.ClasesBase;

public class MapObjectLogin extends ClasesBase {
	
	// constructor de la clase
		@SuppressWarnings("rawtypes")
		public MapObjectLogin(AppiumDriver driver) {
			super(driver);
		} 


		protected By btIngresoUsuarioContra = By.id("com.clarocolombia.miclaro.debug:id/btnLoginEmail");
		protected By btCorreo = By.xpath("//android.widget.TextView[@text='Correo electr�nico']");
		protected By txCorreo = By.xpath("//android.widget.EditText[@text='Usuario o correo electr�nico']");
		protected By txContrase�a = By.xpath("//android.widget.EditText[@text='Contrase�a']");
		protected By btIniciarSesion = By.xpath("//android.widget.Button[@text='Iniciar sesi�n']");
		
		protected By btCancelarGuardado = By.id("com.clarocolombia.miclaro.debug:id/btn31");
		
		protected By imgPerfil = By.xpath("//android.widget.ImageView[@resource-id='com.clarocolombia.miclaro.debug:id/imgPerfil']");
		//Cierre Sesi�n
		protected By btnImgUsuario = By.xpath("//android.widget.ImageView[@resource-id='com.clarocolombia.miclaro.debug:id/imgPerfil']");
		protected By btnInicio = By.xpath("//android.widget.Button[@text='Inicio']");
		protected By btnCerrarSesion = By.xpath("//android.widget.TextView[@text='Cerrar Sesi�n']");
		protected By aceptCerrarSesion = By.xpath("//android.widget.Button[@text='Cerrar sesi�n']"); 
}
