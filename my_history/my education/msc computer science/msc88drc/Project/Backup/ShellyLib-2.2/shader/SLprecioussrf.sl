/*    
**  ShellyLibV2.2 - the ShellShapeGenerator 
**
**  Copyright (C) 1997 Randolf Schultz (rschultz@informatik.uni-rostock.de)
**
**  This software is shareware!
**  Read the file "License" for further information.
*/

/* Surface Shader 						*/
/* Paints the strong ribs of a 'Precious Wentletrap' shell   	*/
/* in a different color                                         */
/* Parameters: 							*/
/* O: number of whorls of the shell, in degrees 		*/
/* W: length of the inner wall, in degrees	 		*/
/* Space: free space between two ribs, in degrees 		*/
/* Width: width of the ribs, in degrees 			*/
/* ribcol: color of the ribs, typically a white                 */

surface
SLprecioussrf(
        float   Ka=1, Kd=1, Ks=0.8, roughness=0.1;
	float   O  = 720;
	float   W  = 0;
	float   Space = 30; 
	float   Width = 9;
	color   ribcol = color (0.9, 0.9, 0.85);
)
{
        point   Nf;
	float	alpha = 0;
	float   v2 = O/(O+W);
	color   col = 1;

	/* Are we inside a rib? */
        if(v < v2)
         if(mod(v*O,Space) <= Width)
	  alpha = 1;

	col = mix(Cs, ribcol, alpha);

        Nf = faceforward(normalize(N),I);

        Oi = Os;
        Ci = Os * col * ((Ka*ambient() + Kd*diffuse(Nf)) + 
	     1*Ks*specular(Nf,normalize(I),roughness));
}

