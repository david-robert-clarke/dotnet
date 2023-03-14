package databook;

/**
 * This class manages details about a single patient
 * 
 * @author David Clarke
 **/

public class Patient
{
  //instance variables declaration
  //private String listNumber;
  private String identifier;
  private String age;
  private String sex;
  private String diameter;
  private String binDiag;
  private String collBin;
  private String bgBin;
  private String blDisp;
  private String blBlus;
  private String derMel;
  private String dmGlob;
  private String asym;
  private String sym1;
  private String sym2;
  private String melGlob;
  private String dispBlus;
  private String diam6;
  private String noSym2;
  private String size;
  private String shape;
  private String colour;
  private String inflamed;
  private String bleed;
  private String sens;
  private String diam7;
  private String total;
  private String suspicious;
        
  /**
   * Constructor to create a Patient with a specified identifier.
   * Only one field (listNo) will be entered
   *
   * @param listNo where the patient is specified in the list
   **/
  public Patient(/*String listNo*/)
  {
    //listNumber = listNo;
    identifier = "";
    age = "";
    sex = "";
    diameter = "";
    binDiag = "";
    collBin = "";
    bgBin = "";
    blDisp = "";
    blBlus = "";
    derMel = "";
    dmGlob = "";
    asym = "";
    sym1 = "";
    sym2 = "";
    melGlob = "";
    dispBlus = "";
    diam6 = "";
    noSym2 = "";
    size = "";
    shape = "";
    colour = "";
    inflamed = "";
    bleed = "";
    sens = "";
    diam7 = "";
    total = "";
    suspicious = "";
  }
        
  /**
   * Constructor to create a Patient with a specified identifier
   * All the fields will be have data
   *
   * @param listNo where the patient is specified in the list
   **/
  public Patient( /*String listNo,*/ String id, String a, String sx, String diam,
		  String bDiag, String cBin, String bBin, String bDisp,
		  String bBlus, String dMel, String dGlob, String asy,
		  String sy1, String sy2, String mGlob, String dBlus,
		  String dia6, String nSym2, String sze, String shpe,
		  String color, String inflame, String bled, String sns,
		  String dia7, String tot, String susp) 
  {
    //listNumber = listNo;
    identifier = id;
    age = a;
    sex = sx;
    diameter = diam;
    binDiag = bDiag;
    collBin = cBin;
    bgBin = bBin;
    blDisp = bDisp;
    blBlus = bBlus;
    derMel = dMel;
    dmGlob = dGlob;
    asym = asy;
    sym1 = sy1;
    sym2 = sy2;
    melGlob = mGlob;
    dispBlus = dBlus;
    diam6 = dia6;
    noSym2 = nSym2;
    size = sze;
    shape = shpe;
    colour = color;
    inflamed = inflame;
    bleed = bled;
    sens = sns;
    diam7 = dia7;
    total = tot;
    suspicious = susp;
  }
        
  /*
    Set Methods
  */
        
  /**
   * set the listNumber of the patient
   *
   * @param listNo the position of the patient in the list
   **/
  /*public void setListNumber (String listNo)
  {
    listNumber = listNo;
    }*/
        
  /**
   * set the patient's identifier Image id no
   *
   * @param id a tag identifying each patient
   **/
  public void setIdentifier (String id)
  {
    identifier = id;
  }
        
  /**
   * set the patient's age
   *
   * @param a the age of the patient in years
   **/
  public void setAge (String a)
  {
    age = a;
  }
        
  /**
   * set the patient's sex
   *
   * @param sx the gender of the patient
   **/
  public void setSex (String sx)
  {
    sex = sx;
  }
        
  /**
   * set the patient's melanoma diameter
   *
   * @param diam the diameter of the patient's melanoma in(mm)
   **/
  public void setDiameter (String diam)
  {
    diameter = diam;
  }
        
  /**
   * set the patient's melanoma binDiag
   *
   * @param bDiag the binDiag of the patient's melanoma
   **/
  public void setBinDiag(String bDiag)
  {
    binDiag = bDiag;
  }
        
  /**
   * set the patient's melanoma collBin
   *
   * @param cBin the collBin of the patient's melanoma
   **/
  public void setCollBin (String cBin)
  {
    collBin = cBin;
  }
        
  /**
   * set the patient's melanoma bgBin
   *
   * @param bBin the bgBin of the patient's melanoma
   **/
  public void setBgBin (String bBin)
  {
    bgBin = bBin;
  }
        
  /**
   * set the patient's melanoma blDisp
   *
   * @param bDisp the blDisp of the patient's melanoma
   **/
  public void setBlDisp (String bDisp)
  {
    blDisp = bDisp;
  }
        
  /**
   * set the patient's melanoma blBlus
   *
   * @param bBlus the blBlus of the patient's melanoma
   **/
  public void setBlBlus (String bBlus)
  {
    blBlus = bBlus;
  }
        
