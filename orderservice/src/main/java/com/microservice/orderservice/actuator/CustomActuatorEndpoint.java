package com.microservice.orderservice.actuator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id="customInfoEndPoint")
public class CustomActuatorEndpoint  {

    @Value("${custominfo.app.name}")
    private String name;

    @Value("${custominfo.app.version}")
    private String version;

    @ReadOperation
    public Map<String, Object> info() {
        // Custom logic to determine health status
        Map<String,Object> map = new HashMap<>();
          map.put("applicationName",name);
          map.put("version",version);

          return map;
    }
}