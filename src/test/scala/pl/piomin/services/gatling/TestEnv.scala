package pl.piomin.services.gatling

import io.gatling.core.scenario.Simulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._
//import pl.piomin.services.gatling.model.Person
import java.util.Date
//import pl.piomin.services.gatling.model.Address
import scala.concurrent.duration.FiniteDuration
import scala.concurrent.duration.Duration
import java.util.concurrent.TimeUnit

object TestEnv {
 
 var base = "http://localhost:8080/students"
 var repeatValue = 1
  
}