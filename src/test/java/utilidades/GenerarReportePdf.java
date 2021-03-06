package utilidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;

import org.openqa.selenium.By;

import com.itextpdf.io.exceptions.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import semilleros.ClasesBase;

public class GenerarReportePdf {

	static String fecha;
	static Document documento;
	static FileOutputStream archivo;
	static Paragraph titulo;
	String rutaImagen;
	String hora;
	String horaInicio, horaFin;
	

	PdfPTable table = new PdfPTable(2);

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

//	public void crearTablaTitulo(String nomTest, File rutaCarpeta) throws Exception, IOException {
//		hora = ClasesBase.fechaHora();
//		horaInicio = ClasesBase.fechaHora2();
//
//		try {
//
//			// CREAR RUTA Y NPMBRE DEL PDF
//			archivo = new FileOutputStream(rutaCarpeta + "\\" + "Reporte-" + nomTest + "-" + hora + ".pdf");
//			PdfWriter.getInstance(documento, archivo);
//
//			// INSERT IMAGEN
//			// UBICACI?N DE LA IMAGEN
//			header = Image.getInstance(rutaImagen);
//			// TAMA?O DE LA IMAGEN
//			header.scaleToFit(250, 1000);
////			header.setAlignment(Chunk.ALIGN_RIGHT);
//			header.setWidthPercentage(100);
//
//			// CREAR TITULO DEL PDF
//			titulo = new Paragraph(nomTest + "\n\n" + "Fecha inicio:  " + horaInicio);
//			titulo.setAlignment(1);
//
//			// CREAR TABLA DE ENCABEZADO
//
//			table.setWidthPercentage(100);
//			PdfPCell pos1 = new PdfPCell(header);
//			pos1.setHorizontalAlignment(1);
//			PdfPCell pos2 = new PdfPCell(titulo);
//			pos2.setHorizontalAlignment(1);// 0=Left, 1=Center, 2=Right
//			pos2.setVerticalAlignment(2);
//
//			table.addCell(pos2);
//			table.addCell(pos1);
//
//			// GEENERAR MARGEN
//			documento.setMargins(30, 30, 30, 30);
//			// ABRIR DOCUMENTO
//			documento.open();
//
//			// INSERTA LA IMAGEN
//			documento.add(table);
//
//			documento.add(Chunk.NEWLINE);
//		} catch (FileNotFoundException e) {
//			System.err.println(e.getMessage());
//		} catch (DocumentException e) {
//			System.err.println(e.getMessage());
//		} catch (IOException e) {
//			System.err.println("Error al logo periferia: " + e.getMessage());
//		}
//	}

