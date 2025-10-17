package br.com.cristianmathias.conversordemoedas.model;

public class Conversion {
    private final String fromCurrency;
    private final String toCurrency;
    private final double originalAmount;
    private final double convertedAmount;
    private final String timestamp;

    public Conversion(String fromCurrency, String toCurrency, double originalAmount, double convertedAmount, String timestamp) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.originalAmount = originalAmount;
        this.convertedAmount = convertedAmount;
        this.timestamp = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    }

    @Override
    public String toString() {
        return "\n{" +
                " \n Moeda de origem= '" + fromCurrency + '\'' +
                ",\n Moeda de destino= '" + toCurrency + '\'' +
                ",\n Valor original= " + originalAmount + '\'' +
                ",\n Valor convertido= '" + convertedAmount + '\'' +
                ",\n Data e hora= '" + timestamp + '\'' +
                "\n}";
    }
}
