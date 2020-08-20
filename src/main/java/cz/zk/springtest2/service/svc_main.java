package cz.zk.springtest2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class svc_main {

    public boolean  srvPingAddr(String ipAddr) throws IOException {

        String OS = System.getProperty("os.name").toLowerCase();
        log.info("##########  OS: " + OS + "   ##############");
        String spar = "", sres = "";
        if(OS.contains("windows")) spar = "-n";
        else if(OS.contains("linux")) spar = "-c";
        else throw new IOException("Unknown OS !!!");
        String s = null;
        List<String> commands = new ArrayList<String>();
        commands.add("ping");
        commands.add(spar);
        commands.add("2");
        commands.add(ipAddr);
        ProcessBuilder processbuilder = new ProcessBuilder(commands);
        Process process = processbuilder.start();
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
        log.info("Here is the standard output of the command:\n");
        while ((s = stdInput.readLine()) != null)
        {
            log.info(s);
            sres += s;
        }
        if((sres.contains("TTL")) || (sres.contains("ttl"))) return(true);
        else return(false);
    }

}
