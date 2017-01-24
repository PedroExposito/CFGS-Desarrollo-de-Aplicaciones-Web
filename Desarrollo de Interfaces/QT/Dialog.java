package QT;
/********************************************************************************
 ** Form generated from reading ui file 'reserva.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class Dialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QWidget widget;
    public QGridLayout gridLayout;
    public QLabel label;
    public QLabel label_DNI;
    public QLineEdit lineDNI;
    public QLabel label_3;
    public QLabel label_4;
    public QSpacerItem horizontalSpacer;
    public QLabel label_5;
    public QLineEdit lineLoc;
    public QLabel label_6;
    public QLineEdit lineProv;
    public QLabel label_7;
    public QLabel label_8;
    public QLabel label_9;
    public QCalendarWidget calendarWidget;
    public QCalendarWidget calendarWidget_2;
    public QLabel label_10;
    public QSpinBox spinBox;
    public QLabel label_11;
    public QComboBox comboBoxHab;
    public QCheckBox checkBoxFumador;
    public QGroupBox groupBox;
    public QRadioButton radioButton_6;
    public QRadioButton radioButton_5;
    public QRadioButton radioButton_4;
    public QSpacerItem verticalSpacer;
    public QLabel label_13;
    public QSpacerItem horizontalSpacer_2;
    public QSpacerItem horizontalSpacer_3;
    public QPushButton ButtonLimpiar;
    public QSpacerItem horizontalSpacer_4;
    public QPushButton pushButton_2;
    public QPushButton pushButton_3;
    public QLineEdit lineNombre;
    public QLineEdit lineDir;

    public Dialog() { super(); }

    public void setupUi(QDialog Dialog)
    {
        Dialog.setObjectName("Dialog");
        Dialog.resize(new QSize(601, 522).expandedTo(Dialog.minimumSizeHint()));
        widget = new QWidget(Dialog);
        widget.setObjectName("widget");
        widget.setGeometry(new QRect(10, 10, 587, 511));
        gridLayout = new QGridLayout(widget);
        gridLayout.setObjectName("gridLayout");
        label = new QLabel(widget);
        label.setObjectName("label");
        QFont font = new QFont();
        font.setPointSize(16);
        font.setBold(true);
        font.setUnderline(true);
        font.setWeight(75);
        label.setFont(font);

        gridLayout.addWidget(label, 0, 0, 1, 6);

        label_DNI = new QLabel(widget);
        label_DNI.setObjectName("label_DNI");

        gridLayout.addWidget(label_DNI, 1, 0, 1, 1);

        lineDNI = new QLineEdit(widget);
        lineDNI.setObjectName("lineDNI");

        gridLayout.addWidget(lineDNI, 1, 2, 1, 5);

        label_3 = new QLabel(widget);
        label_3.setObjectName("label_3");

        gridLayout.addWidget(label_3, 1, 7, 1, 2);

        label_4 = new QLabel(widget);
        label_4.setObjectName("label_4");

        gridLayout.addWidget(label_4, 2, 0, 1, 1);

        horizontalSpacer = new QSpacerItem(158, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer, 3, 0, 1, 5);

        label_5 = new QLabel(widget);
        label_5.setObjectName("label_5");

        gridLayout.addWidget(label_5, 3, 5, 1, 2);

        lineLoc = new QLineEdit(widget);
        lineLoc.setObjectName("lineLoc");

        gridLayout.addWidget(lineLoc, 3, 7, 1, 4);

        label_6 = new QLabel(widget);
        label_6.setObjectName("label_6");

        gridLayout.addWidget(label_6, 3, 11, 1, 1);

        lineProv = new QLineEdit(widget);
        lineProv.setObjectName("lineProv");

        gridLayout.addWidget(lineProv, 3, 12, 1, 2);

        label_7 = new QLabel(widget);
        label_7.setObjectName("label_7");
        QFont font1 = new QFont();
        font1.setPointSize(16);
        font1.setBold(true);
        font1.setUnderline(true);
        font1.setWeight(75);
        label_7.setFont(font1);

        gridLayout.addWidget(label_7, 4, 0, 1, 7);

        label_8 = new QLabel(widget);
        label_8.setObjectName("label_8");

        gridLayout.addWidget(label_8, 5, 0, 1, 2);

        label_9 = new QLabel(widget);
        label_9.setObjectName("label_9");

        gridLayout.addWidget(label_9, 5, 9, 1, 2);

        calendarWidget = new QCalendarWidget(widget);
        calendarWidget.setObjectName("calendarWidget");

        gridLayout.addWidget(calendarWidget, 6, 0, 1, 9);

        calendarWidget_2 = new QCalendarWidget(widget);
        calendarWidget_2.setObjectName("calendarWidget_2");

        gridLayout.addWidget(calendarWidget_2, 6, 9, 1, 5);

        label_10 = new QLabel(widget);
        label_10.setObjectName("label_10");

        gridLayout.addWidget(label_10, 7, 0, 1, 3);

        spinBox = new QSpinBox(widget);
        spinBox.setObjectName("spinBox");

        gridLayout.addWidget(spinBox, 7, 3, 1, 1);

        label_11 = new QLabel(widget);
        label_11.setObjectName("label_11");

        gridLayout.addWidget(label_11, 7, 4, 1, 3);

        comboBoxHab = new QComboBox(widget);
        comboBoxHab.setObjectName("comboBoxHab");

        gridLayout.addWidget(comboBoxHab, 7, 7, 1, 3);

        checkBoxFumador = new QCheckBox(widget);
        checkBoxFumador.setObjectName("checkBoxFumador");

        gridLayout.addWidget(checkBoxFumador, 7, 10, 1, 2);

        groupBox = new QGroupBox(widget);
        groupBox.setObjectName("groupBox");
        QFont font2 = new QFont();
        font2.setPointSize(12);
        font2.setBold(true);
        font2.setWeight(75);
        groupBox.setFont(font2);
        radioButton_6 = new QRadioButton(groupBox);
        radioButton_6.setObjectName("radioButton_6");
        radioButton_6.setGeometry(new QRect(30, 80, 150, 17));
        QFont font3 = new QFont();
        font3.setPointSize(9);
        font3.setBold(false);
        font3.setWeight(50);
        radioButton_6.setFont(font3);
        radioButton_5 = new QRadioButton(groupBox);
        radioButton_5.setObjectName("radioButton_5");
        radioButton_5.setGeometry(new QRect(30, 29, 150, 17));
        QFont font4 = new QFont();
        font4.setPointSize(9);
        font4.setBold(false);
        font4.setWeight(50);
        radioButton_5.setFont(font4);
        radioButton_4 = new QRadioButton(groupBox);
        radioButton_4.setObjectName("radioButton_4");
        radioButton_4.setGeometry(new QRect(30, 57, 111, 17));
        QFont font5 = new QFont();
        font5.setPointSize(9);
        font5.setBold(false);
        font5.setWeight(50);
        radioButton_4.setFont(font5);

        gridLayout.addWidget(groupBox, 8, 0, 1, 6);

        verticalSpacer = new QSpacerItem(38, 108, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout.addItem(verticalSpacer, 8, 6, 1, 1);

        label_13 = new QLabel(widget);
        label_13.setObjectName("label_13");
        label_13.setTextFormat(com.trolltech.qt.core.Qt.TextFormat.AutoText);
        label_13.setVisible(false);

        gridLayout.addWidget(label_13, 8, 9, 1, 5);

        horizontalSpacer_2 = new QSpacerItem(238, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer_2, 9, 0, 1, 8);

        horizontalSpacer_3 = new QSpacerItem(288, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer_3, 9, 8, 1, 6);

        ButtonLimpiar = new QPushButton(widget);
        ButtonLimpiar.setObjectName("ButtonLimpiar");

        gridLayout.addWidget(ButtonLimpiar, 10, 1, 1, 3);

        horizontalSpacer_4 = new QSpacerItem(228, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer_4, 10, 4, 1, 7);

        pushButton_2 = new QPushButton(widget);
        pushButton_2.setObjectName("pushButton_2");

        gridLayout.addWidget(pushButton_2, 10, 11, 1, 2);

        pushButton_3 = new QPushButton(widget);
        pushButton_3.setObjectName("pushButton_3");

        gridLayout.addWidget(pushButton_3, 10, 13, 1, 1);

        lineNombre = new QLineEdit(widget);
        lineNombre.setObjectName("lineNombre");

        gridLayout.addWidget(lineNombre, 1, 9, 1, 5);

        lineDir = new QLineEdit(widget);
        lineDir.setObjectName("lineDir");

        gridLayout.addWidget(lineDir, 2, 2, 1, 12);

        label_DNI.setBuddy(lineDNI);
        label_3.setBuddy(lineNombre);
        label_4.setBuddy(lineDir);
        label_5.setBuddy(lineLoc);
        label_6.setBuddy(lineProv);
        label_10.setBuddy(spinBox);
        label_11.setBuddy(comboBoxHab);
        retranslateUi(Dialog);
        ButtonLimpiar.clicked.connect(lineNombre, "clear()");
        ButtonLimpiar.clicked.connect(lineDNI, "clear()");
        pushButton_3.clicked.connect(Dialog, "reject()");
        ButtonLimpiar.clicked.connect(lineProv, "clear()");
        pushButton_2.clicked.connect(Dialog, "accept()");
        ButtonLimpiar.clicked.connect(comboBoxHab, "clear()");
        ButtonLimpiar.clicked.connect(lineLoc, "clear()");
        ButtonLimpiar.clicked.connect(spinBox, "clear()");
        ButtonLimpiar.clicked.connect(lineDir, "clear()");

        Dialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog Dialog)
    {
        Dialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Dialog", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Datos del cliente", null));
        label_DNI.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "DNI", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Nombre", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Direcci\u00f3n", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Localidad", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Provincia", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Datos de la reserva", null));
        label_8.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fecha de llegada", null));
        label_9.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fecha de salida", null));
        label_10.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "N\u00ba de habitaciones", null));
        label_11.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Tipo de habitaci\u00f3n", null));
        comboBoxHab.clear();
        comboBoxHab.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Individual", null));
        comboBoxHab.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Doble", null));
        comboBoxHab.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Suite", null));
        comboBoxHab.addItem(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Suite superior", null));
        checkBoxFumador.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Fumador", null));
        groupBox.setTitle(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "R\u00e9gimen", null));
        radioButton_6.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Pensi\u00f3n comleta", null));
        radioButton_5.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Alojamiento y desayuno", null));
        radioButton_4.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Media pensi\u00f3n", null));
        label_13.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "En virtud de la ley de sanidad se informa a \n"+
"los clientes", null));
        ButtonLimpiar.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Limpiar", null));
        pushButton_2.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Aceptar", null));
        pushButton_3.setText(com.trolltech.qt.core.QCoreApplication.translate("Dialog", "Cancelar", null));
    } // retranslateUi

    void cambiar(){
        //si se ha activado la casilla de verificacion mostraremos el mensaje
        //la visibilidad de la etiqueta
        //depende de si el checkbox está activado
        label_13.setVisible(checkBoxFumador.isChecked());
    }
}

