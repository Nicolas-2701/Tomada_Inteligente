package com.ngo.tomada_inteligente.service;

import org.springframework.stereotype.Service;

import com.fazecast.jSerialComm.SerialPort;
import com.ngo.tomada_inteligente.model.DadosArduino;

@Service
public class ArduinoServiceImpl implements ArduinoService {

    @Override
    public void comunicacaoS(int porta) {
        //transforma a porta em serial port e abre ela
        SerialPort portS = SerialPort.getCommPorts()[porta];
        portS.openPort();
        if (portS.bytesAvailable() > 0) {
            byte[] buffer = new byte[portS.bytesAvailable()];
            portS.readBytes(buffer, buffer.length);

            String valor = new String(buffer);
            System.out.println("Valor recebido do Arduino: " + valor);

            enviar(valor); // Enviar o valor para a API
            portS.closePort();
            }
    }
    private static void enviar(String valor) {
        DadosArduino dados = new DadosArduino();
        dados.setValor(valor);
    }
}