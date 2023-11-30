import javax.swing.JFrame;

class Main extends JFrame{

    Main(){

        setSize(1200, 800);
        setTitle("Expense Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }


    public static void main(String[] args) {
        
       new Main();
    }

} 