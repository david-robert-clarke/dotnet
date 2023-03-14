/*    
**  ShellyLibV2.2 - the ShellShapeGenerator 
**
**  Copyright (C) 1997 Randolf Schultz (rschultz@informatik.uni-rostock.de)
**
**  This software is shareware!
**  Read the file "License" for further information.
*/

/* Surface Shader 						*/
/* Simulates pearlmut, adds a slight pink colored pattern       */
/* uses trace() to calc reflection:                             */
/* USE WITH BMRT ONLY!						*/
/* Parameters: 							*/
/* txtscale: size of the color-pattern                          */
/* alpha: visibility of the color-pattern			*/

surface
SLpearlmutsrf(
        float   Ka = 0.8, Kd = 1, Ks = 0.6, Kr = 0.1, roughness = 0.5;
	color   speccol = color (0.4, 0.4, 0.4);
	float   txtscale = 10;
	float   alpha = 0.3;
)
{
  point PP, offset;
  float cmi;
  point Nf, V, refldir;
  color Ct, env;
  float pixelsize, twice, scale, turb, turba, alpha2;

  PP = txtscale * transform ("shader", P);

  /* Calculate info for antialiasing */
  pixelsize = txtscale * sqrt(area(P));
  twice = 2 * pixelsize;

  /* calc turbulence for rainbow-like-colors */  
  turb = 0;
  for (scale = 1; scale > twice; scale /= 2)
      turb += scale * abs(noise(PP/scale)-0.5);

  if (scale > pixelsize)
      turb += clamp ((scale/pixelsize)-1, 0, 1) * scale * abs(noise(PP/scale)-0.5);

  PP = txtscale * 2 * transform ("shader", P);

  /* calc info for antialiasing */
  pixelsize = txtscale * 2 * sqrt(area(P));
  twice = 2 * pixelsize;

  /* calc turbulence for visibility of the rainbow 
     this should rather be viewpoint-dependant! */  
  turba = 0;
  for (scale = 1; scale > twice; scale /= 2)
      turba += scale * abs(noise(PP/scale)-0.5);

  if (scale > pixelsize)
      turba += clamp ((scale/pixelsize)-1, 0, 1) * scale * abs(noise(PP/scale)-0.5);

  alpha2 = clamp(turba, 0.0, alpha);

  Ct = mix(Cs,  color spline( turb,
		color (1.0,  0.7, 0.9),
		color (1.0,  0.7, 0.9),
		color (0.7, 0.9,  0.9),
		color (0.7, 0.9,  0.9),
		color (0.7, 0.7, 1.0),
		color (0.7, 0.7, 1.0)
		), alpha2);


  Nf = faceforward (normalize(N), I);
  V = normalize (I);

  env = Ks * specular(Nf,-V,roughness);
  if (Kr > 0.0) {
      refldir = reflect (V, Nf);
      env += Kr * trace (P, refldir);
    }

  env *= speccol;

  Oi = Os;
  Ci = Oi * (Ct * (Ka*ambient() + Kd*diffuse(Nf)) + env);
}

