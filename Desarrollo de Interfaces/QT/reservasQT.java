/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QT;

import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QMainWindow;

/**
 *
 * @author Pedro
 */
public class reservasQT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        QApplication.initialize(args);
        QMainWindow mw = new QMainWindow();
        MainWindow principal = new MainWindow();
        principal.setupUi( mw );
        mw.show();
        QApplication.execStatic();
    }
    void abrir(){
        Dialog Alta = new Dialog();
        QDialog dialog = new QDialog();
        Alta.setupUi(dialog);
        dialog.show();
    }
   
}
