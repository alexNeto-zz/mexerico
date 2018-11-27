package com.chatter.cliente;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {
    
    private final String host;
    private final int porta;
    private Socket cliente;
    
    public Cliente(String host, int porta){
        
        this.host = host;
        this.porta = porta;
        
    }
    
    public void conectar() throws IOException{
        
        //Cria um novo socket com o IP e porta fornecidos na construção da classe.
        this.cliente = new Socket(this.host, this.porta);
        System.out.println("O cliente conseguiu se conectar ao servidor!");
        
    }
    
    //Retorna o OutputStream de cliente. Necessário para conseguir enviar mensagens.
    public OutputStream getClienteOutputStream() throws IOException{
        
        return cliente.getOutputStream();
        
    }
    
    //Retorna o InputStream de cliente. Necessário para conseguir enviar mensagens.
    public InputStream getClienteInputStream() throws IOException{
        
        return cliente.getInputStream();
        
    }
    
}