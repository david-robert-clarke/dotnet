@echo off

:: This is a batch file to run CoreGEN application

:: Create new CoreGEN project
call C:\Fndtn\bin\nt\coregen.bat -b C:\FNDTN\ACTIVE\PROJECTS\CONS_INT\newcore.cm

:: Open CoreGEN with specified project
call C:\Fndtn\bin\nt\coregen.bat -p C:\FNDTN\ACTIVE\PROJECTS\CONS_INT -q C:\FNDTN\ACTIVE\PROJECTS\CONS_INT -i C:\FNDTN\ACTIVE\PROJECTS\CONS_INT\core.ini
