/*
 * SchoolShootingThreatClassifierGUIApp.java
 */

package schoolshootingthreatclassifiergui;

import javax.swing.ImageIcon;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class SchoolShootingThreatClassifierGUIApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new SchoolShootingThreatClassifierGUIView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     * @param root 
     */
    @Override protected void configureWindow(java.awt.Window root) {
        //Setting the Icon for the titlebar
        root.setIconImage(new ImageIcon("src\\schoolshootingthreatclassifiergui\\resources\\Icon.png").getImage());
        

    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of SchoolShootingThreatClassifierGUIApp
     */
    public static SchoolShootingThreatClassifierGUIApp getApplication() {
        return Application.getInstance(SchoolShootingThreatClassifierGUIApp.class);
    }

    /**
     * Main method launching the application.
     * @param args 
     */
    public static void main(String[] args) {
        launch(SchoolShootingThreatClassifierGUIApp.class, args);
    }
}
