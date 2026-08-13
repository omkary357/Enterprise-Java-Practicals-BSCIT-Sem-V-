package mypack;

import javax.ejb.Singleton;

@Singleton
public class HitCounterBean {

    private int count = 0;

    public int getHitCount() {

        count++;

        return count;

    }

}