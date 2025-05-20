package app;

import app.views.MenuView;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Eldair
 */
public class App {

    public static void main(String[] args) {
        // bloco definir o estidlo da janela (LookAndFeelInfo)
        try {            
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("Look and Feel Windows não disponível, usando o padrão.");
        }
        
        MenuView menu = new MenuView();
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);

    }

}
