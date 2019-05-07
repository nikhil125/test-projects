package com.example

import akka.actor.ActorSystem
import akka.testkit.TestActorRef
import org.scalatest.{BeforeAndAfterEach, FunSpecLike, Matchers}

class AkkaTestActorTest extends FunSpecLike with Matchers with BeforeAndAfterEach {

  implicit val system = ActorSystem()

  describe("Akka Test Actor") {
    describe("given SetRequest") {
      it("should place key/value into map") {
        val actorRef = TestActorRef(new AkkaTestActor)
        actorRef !SetRequest("key-1", "value-1")
        val myactor = actorRef.underlyingActor
        myactor.map.get("key-1") should equal (Some("value-1"))
      }
    }
  }

}
