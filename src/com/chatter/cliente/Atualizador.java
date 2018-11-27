package com.chatter.cliente;

import java.io.InputStream;
import java.util.Scanner;
import javax.swing.JTextArea;

public class Atualizador implements Runnable{
    
    private final InputStream mensagens;
    private final JTextArea area_chat;
    
    public Atualizador(InputStream mensagens, JTextArea area_chat){
        
        this.mensagens = mensagens;
        this.area_chat = area_chat;
        
    }
    
    public void run(){
        
        Scanner leitor = new Scanner(mensagens);
        
        while(leitor.hasNextLine()){
            
            area_chat.append(leitor.nextLine() + "\n");
            
        }
        
    }
    
}