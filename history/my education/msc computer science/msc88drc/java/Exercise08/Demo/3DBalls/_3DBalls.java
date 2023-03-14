import java.applet.*;
import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;

public class _3DBalls extends Applet implements Runnable,MouseListener {

boolean sa,pa;
Image bi;
Graphics bg;
int i,j;
Thread t;
Ball b[],tb;
int rh,rf,rf2;
int rz,ax,ay,sf;
double rt,tz;
RandomPlus r;
int nb;
VectorPlus s;
Image cr[],bounce,bk;
ImageFilter imtf,imcf;
ImageProducer imb,imp;
int sx,sy,sz;
MediaTracker mt;
URL burl;

public void init() {
mt=new MediaTracker(this);
r=new RandomPlus();
bi=createImage(300,300);
bg=bi.getGraphics();
t=new Thread(this);

try {nb=Integer.parseInt(getParameter("number"),10);} catch (Exception e) {nb=10;}

b=new Ball[nb];
cr=new Image[nb];
s=new VectorPlus(nb);

burl=getDocumentBase();
bounce=getImage(burl,"circle.gif");
mt.addImage(bounce,1);
bk=getImage(burl,"backg.gif");
mt.addImage(bk,2);
try {mt.waitForAll();} catch (Exception e) {}

imb=bounce.getSource();
imtf=new TransparentFilter();
imb=new FilteredImageSource(imb,imtf);

for (i=0;i<nb;i++) {
b[i]=new Ball(r.nextNZPInt(15,235),r.nextNZPInt(15,235),r.nextNZPInt(15,235),r.nextNZMMInt(2,7),r.nextNZMMInt(2,7),r.nextNZMMInt(2,7),r.nextNZPInt(5,25),r.nextBrightColor(),i);
s.addElement(b[i]);
imcf=new ColorFilter(b[i].c);
imp=new FilteredImageSource(imb,imcf);
cr[i]=createImage(imp);
}

addMouseListener(this);


addKeyListener(new KeyAdapter() {
public void keyPressed(KeyEvent e) {
if (e.isShiftDown()) {pa=!pa;if (pa) t.suspend();else t.resume();}
}
}
);

requestFocus();
}

public void start() {
sa=true;
pa=false;
t.start();
}

public void stop() {
sa=false;
}

public void run() {
while (sa) {
repaint();
try {Thread.sleep(5);} catch (Exception e) {}
}
}

public void mousePressed(MouseEvent e) {
for (j=0;j<nb;j++) {
b[j].dx=r.nextNZMMInt(2,7);
b[j].dy=r.nextNZMMInt(2,7);
b[j].dz=r.nextNZMMInt(2,7);
}
}

public void update(Graphics g) {

bg.drawImage(bk,0,0,this);

if (pa) {
bg.setColor(Color.black);
bg.drawString("Paused",135,130);
bg.setColor(Color.white);
bg.drawString("Paused",135,110);
}

s.sort(0,nb-1);

bg.setColor(Color.black);

for (i=0;i<nb;i++) {
tb=(Ball)s.elementAt(i);
sf=(int)(tb.r*(0.5+tb.z*0.00166667));
ax=(int)(tb.x*0.5)+78;
ay=(int)(tb.y*0.5)+78;
bg.fillOval(ax,ay,sf,sf);
}

for (i=0;i<nb;i++) {
tb=(Ball)s.elementAt(i);
tz=tb.z;
rt=1-tz*0.0016667;
rf=(int)(tb.r2*rt);
rz=(int)(tz*0.25);
bg.setColor(tb.c);
ax=(int)(tb.x*rt)+rz;
ay=(int)(tb.y*rt)+rz;
bg.fillOval(ax,ay,rf,rf);

sx=tb.sx;
sy=tb.sy;
sz=tb.sz;
if (sx==8 || sx==24) tb.sx=0;
if (sy==8 || sy==24) tb.sy=0;
if (sz==8 || sz==24) tb.sz=0;
if (sx>0 || sy>0 || sz>0) {
ax-=4;
ay-=4;
rf2=tb.r;
if (sx==16) {tb.sxx=ax;tb.sxy=ay+rf2;}
else if (sx==32) {tb.sxx=ax+rf;tb.sxy=ay+rf2;}
if (sy==16) {tb.syx=ax+rf2;tb.syy=ay;}
else if (sy==32) {tb.syx=ax+rf2;tb.syy=ay+rf;}
if (sz==16) {tb.szx=ax;tb.szy=ay+rf2;}
else if (sz==32) {tb.szx=ax+rf2;tb.szy=ay+rf2;}
if (sx>8) {bg.drawImage(cr[tb.cp],tb.sxx,tb.sxy,this);tb.sx--;}
if (sy>8) {bg.drawImage(cr[tb.cp],tb.syx,tb.syy,this);tb.sy--;}
if (sz>8) {bg.drawImage(cr[tb.cp],tb.szx,tb.szy,this);tb.sz--;}
}
b[i].move();
}
g.drawImage(bi,0,0,this);

}

public void mouseReleased(MouseEvent e) {}
public void mouseClicked(MouseEvent e) {}
public void mouseEntered(MouseEvent e) {}
public void mouseExited(MouseEvent e) {}

}

