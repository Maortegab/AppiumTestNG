package PagObject;

import java.io.File;
import MapObjectDemoQA.MapObjectLogin;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;



public class PagObjectLogin extends MapObjectLogin {

	// Crear constructor de la clase

	public PagObjectLogin(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
	}

	// Método inicial Abrir link

	public void urlAcceso(String url) {
		driver.get(url);
	}

	// Método para escribir en buscador
	public void ejecucionInicioSesion(String Pdf, String Correo, String Contraseña, File rutaCarpeta) throws Exception {

		

		try {

			tiempoEspera(10);
			click(btIngresoUsuarioContra, rutaCarpeta, Pdf);
			tiempoEspera(1);
			click( btCorreo, rutaCarpeta,Pdf);
			tiempoEspera(1);
			sendKey(Correo, txCorreo, rutaCarpeta, Pdf);
			sendKey(Contraseña, txContraseña, rutaCarpeta, Pdf);

			click(btIniciarSesion, rutaCarpeta, Pdf);

			tiempoEspera(2);
			click(btCancelarGuardado, rutaCarpeta, Pdf);
			tiempoEspera(8);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void ejecucionCierreSesion(File rutaCarpeta, String Pdf) throws Exception {
		

		try {

			// EN PAGINA INICIO
//			tiempoEspera(2);
//			click(btnInicio ,rutaCarpeta, Pdf);
			tiempoEspera(3);
			click(btnImgUsuario ,rutaCarpeta, Pdf);
			click(btnCerrarSesion ,rutaCarpeta, Pdf);
			tiempoEspera(1);
			click(aceptCerrarSesion ,rutaCarpeta, Pdf);

		} catch (Exception e) {
			
			System.out.println(e);
		}

	}

}
