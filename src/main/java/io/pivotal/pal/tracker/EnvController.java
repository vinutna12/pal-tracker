package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    public Map<String, String> envMap= new HashMap<String, String>();

    public EnvController(@Value("${port}") String s,@Value("${memory.limit}") String s1, @Value("${cf.instance.index: NOT SET}")String s2, @Value("${cf.instance.addr}")String s3) {
        envMap.put("PORT", s);
        envMap.put("MEMORY_LIMIT", s1);
        envMap.put("CF_INSTANCE_INDEX", s2);
        envMap.put("CF_INSTANCE_ADDR", s3);

    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return envMap;
    }
}
