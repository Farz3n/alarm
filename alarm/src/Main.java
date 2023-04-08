import java.awt.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();

            java.awt.Image image = Toolkit.getDefaultToolkit().getImage("images/tray.gif");
            TrayIcon trayIcon = new TrayIcon(image);
            tray.add(trayIcon);
            trayIcon.displayMessage("Test.", "This is a message to test notifications in Windows 10",
                    TrayIcon.MessageType.INFO);
        }
    }
}