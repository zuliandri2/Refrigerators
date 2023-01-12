package com.zuliandri.refirgator {

  object RefrigatorBuilder {

    class RefrigatorBuilderImp {
      def build(build: RefrigatorBuild) = build.assemble()
    }

    trait RefrigatorBuild extends RefrigatorFactory {
      def makeSize = {
        Thread.sleep(1000)
        print(s"make width refrigator ${size.width} ${size.unit}")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        println(".")
        Thread.sleep(1000)
        print(s"make height refrigator ${size.height} ${size.unit}")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        println(".")
        this
      }

      def makeColor = {
        Thread.sleep(1000)
        print(s"make color refrigator ${color.color}")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        println(".")
        Thread.sleep(1000)
        this
      }

      def makeDoor = {
        Thread.sleep(1000)
        print(s"make width door refrigator ${door.width} ${door.unit}")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        println(".")
        Thread.sleep(1000)
        print(s"make height door refrigator ${door.height} ${door.unit}")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        println(".")
        Thread.sleep(1000)
        this
      }

      def makeElectric = {
        Thread.sleep(1000)
        print(s"make electric refrigator ${electric.electric}")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        println(".")
        Thread.sleep(1000)
        this
      }

      def maketemperatureCool = {
        Thread.sleep(1000)
        print(s"make temperature cool refrigator ${temperatureCool.fahreinhet} ${temperatureCool.unit}")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        println(".")
        Thread.sleep(1000)
        this
      }

      def makeRangeTemperaturFreeze = {
        Thread.sleep(1000)
        print(s"make temperature freeze ${temperatureFreeze.fahreinhet} ${temperatureFreeze.unit}")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        println(".")
        Thread.sleep(1000)
        this
      }

      def makeShelf = {
        Thread.sleep(1000)
        print(s"make shelf refrigator ${shelf.shelf}")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        println(".")
        Thread.sleep(1000)
        this
      }

      def done = {
        Thread.sleep(1000)
        print("preparing")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        print(".")
        Thread.sleep(1000)
        println(".")
        Thread.sleep(1000)
        println(s"Process assemble refrigator already done... :)")
      }
    }

    trait RefrigatorFactory {
      val size: RefrigatoreSizeImp
      val color: RefriagatorColorImp
      val door: RefrigatorDoorImp
      val electric: RefrigatorElectriImp
      val temperatureCool: RefrigatorTemperatureCoolImp
      val temperatureFreeze: RefrigatorTemperatureFreezeImp
      val shelf: RefrigatorShelfImp
      def assemble(): Unit
    }

    trait Units {
      val unit: String
    }

    abstract class RefrigatoreSizeImp extends Size with Units

    abstract class RefriagatorColorImp extends Color

    abstract class RefrigatorDoorImp extends Door with Size with Units

    abstract class RefrigatorElectriImp extends Electric

    abstract class RefrigatorTemperatureCoolImp extends TemperatureCool with Temperature with Units

    abstract class RefrigatorTemperatureFreezeImp extends TemperatureFreeze with Temperature with Units

    abstract class RefrigatorShelfImp extends Shelf

    trait Size {
      this: Units =>
      val height: Int
      val width: Int
    }

    trait Color {
      val color: String
    }

    trait Door {
      this: Size with Units =>
      val door: Int
    }

    trait Electric {
      val electric: String
    }

    trait Temperature {
      this: Units =>
      val fahreinhet: Int
    }

    trait TemperatureCool {
      this: Temperature with Units =>
    }

    trait TemperatureFreeze {
      this: Temperature with Units =>
    }

    trait Shelf {
      val shelf: Int
    }

  }

  package ToshibaRefrigator {

    import RefrigatorBuilder.{RefriagatorColorImp, RefrigatorBuild, RefrigatorDoorImp, RefrigatorElectriImp, RefrigatorFactory, RefrigatorShelfImp, RefrigatorTemperatureCoolImp, RefrigatorTemperatureFreezeImp, RefrigatoreSizeImp}

    class ToshibaRefrigatorSize extends RefrigatoreSizeImp {
      override val height: Int = 150
      override val width: Int = 60
      override val unit: String = "cm"
    }

    class ToshibaRefrigatorColor extends RefriagatorColorImp {
      override val color: String = "silver"
    }

    class ToshibaRefrigatorDoor extends RefrigatorDoorImp {
      override val door: Int = 1
      override val height: Int = 150
      override val width: Int = 60
      override val unit: String = "cm"
    }

    class ToshibaRefrigatorElectric extends RefrigatorElectriImp {
      override val electric: String = "Electric created....."
    }

    class ToshibaRefrigatorTempCool extends RefrigatorTemperatureCoolImp {
      override val unit: String = "fahreinhet"
      override val fahreinhet: Int = 5
    }

    class ToshibaRefrigatorTempFreeze extends RefrigatorTemperatureFreezeImp {
      override val unit: String = "fahrenhet"
      override val fahreinhet: Int = 0
    }

    class ToshibaRefrigatorShelf extends RefrigatorShelfImp {
      override val shelf: Int = 4
    }

    class ToshibaRefriagtorFatory (
       override val size: RefrigatoreSizeImp,
       override val color: RefriagatorColorImp,
       override val door: RefrigatorDoorImp,
       override val electric: RefrigatorElectriImp,
       override val temperatureCool: RefrigatorTemperatureCoolImp,
       override val temperatureFreeze: RefrigatorTemperatureFreezeImp,
       override val shelf: RefrigatorShelfImp
   ) extends RefrigatorBuild {
      override def assemble(): Unit = {
        makeSize.makeColor.makeShelf.makeDoor.makeElectric.maketemperatureCool.makeRangeTemperaturFreeze.done
      }
    }
  }
}