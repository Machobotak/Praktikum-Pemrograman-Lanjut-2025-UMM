package org.example;

import javax.swing.*;
import org.example.ui.formInputFrame;

public class App
{
    public static void main( String[] args )
    {
        SwingUtilities.invokeLater(()->{
            new formInputFrame().setVisible(true);
        });
    }
}
