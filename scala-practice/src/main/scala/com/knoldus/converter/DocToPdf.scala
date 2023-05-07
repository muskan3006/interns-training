package com.knoldus
package com.knoldus.converter

import fr.opensagres.poi.xwpf.converter.pdf.{PdfConverter, PdfOptions}
import org.apache.poi.xwpf.usermodel.XWPFDocument
import java.io.{File, FileInputStream, FileOutputStream}
import scala.util.{Failure, Success, Try}


class DocToPdf {
  def convertDocToPdf(docPath: String, pdfPath: String): Unit = {
    System.setProperty("java.awt.headless", "true")
    val docFile = getDoc(docPath)
    val pdfFile = getPdf(pdfPath)
    val option = getPdfOption()

    Try {
      val converter = new PdfConverter
      converter.convert(docFile, pdfFile, option)
    } match {
      case Success(value) => println("Converted")
      case Failure(exception) => exception.getMessage
    }
  }

  def getDoc(docPath: String): XWPFDocument = {
    new XWPFDocument(new FileInputStream(new File(docPath)))
  }

  def getPdf(pdfPath: String): FileOutputStream = {
    new FileOutputStream(new File(pdfPath))
  }

  def getPdfOption(): PdfOptions = {
    PdfOptions.create()
  }

}




