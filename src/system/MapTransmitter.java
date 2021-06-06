//package system;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//
//import javax.jms.*;
//
//import com.google.gson.Gson;
//
//public class MapTransmitter {
//
//	private Session session;
//	private String destinationQueueName;
//	private boolean connected;
//	private MessageProducer producer;
//	//private MessageConsumer consumer;
//    //private Destination responseChannel;
//    private int messageID;
//	private ConnectionFactory factory;
//	private Connection connection;
//	private String user, password;
//
//	public MapTransmitter(String host, int port, String user, String password, String dest) throws JMSException {
//		factory = new ActiveMQConnectionFactory("tcp://" + host + ":" + port);
//		this.user = user;
//		this.password = password;
//		this.destinationQueueName = dest;
//		connected = connect();
//	}
//
//	public MapTransmitter(String destination) throws JMSException {
//		this("localhost", 61616, "admin", "admin", destination);
//	}
//
//	public boolean sendData(String data) throws JMSException {
//		
//		if(!connected) {connected = connect();
//		System.out.println("Trying to connect...");}
//		else {
//			
//			if(!connected) connect();
//	        assert(connected== true);
//	        TextMessage textMessage= session.createTextMessage(data);
//	        textMessage.setIntProperty("id", ++messageID);
//	        producer.send(textMessage);
//		}
//		return false;
//	}
//	
//	private boolean connect() throws JMSException
//    {    
//        connection = factory.createConnection(user, password);
//        connection.start();
//        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        Destination dest = session.createQueue(destinationQueueName);
//        producer = session.createProducer(dest);
//        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);     
//        messageID=0;
//        // response channel
//        //responseChannel= session.createTemporaryQueue();
//        //consumer= session.createConsumer(responseChannel);
//        return true;
//    }
//	
//	private boolean close() throws JMSException
//    {
//        connection.close();
//        connected= false;
//        return connected;
//    }
//	
//
//	
//}
