package QT;
/********************************************************************************
 ** Form generated from reading ui file 'hotel.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class MainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionSalir;
    public QAction actionReservas;
    public QWidget centralwidget;
    public QPushButton pushButton_reservas;
    public QPushButton pushButton_salir;
    public QLabel label;
    public QMenuBar menubar;
    public QMenu menuAplicaci_n;
    public QMenu menuGesti_n;
    public QStatusBar statusbar;

    public MainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(500, 278).expandedTo(MainWindow.minimumSizeHint()));
        actionSalir = new QAction(MainWindow);
        actionSalir.setObjectName("actionSalir");
        actionSalir = new QAction(MainWindow);
        actionSalir.setObjectName("actionSalir");
        actionSalir.triggered.connect(MainWindow,"close()");
        actionReservas = new QAction(MainWindow);
        actionReservas.setObjectName("actionReservas");
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        pushButton_reservas = new QPushButton(centralwidget);
        pushButton_reservas.setObjectName("pushButton_reservas");
        pushButton_reservas.setGeometry(new QRect(370, 20, 75, 23));
        pushButton_reservas.clicked.connect(this, "abrir()");
        pushButton_salir = new QPushButton(centralwidget);
        pushButton_salir.setObjectName("pushButton_salir");
        pushButton_salir.setGeometry(new QRect(370, 60, 75, 23));
        label = new QLabel(centralwidget);
        label.setObjectName("label");
        label.setGeometry(new QRect(40, 40, 301, 181));
        label.setPixmap(new QPixmap(("classpath:recursos/hotel.png")));
        label.setScaledContents(true);
        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 500, 21));
        menuAplicaci_n = new QMenu(menubar);
        menuAplicaci_n.setObjectName("menuAplicaci_n");
        menuGesti_n = new QMenu(menubar);
        menuGesti_n.setObjectName("menuGesti_n");
        MainWindow.setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);

        menubar.addAction(menuAplicaci_n.menuAction());
        menubar.addAction(menuGesti_n.menuAction());
        menuAplicaci_n.addAction(actionSalir);
        menuGesti_n.addAction(actionReservas);
        actionReservas = new QAction(MainWindow);
        actionReservas.setObjectName("actionReservas");
        actionReservas.triggered.connect(this, "abrir()");
        retranslateUi(MainWindow);

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
        actionSalir.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Salir", null));
        actionReservas.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Reservas", null));
        pushButton_reservas.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "&Reservas", null));
        pushButton_salir.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "&Salir", null));
        label.setText("");
        menuAplicaci_n.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Aplicaci\u00f3n", null));
        menuGesti_n.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Gesti\u00f3n", null));
    } // retranslateUi
    
    
}

