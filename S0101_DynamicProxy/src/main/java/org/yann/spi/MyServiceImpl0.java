package org.yann.spi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyServiceImpl0 implements IMyService {

    private static Logger logger = LoggerFactory.getLogger(MyServiceImpl0.class);

    public MyServiceImpl0() {
        logger.debug("come on my service loader");
    }

}
