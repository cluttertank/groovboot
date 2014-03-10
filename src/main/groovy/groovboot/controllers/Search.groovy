package groovboot.controllers

import groovboot.models.Answer
import groovboot.models.Data
import java.util.concurrent.Callable
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping('/api')
class Search {

  //TODO Autowired not working right
  //@Autowired Data data
  Data data = new Data()

  /**
   * Callable controller method gets processed async in 
   * separate thread then returned to caller.
   */
  @RequestMapping(value='/answers/{question}',method=RequestMethod.GET)
  Callable<List> search(@PathVariable('question') String question) {
    new Callable<List>() {
      List call() { 
        data.answers(question).get()
      }
    }
  }

}