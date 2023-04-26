package com.knoldus
package com.knoldus.converter

object Driver extends App {

  private val pdfToWord = new PdfToWordConverter
  pdfToWord.convert("/home/knoldus/Downloads/IOT.pdf",
    "/home/knoldus/Documents/output23.docx")

  private val doctoPdf = new DocToPdf
  val convert: Unit = doctoPdf.convertDocToPdf("/home/knoldus/Downloads/Calculator.docx"
    ,"/home/knoldus/Downloads/output123.pdf")
}
