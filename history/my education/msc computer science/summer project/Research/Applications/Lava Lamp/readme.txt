LLAMA: Lava Lamp Animated Model Application

Author: Kim Randell
E-mail: kim (dot) randell (at) blueyonder (dot) co (dot) uk
Homepage: http://members.lycos.co.uk/kim0randell/ (apologies for giant advert, it goes away after a while)

About
-----

This is one half of my final year project. It uses a surface mesh to model the wax blobs; the other half of the project attempted a metaball/particulate model, and was less visually pleasing.

Requires the OpenGL extension, GLUT, available from http://www.opengl.org/developers/documentation/glut.html
You will need to place the glut32.dll file in either your windows directory or in the same folder as globe.exe
(latest version at time of writing is http://www.opengl.org/developers/documentation/glut/glutdlls37beta.zip)

Controls
--------

Hold the left mouse button and drag to rotate around the lamp. The equivalent keyboard controls are the arrow keys.
Hold the right mouse button and drag up and down to zoom in and out.
Press 'P' to pause the simulation.
Press 'Q' or the escape key to quit.
Press 'R' to toggle the diagnostic rendering style.
Press 'F' to "fix" the blobs if they get jammed.
Press 'T' to change the type (shape and colour) of lamp.
Press 'O' to turn the lamp on and off.

Textures
--------

The application will run without textures, but looks a little better with them to spruce up the background. Some textures can be downloaded from the main Llama page (http://members.lycos.co.uk/kim0randell/llama/), or you can provide your own. They must be square targa (.tga) images, with width and height being a power of 2 up to 512. The files used are wood.tga, for the surface of the table, pink.tga, for the wallpaper of the room, and pink_map.tga for the environment map on the surface of the lamp.