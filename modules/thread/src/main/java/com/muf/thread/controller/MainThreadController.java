package com.muf.thread.controller;

import com.muf.thread.test.Station;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-03-22-14:44
 */
public class MainThreadController {
    private static Logger logger = LoggerFactory.getLogger(MainController.class);

    public static void main(String[] args){
        Station station1 = new Station("一号售票口");
        Station station2 = new Station("二号售票口");
        Station station3 = new Station("三号售票口");

        station1.start();
        station2.start();
        station3.start();
        logger.info("aa");
    }
}
