package com.example

import akka.actor.{Actor, Status}
import akka.event.Logging

import scala.collection.mutable

class PingActor extends Actor {
  val map = new mutable.HashMap[String, Object]()
  val log = Logging(context.system, this)

  override def receive: Receive = {
    case SetRequest(key, value) => {
      log.info("Received SetRequest - key={}, value={}", key, value)
      map.put(key, value)
      sender() ! Status.Success "set new value"

    }
    case GetRequest(key) => {
      log.info("Get request for key={}", key)
      val value : Option[Object] = map.get(key)
      value match {
        case Some(x) => sender() ! x
        case None => sender() ! Status.Failure new ClassNotFoundException()
      }
    }
    case o => log.info("Received unknown message ={}", o)
  }

}
