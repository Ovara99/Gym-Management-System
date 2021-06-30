import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Table {

    public static void ViewTable() {

        // create JFrame and JTable
        JFrame frame = new JFrame();
        JTable MemberTable = new JTable();

        // create a table model and set a Column Identifiers to this model
        Object[] columns = {"Id", "Name", "Type", "Membership Date", "School", "Age"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columns);

        // set the model to the table
        MemberTable.setModel(model);

        // Change A JTable Background Color, Font Size, Font Color, Row Height
        MemberTable.setBackground(Color.LIGHT_GRAY);
        MemberTable.setForeground(Color.black);
        Font font = new Font("", 1, 22);
        MemberTable.setFont(font);
        MemberTable.setRowHeight(30);

        //create JLabels
        JLabel labelId= new JLabel("Enter the ID");
        JLabel labelName= new JLabel("Enter the Name");
        // create JTextFields
        JTextField textId = new JTextField();
        JTextField textName = new JTextField();


        // create JButtons
        JButton btnSearch = new JButton("Search");


        textId.setBounds(120, 220, 100, 25);
        textName.setBounds(120, 250, 100, 25);
        labelId.setBounds(20, 220, 100, 25);
        labelName.setBounds(20, 250, 100, 25);

        btnSearch.setBounds(250, 225, 100, 25);


        // create JScrollPane
        JScrollPane pane = new JScrollPane(MemberTable);
        pane.setBounds(0, 0, 880, 200);

        frame.setLayout(null);

        frame.add(pane);

        // add JTextFields to the jframe
        frame.add(textId);
        frame.add(textName);
        frame.add(labelName);
        frame.add(labelId);


        // add JButtons to the jframe
        frame.add(btnSearch);


        // create an array of objects to set the row data
        Object[] row = new Object[6];

        //filling the table
        BasicDBObject basicDBObject = new BasicDBObject("Name", 1);
        SetupDB.setDB();
        DBCollection table2 = SetupDB.database.getCollection("Members");
        DBCursor counter = table2.find();
        for (DBObject count : counter) {
            String MemID = (String) count.get("ID");
            String MemName = (String) count.get("Name");
            String MemType = (String) count.get("Type");
            String SchoolName = (String) count.get("SchoolName");
            String MemAge = (String) count.get("Age");
            String MembershipDate = (String) count.get("DateJoined");

            row[0] = MemID;
            row[1] = MemName;
            row[2] = MemType;
            row[3] = MembershipDate;
            if (MemType.equals("Student")) {
                row[4] = SchoolName;
                row[5]=null;
            } else if (MemType.equals("Over 60")) {
                row[5] = MemAge;
                row[4]=null;
            }else{
                row[4]=null;
                row[5]=null;
            }
            model.addRow(row);




            // button search row
            btnSearch.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {



                    String DBID = (String) count.get("ID");
                    String enteredID = textId.getText();
                    String DBName=(String) count.get("Name");
                    String enteredName = textName.getText();

                    if (DBID.equals(enteredID)) {
                        TableRowSorter<DefaultTableModel> ts=new TableRowSorter<DefaultTableModel>(model);
                        MemberTable.setRowSorter(ts);
                        ts.setRowFilter(RowFilter.regexFilter(enteredID));

                    }else if (DBName.equals(enteredName)) {
                        TableRowSorter<DefaultTableModel> ts2=new TableRowSorter<DefaultTableModel>(model);
                        MemberTable.setRowSorter(ts2);
                        ts2.setRowFilter(RowFilter.regexFilter(enteredName));

                    }
                    else if((DBID==null) && (DBName==null)) {
                        JOptionPane.showMessageDialog(null,"Invalid ID or Name","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            });

            frame.setSize(900, 400);
            frame.setLocationRelativeTo(null);

            frame.setVisible(true);

        }
    }

}
