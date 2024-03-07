import StateFull.IContador;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class testSaludo {
    public static void main(String[] args) {
        contar();
    }

    private static void contar() {
        System.out.println("Llamado al EJB");

        try {


            // Create the InitialContext (automatically loads configuration from jndi.properties)
            Context jdni = new InitialContext();


            // Perform JNDI lookup using the configured properties
            IContador agregar = (IContador) jdni.lookup("java:global/proyectotest-1.0-SNAPSHOT/Contador!StateFull.IContador");

            // Use the obtained reference
            System.out.println(agregar.test());
            agregar.agregarItem();
            agregar.agregarItem();
            System.out.println("registros: " + agregar.contarItem());
        } catch (NamingException e) {
            e.printStackTrace(System.out);
        }
    }
}
