/*
 * Apache Felix OSGi tutorial.
 **/

package tutorial.example1;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;

/**
 * @author slieer Create Date 2013-6-4 version 1.0
 */
public class Activator implements BundleActivator, ServiceListener {
    public void start(BundleContext context) {
        System.out.println("Starting to listen for service events.");
        context.addServiceListener(this);
    }

    public void stop(BundleContext context) {
        context.removeServiceListener(this);
        System.out.println("Stopped listening for service events.");
    }

    public void serviceChanged(ServiceEvent event) {
        String[] objectClass = (String[]) event.getServiceReference()
                .getProperty("objectClass");

        if (event.getType() == ServiceEvent.REGISTERED) {
            System.out.println("Ex1: Service of type " + objectClass[0]
                    + " registered.");
        } else if (event.getType() == ServiceEvent.UNREGISTERING) {
            System.out.println("Ex1: Service of type " + objectClass[0]
                    + " unregistered.");
        } else if (event.getType() == ServiceEvent.MODIFIED) {
            System.out.println("Ex1: Service of type " + objectClass[0]
                    + " modified.");
        }
    }
}
