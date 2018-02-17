package com.bingco.socket;

import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;

/**
 * @author bingco
 * @version v1.0
 * By 2018-02-16 9:26
 * Package com.bingco.socket
 * -----------------------------------------------------
 */
public class WebSocketConfigurator extends ServerEndpointConfig.Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec, HandshakeRequest request, HandshakeResponse response) {
        sec.getUserProperties().put("HttpSession", request.getHttpSession());
    }
}
