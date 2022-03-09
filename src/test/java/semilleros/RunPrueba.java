package semilleros;

import org.testng.annotations.Test;

import PagObject.PagObjectLogin;
import PagObject.PageObjectFormulario;
import PagObject.PageObjectPagoTarjetaCr;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utilidades.ExcelUtilities;
import utilidades.GenerarReportePdf;
import utilidades.MyScreenRecorder;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;

import java.io.File;

import org.testng.annotations.AfterClass;

public class RunPrueba {

	private AppiumDriver<MobileElement> driver;
	PagObjectLogin login;
	PageObjectFormulario formulario;
	PageObjectPagoTarjetaCr PagoTC;
	File rutaCarpeta;
	ClasesBase claseBase;
	GenerarReportePdf generarReportepdf;

	@SuppressWarnings("unchecked")
	@BeforeClass
	@Parameters({ "rutaOutput", "rutaImagenReporte", "platformName", "deviceName", "platformVersion", "appPackage",
			"appActivity", "noReset", "autoGrantPermissions" })
	public void beforeClass(@Optional("default") String rutaOutput, @Optional("default") String rutaImagenReporte,
			@Optional("default") String platformName, @Optional("default") String deviceName,
			@Optional("default") String platformVersion, @Optional("default") String appPackage,
			@Optional("default") String appActivity, @Optional("default") String noReset,
			@Optional("default") String autoGrantPermissions) {

		driver = ClasesBase.appiumDriverConnection(platformName, deviceName, platformVersion, appPackage, appActivity,
				noReset, autoGrantPermissions);
		claseBase = new ClasesBase(driver);

		generarReportepdf = new GenerarReportePdf();
		login = new PagObjectLogin(driver);
		formulario = new PageObjectFormulario(driver);
		PagoTC = new PageObjectPagoTarjetaCr(driver);

		generarReportepdf.setRutaImagen(rutaImagenReporte);
		claseBase.setOutputNG(rutaOutput, driver);
	}

	@DataProvider(name = "formulario")
	public Object[][] datosFor() throws Exception {
		Object[][] arreglo = ExcelUtilities.getTableArray("./data/Prueba.xlsx", "Claro");
		return arreglo;
	}

	@Test(dataProvider = "formulario",priority = 0)
	public void claroUpdateAdress(String Ejecutar, String Video, String Pdf, String Correo, String Contraseña,
			String departamento, String cuidad, String barrio, String tipo, String noPrinc, String sufijo1,
			String noSecun, String sufijo2, String numComple, String Comp1, String numero1, String Comple2,
			String numero2) throws Exception {

		boolean n = false;
		boolean m = false;
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

		if (Ejecutar.equals("Si")) {
			File rutaCarpeta = login.crearCarpeta(nomTest);
			if (Video.equals("Si")) {
				System.out.println("// Ejecutar caso de prueba '" + nomTest + "' con evidencia de video //");
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				claseBase.iniciarVideo();
				m = true;
			} else
				System.out.println("// Ejecutando caso de prueba '" + nomTest + "' sin evidencia en video//");

			if (Pdf.equals("Si")) {
				System.out.println("// Ejecutar caso de prueba '" + nomTest + "' con evidencia en PDF //");
				generarReportepdf.crearPlantilla(nomTest, rutaCarpeta);
				n = true;
			} else {
				System.out.println("// Ejecutando caso de prueba '" + nomTest + "' sin evidencia en PDF//");
			}
			login.ejecucionInicioSesion(Pdf, Correo, Contraseña, rutaCarpeta);
			formulario.ejecucionAppium(Pdf, departamento, cuidad, barrio, tipo, noPrinc, sufijo1, noSecun, sufijo2,
					numComple, Comp1, numero1, Comple2, numero2, nomTest);
			login.ejecucionCierreSesion(rutaCarpeta, Pdf);

			if (Boolean.TRUE.equals(m)) {
				MyScreenRecorder.stopRecording();
				claseBase.finVideo(rutaCarpeta);
			}
			if (Boolean.TRUE.equals(n))
				// INICIA CREACION DE REPORTE PDF
				generarReportepdf.cerrarPlantilla();
		} else
			System.out.println("// Caso de prueba '" + nomTest + "', no se ejecutara//");
	}

	@DataProvider(name = "TarjetaCr")
	public Object[][] datosTC() throws Exception {
		Object[][] arreglo = ExcelUtilities.getTableArray("./data/Prueba.xlsx", "TarjetaCr");
		return arreglo;
	}

