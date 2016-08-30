/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.microservices.quickundertow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.slf4j.LoggerFactory;

/**
 *
 * @author florent
 */
public class HelpCommand {

    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(HelpCommand.class);
    
    private OutputStream out;
    private InputStream is;
    
    public HelpCommand(InputStream is, OutputStream out) {
        this.out = out;
        this.is = is;
    }
    
    /**
     * Ecrire l'aide dans l'objet out
     * 
     * Si on a rien lu, on part en erreur => Exception
     */
    public void run(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String line;
        boolean isRead = false;
        try {
            while ((line = reader.readLine()) != null) {
                isRead = true;
                out.write(line.getBytes());
                out.write(System.getProperty("line.separator").getBytes());
            }
        } catch (IOException ex) {
            LOG.error("Impossible de générer l'aide", ex);
        }
        
        if(!isRead){
            throw new EmptyFileException("oups");
        }
    }

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }
    
}
