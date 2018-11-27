package com.chatter.cliente;

import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JTextField;

public class Ouvidor{
    
    private final PrintStream mensagens;
    private final JTextField area_escrever;
    private final String host;
    
    public Ouvidor(JTextField area_escrever, OutputStream mensagens, String host){
        
        this.area_escrever = area_escrever;
        this.mensagens = new PrintStream(mensagens);
        this.host = host;
        
    }
    
    public void envia_mensagem(){        
       
        mensagens.println(this.host + " diz: " + area_escrever.getText());
        
    }
    
}