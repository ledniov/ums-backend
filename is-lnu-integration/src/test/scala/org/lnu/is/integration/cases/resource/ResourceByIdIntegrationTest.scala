package org.lnu.is.integration.cases.resource
import io.gatling.core.Predef.checkBuilder2Check
import io.gatling.core.Predef.doIf
import io.gatling.core.Predef.exec
import io.gatling.core.Predef.asLongAs
import io.gatling.core.Predef.findCheckBuilder2ValidatorCheckBuilder
import io.gatling.core.Predef.foreach
import io.gatling.core.Predef.feed
import io.gatling.core.Predef.stringToExpression
import io.gatling.core.Predef.validatorCheckBuilder2CheckBuilder
import io.gatling.core.Predef.value2Expression
import io.gatling.core.Predef.value2Success
import io.gatling.http.Predef.http
import io.gatling.http.Predef.jsonPath
import io.gatling.core.Predef.csv
import io.gatling.core.Predef.jsonFile
import io.gatling.http.Predef.status
import io.gatling.http.request.builder.HttpRequestBuilder.toActionBuilder
import scala.concurrent.duration.DurationInt

object ResourceByIdIntegrationTest {
  
    val urls = List(
        "/addresstypes", "/adminunits", "/adminunits/types", "/assets",
        "/assets/states", "/assets/statuses", "/assets/types", "/benefits",
        "/benefits/types", "/broadcastings", "/contacts/types", "/courses/types",
        "/degrees", "/degrees/types", "/departments", "/departments/types",
        "/duties/types", "/educations/types", "/educations/forms/types","/employees",
        "/employees/statuses", "/employees/types", "/enrolments", "/enrolments/statustypes",
        "/enrolments/subjects", "/enrolments/types", "/enrolmentforeignes/types", "/families/types",
        "/gendertypes", "/honors/types", "/jobtypes", "/languages",
        "/marks/scales", "/marks/scales/types", "/marriedtypes", "/operationtypes",
        "/orders", "/orders/types", "/papers/types", "/papers/usages",
        "/partners", "/persons", "/persons/types", "/publicactivities",
        "/publicactivities/types", "/reasons", "/salaries/types", "/specialties",
        "/specialties/types", "/specoffers", "/specoffers/types", "/streets/types",
        "/studyplans/cycles", "/subjects", "/subjects/types", "/timeperiods",
        "/timeperiods/types", "/timesheets/types", "/wave/types"
    )
    
    val testCase = 
      exec(session => {
        session.set("m_urls", urls);
      })
      .foreach("${m_urls}", "url") {
            exec(http("Multiple Paged Request For Getting Count, Offset and Limit")
                  .get("${url}")
                  .basicAuth("admin", "nimda")
                  .check(status.is(200))
                  .check(jsonPath("$.count").find.saveAs("count"))            
                  .check(jsonPath("$.limit").find.saveAs("limit"))            
                  .check(jsonPath("$.offset").find.saveAs("offset"))            
                  .check(jsonPath("$.resources[*]").ofType[Map[String, Any]].findAll.saveAs("resources")))
            .exec(session => {
                val offset = session("offset").as[String].toInt
                val limit = session("limit").as[String].toInt
                val count = session("count").as[String].toInt

                // First occurance -> Situation, when offset == 0 and needs to proceed.
                val result = offset + limit < count || offset <= count
                
                session.set("result", result)
            })     
            .asLongAs(session => session("result").as[Boolean]) {
                  exec(
                      exec(http("Multiple Paged Request for: ${url}")
                            .get("${url}?offset=${offset}")
                            .basicAuth("admin", "nimda")
                            .check(status.is(200))
                            .check(jsonPath("$.count").find.saveAs("count"))            
                            .check(jsonPath("$.limit").find.saveAs("limit"))            
                            .check(jsonPath("$.offset").find.saveAs("offset"))            
                            .check(jsonPath("$.resources[*]").ofType[Map[String, Any]].findAll.saveAs("resources")))                  
                  )
                  .foreach("${resources}", "resource") {
                            exec( session => {
                                val resource = session("resource").as[Map[String, Any]]
                                val resourceId = resource("id")
                                
                                session.set("resourceId", resourceId)
                            })
                            .exec(
                                http("Checking resource by id")
                                  .get("${url}/${resourceId}")
                                  .basicAuth("admin", "nimda")
                                  .check(status.is(200))
                            )
                  }
                  .exec(session => {
                      val offset = session("offset").as[String].toInt
                      val limit = session("limit").as[String].toInt
                      val count = session("count").as[String].toInt

                      // Can be a situation, when offset == 0 and offset + count will be > count
                      // That's why we need to add additional check -> offset != null
                      val result = offset + limit < count || (offset <= count && offset != 0)
                      
                      session
                        .set("offset", offset + limit)
                        .set("result", result)
                  })
            }
      }    
    
}