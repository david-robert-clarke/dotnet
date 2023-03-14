with Ada.Strings.Unbounded;  use  Ada.Strings.Unbounded;

package CGI is
-- This package is an Ada 95 interface to the "Common Gateway Interface" (CGI).
-- This package makes it easier to create Ada programs that can be
-- invoked by World-Wide-Web HTTP servers using the standard CGI interface.
-- CGI is rarely referred to by its full name, so the package name is short.
-- General information on CGI is available at "http://hoohoo.ncsa.uiuc.edu/cgi/".

-- Developed by (C) David A. Wheeler (wheeler@ida.org) June 1995.
-- This is version 1.0.

-- This was inspired by a perl binding by Steven E. Brenner at
--   "http://www.bio.cam.ac.uk/web/form.html"
-- and another perl binding by L. Stein at
--   "http://www-genome.wi.mit.edu/ftp/pub/software/WWW/cgi_docs.html"
-- A different method for interfacing binding Ada with CGI is to use the
-- "Un-CGI" interface at "http://www.hyperion.com/~koreth/uncgi.html".

-- This package automatically loads information from CGI on program start-up.
-- It loads information sent from "Get" or "Post" methods and automatically
-- splits the data into a set of variables that can be accessed by position or
-- by name.  An "Isindex" request is translated into a request with a single
-- key named "isindex" with its Value as the query value.

-- This package provides two data access methods:
-- 1) As an associative array; simply provide the key name and the
--    value associated with that key will be returned.
-- 2) As a sequence of key-value pairs, indexed from 1 to Argument_Count.
--    This is similar to Ada library Ada.Command_Line.
-- The main access routines support both String and Unbounded_String.

-- See the documentation file for more information and sample programs.

function Parsing_Errors return Boolean;  -- True if Error on Parse.
function Input_Received return Boolean;  -- True if Input Received.
function Is_Index       return Boolean;  -- True if an Isindex request made.
  -- An "Isindex" request is turned into a Key of "isindex" at position 1,
  -- with Value(1) as the actual query.

type CGI_Method_Type is (Get, Post, Unknown);

function CGI_Method return CGI_Method_Type;  -- True if Get_Method used.

-- Access data as an associative array - given a key, return its value.
-- The Key value is case-sensitive.
-- If a key is required but not present, raise Constraint_Error;
-- otherwise a missing key's value is considered to be "".
-- These routines find the Index'th value of that key (normally the first one).
function Value(Key : in Unbounded_String; Index : in Positive := 1;
               Required : in Boolean := False) return Unbounded_String;
function Value(Key : in String; Index : in Positive := 1;
               Required : in Boolean := False) return String;
function Value(Key : in Unbounded_String; Index : in Positive := 1;
              Required : in Boolean := False) return String;
function Value(Key : in String; Index : in Positive := 1;
               Required : in Boolean := False) return Unbounded_String;

-- Was a given key provided?
function Key_Exists(Key : in String; Index : in Positive := 1) return Boolean;
function Key_Exists(Key : in Unbounded_String; Index : in Positive := 1)
         return Boolean;

-- How many of a given key were provided?
function Key_Count(Key : in String) return Natural;
function Key_Count(Key : in Unbounded_String) return Natural;


-- Access data as an ordered list (it was sent as Key=Value);
-- Keys and Values may be retrieved from Position (1 .. Argument_Count).
-- Constraint_Error will be raised if (Position < 1 or Position > Argument_Count)
function Argument_Count return Natural;          -- 0 means no data sent.
function Key(Position : in Positive) return Unbounded_String;
function Key(Position : in Positive) return String;
function Value(Position : in Positive) return Unbounded_String;
function Value(Position : in Positive) return String;

-- The following are helpful subprograms to simplify use of CGI.

function My_URL return String; -- Returns the URL of this script.

procedure Put_CGI_Header(Header : in String := "Content-type: text/html");
-- Put CGI Header to Current_Output, followed by two carriage returns.
-- This header determines what the program's reply type is.
-- Default is to return a generated HTML document.

procedure Put_HTML_Head(Title : in String; Mail_To : in String := "");
-- Puts to Current_Output an HTML header with title "Title".  This is:
--   <HTML><HEAD><TITLE> _Title_ </TITLE>
--   <LINK REV="made" HREF="mailto:  _Mail_To_ ">
--   </HEAD><BODY>
-- If Mail_To is omitted, the "made" reverse link is omitted.

procedure Put_HTML_Heading(Title : in String; Level : in Positive);
-- Put an HTML heading at the given level with the given text.
-- If level=1, this puts:  <H1>Title</H1>.

procedure Put_HTML_Tail;
-- This is called at the end of an HTML document. It puts to Current_Output:
--   </BODY></HTML>

procedure Put_Error_Message(Message : in String);
-- Put to Current_Output an error message.
-- This Puts an HTML_Head, an HTML_Heading, and an HTML_Tail.
-- Call "Put_CGI_Header" before calling this.

procedure Put_Variables;
-- Put to Current_Output all of the CGI variables as an HTML-formatted String.

function Line_Count (Value : in String) return Natural;
-- Given a value that may have multiple lines, count the lines.
-- Returns 0 if Value is the empty/null string (i.e., length=0)
 
function Line_Count_of_Value (Key : String) return Natural;
-- Given a Key which has a Value that may have multiple lines,
-- count the lines.  Returns 0 if Key's Value is the empty/null
-- string (i.e., length=0) or if there's no such Key.
-- This is the same as Line_Count(Value(Key)).

function Line (Value : in String; Position : in Positive)
               return String;
-- Given a value that may have multiple lines, return the given line.
-- If there's no such line, raise Constraint_Error.

function Value_of_Line (Key : String; Position : Positive)
                        return String;
-- Given a Key which has a Value that may have multiple lines,
-- return the given line.  If there's no such line, raise Constraint_Error.
-- If there's no such Key, return the null string.
-- This is the same as Line(Value(Key), Position).

function Get_Environment(Variable : in String) return String;
-- Return the given environment variable's value.
-- Returns "" if the variable does not exist.

end CGI;

