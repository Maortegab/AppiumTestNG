package semilleros;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidStartScreenRecordingOptions;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.screenrecording.CanRecordScreen;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utilidades.GenerarReportePdf;

public class ClasesBase {

	protected static AppiumDriver<MobileElement> driver;

	// Constructor de la clase
	@SuppressWarnings("rawtypes")
	public ClasesBase(AppiumDriver driver) {
		super();
	}

	String OutputNG;

	public void setOutputNG(String OutputNG, AppiumDriver<MobileElement> driver) {
		this.OutputNG = OutputNG;
		this.driver = driver;
	}

	@SuppressWarnings("rawtypes")

	public static AppiumDriver appiumDriverConnection(@Optional("default") String platformName,
			@Optional("default") String deviceName, @Optional("default") String platformVersion,
			@Optional("default") String appPackage, @Optional("default") String appActivity,
			@Optional("default") String noReset, @Optional("default") String autoGrantPermissions) {
		// Setear las opciones del navegador
		AppiumDriver _driver = null;
		try {
//			Crear las Capabilitys del movil
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability("platformName", platformName);
			caps.setCapability("deviceName", deviceName);
			caps.setCapability("platformVersion", platformVersion);
			caps.setCapability("appPackage", appPackage);
			caps.setCapability("appActivity", appActivity);
			caps.setCapability("noReset", noReset);
			caps.setCapability("autoGrantPermissions", autoGrantPermissions);

			// Instanciar Appium Driver
			try {
				printCo("Cargando capability de appium, favor esperar...");
				_driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
			} catch (MalformedURLException e) {
				printCo(e.getMessage());
			}
			return _driver;
		} catch (Exception e) {
			printCo(e.getMessage());
		}
		return _driver;
	}

	private static void printCo(String tx) {
		System.out.println(tx);

	}

	// Método Click
	public void click(By locator, File rutaCarpeta, String Pdf) throws Exception {
		try {
			driver.findElement(locator).click();
			tiempoEspera(1);
			capturaScreen(rutaCarpeta, locator, Pdf);
		} catch (Exception e) {

			captureScreenError(rutaCarpeta, locator, Pdf, e.toString());
			throw new InterruptedException();
		}
	}

	// Metodo Scroll Vertical Descendente
	public void scrollVerticalDes(File rutafile) throws Exception {
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(350, 930)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
				.moveTo(PointOption.point(350, 430)).release().perform();

	}

	// Método Borrar
	public void borrar(By locator, File rutaCarpeta, String Pdf) throws Exception {

		try {
			driver.findElement(locator).clear();
			tiempoEspera(1);
			capturaScreen(rutaCarpeta, locator, Pdf);
		} catch (Exception e) {
			captureScreenError(rutaCarpeta, locator, Pdf, e.toString());
			throw new InterruptedException();
		}
	}

	// Método enviar texto
	public void sendKey(String inputText, By locator, File rutaCarpeta, String Pdf) throws Exception {
		try {
			driver.findElement(locator).sendKeys(inputText);
			tiempoEspera(1);
			capturaScreen(rutaCarpeta, locator, Pdf);
		} catch (Exception e) {
			captureScreenError(rutaCarpeta, locator, Pdf, e.toString());
			throw new InterruptedException();
		}
	}

	// Método enter Submit
	public void submit(By locator, File rutaCarpeta, String Pdf) throws Exception {
		driver.findElement(locator).submit();
		capturaScreen(rutaCarpeta, locator, Pdf);
	}

	// Método tiempo de espera
	public void tiempoEspera(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo * 1000);
	}

	public static String fechaHora() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		// DAR FORMATO A LA FECHA DEL SITEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public static String fechaHora2() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// DAR FORMATO A LA FECHA DEL SITEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public static String horaSistema() {

		// Tomamos La fecha del sistema
		LocalTime horaSistema = LocalTime.now();

		// Definir formato de hora
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");

		// dar formato a la fecha del sistema
		String hora = fecha.format(horaSistema);
		return hora;

	}

//	public void captureScreen(File rutaCarpeta) throws Exception {
//		String hora = horaSistema();
//		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//		FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
//	}

//	public void captureScreen(File rutaCarpeta, By locator, String generarEvidencia) throws Exception {
//
//		if (generarEvidencia.equals("Si")) {
//			String hora = horaSistema();
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
//			String rutaImagen = new File(rutaCarpeta + "\\" + hora + ".png").toString();
//
//			// INSTANCIAMOS LA CLASE PDF
//			GenerarReportePdf informePdf = new GenerarReportePdf();
////			informePdf.crearPlantilla(rutaImagen, rutaCarpeta);
//			// PROCEDEMOS A INSERTAR LOCALIZADOR DE IMAGEN PDF
//			informePdf.crearBody(locator, rutaImagen);
//			// ELIMINAR LA IMAGEN CREADA
//			eliminarArchivo(rutaImagen);
//
//		}
//	}
	public void capturaScreen(File rutaCarpeta, By locator, String PDF) throws Exception {

		if (PDF.equals("Si")) {
			String hora = horaSistema();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
			String rutaImagen = new File(rutaCarpeta + "\\" + hora + ".png").toString();

			// INSTANCIAMOS LA CLASE GENERAR PDF
			GenerarReportePdf informePdf = new GenerarReportePdf();
			// SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
			informePdf.crearBody(locator, rutaImagen);
			// ELIMINAR IMAGEN CREADA
			eliminarArchivo(rutaImagen);
		}
	}