class Ball {
int x,y,z;
int dx,dy,dz;
int sx,sy,sz;
int sxx,sxy,syx,syy,szx,szy;
int r,r2,r3;
Color c;
int cp;
Ball(int x,int y,int z,int dx,int dy,int dz,int r,Color c,int cp) {
this.x=x;
this.y=y;
this.z=z;
this.dx=dx;
this.dy=dy;
this.dz=dz;
this.r=r;
this.r2=r*2;
this.r3=300-r2;
this.c=c;
this.sx=0;
this.sy=0;
this.sz=0;
this.cp=cp;
}
public void move() {
x+=dx;
y+=dy;
z+=dz;
if (x<0) {sx=16;x=0;dx=-dx;}
else if (x>r3) {sx=32;x=r3;dx=-dx;}
if (y<0) {sy=16;y=0;dy=-dy;}
else if (y>r3) {sy=32;y=r3;dy=-dy;}
if (z<0) {sz=16;z=0;dz=-dz;}
else if (z>r3) {sz=32;z=r3;dz=-dz;}
}
}

class VectorPlus extends Vector {
int i;
int d,e;
Object t;
boolean f;
int l,h,m;

VectorPlus(int n) {
super(n);
}

public void sort(int ll,int hh) {
l=ll;
h=hh;
m=((Ball)elementAt((l+h)/2)).z;
do {
while (((Ball)elementAt(l)).z>m) l++;
while (((Ball)elementAt(h)).z<m) h--;
if (l<=h) {
t=elementAt(l);
setElementAt(elementAt(h),l++);
setElementAt(t,h--);
}
}
while (l<=h);
if (h>ll) sort(ll,h);
if (l<hh) sort(l,hh);
}

}

class ColorFilter extends RGBImageFilter {
int c;
public ColorFilter(int c) {
canFilterIndexColorModel=true;
this.c=c;
}
public ColorFilter(Color c) {
canFilterIndexColorModel=true;
this.c=c.getRGB();
}
public int filterRGB(int x,int y,int rgb) {
if ((rgb & 0xFFFFFF)==0xFFFFFF) return (0xFF000000 | c);
else return rgb;
}
}

class TransparentFilter extends RGBImageFilter {
public TransparentFilter() {canFilterIndexColorModel=true;}
public int filterRGB(int x,int y,int rgb) {
if ((rgb & 0xFFFFFF)==0) return 0x00000000;
else return rgb;
}
}

class RandomPlus extends Random {
int v;
public int nextNZPInt(int mn,int mx) {
mx++;
do
do
v=nextInt()%mx;
while (v==0);
while (Math.abs(v)<mn);
return Math.abs(v);
}
public int nextNZMMInt(int mn,int mx) {
mx++;
do
do
v=nextInt()%mx;
while (v==0);
while (Math.abs(v)<mn);
return v;
}
public Color nextBrightColor() {
return new Color(nextNZPInt(100,255),nextNZPInt(100,255),nextNZPInt(100,255));
}
}

