package com.zuliandri.refirgator

import ToshibaRefrigator.{ToshibaRefriagtorFatory, ToshibaRefrigatorColor, ToshibaRefrigatorDoor, ToshibaRefrigatorElectric, ToshibaRefrigatorShelf, ToshibaRefrigatorSize, ToshibaRefrigatorTempCool, ToshibaRefrigatorTempFreeze}

import com.zuliandri.refirgator.RefrigatorBuilder.RefrigatorBuilderImp

object Refrigator {
  def main(args: Array[String]): Unit = {
    val nameRefrigator = "Toshiba"
    print(s"Waiting proccess make refrigator ${nameRefrigator}")
    Thread.sleep(1000)
    print(".")
    Thread.sleep(1000)
    print(".")
    Thread.sleep(1000)
    println(".")
    Thread.sleep(1000)
    val toshibaRefrigator = new ToshibaRefriagtorFatory(
      size = new ToshibaRefrigatorSize,
      shelf = new ToshibaRefrigatorShelf,
      door = new ToshibaRefrigatorDoor,
      electric = new ToshibaRefrigatorElectric,
      temperatureCool = new ToshibaRefrigatorTempCool,
      temperatureFreeze = new ToshibaRefrigatorTempFreeze,
      color = new ToshibaRefrigatorColor
    )

    val builder = new RefrigatorBuilderImp
    builder.build(toshibaRefrigator)
  }
}


