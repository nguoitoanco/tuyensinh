package co.jp.admission.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseService {
    private static final Logger LOG = LoggerFactory.getLogger(BaseService.class);

    public interface ServiceCaller {
        Object execute() throws Exception;
    }

}
