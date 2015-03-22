package fr.ffremont.microservices.quickundertow;

import static io.undertow.Handlers.path;
import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author florent
 */
public class Runner {

    public static void main(final String[] args) {
        Undertow server = Undertow.builder()
                .addHttpListener(8888, "localhost")
                .setHandler(path()
                        .addPrefixPath("/", new HttpHandler() {
                            @Override
                            public void handleRequest(HttpServerExchange hse) throws Exception {
                                hse.getResponseSender().send("Hello world");
                            }
                        })
                ).build();
        server.start();
    }
}
