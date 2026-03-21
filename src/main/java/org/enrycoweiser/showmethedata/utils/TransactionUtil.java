package org.enrycoweiser.showmethedata.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

public class TransactionUtil {
    private static final Logger log = LoggerFactory.getLogger(TransactionUtil.class);

    public static void rollback() {
        try {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        } catch (Exception e) {
            log.warn("There is no transaction to rollback!");
        }
    }
}
