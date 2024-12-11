package com.ngo.tomada_inteligente.service;

import org.springframework.stereotype.Service;

import com.fazecast.jSerialComm.SerialPort;
import com.ngo.tomada_inteligente.model.DadosArduino;

@Service
public class ArduinoServiceImpl implements ArduinoService {

    @Override
    public String comunicacaoS(int porta) {
        SerialPort portS = SerialPort.getCommPorts()[porta];
        portS.setBaudRate(9600);
        portS.openPort();

        StringBuilder buffer = new StringBuilder();
        long startTime = System.currentTimeMillis();

        while (true) {
            if (portS.bytesAvailable() > 0) {
                byte[] tempBuffer = new byte[portS.bytesAvailable()];
                portS.readBytes(tempBuffer, tempBuffer.length);
                buffer.append(new String(tempBuffer));

                // Verifica se o dado completo foi recebido
                if (buffer.toString().contains("*")) {
                    break;
                }
            }

            // Timeout para evitar travamento infinito
            if (System.currentTimeMillis() - startTime > 5000) {
            	System.out.println(buffer.toString());
                portS.closePort();
                return "Erro: Timeout ao ler a porta.";
            }
        }

        portS.closePort();
        String valor = buffer.toString().replace("*", "").replace("\n", ""); // Retorna apenas o dado antes do '|'
        System.out.println("Valor recebido do Arduino: " + valor);
        return valor;
    }
    
    @Override
    public String[] separarDados(String dados) {
    	String [] dadosS = dados.split("\\|");
    	return dadosS;
    }
}