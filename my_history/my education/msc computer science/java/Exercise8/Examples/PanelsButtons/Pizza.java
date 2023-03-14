/*  A pizza-order example, based largely on the CGI example */
/*  by N.J. McCracken.  This program by Ernest Sibert   */

import java.awt.*;


public class Pizza extends java.applet.Applet { 
  public static final int  gsize = 16;  /* General font size, font */
  public static final Font gfont = new Font("Helvetica", Font.PLAIN, gsize);

  String address, city;  /* Info. about the shop (from HTML) */
  double tax;      /* Sales tax rate for locality      */

  PizzaSML sml;    /* Panel for pizza size   */
  Toppings tops;   /* Panel for topping selection  */
  Name name;     /* Panel for email address  */
  String email = null;   /* The email address    */
  Button order;    /* "Place Order" button   */
  boolean hasBill;   /* Have we made a bill already? */
  Bill bill;     /* The bill     */
  Button confirm;    /* "Confirm Order" button */
  boolean hasConfirmation; /* Have we confirmed an order?  */
  TextField message;   /* Confirmation message, others */

  public void init() { 
    address = getParameter("address");
    city    = getParameter("city");
    tax     = (Double.valueOf(getParameter("tax"))).doubleValue();
    setLayout(new FlowLayout(FlowLayout.CENTER, 10, 4));
    Top  top  = new Top(36);      /* Arg is font size */
    Loc  loc  = new Loc(address, city, gsize);
    add(top);  add(loc);
    sml = new PizzaSML(gfont);  add(sml);
    add(new Label("--------------------- Toppings ---------------------"));
    tops = new Toppings(gfont);      
    add(tops);
    name = new Name(gfont);  add(name);
    order   = new Button("Place Order");    add(order);
    confirm = new Button("Confirm Order");  add(confirm);
    hasBill = false;  hasConfirmation = false;   /* Neither yet */
    bill = new Bill(gfont);  add(bill);
    message = new TextField(
  "                          Welcome to ECStasy Pizza",
          60);
    message.setEditable(false);  add(message);
  }

  /* Deal with relevant events */

  public boolean action(Event evt, Object arg) { 
    Object tgt = evt.target;    /* The target object */
    boolean result = false;   /* result      */
    if ( tgt instanceof Button ) { 
      if ( tgt == order ) { 
        result = handleOrder();
      } else {
        if ( tgt == confirm ) { 
          result = handleConfirm(); 
        } else return false;
      }
    } else return false;
    return result;
  }

  /* Place order */

  boolean handleOrder() { 
    email = name.getText();  /* We could check more carefully */
    try { 
      bill.enterPrice(this, sml.pSize(), tops.countTops());
      message.setText(
        "Click Confirm or change order and click Place Order.");
      hasBill = true;  hasConfirmation = false;
    } catch (/* StringIndexOutOfBounds */ Exception ex) { 
      message.setText("Sorry "+ex.toString()+"try again tomorrow.");
      hasBill = false;
    }
    return true;
  }

  /*  Confirm order */

  boolean handleConfirm() { 
    if ( hasConfirmation ) { 
      message.setText(
        "Place another order, then click Confirm after you receive the bill.");
      hasConfirmation = false;
    } else if ( hasBill ) { 
      message.setText(
        "Thank you for your order; your account has been debited.");
      hasConfirmation = true;
    } else { 
      message.setText(
        "Place an order first; click Confirm after you receive the bill.");
    }
    return true;
  }
  
} // end Pizza class


class Top extends Panel {   /* Flashy top panel */
   Top(int size) { 
     setLayout(new FlowLayout());
     setFont(new Font("TimesRoman", Font.BOLD+Font.ITALIC, size));
     setForeground(Color.orange);  setBackground(Color.blue);
     add(new Label("ECStasy Pizza", Label.CENTER));
   }
}


class Loc extends Panel {  /* Shop address, location, font size */
   Loc(String address, String city, int size) { 
     setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
     setFont(new Font("TimesRoman", Font.ITALIC, size));
     setForeground(Color.orange);  setBackground(Color.blue);
     add(new Label(address, Label.LEFT));
     add(new Label(city, Label.CENTER));
   }
}


class PizzaSML extends Panel { 
  public static final int SMALL = 1, MEDIUM = 2, LARGE = 3;
  CheckboxGroup sizeBoxes;

  PizzaSML(Font gfont) { 
    setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
    setFont(gfont);
    /* Pizza size with a group of checkboxes */
    add(new Label("Size: "));
    sizeBoxes = new CheckboxGroup();
    add(new Checkbox("small",  sizeBoxes, false));
    add(new Checkbox("medium", sizeBoxes, false));
    add(new Checkbox("large",  sizeBoxes, true ));
  }

  int pSize() { 
    String clabel = sizeBoxes.getCurrent().getLabel();
    /* clabel is label of Currently selected button */
    if ( clabel.equals("small" )) return SMALL;  else
    if ( clabel.equals("medium")) return MEDIUM; else
                                  return LARGE;
  }
   
} // end PizzaSML class


class Toppings extends Panel { 
  private static int nTop = 6; /* Number of choices */
  Checkbox item[]; /* Topping selections */

