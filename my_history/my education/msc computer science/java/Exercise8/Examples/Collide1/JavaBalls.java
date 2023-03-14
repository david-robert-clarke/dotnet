/* JavaBalls.java
 * Copyright 1997 Joel Peterson.
 * All rights reserved.
 *
 * Permission to use and distribute unmodified copies of this file is freely
 * granted, provided that this notice is included and credit is given.
 *
 * The following HTML source is an example of acceptable credit.  It should
 * be included on your web page in close proximity to your use of this code:
 *
 * (APPLICATION NAME) makes use of Java classes provided by
 * <A HREF="http://www.geocities.com/SiliconValley/Peaks/3639/javastuff.html">
 * Joel Peterson</A>.
 *
 * Permission to modify, use and distribute copies of this file is granted
 * provided that the above terms are followed and a disclaimer of the changes
 * made is included.
 *
 * Because the program is licensed free of charge, there is no warranty
 * for the program, to the extent permitted by applicable law.  Except when
 * otherwise stated in writing the I provide the program "as is" without
 * warranty of any kind, either expressed or implied, including, but not
 * limited to, the implied warranties of merchantability and fitness for
 * a particular purpose.  The entire risk as to the quality and performance
 * of the program is with you.  Should the program prove defective, you
 * assume the cost of all necessary servicing, repair or correction.
 *
 * In no event unless required by applicable law or agreed to in writing will
 * I be liable to you for damages, including any general, special, incidental
 * or consequential damages arising out of the use or inability to use the
 * program (including but not limited to loss of data or data being rendered
 * inaccurate or losses sustained by you or third parties or a failure of the
 * program to operate with any other programs), even if such holder or other
 * party has been advised of the possibility of such damages.
 */

import java.util.*;
import java.awt.*;
import java.applet.*;

public class JavaBalls extends Applet {
    private JavaBallsAnimation anim;
    private Button stopped;

    public void init() {
	String value;
	double prob;

	value=getParameter("prob");
	if (value != null) prob=Double.valueOf(value).doubleValue();
	else prob=0.5;

	GridBagLayout gridbag = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();

	setLayout(gridbag);

	anim=new JavaBallsAnimation(prob);
	anim.setBackground(Color.white);

	Container3d animcontainer = new Container3d();
  
	animcontainer.setLayout(new GridLayout(1,0));
	animcontainer.add(anim);

	c.fill=GridBagConstraints.BOTH;
	c.gridwidth=GridBagConstraints.REMAINDER;
	c.gridheight=GridBagConstraints.RELATIVE;
	c.weighty=1;
	c.weightx=1;
	gridbag.setConstraints(animcontainer, c);
	add(animcontainer);

	c.weighty=0;
	c.gridheight=1;
	Panel buttons=new Panel();
	stopped=new Button("Stop");
	buttons.add(stopped);
	buttons.add(new Button("Clear"));
	gridbag.setConstraints(buttons, c);
	add(buttons);
    }

    public void start() {
	anim.start();
    }
    public void stop() {
	anim.stop();
    }

    public boolean action(Event e, Object arg) {
	if (arg.equals("Stop")) {
	    stopped.setLabel("Go");
	    stop();
	}
	else if (arg.equals("Clear")) {
	    stopped.setLabel("Stop");
	    anim.clear();
	}
	else if (arg.equals("Go")) {
	    stopped.setLabel("Stop");
	    start();
	}
	return true;
    }
}
