package com.knoldus
package Converter
import fr.opensagres.poi.xwpf.converter.pdf.{PdfConverter, PdfOptions}

import java.io.{File, FileInputStream, FileOutputStream, InputStream, OutputStream}
import org.apache.poi.xwpf.usermodel.XWPFDocument

import scala.util.{Failure, Success, Try}

object DocsToPdfConverter extends App {
  private val converter = new Converter
  // a file path for the input DOCX file
  val docxFile = new File("/home/knoldus/Downloads/Untitled document.docx")
  // a file path for the output pdf file
  val pdfFile = new File(System.getProperty("user.home"), "Downloads/converted.pdf")
  println("Start")
  converter.ConvertToPDF(docxFile, pdfFile)
}

class Converter {
  def ConvertToPDF(docPath: File, pdfPath: File): Unit = {
    Try {
      val documentInput: InputStream = new FileInputStream(docPath)
      val document: XWPFDocument = new XWPFDocument(documentInput)
      val options: PdfOptions = PdfOptions.create()
      val output: OutputStream = new FileOutputStream(pdfPath)
      PdfConverter.getInstance().convert(document, output, options)
      println("Done")
    } match {
      case Success(_) => println("Conversion successful")
      case Failure(exception) => println(s"Conversion failed: ${exception.getMessage}")
    }
  }
}


