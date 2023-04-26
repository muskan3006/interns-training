package com.knoldus
package Converter
import org.apache.pdfbox.Loader
import java.io.{File, FileInputStream, FileOutputStream}
import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import org.apache.poi.xwpf.usermodel.{XWPFDocument, XWPFParagraph}
import scala.util.{Try, Success, Failure}

object PDFToDocxConverter extends App {
  //  a private File object representing the input PDF file
  private val pdfFile = new File("//home/knoldus/Downloads/Untitled document.pdf")
  //  a private File object representing the output DOCX file in the user's Downloads folder
  private val docxFile = new File(System.getProperty("user.home"), "Downloads/converted.docx")
  convertPDFToDocx(pdfFile, docxFile)
  println("pdf to docx converted successfully")

  // a method which convert takes pdf and an outfile which represents a doc file
  private def convertPDFToDocx(pdfFile: File, DocxFile: File): Unit = {
    val document = new FileInputStream(pdfFile)
    val pdfDocument = Loader.loadPDF(document)
    Try {
      val pdfText = extractTextFromPDF(pdfDocument)
      val docxDocument = new XWPFDocument()
      val paragraph = docxDocument.createParagraph()
      addTextToDocx(pdfText, paragraph)
      saveDocx(docxDocument, docxFile)
      pdfDocument.close()
    } match {
      case Success(_) => println("Conversion successful")
      case Failure(exception) => println(s"Conversion failed: ${exception.getMessage}")
    }
  }

  //a private method named "extractTextFromPDF" that takes in a PDDocument object representing a PDF document
  private def extractTextFromPDF(pdfDocument: PDDocument): String = {
    val pdfTextStripper = new PDFTextStripper()
    pdfTextStripper.getText(pdfDocument)
  }

  // This is a private method that takes a string of text and an XWPFParagraph object as input.
  private def addTextToDocx(text: String, paragraph: XWPFParagraph): Unit = {
    val run = paragraph.createRun()
    val lines = text.split("\n")
    val formattedLines = for{
      line <- lines
    }yield (run.setText(line),run.addBreak(),run.addBreak())
  }

  // This is a private method that takes an XWPFDocument object and a File object as input.
  private def saveDocx(docxDocument: XWPFDocument, docxFile: File): Unit = {
    val out = new FileOutputStream(docxFile)
    docxDocument.write(out)
    out.close()
  }
}