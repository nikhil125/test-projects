package com.example

import akka.actor.Actor
import akka.event.Logging

import scala.collection.mutable

class AkkaTestActor extends Actor {
  val map = new mutable.HashMap[String, Object]()
  val log = Logging(context.system, this)

  override def receive: Receive = {
    case SetRequest(key, value) => {
      log.info("Received SetRequest - key={}, value={}", key, value)
      map.put(key, value)
    }
    case o => log.info("Received unknown message ={}", o)
  }
}
