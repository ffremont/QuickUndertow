package fr.ffremont.microservices.quickundertow;



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
        String base = System.getProperty("server.base") == null ? "." : System.getProperty("server.base");
        String host = System.getProperty("server.host") == null ? StaticServer.DEFAULT_HOST : System.getProperty("server.host");
        int port = System.getProperty("server.port") == null ? StaticServer.DEFAULT_PORT : Integer.valueOf(System.getProperty("server.port"));
        boolean listing = System.getProperty("server.listing") == null ? StaticServer.DEFAULT_LISTING : Boolean.valueOf(System.getProperty("server.listing"));
        
        if(args.length == 0){
            (new StaticServer(host, port, base, listing)).run();
        }else{
            (new HelpCommand( Thread.currentThread().getContextClassLoader().getResourceAsStream("help.txt"), System.out)).run();
        }
    }
}