  /**
   * set the patient's melanoma derMel
   *
   * @param dMel the derMel of the patient's melanoma
   **/
  public void setDerMel (String dMel)
  {
    derMel = dMel;
  }
        
  /**
   * set the patient's melanoma dmGlob
   *
   * @param dGlob the dmBlob of the patient's melanoma
   **/
  public void setDmGlob (String dGlob)
  {
    dmGlob = dGlob;
  }
        
  /**
   * set the patient's melanoma asym
   *
   * @param asy the asym of the patient's melanoma
   **/
  public void setAsym (String asy)
  {
    asym = asy;
  }
        
  /**
   * set the patient's melanoma sym1
   *
   * @param sy1 the sym1 of the patient's melanoma
   **/
  public void setSym1 (String sy1)
  {
    sym1 = sy1;
  }
        
  /**
   * set the patient's melanoma sym2
   *
   * @param sy2 the sym2 of the patient's melanoma
   **/
  public void setSym2 (String sy2)
  {
    sym2 = sy2;
  }
        
  /**
   * set the patient's melanoma melGlob
   *
   * @param mGlob the melGlob of the patient's melanoma
   **/
  public void setMelGlob (String mGlob)
  {
    melGlob = mGlob;
  }
        
  /**
   * set the patient's melanoma dispBlus
   *
   * @param dBlus the dispBlus of the patient's melanoma
   **/
  public void setDispBlus(String dBlus)
  {
    dispBlus = dBlus;
  }
        
  /**
   * set the patient's melanoma diam6
   *
   * @param d6 the diam6 of the patient's melanoma
   **/
  public void setDiam6 (String d6)
  {
    diam6 = d6;
  }
        
  /**
   * set the patient's melanoma noSym2
   *
   * @param nSym2 the noSym2 of the patient's melanoma
   **/
  public void setNoSym2 (String nSym2)
  {
    noSym2 = nSym2;
  }
        
  /**
   * set the patient's melanoma size
   *
   * @param sze is the melanoma large, or has it increased in size?
   **/
  public void setSize (String sze)
  {
    size = sze;
  }
        
  /**
   * set the patient's melanoma shape
   *
   * @param shpe is the melanoma unusual in shape (i.e. non circular).
   **/
  public void setShape (String shpe)
  {
    shape = shpe;
  }
        
  /**
   * set the patient's melanoma colour
   *
   * @param color is the colour unusual?
   **/
  public void setColour (String color)
  {
    colour = color;
  }
        
  /**
   * set the patient's melanoma feature inflamed 
   *
   * @param inflame is the area around the melanoma inflamed?
   **/
  public void setInflamed (String inflame)
  {
    inflamed = inflame;
  }
        
  /**
   * set the patient's melanoma feature bleed 
   *
   * @param bled was the patient's melanoma bleeding
   **/
  public void setBleed (String bled)
  {
    bleed = bled;
  }
        
  /**
   * set the patient's melanoma feature sens
   *
   * @param sns is there any pain or sensitivity associated with the melanoma?
   **/
  public void setSens (String sns)
  {
    sens = sns;
  }
        
  /**
   * set the patient's melanoma feature, diam7
   *
   * @param dia7 is the diameter greater then 7mm
   **/
  public void setDiam7 (String dia7)
  {
    diam7 = dia7;
  }
        
  /**
   * set the patient's melanoma feature, total
   * 
   * @param tot is the total score, the first three features score 2 if present, 
   * the next four score 1.
   **/
  public void setTotal (String tot)
  {
    total = tot;
  }
        
  /**
   * set the patient's melanoma feature, suspicious
   * 
   * @param susp if the sum of the scores from these seven features is greater 
   * than or equal to 3 then the melanoma is traditionally classified as 
   * suspicious.
   **/
  public void setSuspicious (String susp)
  {
    suspicious = susp;
  }
        
  /*
    Get Methods
  */
        
  /**
   * get the listNumber of the patient
   *
   * @return the position of the patient in the list
   **/
  /*public String getListNumber ()
  {
    return listNumber;
    }*/
        
  /**
   * get the patient's identifier Image id no
   *
   * @return a tag identifying each patient
   **/
  public String getIdentifier ()
  {
    return identifier;
  }
        
  /**
   * get the patient's age
   *
   * @return the age of the patient in years
   **/
  public String getAge ()
  {
    return age;
  }
        
  /**
   * get the patient's sex
   *
   * @return the gender of the patient
   **/
  public String getSex ()
  {
    return sex;
  }
        
  /**
   * get the patient's melanoma diameter
   *
   * @return the diameter of the patient's melanoma in(mm)
   **/
  public String getDiameter ()
  {
    return diameter;
  }
        
  /**
   * get the patient's melanoma binDiag
   *
   * @return the binDiag of the patient's melanoma
   **/
  public String getBinDiag()
  {
    return binDiag;
  }
        
  /**
   * get the patient's melanoma collBin
   *
   * @return the collBin of the patient's melanoma
   **/
  public String getCollBin ()
  {
    return collBin;
  }
        