//	private void eliminarArchivo(String rutaImagen) {
//		// TODO Auto-generated method stub
//		File fichero = new File(rutaImagen);
//		fichero.delete();
//
//	}

	public void captureScreenError(File rutaCarpeta, By locator, String Pdf, String msnError)
			throws Exception {
		if (Pdf.equals("Si")) {
			String hora = horaSistema();
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(rutaCarpeta + "\\" + hora + ".png"));
			String rutaImagen = new File(rutaCarpeta + "\\" + hora + ".png").toString();

			// INSTACIAMOS LA CLASE GENERAR PDF
			GenerarReportePdf informePdf = new GenerarReportePdf();
			// SE PROCEDE A INSERTAR LOCALIZADOR HE IMAGEN EN EL PDF
			informePdf.crearbodyError(locator, rutaImagen, msnError);
			// ELIMINAR IMAGEN CREADA

			eliminarArchivo(rutaImagen);
		}
	}
	//METODO PARA VIDEO SOLO DE LA EJECUCIÓN DE LA PANTALLA DEL DISPOSITIVO
	public static void iniciarVideo() {
		((CanRecordScreen) driver).startRecordingScreen(new AndroidStartScreenRecordingOptions().withVideoSize("1240x720").withTimeLimit(Duration.ofSeconds(500)));
		}
	public static void finVideo(File rutaCarpeta) throws IOException {
		String hora = horaSistema();
		String video = ((CanRecordScreen)driver).startRecordingScreen();
		byte[] decode = Base64.getDecoder().decode(video);
		FileUtils.writeByteArrayToFile(new File(rutaCarpeta + "\\ Ejecución_" + hora +".mp4"), decode);
	}

	public void eliminarArchivo(String rutaImagen) {
		File fichero = new File(rutaImagen);
		fichero.delete();
	}

	public File crearCarpeta(String nomTest) {

		// Almacenamos la fecha del sistema
		String fecha = fechaHora();

		// Creamos el nombre de la carpeta
		String nomCarpeta = nomTest + "-" + fecha;

		// Obtenemos la ruta de alojamiento de salida y el nombre dek test a ejecutar
		File directorio = new File("./output/" + nomCarpeta);

		// Creamos la carpeta
		directorio.mkdir();
		return directorio;
	}

	// Método inicial
	public void urlAcceso(String url) {
		driver.get(url);
	}

	protected int posicionEliminado = 53;

	// metodo Busqueda fecha

//	public void busquedaFecha(ReadExcelFile leer, Properties propiedades) throws Exception {
//		leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 10);
//	}
	// ScrollVertical ciclico
	public void scrollVertical(File rutaFile, int xini, int yini, int yfinal, int iteraciones) throws Exception {

		for (int i = 1; i <= iteraciones; i++) {
			@SuppressWarnings("rawtypes")
			TouchAction touch = new TouchAction(driver);
			touch.press(PointOption.point(xini, yini)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(xini, yfinal)).release().perform();

		}
	}

	// Toca la pantalla simulando un click en una coordenada
	public void tocarPantalla(int x, int y) {
		@SuppressWarnings("rawtypes")
		TouchAction touch = new TouchAction(driver);
		touch.press(PointOption.point(x, y)).release().perform();
	}

	// Escribir desde el teclado android
	public void write(String palabra) throws Exception {

		char[] c = palabra.toCharArray();

		for (int i = 0; i < palabra.length(); i++) {
			String C = String.valueOf(c[i]);
			if (C.equals("@"))
				((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.AT));
			else if (C.equals("."))
				((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.PERIOD));
			else if (NumberUtils.isParsable(C))
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.valueOf("DIGIT_" + C)));
			else
				((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.valueOf(C)));
		}
		tiempoEspera(2);
		((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.TAB));
	}

	public void writeDate(String palabra) throws Exception {

		char[] c = palabra.toCharArray();

		for (int i = 0; i < palabra.length(); i++) {
			String C = String.valueOf(c[i]);
			if (C.equals("@"))
				((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.AT));
			else if (C.equals("."))
				((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.PERIOD));
			else if (C.equals(" "))
				((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.SPACE));
			else if (C.equals(","))
				((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.COMMA));
//				else if (C.equals(":"))
//					((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.p));
			else if (NumberUtils.isParsable(C))
				((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.valueOf("DIGIT_" + C)));
			else
				((AndroidDriver<MobileElement>) driver).pressKey(new KeyEvent(AndroidKey.valueOf(C)));
		}
	}

//Validar si el elemento está presente
	public boolean elementoPresente(By locator) {
		boolean estado = driver.findElement(locator).isDisplayed();
		return estado;
	}

	public void selectVisible(String datoExc, By locator, int x, int yPs, int yMt, int i, File rutaCarpeta)
			throws Exception {

		String locatorPart1 = locator.toString();
		String[] parts = locatorPart1.split(" ");

		// String xpathSelect=locatorPart1+datoExc+"']";

		By localizador = By.xpath(parts[1] + datoExc + "']");
		boolean displayed = elementoPresente(localizador);
		while (displayed == false) {
			scrollVertical(rutaCarpeta, x, yPs, yMt, i);
			displayed = elementoPresente(localizador);
		}

		click(rutaCarpeta, 1);
	}

	private void click(File rutaCarpeta, int i) {
		// TODO Auto-generated method stub

	}

	// Metodo boton enter Teclado
	public void clickEnter() {
		((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
	}

	public void clickTAB() {
		((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.TAB));
	}

	public void clickSLASH() {
		((PressesKey) driver).pressKey(new KeyEvent().withKey(AndroidKey.SLASH));
	}

	
}