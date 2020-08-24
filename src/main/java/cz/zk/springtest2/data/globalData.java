package cz.zk.springtest2.data;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Slf4j
public class globalData {

    public ArrayList<String> Datumy = new ArrayList<>();

}
