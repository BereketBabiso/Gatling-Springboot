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

class ApiGatlingSimulationTest extends Simulation {

  val feederData = csv("PassengersInfo.csv").circular
  val restEndPoint = "/${name}"

  val scn = scenario("GetStudnets")
  .feed(feederData)
  .repeat(TestEnv.repeatValue, "n") {
        exec(
          http("RequestName : GetPerson-API")
            .get(TestEnv.base+restEndPoint)
            .check(status.is(200))
            .check(bodyString.saveAs("response")))
            .exec{
            	session=>
            		println(session("response").as[String])
            		session
            }
           
  }
  
  setUp(scn.inject(atOnceUsers(10))).maxDuration(FiniteDuration.apply(1, "minutes"))
  
}