WITH Ada.Float_Text_IO;
WITH Ada.Text_IO;

PACKAGE CS_Flt_IO IS

  PROCEDURE Get(Item  : OUT Float;
                Width : IN Ada.Text_IO.Field := 0)
     RENAMES Ada.Float_Text_IO.Get;

  PROCEDURE Put(Item  : IN Float;
                Fore  : IN Ada.Text_IO.Field := 1;
                Aft   : IN Ada.Text_IO.Field := 2;
                Exp   : IN Ada.Text_IO.Field := 0)
     RENAMES Ada.Float_Text_IO.Put;

  PROCEDURE Get(File  : IN Ada.Text_IO.File_Type;
                Item  : OUT Float;
                Width : IN Ada.Text_IO.Field := 0)
     RENAMES Ada.Float_Text_IO.Get;

  PROCEDURE Put(File  : IN Ada.Text_IO.File_Type;
                Item  : IN Float;
                Fore  : IN Ada.Text_IO.Field := 1;
                Aft   : IN Ada.Text_IO.Field := 2;
                Exp   : IN Ada.Text_IO.Field := 0)
     RENAMES Ada.Float_Text_IO.Put;

END CS_Flt_IO;
