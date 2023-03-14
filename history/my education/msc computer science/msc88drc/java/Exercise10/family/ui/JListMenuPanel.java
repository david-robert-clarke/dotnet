package family.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

/**
   A class used to display a large number of items in a menu. This class shows at most
   eight items, but provides facilities for scrolling through additional items.

   @author B. Wilkins
*/

public class JListMenuPanel extends JPanel
{
	private static final int PREF_WIDTH = 100;
	private static final int PREF_HEIGHT = 200;
	private ArrayList dataList = null;
	private ActionListener actionListener = null;
	private JList list = null;

   /**
		Constructor - create a JListMenuPanel object.

      @param data - the data to be used as items in the list.
      @param al - an ActionListener activated when the user selects an item in the list.
   */
	public JListMenuPanel(ArrayList data,ActionListener al)
	{
		setLayout(new BorderLayout());

		dataList = (ArrayList)data.clone();
		actionListener = al;
		
		// create a JList and adapt as recquired
		list = new JList(dataList.toArray());
		list.setBackground(getBackground());
		list.setCellRenderer(new JListMenuCellRenderer());
		list.addMouseMotionListener(new MouseMotionListener());
		list.addMouseListener(new MouseReleasedListener());

		// place the JList in a JScrollPane (never any scrollbars)
		JScrollPane jsp = new JScrollPane(list);
		jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

		// create the navigation (scroll up/down) buttons
		JListMenuNavButtonCreator navButtonCreator = new JListMenuNavButtonCreator(list);		
		JButton upButton = navButtonCreator.getNavUpButton();
		JButton downButton = navButtonCreator.getNavDownButton();
		jsp.getViewport().addChangeListener(new ViewportChangeListener(upButton,downButton));

		// add it all to the panel
		add(upButton,BorderLayout.NORTH);
		add(jsp,BorderLayout.CENTER);
		add(downButton,BorderLayout.SOUTH);
	}

   /**
      Set the data items to be displayed.

      @param data - The data items to be displayed in the list.
   */
	public void setListData(ArrayList data)
	{
		dataList = (ArrayList)data.clone();
		
		list.setListData(dataList.toArray());
	}
   

	public Dimension getPreferredSize()
	{
		return(new Dimension(PREF_WIDTH,PREF_HEIGHT));
	}

	// inner class JListMenuCellRenderer
	// change the CellRenderer of the JList so that the items look like menu items
	// rather than the normal 'labels' you get in a JList
	private class JListMenuCellRenderer extends JMenuItem implements ListCellRenderer
	{
		public Component getListCellRendererComponent(JList list,Object value,int index,
																		boolean isSelected,boolean cellHasFocus)
		{
			setText(value.toString());
			setArmed(cellHasFocus || isSelected);

			return(this);
		}
	}

	// inner class MouseMotionListener
	// when the user hovers over a displayed item, highlight it
	private class MouseMotionListener extends MouseMotionAdapter
	{
		Point mp = new Point();
		
		public void mouseMoved(MouseEvent e)
		{
			mp.x = e.getX();
			mp.y = e.getY();
			int index = list.locationToIndex(mp);
			if(index > -1)
				list.setSelectedIndex(index);
		}
	}

	// inner class MouseReleasedListener
	// when the user releases the mouse button ON the list then
	// activate the ActionListener
	private class MouseReleasedListener extends MouseAdapter
	{
		public void mouseReleased(MouseEvent e)
		{
			if(actionListener == null)
				return;
			
			// make sure the release is within the displayed area
			Point mp = new Point(e.getX(),e.getY());
			if(list.contains(mp.x,mp.y))
			{
				int index = list.locationToIndex(mp);
				if(index > -1)
				{
					Object data = dataList.get(index);
					actionListener.actionPerformed(new ActionEvent(data,ActionEvent.ACTION_PERFORMED,data.toString()));
               getParent().setVisible(false);
				}
			}
		}
	}

	// inner class ViewportChangeListener
	// changes in the Viewport result in the navigation buttons being enabled/disabled
	// maybe this should be in the JListMenuNavButtonCreator
	private class ViewportChangeListener implements ChangeListener
	{
		JButton upButton = null;
		JButton downButton = null;
		
		ViewportChangeListener(JButton ub,JButton db)
		{
			upButton = ub;
			downButton = db;
		}
		
		public void stateChanged(ChangeEvent e)
		{
			upButton.setEnabled((list.getFirstVisibleIndex() > 0));
			downButton.setEnabled((list.getLastVisibleIndex() < list.getModel().getSize()-1) &&
										 (list.getModel().getSize() > list.getVisibleRowCount()));
		}
	}

	// inner class JListMenuNavButtonCreator
	// handles creation and management of navigation buttons
	// each button has a MouseListener and an ActionListener attached
	// when the user presses in the button it starts a Timer that calls the ActionListener
	// when the user releases the button the Timer is stopped
	private class JListMenuNavButtonCreator
	{
		private static final int DELAY = 100;
		JButton upButton = null;
		JList list = null;
		JButton downButton = null;
		
		JListMenuNavButtonCreator(JList list)
		{
			this.list = list;

			// create the up button
			upButton = new JButton(new ImageIcon("up_arrow.gif"));
			upButton.setEnabled(false);
	
			// create the down button
			downButton = new JButton(new ImageIcon("down_arrow.gif"));
			if(list.getModel().getSize() <= list.getVisibleRowCount())
				downButton.setEnabled(false);

			// add the appropriate listeners to each button
			UpButtonActionListener ubal = new UpButtonActionListener();	
			DownButtonActionListener dbal = new DownButtonActionListener();

			// now attach common listeners
			attachCommonListeners(upButton,ubal);
			attachCommonListeners(downButton,dbal);
		}

		// not really necessary but just in case this class ever goes public
		JButton getNavUpButton()
		{
			return(upButton);
		}
		
		// not really necessary but just in case this class ever goes public
		JButton getNavDownButton()
		{
			return(downButton);
		}
		
		// both buttons have a MouseListener attached and an ActionListener
		private void attachCommonListeners(JButton button,ActionListener al)
		{
			Timer t = new Timer(DELAY,al);
			JListMenuNavButtonMouseListener nbml = new JListMenuNavButtonMouseListener(t);
			button.addActionListener(al);
			button.addMouseListener(nbml);
		}

		// inner class JListMenuNavButtonMouseListener
		// when the mouse is pressed a Timer is started that calls the ActionListener
		// when the mouse is released the Timer is stopped
		private class JListMenuNavButtonMouseListener extends MouseAdapter
		{
			Timer navTimer = null;
			
			JListMenuNavButtonMouseListener(Timer t)
			{
				navTimer = t;
			}
			
			public void mousePressed(MouseEvent e) // mouseEntered(MouseEvent e) 
			{
				navTimer.start();
			}

			public void mouseReleased(MouseEvent e) // mouseExited(MouseEvent e)
			{
				navTimer.stop();
			}
		}	

		// inner class UpButtonActionListener
		// scroll up the items in the list
		private class UpButtonActionListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				int index = list.getFirstVisibleIndex()-1;

				if(index >= 0)
					list.ensureIndexIsVisible(index);
			}
		}
	
		// inner class DownButtonActionListener
		// scroll down the items in the list
		private class DownButtonActionListener implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				int index = list.getLastVisibleIndex()+1;
				int count = list.getModel().getSize();

				if(index < count)
					list.ensureIndexIsVisible(index);
			}
		}
	}
}
