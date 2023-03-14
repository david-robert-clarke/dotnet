
PACKAGE BODY CS_File_IO IS

   MaxPathLen : CONSTANT Positive := 1024;
   SUBTYPE PathString IS String(1 .. MaxPathLen);
   Input, Output : Ada.Text_IO.File_Type;

   PROCEDURE OpenInput(FileName : IN String) IS
      -- Opens the file FileName for input and then sets it
      -- to be the default input stream
   BEGIN
      Ada.Text_IO.Open(File => Input,
                       Mode => Ada.Text_IO.In_File,
                       Name => FileName);
      Ada.Text_IO.Set_Input(File => Input);
   END OpenInput;

   PROCEDURE OpenInput IS
      -- Prompts the user for a file name, opens it for input and
      -- then sets it to be the default input stream.
      PathLen  : Natural;
      FileName : PathString;
   BEGIN
      Ada.Text_IO.Put(File => Ada.Text_IO.Standard_Output,
                      Item => "Input file> ");
      Ada.Text_IO.Get_Line(File => Ada.Text_IO.Standard_Input,
                           Item => FileName,
                           Last => PathLen);
      Ada.Text_IO.Open(File => Input,
                       Mode => Ada.Text_IO.In_File,
                       Name => FileName(1 .. PathLen));
      Ada.Text_IO.Set_Input(File => Input);
   END OpenInput;

   PROCEDURE OpenOutput(FileName : IN String) IS
      -- Opens the file Name for output and then sets it
      -- to be the default output stream.
      -- If the file does not exist it is created.
      -- If the file exists it is truncated.
   BEGIN
      Ada.Text_IO.Open(File => Output,
                       Mode => Ada.Text_IO.Out_File,
                       Name => FileName);
      Ada.Text_IO.Set_Output(File => Output);
      EXCEPTION
         WHEN Ada.Text_IO.Name_Error  =>
            Ada.Text_IO.Create(File => Output,
                               Name => FileName);
            Ada.Text_IO.Set_Output(File => Output);
   END OpenOutput;

   PROCEDURE OpenOutput IS
      -- Prompts the user for a file name, opens it for output and
      -- then sets it to be the default output stream.
      -- If the file does not exist it is created.
      -- If the file exists it is truncated.
      PathLen  : Natural;
      FileName : PathString;
   BEGIN
      Ada.Text_IO.Put(File => Ada.Text_IO.Standard_Output,
                      Item => "Output file> ");
      Ada.Text_IO.Get_Line(File => Ada.Text_IO.Standard_Input,
                           Item => FileName,
                           Last => PathLen);
      Ada.Text_IO.Open(File => Output,
                       Mode => Ada.Text_IO.Out_File,
                       Name => FileName(1 .. PathLen));
      Ada.Text_IO.Set_Output(File => Output);
      EXCEPTION
         WHEN Ada.Text_IO.Name_Error  =>
            Ada.Text_IO.Create(File => Output,
                               Name => FileName(1 .. PathLen));
            Ada.Text_IO.Set_Output(File => Output);
   END OpenOutput;

   PROCEDURE CloseInput IS
      -- Closes the file associated with the current default input
      -- stream. The default input stream reverts to Standard_Input
   BEGIN
      Ada.Text_IO.Set_Input(File => Ada.Text_IO.Standard_Input);
      Ada.Text_IO.Close(File => Input);
   END CloseInput;

   PROCEDURE CloseOutput IS
      -- Closes the file associated with the current default output
      -- stream. The default output stream reverts to Standard_Output
   BEGIN
      Ada.Text_IO.Set_Output(File => Ada.Text_IO.Standard_Output);
      Ada.Text_IO.Close(File => Output);
   END CloseOutput;

END CS_File_IO;

