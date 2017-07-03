package com.eleme.sr

import org.apache.camel.{CamelContext, Exchange}
import org.apache.camel.scala.dsl.builder.ScalaRouteBuilder

/**
 * A Camel Router using the Scala DSL
 */
class MyRouteBuilder(override val context : CamelContext) extends ScalaRouteBuilder(context) {

    // an example of a Processor method
   val myProcessorMethod = (exchange: Exchange) => {
     exchange.getIn.setBody("block test")
   }
   
   // a route using Scala blocks
   "timer://foo?period=5s" ==> {
      process(myProcessorMethod)
      to("log:block")
   }


  def test():Unit = {
    println("this is the 1st test example on 3:44")
  }
}