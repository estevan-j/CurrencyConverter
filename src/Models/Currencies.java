package Models;

public enum Currencies {
    Peso_Argentino("ARS"),
    Boliviano("BOB"),
    Real_brasileño("BRL"),
    Peso_chileno("CLP"),
    Peso_colombiano("COP"),
    Dólar_estadounidense("USD");

    private final String codigo;

    Currencies(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
