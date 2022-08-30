package net.autourducode;

import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

import java.util.logging.Logger;

/**
 * @author autouducode
 */
@ServerEndpoint("/simple")
public class SimpleEndpoint {
    private static final Logger logger = Logger.getLogger(SimpleEndpoint.class.getName());
    @OnOpen
    public void connected(Session session) {
        System.out.println("***** Message du serveur, client connecté *****");
    }

    @OnMessage
    public String textMessage(String message) {
        logger.info("***** Nouveau message texte reçu *****");
        logger.info(message);
        return message+" - Modification du serveur";
    }

    @OnMessage(maxMessageSize = 1024000)
    public byte[] binaryMessage(byte[] buffer) {
        logger.info("***** Nouveau message binaire reçu *****");
        return buffer;
    }
}
