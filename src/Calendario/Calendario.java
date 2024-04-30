package Calendario;

/**
 * @version 1.0
 * @author DanielRobles Clase que simula el funcionamiento de un calendario
 */
public class Calendario {

    private int a�o;
    private int mes;
    private int dia;
    private float test;

    /**
     * Constructor de la clase
     *
     * @param a�o Parametro que representa el a�o
     * @param mes Paramtro que representa el mes
     * @param dia Parametro que representa el dia
     */
    public Calendario(int a�o, int mes, int dia) {
        if (fechaCorrecta(a�o, mes, dia)) { // Si la fecha es correcta se inicializan sus valores
            this.a�o = a�o;
            this.mes = mes;
            this.dia = dia;
        } else { // Si la fecha no es correcta, se inicializa a 1/1/1
            this.a�o = 1;
            this.mes = 1;
            this.dia = 1;
        }
    }

    /**
     * Metodo que incremente el d�a en 1
     */
    public void incrementarDia() {
        dia++;
        if (!fechaCorrecta(a�o, mes, dia)) {
            dia = 1;
            mes++;
            if (!fechaCorrecta(a�o, mes, dia)) {
                mes = 1;
                a�o++;
            }
        }
    }

    /**
     * Metodo que incrementa el mes en 1
     */
    public void incrementarMes() {
        mes++;
        if (!fechaCorrecta(a�o, mes, dia) && mes >= 1 && mes <= 12) {
            dia = 1;
            mes++;
        } else {
            mes = 1;
            a�o++;
        }
    }

    /**
     * Metodo que incrementa el a�o en funci�n del parametro cantidad
     *
     * @param cantidad Cantidad de a�os a incrementar
     */
    public void incrementarA�o(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            a�o++;
            if (a�o == 0) {
                a�o++;
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
        boolean igual = (a�o == otraFecha.a�o && mes == otraFecha.mes && dia == otraFecha.dia);
        return igual;
    }

    /**
     * Metodo que comprueba si una fecha es correcta en funcion del d�a, mes y
     * a�o que se pasan
     *
     * @param a�o Parametro que representa el a�o
     * @param mes Parametro que representa el mes
     * @param dia Parametro que representa el dia
     * @return Valor boolean que determina si la fecha es correcta o no
     */
    public boolean fechaCorrecta(int a�o, int mes, int dia) {
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

        if (a�o == 0) { // El unico a�o que no existe es el 0
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
     * Metodo que devuelve el a�o
     *
     * @return Se devuelve el a�o
     */
    public int getA�o() {
        return a�o;
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
