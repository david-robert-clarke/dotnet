/*    
**  ShellyLibV2.2 - the ShellShapeGenerator 
**
**  Copyright (C) 1997 Randolf Schultz (rschultz@informatik.uni-rostock.de)
**
**  This software is shareware!
**  Read the file "License" for further information.
*/

/* Surface Shader 						*/
/* Add some noisy dark stripes to simulate the pattern on a	*/
/* Common European Cockle					*/
/* Parameters: 							*/
/* O: number of whorls of the shell, in degrees 		*/
/* W: length of the inner wall, in degrees	 		*/
/* strength: number and intensity of the stripes		*/
/* intcol:   color of the interior				*/

surface
SLcocklesrf(
        float   Ka = 0.75, Kd = 1, Ks = 0.0, roughness = 0.1;
	float   O  = 720;
	float   W  = 0;
	float   strength = 0.9;
	color   intcol = color (0.95, 0.95, 0.88);
	color   speccol = 1;
)
{
        point   Nf;
	float	alpha = 0, no = 0;
	float   v2 = O / (O + W);
	color   col = 1;
	float	i = 0, size = strength;

	/* Are we inside the shell? */
        if(v > v2)
	  {
	   alpha = 1;
	   col = mix(Cs, intcol, alpha);
	  }
	else
	 {
	   col = Cs;
	   
	   for(i = 0; i < 6.0; i += 1.0)
            {
             no += abs(0.5-noise(200*v*size))/size;
	     size *= 2.0;
	    }

	    if(no >= 0.05 && no < 1.0)
	     col = mix(col, color (no, no, no), 0.5);
            
	    if(no<0.05 && no > 0.0)
	     col = mix(col, color(no,no,no), 0.7);
         }



        Nf = faceforward(normalize(N), I);

        Oi = Os;
        Ci = Os * col * ((Ka * ambient() + Kd * diffuse(Nf)) + 
	     speccol * Ks * specular(Nf, normalize(I), roughness));
}

