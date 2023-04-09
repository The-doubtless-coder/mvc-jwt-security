package org.example.resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HelloResource {
    private Log logger = LogFactory.getLog(this.getClass());
    @GetMapping("/hello")
    public ResponseEntity getHello(){
        logger.error("Tis done Ladies and Gents!");
        return ResponseEntity.ok("hello_fellows!");
    }

}
