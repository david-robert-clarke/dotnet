module RAM
symbol RAM_INT_STORE
family xc4000xl
symboltemplate ram0
attributes
   BUS_WIDTH = 8
   DEPTH = 16
   STYLE = MAX_SPEED
   USE_RPM = FALSE
pins
   A(3:0)
   DO(7:0)
   DI(7:0)
   WR_EN
