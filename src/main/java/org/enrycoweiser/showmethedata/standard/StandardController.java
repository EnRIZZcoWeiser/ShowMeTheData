package org.enrycoweiser.showmethedata.standard;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface StandardController<REQ extends StandardRequest, RES extends StandardResponse> {
    @PostMapping
    public abstract RES getAPI(@RequestBody REQ request);
}
