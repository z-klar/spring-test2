package cz.zk.springtest2.controller;

import cz.zk.springtest2.service.svc_main;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/main")
public class main {

    @Autowired
    private svc_main serviceMain;

    @RequestMapping(value ="/{id}")
    public ResponseEntity<Object> getSingleOutput(@PathVariable String id) {
        int nid;
        try {
            nid = Integer.parseInt(id);
            log.info("+++ ID = " + nid);
        }
        catch(Exception ex) {
            return new ResponseEntity<>("MAIN: WRONG ID "+ id, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("MAIN: ID=" + nid, HttpStatus.OK);
    }


    @RequestMapping(value ="/ping/{addr}")
    public ResponseEntity<Object> pingIp(@PathVariable String addr) {

        try {
            boolean bres = serviceMain.srvPingAddr(addr);
            return new ResponseEntity<>("RESULT {" + addr + "} = " + bres, HttpStatus.OK);
        }
        catch(Exception ex) {
            return new ResponseEntity<>("ERROR: "+ ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
