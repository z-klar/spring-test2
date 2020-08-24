package cz.zk.springtest2.service;

import cz.zk.springtest2.data.globalData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class schedulerService {

    @Autowired
    globalData gd;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        String spom;
        log.info("   timer_tick ....");
        for(int i=0; i<4; i++) {
            log.info("   Rack[" + i + "]:   LastCall: " + gd.Datumy.get(i)
                    + "  AVAILABILITY: " + gd.availability.get(i)
                    + " / " + gd.availability.get(i).ordinal());
        }
    }
}
