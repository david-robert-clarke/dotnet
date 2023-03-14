WITH Ada.Text_IO;
WITH Ada.Integer_Text_IO;

PACKAGE CS_Int_IO IS

  PROCEDURE Get(Item  : OUT Integer;
                Width : IN Ada.Text_IO.Field := 0)
     RENAMES Ada.Integer_Text_IO.Get;

  PROCEDURE Put(Item  : IN Integer;
                Width : IN Ada.Text_IO.Field := 1;
                Base  : IN Ada.Text_IO.Number_Base := 10)
     RENAMES Ada.Integer_Text_IO.Put;

  PROCEDURE Get(File  : IN Ada.Text_IO.File_Type;
                Item  : OUT Integer;
                Width : IN Ada.Text_IO.Field := 0)
     RENAMES Ada.Integer_Text_IO.Get;

  PROCEDURE Put(File  : IN Ada.Text_IO.File_Type;
                Item  : IN Integer;
                Width : IN Ada.Text_IO.Field := 1;
                Base  : IN Ada.Text_IO.Number_Base := 10)
     RENAMES Ada.Integer_Text_IO.Put;

END CS_Int_IO;
