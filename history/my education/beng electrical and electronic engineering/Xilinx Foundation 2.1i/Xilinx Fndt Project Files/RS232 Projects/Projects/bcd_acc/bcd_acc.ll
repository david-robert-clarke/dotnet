Revision 3
; Created by bitgen C.16 at Tue Jun 01 10:41:27 1999
; Bit lines have the following form:
; <offset> <frame number> <frame offset> <information>
; <information> may be zero or more <kw>=<value> pairs
; Block=<blockname     specifies the block associated with this
;                      memory cell.
;
; Latch=<name>         specifies the latch associated with this memory cell.
;
; Net=<netname>        specifies the user net associated with this
;                      memory cell.
;
; COMPARE=[YES | NO]   specifies whether or not it is appropriate
;                      to compare this bit position between a
;                      "program" and a "readback" bitstream.
;                      If not present the default is NO.
;
; Ram=<ram id>:<bit>   This is used in cases where a CLB function
; Rom=<ram id>:<bit>   generator is used as RAM (or ROM).  <Ram id>
;                      will be either 'F', 'G', or 'M', indicating
;                      that it is part of a single F or G function
;                      generator used as RAM, or as a single RAM
;                      (or ROM) built from both F and G.  <Bit> is
;                      a decimal number.
;
; Info lines have the following form:
; Info <name>=<value>  specifies a bit associated with the LCA
;                      configuration options, and the value of
;                      that bit.  The names of these bits may have
;                      special meaning to software reading the .ll file.
;
Bit       21      1    101 Block=P57 Latch=I1
Bit       31      1     91 Block=UNB37 Latch=I1
Bit       41      1     81 Block=P60 Latch=I1
Bit       51      1     71 Block=UNB33 Latch=I1
Bit       61      1     61 Block=P62 Latch=I1
Bit       73      1     49 Block=P66 Latch=I1
Bit       83      1     39 Block=UNB27 Latch=I1
Bit       93      1     29 Block=P68 Latch=I1
Bit      103      1     19 Block=P70 Latch=I1
Bit      113      1      9 Block=P72 Latch=I1
Bit      259      3    107 Block=P56 Latch=OQ
Bit      265      3    101 Block=P57 Latch=I2
Bit      269      3     97 Block=P58 Latch=OQ
Bit      275      3     91 Block=UNB37 Latch=I2
Bit      279      3     87 Block=P59 Latch=OQ
Bit      285      3     81 Block=P60 Latch=I2
Bit      289      3     77 Block=UNB34 Latch=OQ
Bit      295      3     71 Block=UNB33 Latch=I2
Bit      299      3     67 Block=P61 Latch=OQ
Bit      305      3     61 Block=P62 Latch=I2
Bit      311      3     55 Block=P65 Latch=OQ
Bit      317      3     49 Block=P66 Latch=I2
Bit      321      3     45 Block=UNB28 Latch=OQ
Bit      327      3     39 Block=UNB27 Latch=I2
Bit      331      3     35 Block=P67 Latch=OQ
Bit      337      3     29 Block=P68 Latch=I2
Bit      341      3     25 Block=P69 Latch=OQ
Bit      347      3     19 Block=P70 Latch=I2
Bit      351      3     15 Block=P71 Latch=OQ
Bit      357      3      9 Block=P72 Latch=I2
Bit      382      4    106 Block=P56 Latch=I2
Bit      387      4    101 Block=P57 Latch=OQ
Bit      392      4     96 Block=P58 Latch=I2
Bit      397      4     91 Block=UNB37 Latch=OQ
Bit      402      4     86 Block=P59 Latch=I2
Bit      407      4     81 Block=P60 Latch=OQ
Bit      412      4     76 Block=UNB34 Latch=I2
Bit      417      4     71 Block=UNB33 Latch=OQ
Bit      422      4     66 Block=P61 Latch=I2
Bit      427      4     61 Block=P62 Latch=OQ
Bit      434      4     54 Block=P65 Latch=I2
Bit      439      4     49 Block=P66 Latch=OQ
Bit      444      4     44 Block=UNB28 Latch=I2
Bit      449      4     39 Block=UNB27 Latch=OQ
Bit      454      4     34 Block=P67 Latch=I2
Bit      459      4     29 Block=P68 Latch=OQ
Bit      464      4     24 Block=P69 Latch=I2
Bit      469      4     19 Block=P70 Latch=OQ
Bit      474      4     14 Block=P71 Latch=I2
Bit      479      4      9 Block=P72 Latch=OQ
Bit      504      5    106 Block=P56 Latch=I1
Bit      514      5     96 Block=P58 Latch=I1
Bit      524      5     86 Block=P59 Latch=I1 Net=N_CLR
Bit      534      5     76 Block=UNB34 Latch=I1
Bit      544      5     66 Block=P61 Latch=I1
Bit      556      5     54 Block=P65 Latch=I1
Bit      566      5     44 Block=UNB28 Latch=I1
Bit      576      5     34 Block=P67 Latch=I1
Bit      586      5     24 Block=P69 Latch=I1
Bit      596      5     14 Block=P71 Latch=I1
Bit     5386     45    104 Block=CLB_R10C10 Latch=Y
Bit     5396     45     94 Block=CLB_R9C10 Latch=Y
Bit     5406     45     84 Block=CLB_R8C10 Latch=Y
Bit     5416     45     74 Block=CLB_R7C10 Latch=Y
Bit     5426     45     64 Block=CLB_R6C10 Latch=Y
Bit     5438     45     52 Block=CLB_R5C10 Latch=Y
Bit     5448     45     42 Block=CLB_R4C10 Latch=Y
Bit     5458     45     32 Block=CLB_R3C10 Latch=Y
Bit     5468     45     22 Block=CLB_R2C10 Latch=Y
Bit     5478     45     12 Block=CLB_R1C10 Latch=Y
Bit     5995     50    105 Block=CLB_R10C10 Latch=YQ
Bit     6005     50     95 Block=CLB_R9C10 Latch=YQ
Bit     6015     50     85 Block=CLB_R8C10 Latch=YQ
Bit     6025     50     75 Block=CLB_R7C10 Latch=YQ
Bit     6035     50     65 Block=CLB_R6C10 Latch=YQ
Bit     6047     50     53 Block=CLB_R5C10 Latch=YQ
Bit     6057     50     43 Block=CLB_R4C10 Latch=YQ
Bit     6067     50     33 Block=CLB_R3C10 Latch=YQ
Bit     6077     50     23 Block=CLB_R2C10 Latch=YQ
Bit     6087     50     13 Block=CLB_R1C10 Latch=YQ
Bit     6484     54    104 Block=CLB_R10C10 Latch=X
Bit     6494     54     94 Block=CLB_R9C10 Latch=X
Bit     6504     54     84 Block=CLB_R8C10 Latch=X
Bit     6514     54     74 Block=CLB_R7C10 Latch=X
Bit     6524     54     64 Block=CLB_R6C10 Latch=X
Bit     6536     54     52 Block=CLB_R5C10 Latch=X
Bit     6546     54     42 Block=CLB_R4C10 Latch=X
Bit     6556     54     32 Block=CLB_R3C10 Latch=X
Bit     6566     54     22 Block=CLB_R2C10 Latch=X
Bit     6576     54     12 Block=CLB_R1C10 Latch=X
Bit     6956     58    120 Block=P51 Latch=OQ
Bit     6957     58    119 Block=P50 Latch=OQ
Bit     6971     58    105 Block=CLB_R10C10 Latch=XQ
Bit     6981     58     95 Block=CLB_R9C10 Latch=XQ
Bit     6991     58     85 Block=CLB_R8C10 Latch=XQ
Bit     7001     58     75 Block=CLB_R7C10 Latch=XQ
Bit     7011     58     65 Block=CLB_R6C10 Latch=XQ
Bit     7023     58     53 Block=CLB_R5C10 Latch=XQ
Bit     7033     58     43 Block=CLB_R4C10 Latch=XQ
Bit     7043     58     33 Block=CLB_R3C10 Latch=XQ
Bit     7053     58     23 Block=CLB_R2C10 Latch=XQ
Bit     7063     58     13 Block=CLB_R1C10 Latch=XQ
Bit     7072     58      4 Block=P78 Latch=OQ
Bit     7073     58      3 Block=P77 Latch=OQ
Bit     7078     59    120 Block=P51 Latch=I1
Bit     7079     59    119 Block=P51 Latch=I2
Bit     7194     59      4 Block=P77 Latch=I2
Bit     7195     59      3 Block=P77 Latch=I1
Bit     7200     60    120 Block=P50 Latch=I2
Bit     7201     60    119 Block=P50 Latch=I1
Bit     7316     60      4 Block=P78 Latch=I1
Bit     7317     60      3 Block=P78 Latch=I2
Bit     9778     81    104 Block=CLB_R10C9 Latch=Y
Bit     9788     81     94 Block=CLB_R9C9 Latch=Y
Bit     9798     81     84 Block=CLB_R8C9 Latch=Y
Bit     9808     81     74 Block=CLB_R7C9 Latch=Y
Bit     9818     81     64 Block=CLB_R6C9 Latch=Y Net=syn421
Bit     9830     81     52 Block=CLB_R5C9 Latch=Y
Bit     9840     81     42 Block=CLB_R4C9 Latch=Y
Bit     9850     81     32 Block=CLB_R3C9 Latch=Y
Bit     9860     81     22 Block=CLB_R2C9 Latch=Y
Bit     9870     81     12 Block=CLB_R1C9 Latch=Y
Bit    10387     86    105 Block=CLB_R10C9 Latch=YQ
Bit    10397     86     95 Block=CLB_R9C9 Latch=YQ
Bit    10407     86     85 Block=CLB_R8C9 Latch=YQ
Bit    10417     86     75 Block=CLB_R7C9 Latch=YQ Net=N_Q2<1>
Bit    10427     86     65 Block=CLB_R6C9 Latch=YQ
Bit    10439     86     53 Block=CLB_R5C9 Latch=YQ Net=N_Q2<3>
Bit    10449     86     43 Block=CLB_R4C9 Latch=YQ
Bit    10459     86     33 Block=CLB_R3C9 Latch=YQ
Bit    10469     86     23 Block=CLB_R2C9 Latch=YQ
Bit    10479     86     13 Block=CLB_R1C9 Latch=YQ
Bit    10876     90    104 Block=CLB_R10C9 Latch=X
Bit    10886     90     94 Block=CLB_R9C9 Latch=X Net=syn362
Bit    10896     90     84 Block=CLB_R8C9 Latch=X
Bit    10906     90     74 Block=CLB_R7C9 Latch=X
Bit    10916     90     64 Block=CLB_R6C9 Latch=X Net=syn429
Bit    10928     90     52 Block=CLB_R5C9 Latch=X
Bit    10938     90     42 Block=CLB_R4C9 Latch=X
Bit    10948     90     32 Block=CLB_R3C9 Latch=X
Bit    10958     90     22 Block=CLB_R2C9 Latch=X
Bit    10968     90     12 Block=CLB_R1C9 Latch=X
Bit    11348     94    120 Block=P49 Latch=OQ
Bit    11349     94    119 Block=P48 Latch=OQ
Bit    11363     94    105 Block=CLB_R10C9 Latch=XQ
Bit    11373     94     95 Block=CLB_R9C9 Latch=XQ
Bit    11383     94     85 Block=CLB_R8C9 Latch=XQ
Bit    11393     94     75 Block=CLB_R7C9 Latch=XQ Net=N_Q2<0>
Bit    11403     94     65 Block=CLB_R6C9 Latch=XQ
Bit    11415     94     53 Block=CLB_R5C9 Latch=XQ Net=N_Q2<2>
Bit    11425     94     43 Block=CLB_R4C9 Latch=XQ
Bit    11435     94     33 Block=CLB_R3C9 Latch=XQ
Bit    11445     94     23 Block=CLB_R2C9 Latch=XQ
Bit    11455     94     13 Block=CLB_R1C9 Latch=XQ
Bit    11464     94      4 Block=P80 Latch=OQ
Bit    11465     94      3 Block=P79 Latch=OQ
Bit    11470     95    120 Block=P49 Latch=I1
Bit    11471     95    119 Block=P49 Latch=I2
Bit    11586     95      4 Block=P79 Latch=I2
Bit    11587     95      3 Block=P79 Latch=I1
Bit    11592     96    120 Block=P48 Latch=I2
Bit    11593     96    119 Block=P48 Latch=I1
Bit    11708     96      4 Block=P80 Latch=I1
Bit    11709     96      3 Block=P80 Latch=I2
Bit    14170    117    104 Block=CLB_R10C8 Latch=Y
Bit    14180    117     94 Block=CLB_R9C8 Latch=Y Net=syn365
Bit    14190    117     84 Block=CLB_R8C8 Latch=Y
Bit    14200    117     74 Block=CLB_R7C8 Latch=Y Net=N50
Bit    14210    117     64 Block=CLB_R6C8 Latch=Y Net=syn364
Bit    14222    117     52 Block=CLB_R5C8 Latch=Y
Bit    14232    117     42 Block=CLB_R4C8 Latch=Y
Bit    14242    117     32 Block=CLB_R3C8 Latch=Y
Bit    14252    117     22 Block=CLB_R2C8 Latch=Y
Bit    14262    117     12 Block=CLB_R1C8 Latch=Y
Bit    14779    122    105 Block=CLB_R10C8 Latch=YQ
Bit    14789    122     95 Block=CLB_R9C8 Latch=YQ
Bit    14799    122     85 Block=CLB_R8C8 Latch=YQ Net=N_Q3<2>
Bit    14809    122     75 Block=CLB_R7C8 Latch=YQ
Bit    14819    122     65 Block=CLB_R6C8 Latch=YQ
Bit    14831    122     53 Block=CLB_R5C8 Latch=YQ
Bit    14841    122     43 Block=CLB_R4C8 Latch=YQ
Bit    14851    122     33 Block=CLB_R3C8 Latch=YQ
Bit    14861    122     23 Block=CLB_R2C8 Latch=YQ
Bit    14871    122     13 Block=CLB_R1C8 Latch=YQ
Bit    15268    126    104 Block=CLB_R10C8 Latch=X
Bit    15278    126     94 Block=CLB_R9C8 Latch=X Net=syn450
Bit    15288    126     84 Block=CLB_R8C8 Latch=X
Bit    15298    126     74 Block=CLB_R7C8 Latch=X Net=N54
Bit    15308    126     64 Block=CLB_R6C8 Latch=X Net=syn361
Bit    15320    126     52 Block=CLB_R5C8 Latch=X
Bit    15330    126     42 Block=CLB_R4C8 Latch=X
Bit    15340    126     32 Block=CLB_R3C8 Latch=X
Bit    15350    126     22 Block=CLB_R2C8 Latch=X
Bit    15360    126     12 Block=CLB_R1C8 Latch=X
Bit    15740    130    120 Block=P47 Latch=OQ
Bit    15741    130    119 Block=P46 Latch=OQ
Bit    15755    130    105 Block=CLB_R10C8 Latch=XQ
Bit    15765    130     95 Block=CLB_R9C8 Latch=XQ
Bit    15775    130     85 Block=CLB_R8C8 Latch=XQ Net=N_Q3<3>
Bit    15785    130     75 Block=CLB_R7C8 Latch=XQ
Bit    15795    130     65 Block=CLB_R6C8 Latch=XQ
Bit    15807    130     53 Block=CLB_R5C8 Latch=XQ
Bit    15817    130     43 Block=CLB_R4C8 Latch=XQ
Bit    15827    130     33 Block=CLB_R3C8 Latch=XQ
Bit    15837    130     23 Block=CLB_R2C8 Latch=XQ
Bit    15847    130     13 Block=CLB_R1C8 Latch=XQ
Bit    15856    130      4 Block=P82 Latch=OQ
Bit    15857    130      3 Block=P81 Latch=OQ
Bit    15862    131    120 Block=P47 Latch=I1
Bit    15863    131    119 Block=P47 Latch=I2
Bit    15978    131      4 Block=P81 Latch=I2
Bit    15979    131      3 Block=P81 Latch=I1
Bit    15984    132    120 Block=P46 Latch=I2
Bit    15985    132    119 Block=P46 Latch=I1
Bit    16100    132      4 Block=P82 Latch=I1
Bit    16101    132      3 Block=P82 Latch=I2
Bit    18562    153    104 Block=CLB_R10C7 Latch=Y
Bit    18572    153     94 Block=CLB_R9C7 Latch=Y
Bit    18582    153     84 Block=CLB_R8C7 Latch=Y
Bit    18592    153     74 Block=CLB_R7C7 Latch=Y
Bit    18602    153     64 Block=CLB_R6C7 Latch=Y
Bit    18614    153     52 Block=CLB_R5C7 Latch=Y
Bit    18624    153     42 Block=CLB_R4C7 Latch=Y
Bit    18634    153     32 Block=CLB_R3C7 Latch=Y Net=ACC1_SUM_C12
Bit    18644    153     22 Block=CLB_R2C7 Latch=Y
Bit    18654    153     12 Block=CLB_R1C7 Latch=Y
Bit    19171    158    105 Block=CLB_R10C7 Latch=YQ
Bit    19181    158     95 Block=CLB_R9C7 Latch=YQ Net=N_Q3<1>
Bit    19191    158     85 Block=CLB_R8C7 Latch=YQ
Bit    19201    158     75 Block=CLB_R7C7 Latch=YQ
Bit    19211    158     65 Block=CLB_R6C7 Latch=YQ
Bit    19223    158     53 Block=CLB_R5C7 Latch=YQ
Bit    19233    158     43 Block=CLB_R4C7 Latch=YQ
Bit    19243    158     33 Block=CLB_R3C7 Latch=YQ
Bit    19253    158     23 Block=CLB_R2C7 Latch=YQ
Bit    19263    158     13 Block=CLB_R1C7 Latch=YQ
Bit    19660    162    104 Block=CLB_R10C7 Latch=X
Bit    19670    162     94 Block=CLB_R9C7 Latch=X
Bit    19680    162     84 Block=CLB_R8C7 Latch=X
Bit    19690    162     74 Block=CLB_R7C7 Latch=X
Bit    19700    162     64 Block=CLB_R6C7 Latch=X
Bit    19712    162     52 Block=CLB_R5C7 Latch=X
Bit    19722    162     42 Block=CLB_R4C7 Latch=X
Bit    19732    162     32 Block=CLB_R3C7 Latch=X Net=syn366
Bit    19742    162     22 Block=CLB_R2C7 Latch=X
Bit    19752    162     12 Block=CLB_R1C7 Latch=X
Bit    20132    166    120 Block=UNB47 Latch=OQ
Bit    20133    166    119 Block=UNB48 Latch=OQ
Bit    20147    166    105 Block=CLB_R10C7 Latch=XQ
Bit    20157    166     95 Block=CLB_R9C7 Latch=XQ Net=N_Q3<0>
Bit    20167    166     85 Block=CLB_R8C7 Latch=XQ
Bit    20177    166     75 Block=CLB_R7C7 Latch=XQ
Bit    20187    166     65 Block=CLB_R6C7 Latch=XQ
Bit    20199    166     53 Block=CLB_R5C7 Latch=XQ
Bit    20209    166     43 Block=CLB_R4C7 Latch=XQ
Bit    20219    166     33 Block=CLB_R3C7 Latch=XQ
Bit    20229    166     23 Block=CLB_R2C7 Latch=XQ
Bit    20239    166     13 Block=CLB_R1C7 Latch=XQ
Bit    20248    166      4 Block=UNB13 Latch=OQ
Bit    20249    166      3 Block=UNB14 Latch=OQ
Bit    20254    167    120 Block=UNB47 Latch=I1
Bit    20255    167    119 Block=UNB47 Latch=I2
Bit    20370    167      4 Block=UNB14 Latch=I2
Bit    20371    167      3 Block=UNB14 Latch=I1
Bit    20376    168    120 Block=UNB48 Latch=I2
Bit    20377    168    119 Block=UNB48 Latch=I1
Bit    20492    168      4 Block=UNB13 Latch=I1
Bit    20493    168      3 Block=UNB13 Latch=I2
Bit    22954    189    104 Block=CLB_R10C6 Latch=Y
Bit    22964    189     94 Block=CLB_R9C6 Latch=Y
Bit    22974    189     84 Block=CLB_R8C6 Latch=Y
Bit    22984    189     74 Block=CLB_R7C6 Latch=Y
Bit    22994    189     64 Block=CLB_R6C6 Latch=Y
Bit    23006    189     52 Block=CLB_R5C6 Latch=Y
Bit    23016    189     42 Block=CLB_R4C6 Latch=Y
Bit    23026    189     32 Block=CLB_R3C6 Latch=Y
Bit    23036    189     22 Block=CLB_R2C6 Latch=Y
Bit    23046    189     12 Block=CLB_R1C6 Latch=Y
Bit    23563    194    105 Block=CLB_R10C6 Latch=YQ
Bit    23573    194     95 Block=CLB_R9C6 Latch=YQ
Bit    23583    194     85 Block=CLB_R8C6 Latch=YQ
Bit    23593    194     75 Block=CLB_R7C6 Latch=YQ
Bit    23603    194     65 Block=CLB_R6C6 Latch=YQ
Bit    23615    194     53 Block=CLB_R5C6 Latch=YQ
Bit    23625    194     43 Block=CLB_R4C6 Latch=YQ Net=N_Q1<1>
Bit    23635    194     33 Block=CLB_R3C6 Latch=YQ Net=N_Q1<2>
Bit    23645    194     23 Block=CLB_R2C6 Latch=YQ
Bit    23655    194     13 Block=CLB_R1C6 Latch=YQ
Bit    24052    198    104 Block=CLB_R10C6 Latch=X
Bit    24062    198     94 Block=CLB_R9C6 Latch=X
Bit    24072    198     84 Block=CLB_R8C6 Latch=X
Bit    24082    198     74 Block=CLB_R7C6 Latch=X
Bit    24092    198     64 Block=CLB_R6C6 Latch=X
Bit    24104    198     52 Block=CLB_R5C6 Latch=X
Bit    24114    198     42 Block=CLB_R4C6 Latch=X
Bit    24124    198     32 Block=CLB_R3C6 Latch=X
Bit    24134    198     22 Block=CLB_R2C6 Latch=X
Bit    24144    198     12 Block=CLB_R1C6 Latch=X
Bit    24524    202    120 Block=P45 Latch=OQ
Bit    24525    202    119 Block=P44 Latch=OQ
Bit    24539    202    105 Block=CLB_R10C6 Latch=XQ
Bit    24549    202     95 Block=CLB_R9C6 Latch=XQ
Bit    24559    202     85 Block=CLB_R8C6 Latch=XQ
Bit    24569    202     75 Block=CLB_R7C6 Latch=XQ
Bit    24579    202     65 Block=CLB_R6C6 Latch=XQ
Bit    24591    202     53 Block=CLB_R5C6 Latch=XQ
Bit    24601    202     43 Block=CLB_R4C6 Latch=XQ Net=N_Q1<0>
Bit    24611    202     33 Block=CLB_R3C6 Latch=XQ Net=N_Q1<3>
Bit    24621    202     23 Block=CLB_R2C6 Latch=XQ
Bit    24631    202     13 Block=CLB_R1C6 Latch=XQ
Bit    24640    202      4 Block=P84 Latch=OQ
Bit    24641    202      3 Block=P83 Latch=OQ
Bit    24646    203    120 Block=P45 Latch=I1
Bit    24647    203    119 Block=P45 Latch=I2
Bit    24762    203      4 Block=P83 Latch=I2
Bit    24763    203      3 Block=P83 Latch=I1
Bit    24768    204    120 Block=P44 Latch=I2 Net=N_IL<0>
Bit    24769    204    119 Block=P44 Latch=I1
Bit    24884    204      4 Block=P84 Latch=I1
Bit    24885    204      3 Block=P84 Latch=I2 Net=N_IH<0>
Bit    27590    227    104 Block=CLB_R10C5 Latch=Y
Bit    27600    227     94 Block=CLB_R9C5 Latch=Y
Bit    27610    227     84 Block=CLB_R8C5 Latch=Y
Bit    27620    227     74 Block=CLB_R7C5 Latch=Y
Bit    27630    227     64 Block=CLB_R6C5 Latch=Y Net=C1
Bit    27642    227     52 Block=CLB_R5C5 Latch=Y
Bit    27652    227     42 Block=CLB_R4C5 Latch=Y Net=ACC1_SUM_N70
Bit    27662    227     32 Block=CLB_R3C5 Latch=Y Net=ACC1_SUM_N72
Bit    27672    227     22 Block=CLB_R2C5 Latch=Y Net=ACC1_SUM_N74
Bit    27682    227     12 Block=CLB_R1C5 Latch=Y
Bit    28199    232    105 Block=CLB_R10C5 Latch=YQ
Bit    28209    232     95 Block=CLB_R9C5 Latch=YQ
Bit    28219    232     85 Block=CLB_R8C5 Latch=YQ Net=N_Q0<0>
Bit    28229    232     75 Block=CLB_R7C5 Latch=YQ Net=N_Q0<2>
Bit    28239    232     65 Block=CLB_R6C5 Latch=YQ
Bit    28251    232     53 Block=CLB_R5C5 Latch=YQ
Bit    28261    232     43 Block=CLB_R4C5 Latch=YQ
Bit    28271    232     33 Block=CLB_R3C5 Latch=YQ
Bit    28281    232     23 Block=CLB_R2C5 Latch=YQ
Bit    28291    232     13 Block=CLB_R1C5 Latch=YQ
Bit    28688    236    104 Block=CLB_R10C5 Latch=X
Bit    28698    236     94 Block=CLB_R9C5 Latch=X
Bit    28708    236     84 Block=CLB_R8C5 Latch=X
Bit    28718    236     74 Block=CLB_R7C5 Latch=X
Bit    28728    236     64 Block=CLB_R6C5 Latch=X Net=syn387
Bit    28740    236     52 Block=CLB_R5C5 Latch=X
Bit    28750    236     42 Block=CLB_R4C5 Latch=X
Bit    28760    236     32 Block=CLB_R3C5 Latch=X Net=ACC1_SUM_N71
Bit    28770    236     22 Block=CLB_R2C5 Latch=X Net=ACC1_SUM_N73
Bit    28780    236     12 Block=CLB_R1C5 Latch=X
Bit    29160    240    120 Block=P41 Latch=OQ
Bit    29161    240    119 Block=P40 Latch=OQ
Bit    29175    240    105 Block=CLB_R10C5 Latch=XQ
Bit    29185    240     95 Block=CLB_R9C5 Latch=XQ
Bit    29195    240     85 Block=CLB_R8C5 Latch=XQ Net=N_Q0<1>
Bit    29205    240     75 Block=CLB_R7C5 Latch=XQ Net=N_Q0<3>
Bit    29215    240     65 Block=CLB_R6C5 Latch=XQ
Bit    29227    240     53 Block=CLB_R5C5 Latch=XQ
Bit    29237    240     43 Block=CLB_R4C5 Latch=XQ
Bit    29247    240     33 Block=CLB_R3C5 Latch=XQ
Bit    29257    240     23 Block=CLB_R2C5 Latch=XQ
Bit    29267    240     13 Block=CLB_R1C5 Latch=XQ
Bit    29276    240      4 Block=P4 Latch=OQ
Bit    29277    240      3 Block=P3 Latch=OQ
Bit    29282    241    120 Block=P41 Latch=I1
Bit    29283    241    119 Block=P41 Latch=I2 Net=N_IL<2>
Bit    29398    241      4 Block=P3 Latch=I2 Net=N_IH<2>
Bit    29399    241      3 Block=P3 Latch=I1
Bit    29404    242    120 Block=P40 Latch=I2
Bit    29405    242    119 Block=P40 Latch=I1
Bit    29520    242      4 Block=P4 Latch=I1 Net=N_IH<3>
Bit    29521    242      3 Block=P4 Latch=I2
Bit    31982    263    104 Block=CLB_R10C4 Latch=Y
Bit    31992    263     94 Block=CLB_R9C4 Latch=Y Net=ACC0_SUM_N70
Bit    32002    263     84 Block=CLB_R8C4 Latch=Y Net=ACC0_SUM_N72
Bit    32012    263     74 Block=CLB_R7C4 Latch=Y Net=ACC0_SUM_N74
Bit    32022    263     64 Block=CLB_R6C4 Latch=Y
Bit    32034    263     52 Block=CLB_R5C4 Latch=Y
Bit    32044    263     42 Block=CLB_R4C4 Latch=Y
Bit    32054    263     32 Block=CLB_R3C4 Latch=Y
Bit    32064    263     22 Block=CLB_R2C4 Latch=Y
Bit    32074    263     12 Block=CLB_R1C4 Latch=Y
Bit    32591    268    105 Block=CLB_R10C4 Latch=YQ
Bit    32601    268     95 Block=CLB_R9C4 Latch=YQ
Bit    32611    268     85 Block=CLB_R8C4 Latch=YQ
Bit    32621    268     75 Block=CLB_R7C4 Latch=YQ
Bit    32631    268     65 Block=CLB_R6C4 Latch=YQ
Bit    32643    268     53 Block=CLB_R5C4 Latch=YQ
Bit    32653    268     43 Block=CLB_R4C4 Latch=YQ
Bit    32663    268     33 Block=CLB_R3C4 Latch=YQ
Bit    32673    268     23 Block=CLB_R2C4 Latch=YQ
Bit    32683    268     13 Block=CLB_R1C4 Latch=YQ
Bit    33080    272    104 Block=CLB_R10C4 Latch=X
Bit    33090    272     94 Block=CLB_R9C4 Latch=X Net=GLOBAL_LOGIC0
Bit    33100    272     84 Block=CLB_R8C4 Latch=X Net=ACC0_SUM_N71
Bit    33110    272     74 Block=CLB_R7C4 Latch=X Net=ACC0_SUM_N73
Bit    33120    272     64 Block=CLB_R6C4 Latch=X
Bit    33132    272     52 Block=CLB_R5C4 Latch=X
Bit    33142    272     42 Block=CLB_R4C4 Latch=X
Bit    33152    272     32 Block=CLB_R3C4 Latch=X
Bit    33162    272     22 Block=CLB_R2C4 Latch=X
Bit    33172    272     12 Block=CLB_R1C4 Latch=X
Bit    33552    276    120 Block=UNB53 Latch=OQ
Bit    33553    276    119 Block=UNB54 Latch=OQ
Bit    33567    276    105 Block=CLB_R10C4 Latch=XQ
Bit    33577    276     95 Block=CLB_R9C4 Latch=XQ
Bit    33587    276     85 Block=CLB_R8C4 Latch=XQ
Bit    33597    276     75 Block=CLB_R7C4 Latch=XQ
Bit    33607    276     65 Block=CLB_R6C4 Latch=XQ
Bit    33619    276     53 Block=CLB_R5C4 Latch=XQ
Bit    33629    276     43 Block=CLB_R4C4 Latch=XQ
Bit    33639    276     33 Block=CLB_R3C4 Latch=XQ
Bit    33649    276     23 Block=CLB_R2C4 Latch=XQ
Bit    33659    276     13 Block=CLB_R1C4 Latch=XQ
Bit    33668    276      4 Block=UNB7 Latch=OQ
Bit    33669    276      3 Block=UNB8 Latch=OQ
Bit    33674    277    120 Block=UNB53 Latch=I1
Bit    33675    277    119 Block=UNB53 Latch=I2
Bit    33790    277      4 Block=UNB8 Latch=I2
Bit    33791    277      3 Block=UNB8 Latch=I1
Bit    33796    278    120 Block=UNB54 Latch=I2
Bit    33797    278    119 Block=UNB54 Latch=I1
Bit    33912    278      4 Block=UNB7 Latch=I1
Bit    33913    278      3 Block=UNB7 Latch=I2
Bit    36374    299    104 Block=CLB_R10C3 Latch=Y
Bit    36384    299     94 Block=CLB_R9C3 Latch=Y
Bit    36394    299     84 Block=CLB_R8C3 Latch=Y
Bit    36404    299     74 Block=CLB_R7C3 Latch=Y
Bit    36414    299     64 Block=CLB_R6C3 Latch=Y
Bit    36426    299     52 Block=CLB_R5C3 Latch=Y
Bit    36436    299     42 Block=CLB_R4C3 Latch=Y
Bit    36446    299     32 Block=CLB_R3C3 Latch=Y
Bit    36456    299     22 Block=CLB_R2C3 Latch=Y
Bit    36466    299     12 Block=CLB_R1C3 Latch=Y
Bit    36983    304    105 Block=CLB_R10C3 Latch=YQ
Bit    36993    304     95 Block=CLB_R9C3 Latch=YQ
Bit    37003    304     85 Block=CLB_R8C3 Latch=YQ
Bit    37013    304     75 Block=CLB_R7C3 Latch=YQ
Bit    37023    304     65 Block=CLB_R6C3 Latch=YQ
Bit    37035    304     53 Block=CLB_R5C3 Latch=YQ
Bit    37045    304     43 Block=CLB_R4C3 Latch=YQ
Bit    37055    304     33 Block=CLB_R3C3 Latch=YQ
Bit    37065    304     23 Block=CLB_R2C3 Latch=YQ
Bit    37075    304     13 Block=CLB_R1C3 Latch=YQ
Bit    37472    308    104 Block=CLB_R10C3 Latch=X
Bit    37482    308     94 Block=CLB_R9C3 Latch=X
Bit    37492    308     84 Block=CLB_R8C3 Latch=X
Bit    37502    308     74 Block=CLB_R7C3 Latch=X
Bit    37512    308     64 Block=CLB_R6C3 Latch=X
Bit    37524    308     52 Block=CLB_R5C3 Latch=X
Bit    37534    308     42 Block=CLB_R4C3 Latch=X
Bit    37544    308     32 Block=CLB_R3C3 Latch=X
Bit    37554    308     22 Block=CLB_R2C3 Latch=X
Bit    37564    308     12 Block=CLB_R1C3 Latch=X
Bit    37944    312    120 Block=P39 Latch=OQ
Bit    37945    312    119 Block=P38 Latch=OQ
Bit    37959    312    105 Block=CLB_R10C3 Latch=XQ
Bit    37969    312     95 Block=CLB_R9C3 Latch=XQ
Bit    37979    312     85 Block=CLB_R8C3 Latch=XQ
Bit    37989    312     75 Block=CLB_R7C3 Latch=XQ
Bit    37999    312     65 Block=CLB_R6C3 Latch=XQ
Bit    38011    312     53 Block=CLB_R5C3 Latch=XQ
Bit    38021    312     43 Block=CLB_R4C3 Latch=XQ
Bit    38031    312     33 Block=CLB_R3C3 Latch=XQ
Bit    38041    312     23 Block=CLB_R2C3 Latch=XQ
Bit    38051    312     13 Block=CLB_R1C3 Latch=XQ
Bit    38060    312      4 Block=P6 Latch=OQ
Bit    38061    312      3 Block=P5 Latch=OQ
Bit    38066    313    120 Block=P39 Latch=I1
Bit    38067    313    119 Block=P39 Latch=I2 Net=N_IL<1>
Bit    38182    313      4 Block=P5 Latch=I2
Bit    38183    313      3 Block=P5 Latch=I1
Bit    38188    314    120 Block=P38 Latch=I2
Bit    38189    314    119 Block=P38 Latch=I1
Bit    38304    314      4 Block=P6 Latch=I1
Bit    38305    314      3 Block=P6 Latch=I2
Bit    40766    335    104 Block=CLB_R10C2 Latch=Y
Bit    40776    335     94 Block=CLB_R9C2 Latch=Y
Bit    40786    335     84 Block=CLB_R8C2 Latch=Y
Bit    40796    335     74 Block=CLB_R7C2 Latch=Y
Bit    40806    335     64 Block=CLB_R6C2 Latch=Y
Bit    40818    335     52 Block=CLB_R5C2 Latch=Y
Bit    40828    335     42 Block=CLB_R4C2 Latch=Y
Bit    40838    335     32 Block=CLB_R3C2 Latch=Y
Bit    40848    335     22 Block=CLB_R2C2 Latch=Y
Bit    40858    335     12 Block=CLB_R1C2 Latch=Y
Bit    41375    340    105 Block=CLB_R10C2 Latch=YQ
Bit    41385    340     95 Block=CLB_R9C2 Latch=YQ
Bit    41395    340     85 Block=CLB_R8C2 Latch=YQ
Bit    41405    340     75 Block=CLB_R7C2 Latch=YQ
Bit    41415    340     65 Block=CLB_R6C2 Latch=YQ
Bit    41427    340     53 Block=CLB_R5C2 Latch=YQ
Bit    41437    340     43 Block=CLB_R4C2 Latch=YQ
Bit    41447    340     33 Block=CLB_R3C2 Latch=YQ
Bit    41457    340     23 Block=CLB_R2C2 Latch=YQ
Bit    41467    340     13 Block=CLB_R1C2 Latch=YQ
Bit    41864    344    104 Block=CLB_R10C2 Latch=X
Bit    41874    344     94 Block=CLB_R9C2 Latch=X
Bit    41884    344     84 Block=CLB_R8C2 Latch=X
Bit    41894    344     74 Block=CLB_R7C2 Latch=X
Bit    41904    344     64 Block=CLB_R6C2 Latch=X
Bit    41916    344     52 Block=CLB_R5C2 Latch=X
Bit    41926    344     42 Block=CLB_R4C2 Latch=X
Bit    41936    344     32 Block=CLB_R3C2 Latch=X
Bit    41946    344     22 Block=CLB_R2C2 Latch=X
Bit    41956    344     12 Block=CLB_R1C2 Latch=X
Bit    42336    348    120 Block=P37 Latch=OQ
Bit    42337    348    119 Block=UNB58 Latch=OQ
Bit    42351    348    105 Block=CLB_R10C2 Latch=XQ
Bit    42361    348     95 Block=CLB_R9C2 Latch=XQ
Bit    42371    348     85 Block=CLB_R8C2 Latch=XQ
Bit    42381    348     75 Block=CLB_R7C2 Latch=XQ
Bit    42391    348     65 Block=CLB_R6C2 Latch=XQ
Bit    42403    348     53 Block=CLB_R5C2 Latch=XQ
Bit    42413    348     43 Block=CLB_R4C2 Latch=XQ
Bit    42423    348     33 Block=CLB_R3C2 Latch=XQ
Bit    42433    348     23 Block=CLB_R2C2 Latch=XQ
Bit    42443    348     13 Block=CLB_R1C2 Latch=XQ
Bit    42452    348      4 Block=P8 Latch=OQ
Bit    42453    348      3 Block=P7 Latch=OQ
Bit    42458    349    120 Block=P37 Latch=I1
Bit    42459    349    119 Block=P37 Latch=I2
Bit    42574    349      4 Block=P7 Latch=I2
Bit    42575    349      3 Block=P7 Latch=I1
Bit    42580    350    120 Block=UNB58 Latch=I2
Bit    42581    350    119 Block=UNB58 Latch=I1
Bit    42696    350      4 Block=P8 Latch=I1
Bit    42697    350      3 Block=P8 Latch=I2
Bit    45158    371    104 Block=CLB_R10C1 Latch=Y
Bit    45168    371     94 Block=CLB_R9C1 Latch=Y
Bit    45178    371     84 Block=CLB_R8C1 Latch=Y
Bit    45188    371     74 Block=CLB_R7C1 Latch=Y
Bit    45198    371     64 Block=CLB_R6C1 Latch=Y
Bit    45210    371     52 Block=CLB_R5C1 Latch=Y
Bit    45220    371     42 Block=CLB_R4C1 Latch=Y
Bit    45230    371     32 Block=CLB_R3C1 Latch=Y
Bit    45240    371     22 Block=CLB_R2C1 Latch=Y
Bit    45250    371     12 Block=CLB_R1C1 Latch=Y
Bit    45767    376    105 Block=CLB_R10C1 Latch=YQ
Bit    45777    376     95 Block=CLB_R9C1 Latch=YQ
Bit    45787    376     85 Block=CLB_R8C1 Latch=YQ
Bit    45797    376     75 Block=CLB_R7C1 Latch=YQ
Bit    45807    376     65 Block=CLB_R6C1 Latch=YQ
Bit    45819    376     53 Block=CLB_R5C1 Latch=YQ
Bit    45829    376     43 Block=CLB_R4C1 Latch=YQ
Bit    45839    376     33 Block=CLB_R3C1 Latch=YQ
Bit    45849    376     23 Block=CLB_R2C1 Latch=YQ
Bit    45859    376     13 Block=CLB_R1C1 Latch=YQ
Bit    46256    380    104 Block=CLB_R10C1 Latch=X
Bit    46266    380     94 Block=CLB_R9C1 Latch=X
Bit    46276    380     84 Block=CLB_R8C1 Latch=X
Bit    46286    380     74 Block=CLB_R7C1 Latch=X
Bit    46296    380     64 Block=CLB_R6C1 Latch=X
Bit    46308    380     52 Block=CLB_R5C1 Latch=X
Bit    46318    380     42 Block=CLB_R4C1 Latch=X
Bit    46328    380     32 Block=CLB_R3C1 Latch=X
Bit    46338    380     22 Block=CLB_R2C1 Latch=X
Bit    46348    380     12 Block=CLB_R1C1 Latch=X
Bit    46728    384    120 Block=P36 Latch=OQ
Bit    46729    384    119 Block=P35 Latch=OQ
Bit    46743    384    105 Block=CLB_R10C1 Latch=XQ
Bit    46753    384     95 Block=CLB_R9C1 Latch=XQ
Bit    46763    384     85 Block=CLB_R8C1 Latch=XQ
Bit    46773    384     75 Block=CLB_R7C1 Latch=XQ
Bit    46783    384     65 Block=CLB_R6C1 Latch=XQ
Bit    46795    384     53 Block=CLB_R5C1 Latch=XQ
Bit    46805    384     43 Block=CLB_R4C1 Latch=XQ
Bit    46815    384     33 Block=CLB_R3C1 Latch=XQ
Bit    46825    384     23 Block=CLB_R2C1 Latch=XQ
Bit    46835    384     13 Block=CLB_R1C1 Latch=XQ
Bit    46844    384      4 Block=P10 Latch=OQ
Bit    46845    384      3 Block=P9 Latch=OQ
Bit    46850    385    120 Block=P36 Latch=I1
Bit    46851    385    119 Block=P36 Latch=I2
Bit    46966    385      4 Block=P9 Latch=I2
Bit    46967    385      3 Block=P9 Latch=I1
Bit    46972    386    120 Block=P35 Latch=I2
Bit    46973    386    119 Block=P35 Latch=I1
Bit    47088    386      4 Block=P10 Latch=I1
Bit    47089    386      3 Block=P10 Latch=I2
Bit    51744    425    106 Block=P29 Latch=I1
Bit    51754    425     96 Block=UNB63 Latch=I1
Bit    51764    425     86 Block=P26 Latch=I1
Bit    51774    425     76 Block=UNB67 Latch=I1
Bit    51784    425     66 Block=P24 Latch=I1
Bit    51796    425     54 Block=P20 Latch=I1
Bit    51806    425     44 Block=UNB73 Latch=I1
Bit    51816    425     34 Block=P18 Latch=I1
Bit    51826    425     24 Block=P16 Latch=I1
Bit    51836    425     14 Block=P14 Latch=I1
Bit    51866    426    106 Block=P29 Latch=I2
Bit    51871    426    101 Block=P28 Latch=OQ
Bit    51876    426     96 Block=UNB63 Latch=I2
Bit    51881    426     91 Block=P27 Latch=OQ
Bit    51886    426     86 Block=P26 Latch=I2
Bit    51891    426     81 Block=P25 Latch=OQ
Bit    51896    426     76 Block=UNB67 Latch=I2
Bit    51901    426     71 Block=UNB68 Latch=OQ
Bit    51906    426     66 Block=P24 Latch=I2
Bit    51911    426     61 Block=P23 Latch=OQ
Bit    51918    426     54 Block=P20 Latch=I2
Bit    51923    426     49 Block=P19 Latch=OQ
Bit    51928    426     44 Block=UNB73 Latch=I2
Bit    51933    426     39 Block=UNB74 Latch=OQ
Bit    51938    426     34 Block=P18 Latch=I2
Bit    51943    426     29 Block=P17 Latch=OQ
Bit    51948    426     24 Block=P16 Latch=I2
Bit    51953    426     19 Block=P15 Latch=OQ
Bit    51958    426     14 Block=P14 Latch=I2
Bit    51963    426      9 Block=P13 Latch=OQ
Bit    51987    427    107 Block=P29 Latch=OQ
Bit    51993    427    101 Block=P28 Latch=I2
Bit    51997    427     97 Block=UNB63 Latch=OQ
Bit    52003    427     91 Block=P27 Latch=I2
Bit    52007    427     87 Block=P26 Latch=OQ
Bit    52013    427     81 Block=P25 Latch=I2
Bit    52017    427     77 Block=UNB67 Latch=OQ
Bit    52023    427     71 Block=UNB68 Latch=I2
Bit    52027    427     67 Block=P24 Latch=OQ
Bit    52033    427     61 Block=P23 Latch=I2
Bit    52039    427     55 Block=P20 Latch=OQ
Bit    52045    427     49 Block=P19 Latch=I2
Bit    52049    427     45 Block=UNB73 Latch=OQ
Bit    52055    427     39 Block=UNB74 Latch=I2
Bit    52059    427     35 Block=P18 Latch=OQ
Bit    52065    427     29 Block=P17 Latch=I2
Bit    52069    427     25 Block=P16 Latch=OQ
Bit    52075    427     19 Block=P15 Latch=I2
Bit    52079    427     15 Block=P14 Latch=OQ
Bit    52085    427      9 Block=P13 Latch=I2
Bit    52237    429    101 Block=P28 Latch=I1
Bit    52247    429     91 Block=P27 Latch=I1 Net=N_IL<3>
Bit    52257    429     81 Block=P25 Latch=I1
Bit    52267    429     71 Block=UNB68 Latch=I1
Bit    52277    429     61 Block=P23 Latch=I1
Bit    52289    429     49 Block=P19 Latch=I1 Net=N_IH<1>
Bit    52299    429     39 Block=UNB74 Latch=I1
Bit    52309    429     29 Block=P17 Latch=I1
Bit    52319    429     19 Block=P15 Latch=I1
Bit    52329    429      9 Block=P13 Latch=I1
Info ReadCaptureEnabled=1
Info STARTSEL0=1
