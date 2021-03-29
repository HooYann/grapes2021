package org.yann.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLoader0 {

    /**
     *
     * AutoService
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        ServiceLoader loader = ServiceLoader.load(IMyService.class);
        Iterator iterator = loader.iterator();
        while (iterator.hasNext()) {
            IMyService myService = (IMyService) iterator.next();
        }
    }

}