	@Test(dataProvider = "TarjetaCr",priority = 1)
	public void claroPayTC(String Ejecutar, String Video, String Pdf, String Correo, String Contraseña,
			String NumeroTarjeta, String CodSeguridad, String Nombre, String NumeroDoc, String Telefono,
			String CorreoPago) throws Exception {

		boolean n = false;
		boolean m = false;
		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();

		if (Ejecutar.equals("Si")) {
			File rutaCarpeta = login.crearCarpeta(nomTest);
			if (Video.equals("Si")) {
				System.out.println("// Ejecutar caso de prueba '" + nomTest + "' con evidencia de video //");
				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
				claseBase.iniciarVideo();
				m = true;
			} else
				System.out.println("// Ejecutando caso de prueba '" + nomTest + "' sin evidencia en video//");

			if (Pdf.equals("Si")) {
				System.out.println("// Ejecutar caso de prueba '" + nomTest + "' con evidencia en PDF //");
				generarReportepdf.crearPlantilla(nomTest, rutaCarpeta);
				n = true;
			} else {
				System.out.println("// Ejecutando caso de prueba '" + nomTest + "' sin evidencia en PDF//");
			}
			login.ejecucionInicioSesion(Pdf, Correo, Contraseña, rutaCarpeta);
			PagoTC.ejecucionAppium(NumeroTarjeta, CodSeguridad, Nombre, NumeroDoc, Telefono, CorreoPago, rutaCarpeta,
					Pdf);
//					login.ejecucionCierreSesion(rutaCarpeta, Pdf);
			if (Boolean.TRUE.equals(m)) {
				MyScreenRecorder.stopRecording();
				claseBase.finVideo(rutaCarpeta);
			}
			if (Boolean.TRUE.equals(n))
				// INICIA CREACION DE REPORTE PDF
				generarReportepdf.cerrarPlantilla();
		} else
			System.out.println("// Caso de prueba '" + nomTest + "', no se ejecutara//");

	}

//	@DataProvider(name = "datosLogin")
//	public Object[][] datosLg() throws Exception {
//		Object[][] arreglo = ExcelUtilities.getTableArray("./data/Prueba.xlsx", "Login");
//		return arreglo;
//	}
//
//	@Test(dataProvider = "datosLogin")
//	public void claroLogin(String Ejecutar, String Video, String Pdf, String Correo, String Contraseña)
//			throws Exception {

//		if (Pdf.equals("Si")) {
//
//			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
//			login.ejecucionInicioSesion(Pdf,Correo, Contraseña, nomTest);	
////			formulario.ejecucionAppium(Pdf, departamento, cuidad, barrio, tipo, noPrinc, sufijo1, noSecun,
////					sufijo2, numComple, Comp1, numero1, Comple2, numero2, nomTest);
//		}
//		boolean n = false;
//		boolean m = false;
//		String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
//
//		if (Ejecutar.equals("Si")) {
//			File rutaCarpeta = login.crearCarpeta(nomTest);
//			if (Video.equals("Si")) {
//				System.out.println("// Ejecutar caso de prueba '" + nomTest + "' con evidencia de video //");
//				MyScreenRecorder.startRecording(nomTest, rutaCarpeta);
//				m = true;
//			} else
//				System.out.println("// Ejecutando caso de prueba '" + nomTest + "' sin evidencia en video//");
//
//			if (Pdf.equals("Si")) {
//				System.out.println("// Ejecutar caso de prueba '" + nomTest + "' con evidencia en PDF //");
//				generarReportepdf.crearPlantilla(nomTest, rutaCarpeta);
//				n = true;
//			} else
//				System.out.println("// Ejecutando caso de prueba '" + nomTest + "' sin evidencia en PDF//");
//
//			login.ejecucionInicioSesion(Pdf, Correo, Contraseña, rutaCarpeta);
////				pagObjetCambioDirNG.direccion(Barrio,Principal,NunSecundario,Numcomplemento,NumApto, rutaCarpeta,PDF);
////				pagObjetCerrarNG.cerrar(rutaCarpeta, PDF);
//
//			if (Boolean.TRUE.equals(m))
//				MyScreenRecorder.stopRecording();
//			if (Boolean.TRUE.equals(n))
//				// INICIA CREACION DE REPORTE PDF
//				generarReportepdf.cerrarPlantilla();
//		} else
//			System.out.println("// Caso de prueba '" + nomTest + "', no se ejecutara//");
//
//	}

//	@AfterClass
//	public void afterClass() {
////		driver.quit();
//	}

}
