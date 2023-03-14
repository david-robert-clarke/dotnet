WITH Ada.Text_IO;

PACKAGE CS_File_IO IS

   PROCEDURE OpenInput(FileName : IN String);
      -- Opens the file Name for input and then sets it
      -- to be the default input stream

   PROCEDURE OpenInput;
      -- Prompts the user for a file name, opens it for input and
      -- then sets it to be the default input stream.

   PROCEDURE OpenOutput(FileName : IN String);
      -- Opens the file Name for output and then sets it
      -- to be the default output stream.
      -- If the file does not exist it is created.
      -- If the file exists it is truncated.

   PROCEDURE OpenOutput;
      -- Prompts the user for a file name, opens it for output and
      -- then sets it to be the default output stream.
      -- If the file does not exist it is created.
      -- If the file exists it is truncated.

   PROCEDURE CloseInput;
      -- Closes the file associated with the current default input
      -- stream. The default input stream reverts to Standard_Input

   PROCEDURE CloseOutput;
      -- Closes the file associated with the current default output
      -- stream. The default output stream reverts to Standard_Output

END CS_File_IO;
