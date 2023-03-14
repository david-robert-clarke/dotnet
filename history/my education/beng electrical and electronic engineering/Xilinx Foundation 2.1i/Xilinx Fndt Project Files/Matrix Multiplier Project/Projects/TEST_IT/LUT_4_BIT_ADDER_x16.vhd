

Entity LUT_multiplier is
	Port (A, B : in std_logic_vector (1 downto 0); Z : out std_logic_vector (3 downto 0));
End Entity LUT_multiplier;

Begin

ADD15 : LUTPort MAP (A, B : in std_logic_vector (1 downto 0); Z : out std_logic_vector (3 downto 0));

