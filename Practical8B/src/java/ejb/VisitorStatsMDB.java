package ejb;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(mappedName = "jms/VisitorQueue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class VisitorStatsMDB implements MessageListener {

    @EJB
    private VisitorStatsBean statsBean;

    public VisitorStatsMDB() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String visitorDetails = textMessage.getText();

                String timeStamp = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
                String logEntry = visitorDetails + " (Visited at: " + timeStamp + ")";

                // Update statistics in Singleton EJB
                statsBean.recordVisit(logEntry);

                System.out.println("[MDB Processed Visit]: " + logEntry);
            }
        } catch (JMSException e) {
            System.err.println("Error processing JMS message in MDB: " + e.getMessage());
        }
    }
}
