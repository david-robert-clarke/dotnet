package family.ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import family.*;

public class PersonForm extends JDialog implements ActionListener
{
   private FamilyTreeBrowser browser;
   private Person currentPerson;
   
   private JRadioButton maleButton,
                        femaleButton;
	private JTextField nameField,
                      birthField,
                      deathField,
                      occupationField;
   private JTextArea notesArea;
   private JButton okButton,
                   cancelButton;
	
	public PersonForm(FamilyTreeBrowser owner, Person p)
	{
		super((Frame)owner,"Person Details...",true);
		setResizable(false);
      
      currentPerson = p;
      browser = owner;
      
      JPanel content = new JPanel(new BorderLayout());
      content.setBorder(BorderFactory.createEmptyBorder(2, 10, 0, 10));

      JPanel top = new JPanel(new GridLayout(5, 1));
      
      JPanel temp = new JPanel(new FlowLayout(FlowLayout.CENTER));
      temp.add(new JLabel("Gender: "));
      ButtonGroup genderGroup = new ButtonGroup();
      maleButton = new JRadioButton("Male", true);
      femaleButton = new JRadioButton("Female", false);
      genderGroup.add(maleButton);
      genderGroup.add(femaleButton);
      temp.add(maleButton);
      temp.add(femaleButton);
      top.add(temp);
      
      temp = new JPanel(new FlowLayout(FlowLayout.RIGHT));      
      temp.add(new JLabel("Name: "));
      temp.add(nameField = new JTextField(25));
      top.add(temp);
      
      temp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      temp.add(new JLabel("Birth: "));
      temp.add(birthField = new JTextField(25));
      top.add(temp);

      temp = new JPanel(new FlowLayout(FlowLayout.RIGHT));      
      temp.add(new JLabel("Death: "));
      temp.add(deathField = new JTextField(25));
      top.add(temp);
      
      temp = new JPanel(new FlowLayout(FlowLayout.RIGHT));
      temp.add(new JLabel("Occupation: "));
      temp.add(occupationField = new JTextField(25));
      top.add(temp);
      
      content.add(top, BorderLayout.NORTH);
      
      temp = new JPanel(new BorderLayout());
      temp.add(new JLabel("Notes: ", SwingConstants.LEFT), BorderLayout.NORTH);
      notesArea = new JTextArea("", 10, 30);
      notesArea.setLineWrap(true);
      temp.add(new JScrollPane(notesArea), BorderLayout.CENTER);
      content.add(temp, BorderLayout.CENTER);
      
		temp = new JPanel(new FlowLayout(FlowLayout.CENTER));
      temp.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
		okButton = new JButton("OK");
		okButton.addActionListener(this);
		cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(this);
		temp.add(okButton);
		temp.add(cancelButton);
      
      content.add(temp, BorderLayout.SOUTH);
      
      setContentPane(content);
      
      if (currentPerson != null)
         setFields();
         
		pack();
	}
   
   public void actionPerformed(ActionEvent e)
   {
      if (e.getSource() == cancelButton)
      {
         hide();
         dispose();
      }
      else if (e.getSource() == okButton)
      {
         String name = nameField.getText().trim();
         String birth = birthField.getText().trim();
         String death = deathField.getText().trim();
         String occ = occupationField.getText().trim();
         String notes = notesArea.getText().trim();

         if (currentPerson == null) // adding rather than editing
         {
            boolean gender = (maleButton.isSelected()) ? Person.MALE
                                                       : Person.FEMALE;            
            
            Person p = new Person(name, gender, birth, death);
            p.setOccupation(occ);
            p.setNotes(notes);
            
            hide();
            browser.addPerson(p);
         }
         else // editing
         {
            currentPerson.setName(name);
            currentPerson.setBirth(birth);
            currentPerson.setDeath(death);
            currentPerson.setOccupation(occ);
            currentPerson.setNotes(notes);
            hide();
         }
         dispose();
      }
   }
   
   private void setFields()
   {
      if (currentPerson.getGender() == Person.MALE)
         maleButton.setSelected(true);
      else
         femaleButton.setSelected(true);
         
      maleButton.setEnabled(false);
      femaleButton.setEnabled(false);
      
      nameField.setText(currentPerson.getName());
      String birth = currentPerson.getBirth();
      if (birth != null)
         birthField.setText(birth);
      String death = currentPerson.getDeath();
      if (death != null)
         deathField.setText(death);
      String occ = currentPerson.getOccupation();
      if (occ != null)
         occupationField.setText(occ);
      String notes = currentPerson.getNotes();
      if (notes != null)
         notesArea.setText(notes);
   }
}