	public void crearPlantilla(String nomTest, File rutaCarpeta) throws Exception, IOException {

		// Instanciar Docmento
		documento = new Document();
//		crearTablaTitulo(nomTest, rutaCarpeta);
		// Tomar la hora del sistema
		hora = ClasesBase.fechaHora();
		horaInicio = ClasesBase.fechaHora2();

		try {

			// CREAR RUTA Y NPMBRE DEL PDF
			archivo = new FileOutputStream(rutaCarpeta + "\\" + "Reporte-" + nomTest + "-" + hora + ".pdf");
			PdfWriter.getInstance(documento, archivo);

			// INSERT IMAGEN
			// UBICACI?N DE LA IMAGEN
			Image header = Image.getInstance(rutaImagen);
			// TAMA?O DE LA IMAGEN
			header.scaleToFit(250, 1000);
//			header.setAlignment(Chunk.ALIGN_RIGHT);
			header.setWidthPercentage(100);

			// CREAR TITULO DEL PDF
			titulo = new Paragraph(nomTest + "\n\n" + "Fecha inicio:  " + horaInicio);
			titulo.setAlignment(1);

			// CREAR TABLA DE ENCABEZADO

			table.setWidthPercentage(100);
			PdfPCell pos1 = new PdfPCell(header);
			pos1.setHorizontalAlignment(1);
			PdfPCell pos2 = new PdfPCell(titulo);
			pos2.setHorizontalAlignment(1);// 0=Left, 1=Center, 2=Right
			pos2.setVerticalAlignment(2);

			table.addCell(pos2);
			table.addCell(pos1);

			// GEENERAR MARGEN
			documento.setMargins(30, 30, 30, 30);
			// ABRIR DOCUMENTO
			documento.open();

			// INSERTA LA IMAGEN
//			documento.add(table);
//			int it = 0;
			documento.add(table);
//			it++;
//
//			if (it == 1) {
//				documento.newPage();
////				documento.add(table);
//				documento.add(new Paragraph("\n"));
//				it = 0;
//			}

			documento.add(Chunk.NEWLINE);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (DocumentException e) {
			System.err.println(e.getMessage());
		} catch (IOException e) {
			System.err.println("Error al logo periferia: " + e.getMessage());
		}
	}

	public void crearBody(By locator, String rutaImagen/* ,String nomTest, File rutaCarpeta */)
			throws DocumentException, java.io.IOException {

		// Obtener el nombre del localizador
		String locator1 = locator.toString();

//		try {
//
//			// CREAR RUTA Y NPMBRE DEL PDF
//			archivo = new FileOutputStream(rutaCarpeta + "\\" + "Reporte-" + nomTest + "-" + hora + ".pdf");
//			PdfWriter.getInstance(documento, archivo);
//
//			// INSERT IMAGEN
//			// UBICACI?N DE LA IMAGEN
//			header = Image.getInstance(rutaImagen);
//			// TAMA?O DE LA IMAGEN
//			header.scaleToFit(250, 1000);
////			header.setAlignment(Chunk.ALIGN_RIGHT);
//			header.setWidthPercentage(100);
//
//			// CREAR TITULO DEL PDF
//			titulo = new Paragraph(nomTest + "\n\n" + "Fecha inicio:  " + horaInicio);
//			titulo.setAlignment(1);
//
//			// CREAR TABLA DE ENCABEZADO
//
//			table.setWidthPercentage(100);
//			PdfPCell pos1 = new PdfPCell(header);
//			pos1.setHorizontalAlignment(1);
//			PdfPCell pos2 = new PdfPCell(titulo);
//			pos2.setHorizontalAlignment(1);// 0=Left, 1=Center, 2=Right
//			pos2.setVerticalAlignment(2);
//
//			table.addCell(pos2);
//			table.addCell(pos1);
//
//			// GEENERAR MARGEN
//			documento.setMargins(30, 30, 30, 30);
//			// ABRIR DOCUMENTO
//			documento.open();
//
//			// INSERTA LA IMAGEN
//			documento.add(table);
//
//			documento.add(Chunk.NEWLINE);
//		} catch (FileNotFoundException e) {
//			System.err.println(e.getMessage());
//		} catch (DocumentException e) {
//			System.err.println(e.getMessage());
//		} catch (IOException e) {
//			System.err.println("Error al logo periferia: " + e.getMessage());
//		}

		// DAR FORMATO A LA FUENTE
		Paragraph parrafo = new Paragraph();

		parrafo.setAlignment(Chunk.ALIGN_LEFT);
		parrafo.setFont(FontFactory.getFont("Arial", 10, Font.NORMAL));
		parrafo.add("\nSe realiza acci?n sobre elemento: " + locator1);

		// ADICIONAR MENSAJE AL PDF
		documento.add(parrafo);

		// INSERT IMAGEN
		// UBICACI?N DE LA IMAGEN
		Image imagen = Image.getInstance(rutaImagen);
		// TAMA?O DE LA IMAGEN
		imagen.scalePercent(30, 30);
		imagen.setAlignment(Chunk.ALIGN_CENTER);
		// CREAMOS CONTADOR DE IMAGENES POR PAGINA
		int im = 0;
		documento.add(imagen);
		im++;

		if (im == 1) {
			documento.newPage();
//			documento.add(table);
			documento.add(new Paragraph("\n"));
			im = 0;
		}
	}

	public void crearbodyError(By locator, String rutaImagen, String msnError/* ,String nomTest, File rutaCarpeta */)
			throws DocumentException, IOException, Exception {
		// OBTENER EL NOMBRE DEL LOCALIZADOR
		String locator1 = locator.toString();

//		try {
//
//			// CREAR RUTA Y NPMBRE DEL PDF
//			archivo = new FileOutputStream(rutaCarpeta + "\\" + "Reporte-" + nomTest + "-" + hora + ".pdf");
//			PdfWriter.getInstance(documento, archivo);
//
//			// INSERT IMAGEN
//			// UBICACI?N DE LA IMAGEN
//			header = Image.getInstance(rutaImagen);
//			// TAMA?O DE LA IMAGEN
//			header.scaleToFit(250, 1000);
////			header.setAlignment(Chunk.ALIGN_RIGHT);
//			header.setWidthPercentage(100);
//
//			// CREAR TITULO DEL PDF
//			titulo = new Paragraph(nomTest + "\n\n" + "Fecha inicio:  " + horaInicio);
//			titulo.setAlignment(1);
//
//			// CREAR TABLA DE ENCABEZADO
//
//			table.setWidthPercentage(100);
//			PdfPCell pos1 = new PdfPCell(header);
//			pos1.setHorizontalAlignment(1);
//			PdfPCell pos2 = new PdfPCell(titulo);
//			pos2.setHorizontalAlignment(1);// 0=Left, 1=Center, 2=Right
//			pos2.setVerticalAlignment(2);
//
//			table.addCell(pos2);
//			table.addCell(pos1);
//
//			// GEENERAR MARGEN
//			documento.setMargins(30, 30, 30, 30);
//			// ABRIR DOCUMENTO
//			documento.open();
//
//			// INSERTA LA IMAGEN
//			documento.add(table);
//
//			documento.add(Chunk.NEWLINE);
//		} catch (FileNotFoundException e) {
//			System.err.println(e.getMessage());
//		} catch (DocumentException e) {
//			System.err.println(e.getMessage());
//		} catch (IOException e) {
//			System.err.println("Error al logo periferia: " + e.getMessage());
//		}

		// DAR FORMATO A LA FUENTE
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Chunk.ALIGN_LEFT);
		parrafo.setFont(FontFactory.getFont("Arial", 10, Font.NORMAL));
		parrafo.add("Se realiza accion sobre el elemento: " + locator1);
		// ADICIONAR MENSAJE AL PDF
		documento.add(parrafo);

		// INSERTT IMAGEN
		// UBICACION DE LA IMAGEN
		Image imagen = Image.getInstance(rutaImagen);
		// TAMA?O DE LA IMAGEN
		imagen.scalePercent(30, 30);
		imagen.setAlignment(Chunk.ALIGN_CENTER);
		int im = 0;
		documento.add(imagen);
		im++;

		if (im == 1) {
			documento.newPage();
//			documento.add(table);
			documento.add(new Paragraph("\n"));
			im = 0;
		}

		// MENSAJE ERROR
		// DAR FORMATO A LA FUENTE
//		Paragraph parrafoError = new Paragraph();
//		parrafoError.setAlignment(Chunk.ALIGN_LEFT);
//		parrafoError.setFont(FontFactory.getFont("Arial", 8, Font.ITALIC, BaseColor.GRAY));
//		parrafoError.add("MENSAJE DE ERROR: " + "\n" + msnError);
////		documento.add(parrafoError);
//		int me=0;
//		documento.add(parrafoError);
//		me++;
//		
//		if (me == 1) {
//			documento.newPage();
////			documento.add(table);
//			documento.add(new Paragraph("\n"));
//			me = 0;
//		}
		// MENSAJE ERROR
		// DAR FORMATO A LA FUENTE
		Paragraph elementoError = new Paragraph();
		elementoError.setAlignment(Chunk.ALIGN_LEFT);
		elementoError.setFont(FontFactory.getFont("Times", 10, Font.NORMAL, BaseColor.RED));
		elementoError.add("\nAcci?n con error: " + locator);

		Paragraph parrafoError = new Paragraph();
		parrafoError.setAlignment(Chunk.ALIGN_LEFT);
		parrafoError.setFont(FontFactory.getFont("Arial", 8, Font.ITALIC, BaseColor.GRAY));
		parrafoError.add("MENSAJE DE ERROR: " + "\n" + msnError);
		// documento.add(parrafoError);
		documento.add(elementoError);
		int me = 0;
		documento.add(parrafoError);
		me++;

		if (me == 1) {
			documento.newPage();
//					documento.add(table);
			documento.add(new Paragraph("\n"));
			me = 0;
		}

		documento.close();

	

	}

	public void cerrarPlantilla() throws DocumentException {
		documento.add(Chunk.NEWLINE);
		// DAR FORMATO A LA FUENTE
		Paragraph parrafo = new Paragraph();
		parrafo.setAlignment(Chunk.ALIGN_RIGHT);
		parrafo.setFont(FontFactory.getFont("Arial", 10, Font.BOLD));
		parrafo.add("Fecha inicio:  " + horaInicio + "\n");

		// ADICIONAR MENSAJE AL PDG
		// documento.add(parrafo);
		horaFin = ClasesBase.fechaHora2();
		parrafo.add("Fecha Fin:  " + horaFin);

		// ADICIONAR MENSAJE AL PDF
		documento.add(parrafo);
		documento.close();

	}

}
