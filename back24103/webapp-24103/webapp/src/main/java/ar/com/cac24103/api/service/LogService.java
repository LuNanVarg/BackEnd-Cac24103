package ar.com.cac24103.api.service;

import ar.com.cac24103.api.EmailLog;
import ar.com.cac24103.api.Ilog;
import ar.com.cac24103.api.SMSLog;
import ar.com.cac24103.api.DefaultLog;

public class LogService {

    private Ilog logger;

    public LogService(int logHabilitado) {
        
        //Interface i = new Clase();   

        switch (logHabilitado) {
            case 1:
                this.logger = new SMSLog(); 
                break;
            case 2: 
                this.logger = new EmailLog();
                break;
            default:
                this.logger = new DefaultLog();
                break;
        }
    }

    public void enviarMensaje(String msjAEnviar) {
        this.logger.log(msjAEnviar);
    }
}
