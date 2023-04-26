package com.knoldus
package com.knoldus.converter

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import org.apache.poi.xwpf.usermodel.XWPFDocument

import java.io.{File, FileOutputStream}
import scala.util.{Failure, Success, Try}

class PdfToWordConverter {

  def convert(pdfPath: String, docPath: String): Unit = {
    System.setProperty("java.awt.headless", "true")
    val pdfDocument = PDDocument.load(new File(pdfPath))
    val text = extractTextFromPdf(pdfDocument)
    val wordDocument = convertTextToWord(text)
    saveWordDocument(wordDocument, docPath)
    wordDocument.close()
    pdfDocument.close()
  }

  def extractTextFromPdf(pdfDocument: PDDocument): String = {
    val stripper = new PDFTextStripper()
    stripper.setStartPage(0)
    stripper.setEndPage(pdfDocument.getNumberOfPages)
    stripper.getText(pdfDocument)
  }

  def convertTextToWord(text: String): XWPFDocument = {
    val wordDocument = new XWPFDocument()
    val paragraph = wordDocument.createParagraph()
    val run = paragraph.createRun()
    run.setText(text)
    wordDocument
  }

  def saveWordDocument(wordDocument: XWPFDocument, docPath: String): Unit = {
    Try {
      val doc = new FileOutputStream(new File(docPath))
      wordDocument.write(doc)
      doc.close()
    } match {
      case Failure(exception: Exception) => exception.getMessage
      case Success(value) => println("PDF converted to Word document successfully!")
    }
  }
}
