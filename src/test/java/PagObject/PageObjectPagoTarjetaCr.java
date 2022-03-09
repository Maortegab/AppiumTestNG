package PagObject;

import java.io.File;
import MapObjectDemoQA.MapObjectPagoTarjetaCr;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


public class PageObjectPagoTarjetaCr extends MapObjectPagoTarjetaCr {

	// Crear constructor de la clase

	public PageObjectPagoTarjetaCr(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
	}

	// Método inicial Abrir link

	public void urlAcceso(String url) {
		driver.get(url);
	}

	// Método para escribir en buscador
	public void ejecucionAppium(String NumeroTarjeta, String CodSeguridad, String Nombre, String NumeroDoc,
								String Telefono, String CorreoPago, File rutaCarpeta, String Pdf) throws Exception {
		try {

			tiempoEspera(10);
			click(btnPagos ,rutaCarpeta, Pdf);
			tiempoEspera(1);
			click(btnPagaAqui ,rutaCarpeta, Pdf);
			click(btnTotal ,rutaCarpeta, Pdf);
			click(btnPagar ,rutaCarpeta, Pdf);
			tiempoEspera(4);
			click(btnMPago ,rutaCarpeta, Pdf);
			
			tocarPantalla(500, 1347);
			click(btnContinuar ,rutaCarpeta, Pdf);
			tiempoEspera(8);
			scrollVertical(rutaCarpeta,572, 1800, 1400, 3);
			sendKey(NumeroTarjeta,intNumTC,rutaCarpeta,Pdf);
			click(selMonth ,rutaCarpeta, Pdf);
			click(btnSelMes ,rutaCarpeta, Pdf);
			click(selYear ,rutaCarpeta, Pdf);
			click(btnSelAnio ,rutaCarpeta, Pdf);
			scrollVertical(rutaCarpeta, 572, 1800, 1000, 1);
			sendKey(CodSeguridad,codCVV,rutaCarpeta,Pdf);
			click(selCuotas ,rutaCarpeta, Pdf);
			click(btncoutas ,rutaCarpeta, Pdf);
			scrollVertical(rutaCarpeta,572, 1800, 1400, 2);
			tiempoEspera(2);
			sendKey(Nombre,txtNombreTC,rutaCarpeta,Pdf);
			tiempoEspera(2);
			click(selTipoID ,rutaCarpeta,Pdf);
			tiempoEspera(2);
			click(selTipoCC ,rutaCarpeta,Pdf);
			sendKey(NumeroDoc,txtNumID,rutaCarpeta,Pdf);
			sendKey(Telefono,txtNumTel,rutaCarpeta,Pdf);
			sendKey(CorreoPago,txtEmail,rutaCarpeta,Pdf);
			scrollVertical(rutaCarpeta,572, 1800, 1400, 2);
			click(btnCancePago ,rutaCarpeta, Pdf);
			tiempoEspera(5);
			click(btnAtrás ,rutaCarpeta, Pdf);
			tiempoEspera(1);
			click(btnInicio ,rutaCarpeta, Pdf);
			tiempoEspera(10);
			click(btnImgUsuario ,rutaCarpeta, Pdf);
			click(btnCerrarSesion ,rutaCarpeta, Pdf);
			tiempoEspera(1);
			click(aceptCerrarSesion ,rutaCarpeta, Pdf);
			tiempoEspera(3);
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);

		}
	}
}