package MapObjectDemoQA;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumDriver;
import semilleros.ClasesBase;

public class MapObjectPagoTarjetaCr extends ClasesBase {

	// constructor de la clase
	@SuppressWarnings("rawtypes")
	public MapObjectPagoTarjetaCr(AppiumDriver driver) {
		super(driver);
	}
	
	//Estando en Pagina Principal		
	
//	protected By btnPagos = By.xpath("//android.widget.FrameLayout[@content-desc=\"Pagos\"]/android.widget.ImageView");
	protected By btnPagaTuFacturaAqui = By.xpath("//android.widget.Button[@text='Paga tu factura aquí']");
//	protected By btnPagar = By.xpath("//android.widget.Button[@text='Pagar']");
	protected By listaMedioDePago = By.xpath("//android.view.View[@resource-id='select']");
	protected By btnTarjetaCr = By.xpath("//android.view.View[@content-desc=\"Tarjeta de Crédito - Débito Tarjeta de Crédito - Débito\"]");	
//	protected By btnContinuar = By.xpath("//android.widget.Button[@resource-id='mySubmit_']");
	protected By btnContinuar2 = By.xpath("//android.widget.Button[@text='Continuar']");
	//Datos tarjeta
	protected By txNoTarjeta = By.xpath("//android.widget.EditText[@resource-id='NUMERO_TARJETA']");
	protected By listMesVencimiento = By.xpath("//android.view.View[@resource-id='FECHA_VENC_MES']");
	protected By listAnnoVencimiento = By.xpath("//android.view.View[@resource-id='FECHA_VENC_ANNO']");
	protected By tcCodigoSeguridad = By.xpath("//android.widget.EditText[@resource-id='CODIGO_SEGURIDAD']");
	protected By listCoutas = By.xpath("//android.view.View[@resource-id='CUOTAS']");
	protected By txNombreTarjeta = By.xpath("//android.widget.EditText[@resource-id='NOMBRE_TARJETA']");
	protected By listTipoDocumento = By.xpath("//android.view.View[@resource-id='TIPO_DOCUMENTO']");
	protected By txNumeroDoc = By.xpath("//android.widget.EditText[@resource-id='NUMERO_DOCUMENTO']");
	protected By txTelefono = By.xpath("//android.widget.EditText[@resource-id='TELEFONO']");
	protected By txCorreo = By.xpath("//android.widget.EditText[@resource-id='EMAIL']");
	protected By btnCancelar = By.xpath("//android.widget.Button[@resource-id='btnCancelar']");
	
	//Volver
	protected By btnVolver = By.xpath("//android.widget.ImageButton[@content-desc=\"Desplazarse hacia arriba\"]");
	//Falta el Map de BotonInicio
	protected By btnSelAnio = By.xpath("//android.widget.ListView/android.widget.CheckedTextView[3]");
	protected By btnSelMes = By.xpath("//android.widget.ListView/android.widget.CheckedTextView[3]");
	protected By opTargeta = By.xpath("//android.view.View[@content-desc=\"Tarjeta de Crédito - Débito Tarjeta de Crédito - Débito\"]");
	protected By btnPago = By.xpath("//android.widget.FrameLayout[@content-desc=\"Pagos\"]");
	protected By btnPagoAqui = By.xpath("//android.widget.Button[@text='Paga tu factura aquí']");
	protected By btnRadiobnt = By.xpath("//android.widget.RadioButton[@text='Deseo pagar el total de la factura']");
	// PAGAR FACTURA

	// INGRESAR DESDE MENÚ A PAGOS
	protected By btnPagos = By.xpath("//android.widget.FrameLayout[@content-desc=\"Pagos\"]/android.widget.ImageView");

	// PAGA TU FACTURA AQUÍ
	protected By btnPagaAqui = By.xpath("//android.widget.Button[@text='Paga tu factura aquí']");

	// DESEO PAGAR TODA LA FACTURA
	protected By btnTotal = By.xpath("//android.widget.RadioButton[@resource-id = 'com.clarocolombia.miclaro.debug:id/rbtn1']");

	// DESEO UN PAGO PARCIAL
	protected By btnPagar = By.xpath("//android.widget.Button[@resource-id = 'com.clarocolombia.miclaro.debug:id/btnAceptar']");

	// SELECCIONE MEDIO DE PAGO
	protected By btnMPago = By.xpath("//android.view.View[@resource-id = 'select']");

	// TARJETA DE CRÉDITO - DEBITO
	protected By btnTC= By.xpath("//android.widget.TextView[@text = 'Tarjeta de Crédito - Débito']");

	// CONTINUAR CON TARJETA DE CRÉDITO
	protected By btnContinuar = By.xpath("//android.widget.Button[@text = 'Continuar']");

	// CASILLA NUMERO DE TARJETA
	protected By intNumTC = By.xpath("//android.widget.EditText[@resource-id = 'NUMERO_TARJETA']");

	// INGRESAR MES
	protected By selMonth = By.xpath("//android.view.View[@resource-id = 'FECHA_VENC_MES']");

	// INGRESAR AÑO
	protected By selYear = By.xpath("//android.view.View[@resource-id = 'FECHA_VENC_ANNO']");



	// INGRESAR CVV
	protected By codCVV = By.xpath("//android.widget.EditText [@resource-id = 'CODIGO_SEGURIDAD']");
	
	// INGRESAR NUMERO DE CUOTAS
	protected By selCuotas = By.xpath("//android.view.View [@resource-id = 'CUOTAS']");
	protected By btncoutas = By.xpath("//android.widget.CheckedTextView[@text='6']");
	// INGRESAR NOMBRE DE LA TARJETA DE CRÉDITO
	protected By txtNombreTC = By.xpath("//android.widget.EditText[@resource-id = 'NOMBRE_TARJETA']");
	// INGRESAR SELECCIÓN TIPO DE INDENTIFICACIÓN
	protected By selTipoID = By.xpath("//android.view.View[@resource-id = 'TIPO_DOCUMENTO']");
	protected By selTipoCC = By.xpath("//android.widget.CheckedTextView[@text='C.C. (Cédula de Ciudadanía)']");
	// INGRESAR NUMERO DE IDENTIFICACIÓN
	protected By txtNumID = By.xpath("//android.widget.EditText[@resource-id='NUMERO_DOCUMENTO']");
	// INGRESAR TELEFONO
	protected By txtNumTel = By.xpath("//android.widget.EditText[@resource-id='TELEFONO']");
	// INGRESAR CORREO ELECTRONICO
	protected By txtEmail = By.xpath("//android.widget.EditText[@resource-id='EMAIL']");
	// BOTON ACEPTAR
	protected By btnCnfPago = By.xpath("//android.widget.Button [@resource-id = 'mySubmit_']");
	// BOTON CANCELAR
	protected By btnCancePago = By.xpath("//android.widget.Button[@text='Cancelar']");

	// BOTON DEVOLVERSE
	protected By btnAtrás = By.xpath("//android.widget.ImageButton[@content-desc='Desplazarse hacia arriba']");
	protected By btnImgUsuario = By.xpath("//android.widget.ImageView[@resource-id='com.clarocolombia.miclaro.debug:id/imgPerfil']");
	protected By btnInicio = By.xpath("//android.widget.FrameLayout[@content-desc=\"Inicio\"]/android.widget.ImageView");
	protected By btnCerrarSesion = By.xpath("//android.widget.TextView[@text='Cerrar Sesión']");
	protected By aceptCerrarSesion = By.xpath("//android.widget.Button[@text='Cerrar sesión']");  
}
	
	