  Toppings(Font gfont) { 
    setLayout(new GridLayout(2, 3, 10, 10));  setFont(gfont);
    if ( nTop > 64 ) { /* Too many toppings for bitvector */
      add(new Label("TOO"));  add(new Label(" MANY"));
      add(new Label("TOPPINGS"));
    }
    item = new Checkbox[nTop];
    item[0] = new Checkbox("Pepperoni"   );  add(item[0]);
    item[1] = new Checkbox("Extra Cheese");  add(item[1]);
    item[2] = new Checkbox("Sausage");       add(item[2]);
    item[3] = new Checkbox("Onions");        add(item[3]);
    item[4] = new Checkbox("Peppers");       add(item[4]);
    item[5] = new Checkbox("Dead Fish");     add(item[5]);
  }

  int countTops() {   /* Returns number of toppings chosen */
    int n = 0;
    for ( int i = 0;  i < nTop;  i++ )
      if ( item[i].getState() ) n++;
    return n;
  }

  /* Returns long viewed as bit vector - bit 2^i represents topping i */

  long topSelection() { 
    long bt = 0;
    for ( int i = 0;  i < nTop;  i++ )
      if ( item[i].getState() ) bt |= 1<<i;
    return bt;
  }
  
} // end Toppings class


class Name extends Panel { 
  TextField name;

  Name(Font gfont) { 
    setLayout(new FlowLayout());  setFont(gfont);
    add(new Label("email address: "));
    name = new TextField(40);
    name.setFont(gfont);  add(name);
  }

  String getText() { return name.getText(); }
}

/********************************************************/
/*  Prices are recorded in pennies, printed as dollars  */
/********************************************************/

class Bill extends Panel { 
  long pPrice, tPrice, subtotal, tax, total;  /* Amounts */

  static final Label subl = new Label("Subtotal");  /* Fixed labels */
  static final Label taxl = new Label("Tax");
  static final Label totl = new Label("Total");

  static final int dchars = 8;  /* Spaces for amounts */
        /* This is  $dddd.dd  */

  static final String blank  = "        ";  /* dchars blanks */
  static final String dblank = "$       ";  /* with $  */
  static final String errstr = "$ ERROR ";  /* For errors  */

  /* Adjustable labels */

  Label lPizza  = new Label("Your pizza");
  Label lTops   = new Label("Your toppings");
  Label lPPrice = new Label(dblank, Label.RIGHT);
  Label lTPrice = new Label(blank,  Label.RIGHT);
  Label lSubt   = new Label(blank,  Label.RIGHT);
  Label lTax    = new Label(blank,  Label.RIGHT);
  Label lTotal  = new Label(dblank, Label.RIGHT);


  /* Create a blank bill */

  Bill (Font gfont) { 
    setLayout(new GridLayout(5, 2, 30, 5));
    setFont(gfont);  setBackground(Color.green);
    add(lPizza);  add(lPPrice);
    add(lTops);   add(lTPrice);
    add(subl);    add(lSubt);
    add(taxl);    add(lTax);
    add(totl);    add(lTotal);
  }

  public Insets insets() {  /* Specify small insets */
    return new Insets(10, 10, 10, 10); 
  } /* top, bot, lft rgt  */


  /* Compute the bill.  TaxRate is in percent, e.g.,  */
  /* 7.0 for a 7% tax         */

  void enterPrice(Pizza pizza, int pSize, int nTops)
         throws StringIndexOutOfBoundsException { 
    String plabel = (pSize == PizzaSML.SMALL ) ? "Small " :
        (pSize == PizzaSML.MEDIUM) ? "Medium" : "Large " ;
    lPizza.setText(plabel + " pizza");
    pPrice = 600 + pSize*100;
    lPPrice.setText(dollar(pPrice, true));
    String tlabel =  (nTops == 0) ? "No toppings" :
                     (nTops == 1) ? "1 topping"   :
                     nTops + " toppings"   ;
    lTops.setText(tlabel);
    tPrice = nTops*(50 + pSize*25);
    lTPrice.setText(dollar(tPrice, false));
    subtotal = pPrice + tPrice;
    lSubt.setText(dollar(subtotal, false));
    tax = Math.round(subtotal*pizza.tax/100.0D);
    lTax.setText(dollar(tax, false));
    total = subtotal + tax;
    lTotal.setText(dollar(total, true));
  }

  /* Format long (pennies) as dollars, ( with $ ) */

  static String dollar(long amt, boolean dsign)
         throws StringIndexOutOfBoundsException { 
    StringBuffer dbuff = new StringBuffer("$.");
    int i;
    if ( !dsign ) dbuff.setCharAt(0, ' '); /* Dollar sign */
    String ast = Long.toString(amt);
    int slen = ast.length();   /* length of string */
    if ( slen > dchars - 2 ) return errstr;  /* Too big */
    if ( slen == 1 ) {  /* Very small value */
    ast = "0" + ast;  slen = 2; }
    int sfst = dchars - slen - 1;  /* position of 1st char */
    /* Digits before decimal point */
    dbuff.insert(1, ast.substring(0, slen - 2));
    /* Initial blanks */
    for (i = 1;  i < sfst;  i++ ) dbuff.insert(1, ' ');
    /* Last two digits */
    dbuff.append(ast.substring(slen-2, slen));
    return dbuff.toString();
  }

} // end Bill class
