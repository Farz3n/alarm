import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;


public class asd extends JFrame {
    private JPanel panel;
    JSpinner spinner;
    private JSpinner spinner1;
    private JSpinner spinner2;
    private JButton button1;
    private JSeparator separator1;
    private JLabel hours;
    private JLabel minutes;
    private JLabel seconds;

    int hour;
    int min;
    int sec;

    boolean alarm = false;

    private TimerTask timerTask;


    //Integer.parseInt(hours.getText())==hour && Integer.parseInt(minutes.getText())==min && Integer.parseInt(seconds.getText())==sec

    public static void main(String[] args) {
        JFrame app = new asd();
        app.setVisible(true);
    }

    public asd() {
        super("12132");
        this.setContentPane(panel);
        this.setBounds(100, 100, 200, 200);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);


        seconds.setText(new SimpleDateFormat("ss").format(new Date()));
        minutes.setText(new SimpleDateFormat("mm").format(new Date()));
        hours.setText(String.valueOf(new Date().getHours()));

        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 23, 1);
        SpinnerNumberModel model1 = new SpinnerNumberModel(0, 0, 59, 1);
        SpinnerNumberModel model2 = new SpinnerNumberModel(0, 0, 59, 1);
        spinner.setModel(model);
        spinner1.setModel(model1);
        spinner2.setModel(model2);
        JFormattedTextField tf = ((JSpinner.DefaultEditor) spinner.getEditor()).getTextField();
        tf.setEditable(false);
        JFormattedTextField tf1 = ((JSpinner.DefaultEditor) spinner1.getEditor()).getTextField();
        tf1.setEditable(false);
        JFormattedTextField tf2 = ((JSpinner.DefaultEditor) spinner2.getEditor()).getTextField();
        tf2.setEditable(false);

        new Timer(1000, ev -> seconds.setText(new SimpleDateFormat("ss").format(new Date()))).start();
        new Timer(1000, e -> minutes.setText(new SimpleDateFormat("mm").format(new Date()))).start();
        new Timer(1000, e -> hours.setText(String.valueOf(new Date().getHours()))).start();

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Integer.parseInt(hours.getText()) != hour && Integer.parseInt(minutes.getText()) != min && Integer.parseInt(seconds.getText()) != sec) {
                    System.out.println(123);
                }else if (!alarm){
                    if (SystemTray.isSupported()) {
                        SystemTray tray = SystemTray.getSystemTray();

                        java.awt.Image image = Toolkit.getDefaultToolkit().getImage("C:/Users/admin/OneDrive/Рабочий стол/Рабочий стол/Новая папка/1537782802_5.gif");
                        TrayIcon trayIcon = new TrayIcon(image);
                        try {
                            tray.add(trayIcon);
                        } catch (AWTException ex) {
                            throw new RuntimeException(ex);
                        }
                        trayIcon.displayMessage("Alarm", "Press to turn off",
                                TrayIcon.MessageType.INFO);
                        alarm = true;
                    }
                }
            }
        };
        Timer timer = new Timer(1000,listener);

        button1.addActionListener(e -> {
            getInput();
            timer.start();
            alarm = false;
        });
    }

    public void getInput (){
        sec = (int) spinner.getValue();
        min = (int) spinner1.getValue();
        hour = (int) spinner2.getValue();
    }
}


