package LB_5;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;

public class lb5 {
    public static void main(String[] args) {
        JFrame app = new MainWindow();
        app.revalidate();
    }
}

class MainWindow extends JFrame {
    JMenuBar menu = CreateMenu();
    JTable table = CreateTable();
    JScrollPane scrollTable = new JScrollPane(table);
    Employees employees = new Employees();

    MainWindow() {
        super("LB5");
        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(menu);
        add(scrollTable);
    }

    private JMenuBar CreateMenu() {
        JMenuBar menu = new JMenuBar();

        // File Menu
        JMenu file = new JMenu("File");

        JMenuItem load = new JMenuItem("Load");
        load.addActionListener(e -> LoadFile());

        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(e -> SaveFile());

        file.add(load);
        file.add(save);

        // Employee Menu
        JMenu employee = new JMenu("Employee");

        JMenuItem show_full = new JMenuItem("Show Full Info");
        show_full.addActionListener(e -> ShowInfo());

        JMenuItem add = new JMenuItem("Add");
        add.addActionListener(e -> AddEmployee());

        JMenuItem delete = new JMenuItem("Remove");
        delete.addActionListener(e -> DeleteSelectedTableRow());

        employee.add(show_full);
        employee.add(add);
        employee.add(delete);

        // Advanced Menu
        JMenu advanced = new JMenu("Advanced");

        JMenuItem sort = new JMenuItem("Sort");
        sort.addActionListener(e -> Sort());

        advanced.add(sort);

        //
        menu.add(file);
        menu.add(employee);
        menu.add(advanced);
        return menu;
    }

    private JTable CreateTable() {
        String[] titles = {"Surname", "Department"};
        DefaultTableModel model = new DefaultTableModel(titles, 0) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);
        return table;
    }

    private void AddTableRow(String surname, String department) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{surname, department});
    }

    private void ShowInfo(){
        int selectedRowId = table.getSelectedRow();
        if (selectedRowId != -1 ){
            Employee employee = employees.getEmployeeById(selectedRowId);
            JPanel myPanel = new JPanel();
            myPanel.add(new JLabel("Surname:"));
            myPanel.add(new JLabel(employee.getSurname()));
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Position:"));
            myPanel.add(new JLabel(employee.getPosition()));
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Department:"));
            myPanel.add(new JLabel(employee.getDepartment()));
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Rank:"));
            myPanel.add(new JLabel(String.valueOf(employee.getRank())));
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Certificate Number:"));
            myPanel.add(new JLabel(String.valueOf(employee.getCertificate_number())));
            myPanel.add(Box.createHorizontalStrut(15));
            myPanel.add(new JLabel("Is he at work?:"));
            myPanel.add(new JLabel(String.valueOf(employee.isLocatedAtWork())));

            JOptionPane.showMessageDialog(null, myPanel);
        }
        else
            JOptionPane.showMessageDialog(null, "There is no selected row");
    }

    private void DeleteSelectedTableRow() {
        int rowToDelete = table.getSelectedRow();
        if (rowToDelete != -1) {
            ((DefaultTableModel) table.getModel()).removeRow(rowToDelete);
            employees.deleteEmployeeById(rowToDelete);
        }
        else
            JOptionPane.showMessageDialog(null, "There is no selected row");
    }

    private void AddEmployee() {
        JTextField surname = new JTextField(8);
        JTextField position = new JTextField(8);
        JTextField department = new JTextField(8);
        JTextField rank = new JTextField(2);
        JTextField certificate_number = new JTextField(5);
        JCheckBox isLocatedAtWork = new JCheckBox();

        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Surname:"));
        myPanel.add(surname);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Position:"));
        myPanel.add(position);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Department:"));
        myPanel.add(department);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Rank:"));
        myPanel.add(rank);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Certificate Number:"));
        myPanel.add(certificate_number);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Is he at work?:"));
        myPanel.add(isLocatedAtWork);

        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Employee Data", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            employees.addEmployee(new Employee(surname.getText(), position.getText(), department.getText(),
                    Integer.parseInt(rank.getText()), Integer.parseInt(certificate_number.getText())
                    , isLocatedAtWork.isBorderPainted()
            ));
            AddTableRow(surname.getText(), department.getText());
        }
    }

    private void SaveFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Wanna save this? Fine");

        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            employees.saveToFile(fileToSave.getAbsolutePath());
        }
    }

    private void LoadFile() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            employees.loadFromFile(selectedFile.getAbsolutePath());
            UpdateTable();
        }
    }

    private void Sort(){
        employees.sort();
        UpdateTable();
    }

    private void UpdateTable(){
        String[] titles = {"Surname", "Department"};
        DefaultTableModel model = new DefaultTableModel(employees.GetArrayOfSurnamesAndDepartments(), titles) {
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        };
        table.setModel(model);
    }
}