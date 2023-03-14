/*    
**  ShellyLibV2.2 - the ShellShapeGenerator 
**
**  Copyright (C) 1997 Randolf Schultz (rschultz@informatik.uni-rostock.de)
**
**  This software is shareware!
**  Read the file "License" for further information.
*/

/* Surface Shader 						*/
/* Generic surface shader, that paints the interior of the	*/
/* shell in a different color                                   */
/* Parameters: 							*/
/* O: number of whorls of the shell, in degrees 		*/
/* W: length of the inner wall, in degrees	 		*/
/* intcol: color of the interior				*/

surface
SLshellsrf(
        float   Ka = 1, Kd = 1, Ks = 0.8, roughness = 0.1;
	float   O  = 720;
	float   W  = 0;
	color   intcol = color (0.9, 0.9, 0.85);
	color   speccol = 1;
)
{
        point   Nf;
	float	alpha = 0;
	float   v2 = O / (O + W);
	color   col = 1;

	/* Are we inside the shell? */
        if(v > v2)
	  alpha = 1;

	col = mix(Cs, intcol, alpha);

        Nf = faceforward(normalize(N), I);

        Oi = Os;
        Ci = Os * col * ((Ka * ambient() + Kd * diffuse(Nf)) + 
	     speccol * Ks * specular(Nf, normalize(I), roughness));
}

