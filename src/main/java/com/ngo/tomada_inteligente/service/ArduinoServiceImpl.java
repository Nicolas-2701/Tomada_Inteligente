package com.ngo.tomada_inteligente.service;

import org.springframework.stereotype.Service;

import com.fazecast.jSerialComm.SerialPort;
import com.ngo.tomada_inteligente.model.DadosArduino;

@Service
public class ArduinoServiceImpl implements ArduinoService {

    @Override
    public String comunicacaoS(int porta) {
        //transforma a porta em serial port e abre ela
        SerialPort portS = SerialPort.getCommPorts()[porta];
        portS.openPort();
        if (portS.bytesAvailable() > 0) {
            byte[] buffer = new byte[portS.bytesAvailable()];
            portS.readBytes(buffer, buffer.length);

            String valor = new String(buffer);
            System.out.println("Valor recebido do Arduino: " + valor);

            portS.closePort();
            return valor;
            } else {
            	return "Não foi possivel ler a porta";
            }
    }
    
    @Override
    public String[] separarDados(String dados) {
    	String [] dadosS = dados.split("|");
    	return dadosS;
    }
}