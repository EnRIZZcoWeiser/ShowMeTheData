package org.enrycoweiser.showmethedata.standard;

import lombok.Getter;
import lombok.Setter;
import org.enrycoweiser.showmethedata.utils.GeneralUtil;

@Setter
@Getter
public class StandardResponse {
    public String status;
    public String error;
    public String errorCode;

    public void createErrorResponse(String error, String errorCode) {
        this.status = GeneralUtil.STATUS_KO;
        this.error = error;
        this.errorCode = errorCode;
    }

    public void createResponse() {
        this.status = GeneralUtil.STATUS_OK;
    }
}
