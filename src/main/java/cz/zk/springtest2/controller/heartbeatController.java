package cz.zk.springtest2.controller;

import cz.zk.springtest2.data.globalData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/testrack")
public class heartbeatController {

    @Autowired
    globalData gd;

    @RequestMapping(value ="/{id}/heartbeat", method = RequestMethod.POST)
    public ResponseEntity<Object> getSingleOutput(@PathVariable String id) {
        int nid;
        try {
            nid = Integer.parseInt(id);
            log.info("+++ ID = " + nid);
            if((nid >= 0) && (nid < 4)) {
                gd.Datumy.set(nid, LocalDateTime.now().toString());
                gd.availability.set(nid, globalData.AVAILABILITY.INUSE);
            }
        }
        catch(Exception ex) {
            return new ResponseEntity<>("MAIN: WRONG ID "+ id, HttpStatus.FORBIDDEN);
        }

        return new ResponseEntity<>("MAIN: ID=" + nid, HttpStatus.OK);
    }


}
