package Calendario;

/**
 * @version 1.0
 * @author DanielRobles Clase que simula el funcionamiento de un calendario
 */
public class Calendario {

    private int año;
    private int mes;
    private int dia;
    private float test;

    /**
     * Constructor de la clase
     *
     * @param año Parametro que representa el año
     * @param mes Paramtro que representa el mes
     * @param dia Parametro que representa el dia
     */
    public Calendario(int año, int mes, int dia) {
        if (fechaCorrecta(año, mes, dia)) { // Si la fecha es correcta se inicializan sus valores
            this.año = año;
            this.mes = mes;
            this.dia = dia;
        } else { // Si la fecha no es correcta, se inicializa a 1/1/1
            this.año = 1;
            this.mes = 1;
            this.dia = 1;
        }
    }

    /**
     * Metodo que incremente el día en 1
     */
    public void incrementarDia() {
        dia++;
        if (!fechaCorrecta(año, mes, dia)) {
            dia = 1;
            mes++;
            if (!fechaCorrecta(año, mes, dia)) {
                mes = 1;
                año++;
            }
        }
    }

    /**
     * Metodo que incrementa el mes en 1
     */
    public void incrementarMes() {
        mes++;
        if (!fechaCorrecta(año, mes, dia) && mes >= 1 && mes <= 12) {
            dia = 1;
            mes++;
        } else {
            mes = 1;
            año++;
        }
    }

    /**
     * Metodo que incrementa el año en función del parametro cantidad
     *
     * @param cantidad Cantidad de años a incrementar
     */
    public void incrementarAño(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            año++;
            if (año == 0) {
                año++;
            }
        }
    }

    /**
     * Metodo que comprueba si dos fechas son iguales
     *
     * @param otraFecha Parametro que representa la fecha a comparar
     * @return Valor boolean en funcion de si las fechas son iguales o no
     */
    public boolean iguales(Calendario otraFecha) {
        boolean igual = (año == otraFecha.año && mes == otraFecha.mes && dia == otraFecha.dia);
        return igual;
    }

    /**
     * Metodo que comprueba si una fecha es correcta en funcion del día, mes y
     * año que se pasan
     *
     * @param año Parametro que representa el año
     * @param mes Parametro que representa el mes
     * @param dia Parametro que representa el dia
     * @return Valor boolean que determina si la fecha es correcta o no
     */
    public boolean fechaCorrecta(int año, int mes, int dia) {
        boolean fechaCorrecta;
        int diasMaxMes = switch (mes) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                yield 31;
            }
            case 2 -> {
                yield 28;
            }
            case 4, 6, 9, 11 -> {
                yield 30;
            }
            default -> {
                yield -1;
            }
        };

        if (año == 0) { // El unico año que no existe es el 0
            fechaCorrecta = false;
        } else { // Comprobamos si el dia es correcto
            if (1 <= dia && dia <= diasMaxMes) {
                fechaCorrecta = true;
            } else {
                fechaCorrecta = false;
            }
        }
        return fechaCorrecta;
    }

    /**
     * Metodo que devuelve el año
     *
     * @return Se devuelve el año
     */
    public int getAño() {
        return año;
    }

    /**
     * Metodo que devuelve el mes
     *
     * @return Se devuelve el mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * Metodo que devuelve el dia
     *
     * @return Se devuelve el dia
     */
    public int getDia() {
        return dia;
    }

}
