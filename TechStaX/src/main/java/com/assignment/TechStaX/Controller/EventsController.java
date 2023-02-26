package com.assignment.TechStaX.Controller;

import com.assignment.TechStaX.Entity.Commit;
import com.assignment.TechStaX.Entity.Event;
import com.assignment.TechStaX.Service.EventsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/log")
public class EventsController {
    private EventsService eventsService;
    public EventsController(EventsService eventsService){
        this.eventsService=eventsService;
    }
    @PostMapping
    public ResponseEntity<String> details(@RequestBody String str){
        Event events = eventsService.eventsLog(str);
        Logger logger = LoggerFactory.getLogger(EventsController.class);
        logger.info(events.toString());
        return new ResponseEntity<>(str, HttpStatus.OK);
    }
    @GetMapping()
    public ResponseEntity<List<Commit>> getCommits() {
        Logger logger = LoggerFactory.getLogger(EventsController.class);
        List<Commit> list = eventsService.commitLog();
        for (Commit commits:list){
            logger.info(commits.toString());
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
