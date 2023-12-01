import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;

class Main extends JFrame{

    
    ExpenseTracker ET;

    // & Containers
    JPanel mainPanel;
    
    
    
    // & Components
    JLabel totalSpentLabel;

    public Main( ExpenseTracker expenseTracker){
        super("Expense Tracker");

        this.ET = expenseTracker;
        // Create components
        

        // Create main panel
        mainPanel = new JPanel(new GridLayout(1,1));
        
        // mainPanel.add(leftPanel, BorderLayout.WEST);
        // mainPanel.add(rightPanel, BorderLayout.CENTER);

        // Add main panel to the frame
        setJMenuBar(createMenuBar());
        add(mainPanel);
        expenseView();
    
        // Set up action listeners
      

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // Menu for adding expenses
        JMenu options = new JMenu("Options");
        
        JMenuItem addExpenseMenuItem = new JMenuItem("Add Expense and Get Summary");
        addExpenseMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.removeAll();

                mainPanel.revalidate();
                mainPanel.repaint();
                expenseView();
            }
        });

        
        // Menu for adding categories

        JMenuItem addCategoryMenuItem = new JMenuItem("Add Category View");
        addCategoryMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                mainPanel.removeAll();
                mainPanel.revalidate();
                mainPanel.repaint();
                addCategoryView();
            }
        });

        options.add(addExpenseMenuItem);
        options.add(addCategoryMenuItem);
        // Add menus to the menu bar
        menuBar.add(options);
        

        return menuBar;
    }
    
    private void expenseView(){
        mainPanel.removeAll();
        
        mainPanel.setLayout(new GridLayout(1,1));

        JPanel leftPanel = new JPanel(new GridLayout(0, 1));
        JPanel rightPanel = new JPanel(new BorderLayout());
        JButton addExpenseButton = new JButton("Add Expense");
        JButton getSummaryButton = new JButton("Get Summary");
        JTextArea graphPanel = new JTextArea(); // Placeholder for graph

        // Create left panel with GridLayout
        leftPanel.add(addExpenseButton);
        leftPanel.add(getSummaryButton);

        // Create right panel
        // ^ Create label for total money spent

        rightPanel.add(new JScrollPane(graphPanel), BorderLayout.CENTER);
        totalSpentLabel = new JLabel("Total Money Spent: Ksh " + ET.summary.getTotalAmountSpent() );
        totalSpentLabel.setFont(new Font("Arial", Font.BOLD, 30)); // Set a larger font
        totalSpentLabel.setHorizontalAlignment(SwingConstants.CENTER);
        // Add label to the right panel
        rightPanel.add(totalSpentLabel, BorderLayout.CENTER);


          addExpenseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement logic for adding an expense
                showExpenseDialog();
            }
        });

        getSummaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Implement logic for getting summary
                showPieChart();
                // JOptionPane.showMessageDialog(Main.this, "Get Summary button clicked");
            }
        });

        this.mainPanel.add(leftPanel);
        this.mainPanel.add(rightPanel);
        mainPanel.revalidate();
        mainPanel.repaint();

    }


    private void addCategoryView(){
        mainPanel.removeAll();
        JButton addCategoryButton = new JButton("Add Category");

        addCategoryButton.setPreferredSize(new Dimension(150,50));
        addCategoryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddCategoryDialog();
            }
        });
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(addCategoryButton);
        mainPanel.revalidate();
        mainPanel.repaint();
    }


 

    private void showAddCategoryDialog() {
        // Create a dialog for adding categories
        JDialog addCategoryDialog = new JDialog(this, "Add Category", true);
        addCategoryDialog.setSize(300, 150);
        addCategoryDialog.setLocationRelativeTo(this);

        // Components for the category input form
        JLabel nameLabel = new JLabel("Category Name:");
        JTextField nameTextField = new JTextField();

        JButton addButton = new JButton("Add");

        // Layout for the dialog
        addCategoryDialog.setLayout(new GridLayout(3, 2, 5, 5)); // Adjusted to include padding

        // Add components to the dialog
        addCategoryDialog.add(nameLabel);
        addCategoryDialog.add(nameTextField);
        addCategoryDialog.add(new JLabel()); // Empty label for spacing
        addCategoryDialog.add(new JLabel()); // Empty label for spacing
        addCategoryDialog.add(new JLabel()); // Empty label for spacing
        addCategoryDialog.add(addButton);

        // Set up action listener for the Add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve data from the input field
                String categoryName = nameTextField.getText();

                // TODO: Use the data to add the category to your data model

                
                ET.addCategory(categoryName);

                JOptionPane.showMessageDialog(Main.this,
                        "Category added!\nName: " + categoryName);

                addCategoryDialog.dispose(); // Close the dialog after adding category
            }
        });

        // Show the dialog
        addCategoryDialog.setVisible(true);
    }




    // * Add Expense dialog box

    private void showExpenseDialog(){
        JDialog addExpenseDialog = new JDialog(this, "Add Expense", true);
        addExpenseDialog.setSize(300, 200);
        addExpenseDialog.setLocationRelativeTo(this);
        
        // Components for the expense input form
        JLabel nameLabel = new JLabel("Expense Name:");
        JTextField nameTextField = new JTextField();
        
        JLabel amountLabel = new JLabel("Expense Amount:");
        JTextField amountTextField = new JTextField();

        JLabel categoryLabel = new JLabel("Category:");
        JComboBox<String> categoryComboBox = new JComboBox<>();
        for (Category category : this.ET.categories.getCategories()) {
            System.out.println(category.getCategoryName());
            categoryComboBox.addItem(category.getCategoryName());
        }


        JButton addButton = new JButton("Add");

        // Layout for the dialog        
        addExpenseDialog.setLayout(new GridLayout(4, 2, 5, 5));
        // Add components to the dialog
        addExpenseDialog.add(nameLabel);
        addExpenseDialog.add(nameTextField);
        addExpenseDialog.add(amountLabel);
        addExpenseDialog.add(amountTextField);
        addExpenseDialog.add(categoryLabel);
        addExpenseDialog.add(categoryComboBox);
        addExpenseDialog.add(new JLabel()); // Empty label for spacing
        addExpenseDialog.add(addButton);

        // Set up action listener for the Add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: Retrieve data from the input fields and add the expense


            String expenseName = nameTextField.getText();
            String amountText = amountTextField.getText();
            String selectedCategory = (String) categoryComboBox.getSelectedItem();

            // Validate input
            if (expenseName.isEmpty() || amountText.isEmpty() || selectedCategory == null) {
                JOptionPane.showMessageDialog(Main.this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop further processing if validation fails
            }

            // Validate amount is greater than 0
            double expenseAmount;
            try {
                expenseAmount = Double.parseDouble(amountText);
                if (expenseAmount <= 0) {
                    JOptionPane.showMessageDialog(Main.this, "Please enter an amount greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Stop further processing if validation fails
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(Main.this, "Invalid amount format.", "Error", JOptionPane.ERROR_MESSAGE);
                return; // Stop further processing if validation fails
            }


            // TODO: Use the data to add the expense to your data model
            Category chosenCategory = ET.categories.getCategory(selectedCategory);
            ET.addExpense(
                expenseName, expenseAmount, chosenCategory, new Date());

            totalSpentLabel.setText("Total Money Spent: Ksh " + ET.summary.getTotalAmountSpent());
            
                
            JOptionPane.showMessageDialog(Main.this,
                    "Expense added!\nName: " + expenseName +
                    "\nAmount: " + expenseAmount +
                    "\nCategory: " + selectedCategory);

            addExpenseDialog.dispose(); // Close the dialog after adding expense
        } // Close the dialog after adding expense
            
        });

        // Show the dialog
        addExpenseDialog.setVisible(true);
    }


    private void showPieChart(){

        DefaultPieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel  chartPanel = new ChartPanel(chart);
        
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        chartPanel.setBackground(Color.white);

        JFrame pieChartFrame = new JFrame("Category Expenses Pie Chart");
        pieChartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        // *Category expense information
        JPanel categoryInfoPanel = new JPanel(new GridLayout(0,1));


        for(Category category : ET.categories.getCategories()){
            JLabel categoryLabel  = new JLabel(category.getCategoryName()+ " Ksh." + category.getTotal());

            categoryInfoPanel.add(categoryLabel);
            for(Expense expense : category.expenseList){
                JLabel expenseLabel = new JLabel(" - " + expense.getName() + ": Ksh." + expense.getAmount());
                categoryInfoPanel.add(expenseLabel);
            }
        }

        JPanel containerPanel = new JPanel(new GridLayout(2, 1));
        containerPanel.add(chartPanel);
        containerPanel.add(categoryInfoPanel);


        pieChartFrame.getContentPane().add(containerPanel);
        pieChartFrame.pack();
        pieChartFrame.setLocationRelativeTo(this);
        pieChartFrame.setVisible(true);



    }
    
    private DefaultPieDataset createDataset(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        for(Category category : ET.categories.getCategories()){

            if(category.getTotal() > 0 ){
                
                dataset.setValue(category.getCategoryName() + ": Ksh." + category.getTotal(), category.categoryTotal);

            }else{
                continue;
            }


        }

        return dataset;

    }

    private JFreeChart createChart(DefaultPieDataset dataset){

        return ChartFactory.createPieChart(
            "Category Expenses",
             dataset,false,true,false);

    }
   
    

} 



