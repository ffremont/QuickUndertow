/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.microservices.quickundertow;

import io.undertow.Handlers;
import io.undertow.Undertow;
import io.undertow.server.handlers.resource.FileResourceManager;
import java.nio.file.Paths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author florent
 */
public class StaticServer {
    
    private final static Logger LOG = LoggerFactory.getLogger(StaticServer.class);
    
    public final static String DEFAULT_HOST = "localhost";
    public final static int DEFAULT_PORT = 8080;
    public final static boolean DEFAULT_LISTING = false;
    
    private boolean listing;
    private String host;

    private int port;
    private String baseDir;
        
     public StaticServer(String host, int port, String baseDir, boolean listing) {
        this.listing = listing;
        this.baseDir = baseDir;
        this.host = host;
        this.port = port;
    }
    
    public void run(){
        LOG.info("Démarrage du serveur {}:{} -> {}", this.host, this.port, this.baseDir);
        
        FileResourceManager prm = new FileResourceManager(Paths.get(this.baseDir).toFile(), 1024);
        
        Undertow server = Undertow.builder()                                                    
                .addHttpListener(this.port, this.host)
                .setHandler( Handlers.resource(prm).setDirectoryListingEnabled(this.listing) ).build();
        
        server.start();
    }
    
    public boolean isListing() {
        return listing;
    }

    public void setListing(boolean listing) {
        this.listing = listing;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getBaseDir() {
        return baseDir;
    }

    public void setBaseDir(String baseDir) {
        this.baseDir = baseDir;
    }
}
