package controllers

import play.api.mvc._
import io.circe.syntax._
import io.circe.generic.auto._
import models._
import utils.Parser._

class Application(val controllerComponents: ControllerComponents) extends BaseController{

  def index = Action {
    Ok("Welcome to the zoo")
  }

  def getLion = Action {
    val lion = Lion("Katherine")
    Ok(lion.asJson.noSpaces)
  }

  def addLion = Action { req =>
    {
      val lion = for {
        body <- extractBody(req.body.asJson.map(_.toString))
        json <- stringToJson(body)
        lion <- jsonToLion(json)
      } yield lion
      val response = lion.fold(_ => InternalServerError, r => Ok(r.asJson.noSpaces))
      response.as("text/json")
    }
  }

}




