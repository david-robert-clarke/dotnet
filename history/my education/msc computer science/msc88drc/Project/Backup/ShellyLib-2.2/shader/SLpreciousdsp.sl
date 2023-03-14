/*    
**  ShellyLibV2.2 - the ShellShapeGenerator 
**
**  Copyright (C) 1997 Randolf Schultz (rschultz@informatik.uni-rostock.de)
**
**  This software is shareware!
**  Read the file "License" for further information.
*/

/* Displacement Shader 						*/
/* Simulates the strong ribs of a 'Precious Wentletrap' shell   */
/* currently the ribs are sinusoidal, exponential might         */
/* deliver better results 					*/
/* Parameters: 							*/
/* Km: height of the ribs 					*/
/* O: number of whorls of the shell, in degrees 		*/
/* W: length of the inner wall, in degrees	 		*/
/* Space: free space between two ribs, in degrees 		*/
/* Width: width of the ribs, in degrees 			*/

displacement
SLpreciousdsp(
	float	Km = 0.04;
	float   O  = 720;
	float   W  = 0;
	float   Space = 30; 
	float   Width = 9
)
{
	float	magnitude = 0;
	float   v2 = O/(O+W);

	/* Compute the distance the surface should be displaced. */
        if(v < v2)
         if(mod(v*O,Space) <= Width)
	  magnitude = cos(PI*((mod(v*O,Space)/Width)-0.5))*v;

	/* Now apply the displacement in the direction of the normal. */
	P += Km * magnitude * normalize(N);

	/* Recalculate the normal. */
	N = calculatenormal(P);
}

