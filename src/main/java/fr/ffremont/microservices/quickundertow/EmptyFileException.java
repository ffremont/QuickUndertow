/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ffremont.microservices.quickundertow;

/**
 *
 * @author florent
 */
class EmptyFileException extends RuntimeException {

    public EmptyFileException(String oups) {
        super(oups);
    }
    
}
