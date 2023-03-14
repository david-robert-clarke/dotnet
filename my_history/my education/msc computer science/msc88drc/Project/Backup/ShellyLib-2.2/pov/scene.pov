/*    ShellyLibV2.0 - the ShellShapeGenerator 
**
**    Copyright (C) 1996 Randolf Schultz (rschultz@informatik.uni-rostock.de)
**
**    This software is shareware!
**    Read the file "License" for further information.
*/ 

/* POVRay scene example */

/* Texture declaration for shell */
#declare SLte = pigment { color red 1.0 green 1.0 blue 1.0 }

camera {
   location  <0.75,  10.0, -8.0>
   direction <0.0,  0.0,  0.5>       
   up        <0.0,  1.0,  0.0>
   right     <4/3,  0.0,  0.0>
   look_at   <0.0,  0.0,  0.0>}

light_source {<0.0, 11.0,  -8.0> color red 1.0 blue 1.0 green 1.0}

/* include ShellyLib output, hopefully named shell.pov */
#include "shell.pov"

