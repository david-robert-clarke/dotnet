/*    
**  ShellyLibV2.2 - the ShellShapeGenerator 
**
**  Copyright (C) 1997 Randolf Schultz (rschultz@informatik.uni-rostock.de)
**
**  This software is shareware!
**  Read the file "License" for further information.
*/

/* Surface Shader 						*/
/* Simulates the pattern of a Drupe shell			*/
/* (Use with the drupe displacement shader)			*/
/* This shader will paint the nodules created by the drupe	*/
/* displacement in a dark purple color, and add some speckles   */
/* to the whole surface.				        */
/* Parameters:							*/
/* O: number of whorls of the shell (deg)	 		*/
/* S: size of the S direction of the shell (deg) 		*/
/* W: length of the inner wall (deg)		 		*/
/* SpaceO: free space between the nodules in O dir (deg) 	*/
/* SpaceS: free space between the nodules in S dir (deg) 	*/
/* WidthO: size of the nodule in O dir (deg) 			*/
/* WidthS: size of the nodule in S dir (deg) 			*/
/* nodcol: dark purple color					*/

surface
SLdrupesrf( 
	float   Ka = 1; 
	float	Kd = 1;
	float   O  = 720;
	float   S  = 360;
	float   W  = 0;
	float   SpaceO = 30;
	float   SpaceS = 30; 
	float   WidthO = 30;
	float   WidthS = 30; 
 	color   nodcol = color (0.5, 0.2, 0.3); )
{
    point Nf;
    color col = 1;
    float alpha = 0;
    float g1 = 0;
    float g2 = 0;
    float i, v2 = O/(O+W);

   if(v < v2)	
    {
     if((mod(v*O,SpaceO) <= WidthO) && (mod(u*S,SpaceS) <= WidthS))
     {
	 g1 = 2*((mod(v*O,SpaceO)/WidthO)-0.5);
	 g2 = 2*((mod(u*S,SpaceS)/WidthS)-0.5);

	 alpha = 1.4 * exp(-(4.5 * g1 * g1)) * exp(-(4.5 * g2 * g2));

	i = noise( transform("shader",P)/0.01 );
	if(i > 0.75 )
	alpha = 1;


     }
     else
     {    
	i =  noise( transform("shader",P)/0.01);  
	if( i > 0.75 )
	alpha = 1;
     }
    col = mix(Cs, nodcol, alpha);
   }

    Nf = faceforward(normalize(N),I);

    Oi = Os;
    Ci = Os  * col * ( Ka*ambient() + Kd*diffuse(Nf) ) ;
}
