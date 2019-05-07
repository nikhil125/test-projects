package com.example
trait Status {

  case class Failure(val exception: Exception)

  case class Success(val message: String)

}


