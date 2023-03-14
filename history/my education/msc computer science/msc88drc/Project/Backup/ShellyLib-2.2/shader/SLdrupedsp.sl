/*    
**  ShellyLibV2.2 - the ShellShapeGenerator 
**
**  Copyright (C) 1997 Randolf Schultz (rschultz@informatik.uni-rostock.de)
**
**  This software is shareware!
**  Read the file "License" for further information.
*/

/* Displacement Shader 						*/
/* Simulates the nodules of a Drupe shell 			*/
/* Parameters: 							*/
/* Km: height of the nodules 					*/
/* O: number of whorls of the shell (deg)	 		*/
/* S: size of the S direction of the shell (deg) 		*/
/* W: length of the inner wall (deg)		 		*/
/* SpaceO: distance between the nodules in O dir (deg) 		*/
/* SpaceS: distance between the nodules in S dir (deg) 		*/
/* WidthO: size of the nodule in O dir (deg) 			*/
/* WidthS: size of the nodule in S dir (deg) 			*/

displacement
SLdrupedsp(
	float   Km = 0.08,
		O  = 720,
		S  = 360,
	        W  = 0,	
	        SpaceO = 30,
	        SpaceS = 30,	
		WidthO = 30,
		WidthS = 30;
)
{
	float	magnitude = 0;
	float   g1 = 0;
	float   g2 = 0;
	float   v2 = O/(O+W);
	

	/* Compute the distance the surface should be displaced. */
       if(v < v2)	
        if((mod(v*O,SpaceO) <= WidthO) && (mod(u*S,SpaceS) <= WidthS))
	{
	 g1 = 2*((mod(v*O,SpaceO)/WidthO)-0.5);
	 g2 = 2*((mod(u*S,SpaceS)/WidthS)-0.5);

	 magnitude = exp(-(8 * g1 * g1)) * exp(-(8 * g2 * g2))*v / 2;
	}

	/* Now apply the displacement in the direction of the normal. */
	P += Km * magnitude * normalize(N);

	/* Recalculate the normal. */
	N = calculatenormal(P);
}

