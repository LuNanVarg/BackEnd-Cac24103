package ar.com.cac24103.api;

public class EmailLog  implements Ilog{

    public void log(String msj){
        System.out.println("Enviando email...");
        System.out.println("body:" + msj);
    }
}
