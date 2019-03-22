package com.muf.thread.controller;

import com.muf.thread.test.Station;

/**
 * Description:
 *
 * @author: hutao
 * Date: 2019-03-22-14:44
 */
public class MainThreadController {

    public static void main(String[] args){
        Station station1 = new Station("一号售票口");
        Station station2 = new Station("二号售票口");
        Station station3 = new Station("三号售票口");

        station1.start();
        station2.start();
        station3.start();
    }
}
