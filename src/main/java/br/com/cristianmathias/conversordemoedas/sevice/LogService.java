package br.com.cristianmathias.conversordemoedas.sevice;

import br.com.cristianmathias.conversordemoedas.model.Conversion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class LogService {
    private static final String LOG_FILE = "logs_conversoes.txt";

    public static void  registerConversion(Conversion conversion){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE, true))){
            writer.write(conversion.toString());
            writer.newLine();
        }catch (IOException e){
            System.err.println("Erro ao registrar log: " + e.getMessage());
        }
    }
}
