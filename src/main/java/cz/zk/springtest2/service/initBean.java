package cz.zk.springtest2.service;

import cz.zk.springtest2.data.globalData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j

public class initBean implements InitializingBean {

    @Autowired
    globalData gd;

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("############   InitializingBean#afterPropertiesSet()");
        gd.Datumy.add("String 1");
        gd.Datumy.add("String 2");
        gd.Datumy.add("String 3");
        gd.Datumy.add("String 4");
    }

}
