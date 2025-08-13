package com.task6;

import javax.swing.*;

public class ToDoList {
    public static void main(String[] args) {
    	
        JFrame frame = new JFrame("To-Do-List");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Input field
        JTextField taskField = new JTextField();
        taskField.setBounds(20, 20, 240, 30);

        // Add button
        JButton addButton = new JButton("Add Task");
        addButton.setBounds(270, 20, 100, 30);

        // Delete button
        JButton deleteButton = new JButton("Delete Task");
        deleteButton.setBounds(20, 300, 150, 30);

        // Task list
        DefaultListModel<String> taskListModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>(taskListModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        scrollPane.setBounds(20, 70, 350, 210);
        
     // Add task action
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a task.");
            }
        });

        // Delete selected task
        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            } else {
                JOptionPane.showMessageDialog(frame, "Please select a task to delete.");
            }
        });
        
        frame.add(taskField);
        frame.add(addButton);
        frame.add(deleteButton);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}

