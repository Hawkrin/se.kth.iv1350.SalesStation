package startup;

import controller.Controller;
import integration.SystemHandler;
import integration.CatalogHandler;
import view.View;
import integration.RecieptPrinter;

/**
 * Contains the <code>main</code> method. Performs all startup of the application.
 */
public class Main {

    /**
     * Starts the application
     * @param args no command line parameters are taken
     */
    public static void main(String[] args) {
        SystemHandler systemHandler = new SystemHandler();
        CatalogHandler catalogHandler = new CatalogHandler();
        RecieptPrinter recieptPrinter = new RecieptPrinter();
        Controller ctrl = new Controller(catalogHandler, systemHandler, recieptPrinter);
        View view = new View(ctrl);

        
        

    }
    
}
