package org.enrycoweiser.showmethedata.standard;

import jakarta.transaction.Transactional;

public interface StandardService<REQ extends StandardRequest, RES extends StandardResponse> {
    @Transactional
    public abstract RES getAPI(REQ request);
}
