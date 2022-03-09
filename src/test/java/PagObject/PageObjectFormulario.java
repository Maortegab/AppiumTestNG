package PagObject;

import java.io.File;
import MapObjectDemoQA.MapObjectFormulario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class PageObjectFormulario extends MapObjectFormulario {

	// Crear constructor de la clase

	public PageObjectFormulario(AppiumDriver<MobileElement> driver) {
		super(driver);
		this.driver = driver;
	}

	// Método inicial Abrir link

	public void urlAcceso(String url) {
		driver.get(url);
	}

	// Método para escribir en buscador
	public void ejecucionAppium(String Pdf, String departamento, String cuidad, String barrio, String tipo,
			String noPrinc, String sufijo1, String noSecun, String sufijo2, String numComple, String Comp1,
			String numero1, String Comple2, String numero2, String nomTest) throws Exception {

		File rutaFile = crearCarpeta(nomTest);

		try {
			// Tiempo Provisional
			tiempoEspera(10);
			// Ingreso al menú
			click(imgPerfil, rutaFile, Pdf);
			tiempoEspera(1);
			tocarPantalla(700, 1000);
			tiempoEspera(4);
			click(btActualizarDatos, rutaFile, Pdf);

			click(btCuenta, rutaFile, Pdf);

			tiempoEspera(2);
			click(btDireccion, rutaFile, Pdf);
			tiempoEspera(3);

			// departamento
			click(listDepartamento, rutaFile, Pdf);
			click(seleccionDepa, rutaFile, Pdf);
			tiempoEspera(2);

			// Ciudad
			click(listCiudad, rutaFile, Pdf);
			click(seleccionCiu, rutaFile, Pdf);
			tiempoEspera(2);

			// Barrio
			sendKey(barrio, txBarrio, rutaFile, Pdf);

			// Tipo (calle,carrera)
			click(listaTipo, rutaFile, Pdf);
			click(seleccionTipo, rutaFile, Pdf);

			// Scroll Para llegar al final
			scrollVertical(rutaFile, 487, 1470, 790, 2);

			// No Principal
			sendKey(noPrinc, txNoPrincipal, rutaFile, Pdf);

			// sufijo1
			click(listSufijo1, rutaFile, Pdf);
			click(seleccionSufi, rutaFile, Pdf);

			// no Secundario
			sendKey(noSecun, txNoSecundario, rutaFile, Pdf);

			// sufijo2
			click(listSufijo2, rutaFile, Pdf);
			click(seleccionSufi2, rutaFile, Pdf);

			// No Complemento
			sendKey(numComple, txNoComplem, rutaFile, Pdf);

			// complemento1
			click(listComplem1, rutaFile, Pdf);
			click(seleccionComp1, rutaFile, Pdf);
			// numero 1
			sendKey(numero1, txNumero1, rutaFile, Pdf);
			clickEnter();
			// complemento2
			click(listComplem2, rutaFile, Pdf);
			click(seleccionComp2, rutaFile, Pdf);
			// numero 2
			sendKey(numero2, txNumero2, rutaFile, Pdf);
			clickEnter();

			tiempoEspera(1);
			click(btnValidar, rutaFile, Pdf);

			tiempoEspera(1);
			click(btnAceptar, rutaFile, Pdf);

			tiempoEspera(8);
			click(btnCerrar, rutaFile, Pdf);
			click(btnInicio, rutaFile, Pdf);
			tiempoEspera(2);


		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