  /**
   * get the patient's melanoma bgBin
   *
   * @return the bgBin of the patient's melanoma
   **/
  public String getBgBin ()
  {
    return bgBin;
  }
        
  /**
   * get the patient's melanoma blDisp
   *
   * @return the blDisp of the patient's melanoma
   **/
  public String getBlDisp ()
  {
    return blDisp;
  }
        
  /**
   * get the patient's melanoma blBlus
   *
   * @return the blBlus of the patient's melanoma
   **/
  public String getBlBlus ()
  {
    return blBlus;
  }
        
  /**
   * get the patient's melanoma derMel
   *
   * @return the derMel of the patient's melanoma
   **/
  public String getDerMel ()
  {
    return derMel;
  }
        
  /**
   * get the patient's melanoma dmGlob
   *
   * @return the dmBlob of the patient's melanoma
   **/
  public String getDmGlob ()
  {
    return dmGlob;
  }
        
  /**
   * get the patient's melanoma asym
   *
   * @return the asym of the patient's melanoma
   **/
  public String getAsym ()
  {
    return asym;
  }
        
  /**
   * get the patient's melanoma sym1
   *
	p.getCollBin() + ", ");
   * @return the sym1 of the patient's melanoma
   **/
  public String getSym1 ()
  {
    return sym1;
  }
        
  /**
   * get the patient's melanoma sym2
   *
   * @return the sym2 of the patient's melanoma
   **/
  public String getSym2 ()
  {
    return sym2;
  }
        
  /**
   * get the patient's melanoma melGlob
   *
   * @return the melGlob of the patient's melanoma
   **/
  public String getMelGlob ()
  {
    return melGlob;
  }
        
  /**
   * get the patient's melanoma dispBlus
   *
   * @return the dispBlus of the patient's melanoma
   **/
  public String getDispBlus()
  {
    return dispBlus;
  }
        
  /**
   * get the patient's melanoma diam6
   *
   * @return the diam6 of the patient's melanoma
   **/
  public String getDiam6 ()
  {
    return diam6;
  }
        
  /**
   * get the patient's melanoma noSym2
   *
   * @return the noSym2 of the patient's melanoma
   **/
  public String getNoSym2 ()
  {
    return noSym2;
  }
        
  /**
   * get the patient's melanoma size
   *
   * @return is the melanoma large, or has it increased in size?
   **/
  public String getSize ()
  {
    return size;
  }
        
  /**
   * get the patient's melanoma shape
   *
   * @return is the melanoma unusual in shape (i.e. non circular).
   **/
  public String getShape ()
  {
    return shape;
  }
        
  /**
   * get the patient's melanoma colour
   *
   * @return is the colour unusual?
   **/
  public String getColour ()
  {
    return colour;
  }
        
  /**
   * get the patient's melanoma feature inflamed 
   *
   * @return is the area around the melanoma inflamed?
   **/
  public String getInflamed ()
  {
    return inflamed;
  }
        
  /**
   * get the patient's melanoma feature bleed 
   *
   * @return was the patient's melanoma bleeding
   **/
  public String getBleed ()
  {
    return bleed;
  }
        
  /**
   * get the patient's melanoma feature sens
   *
   * @return is there any pain or sensitivity associated with the melanoma?
   **/
  public String getSens ()
  {
    return sens;
  }
        
  /**
   * get the patient's melanoma feature, diam7
   *
   * @return is the diameter greater then 7mm
   **/
  public String getDiam7 ()
  {
    return diam7;
  }
        
  /**
   * get the patient's melanoma feature, total
   * 
   * @return is the total score, the first three features score 2 if present, 
   * the next four score 1.
   **/
  public String getTotal ()
  {
    return total;
  }
        
  /**
   * get the patient's melanoma feature, suspicious
   * 
   * @return if the sum of the scores from these seven features is greater 
   * than or equal to 3 then the melanoma is traditionally classified as 
   * suspicious.
   **/
  public String getSuspicious ()
  {
    return suspicious;
  }
        
  /**
   * Get a string representation of this Patient
   *
   * @return a multi-line string containing all the Patients details
   **/
  public String toString()
  {
    String everything = "\n"/* + getListNumber () + " "*/ + getIdentifier () + " " + 
      getAge () + " " +  getSex () + " " + getDiameter () + " " + getBinDiag() + " " + 
      getCollBin () + " " + getBgBin () + " " + getBlDisp () + " " + getBlBlus ()
      + " " + getDerMel () + " " + getDmGlob () + " " + getAsym () + " " + getSym1 ()
      + " " + getSym2 () + " " + getMelGlob () + " " + getDispBlus() + " " + getDiam6 ()
      + " " + getNoSym2 () + " " + getSize () + " " + getShape () + " " + getColour ()
      + " " + getInflamed () + " " + getBleed () + " " + getSens () + " " + getDiam7 ()
      + " " + getTotal () + " " + getSuspicious ();

    return everything;
        
  }
  
}
