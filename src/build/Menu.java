/**
 * This is the menu class that has the JOption dialog to set the player names at the beginning of the game
 * CPSC 224, Fall 2019
 *Final Project
 * No sources to cite.
 *
 * @author Kat Sotelo, Zac Foteff, Rebekah Hale
 * @version v1.0 12/12/19
 */
package build;

import javax.swing.*;

public class Menu
{
    View view;

    /**
     *shows the option dialog if the user wants to play a new game or quit
     */
    public int showMenu (View view)
    {
        String[] options = {"New Game", "High Scores", "Quit"};
        int choice = JOptionPane.showOptionDialog(view,
                "WELCOME TO BALL-IEVE IN YOUR SPEED!",
                "Menu", JOptionPane.YES_NO_CANCEL_OPTION, 0, null, options, options[0]);

        if (choice == JOptionPane.YES_OPTION)
            return 0;

        else if (choice == JOptionPane.NO_OPTION)
            return 1;

        else if (choice == JOptionPane.CANCEL_OPTION)
            return 2;

        return 0;
    }

    /**
     *is a countdown that is supposed to start after the option dialog
     * @param view gets the view
     */
    public void countdown(View view)
    {
        JOptionPane countdown = new JOptionPane("Countdown");
        JDialog count3 = countdown.createDialog("3");
        JDialog count2 = countdown.createDialog("2");
        JDialog count1 = countdown.createDialog("1");
        count3.setVisible(false);
        count2.setVisible(false);
        count1.setVisible(false);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count3.setVisible(true);
        count2.setVisible(false);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count3.setVisible(false);
        count2.setVisible(true);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count2.setVisible(false);
        count1.setVisible(true);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count1.setVisible(false);
    }

    /**
     *option dialogs for entering the player names and sets the player names as well on the view
     * @param view gets the view.
     * @param p1Panel, panel for player 1 so you can set the name
     * @param p2Panel, panel for player 2 so you can set the name
     */
    public void enterPlayerNames (JPanel p1Panel, JPanel p2Panel, View view)
    {
        String pn1 = JOptionPane.showInputDialog("Enter Player1's Name: ");
        if (pn1.isEmpty()){
                view.setP1S("Player 1");
        }else{
            view.setP1S(pn1);
        }
        String pn2 = JOptionPane.showInputDialog("Enter Player2's Name: ");
        if (pn2.isEmpty()){
            view.setP2S("Player 2");
        }else{
            view.setP2S(pn2);
        }

        p1Panel.setBorder(BorderFactory.createTitledBorder(pn1));
        view.setP1S(pn1);
        view.setP2S(pn2);

        p2Panel.setBorder(BorderFactory.createTitledBorder(pn2));
    }
}
