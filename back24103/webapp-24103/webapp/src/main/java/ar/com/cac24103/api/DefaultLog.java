package ar.com.cac24103.api;


public class DefaultLog implements Ilog {

    public void log(String msj) {
        System.out.println("Log en file system por defecto: " + msj);
    }
}
