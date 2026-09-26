package ejb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Singleton;

@Singleton
public class VisitorStatsBean {

    private int totalVisitors = 0;
    private final List<String> visitorLog = Collections.synchronizedList(new ArrayList<String>());

    // Method called by MDB when a new visit message is consumed
    public synchronized void recordVisit(String visitorInfo) {
        totalVisitors++;
        visitorLog.add(visitorInfo);
    }

    public synchronized int getTotalVisitors() {
        return totalVisitors;
    }

    public synchronized List<String> getVisitorLog() {
        return new ArrayList<String>(visitorLog);
    }
}