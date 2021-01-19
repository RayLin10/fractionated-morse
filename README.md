# Fractionated Morse Cipher

## Directions
Clone the Repository
```
$ git clone https://github.com/RayLin10/fractionatedMorse
```

Use Make to Run the Code
```
$ make run ARGS="[zero] [one] [two] [three]"
[zero] = encode/decode
[one] = key
[two] = plaintext/ciphertext *Use '' if your plaintext has space(s)*
[three] = verbose *Optional*
```

Examples
```
$ make run ARGS="encode KQIVPABOSGYTDJZHFXCWERMLUN 'SEMESTER IS ALMOST OVER.'"
Input: SEMESTER IS ALMOST OVER.
Key: KQIVPABOSGYTDJZHFXCWERMLUN
Morse: ...x.x--x.x...x-x.x.-.xx..x...xx.-x.-..x--x---x...x-xx---x...-x.x.-.x.-.-.-
Ciphertext: KEZBIHWSIKUHGMMHIXJCABTVY
```
```
$ make run ARGS="decode KQIVPABOSGYTDJZHFXCWERMLUN KEZBIHWSIKUHGMMHIXJCABTVY"
Input: KEZBIHWSIKUHGMMHIXJCABTVY
Key: KQIVPABOSGYTDJZHFXCWERMLUN
Morse: ...x.x--x.x...x-x.x.-.xx..x...xx.-x.-..x--x---x...x-xx---x...-x.x.-.x.-.-.-
Plaintext: SEMESTER IS ALMOST OVER.
```

Verbose Examples
```
$ make run ARGS="encode KQIVPABOSGYTDJZHFXCWERMLUN 'A TEST' verbose"
Input: A TEST
Key: KQIVPABOSGYTDJZHFXCWERMLUN
----------------------------------------------------------------------------------------------------
K | "..."
Q | "..-"
I | "..x"
V | ".-."
P | ".--"
A | ".-x"
B | ".x."
O | ".x-"
S | ".xx"
G | "-.."
Y | "-.-"
T | "-.x"
D | "--."
J | "---"
Z | "--x"
H | "-x."
F | "-x-"
X | "-xx"
C | "x.."
W | "x.-"
E | "x.x"
R | "x-."
M | "x--"
L | "x-x"
U | "xx."
N | "xx-"
----------------------------------------------------------------------------------------------------
A -> ".-"
Current Morse: .-x
T -> "-"
Current Morse: .-xx-x
E -> "."
Current Morse: .-xx-x.x
S -> "..."
Current Morse: .-xx-x.x...x
T -> "-"
Current Morse: .-xx-x.x...x-
----------------------------------------------------------------------------------------------------
Morse: .-xx-x.x...x-xx
----------------------------------------------------------------------------------------------------
".-x" -> A
Current Ciphertext: A
"x-x" -> L
Current Ciphertext: AL
".x." -> B
Current Ciphertext: ALB
"..x" -> I
Current Ciphertext: ALBI
"-xx" -> X
Current Ciphertext: ALBIX
----------------------------------------------------------------------------------------------------
Ciphertext: ALBIX
```
```
$ make run ARGS="decode KQIVPABOSGYTDJZHFXCWERMLUN ALBIX verbose"
Input: ALBIX
Key: KQIVPABOSGYTDJZHFXCWERMLUN
----------------------------------------------------------------------------------------------------
K | "..."
Q | "..-"
I | "..x"
V | ".-."
P | ".--"
A | ".-x"
B | ".x."
O | ".x-"
S | ".xx"
G | "-.."
Y | "-.-"
T | "-.x"
D | "--."
J | "---"
Z | "--x"
H | "-x."
F | "-x-"
X | "-xx"
C | "x.."
W | "x.-"
E | "x.x"
R | "x-."
M | "x--"
L | "x-x"
U | "xx."
N | "xx-"
----------------------------------------------------------------------------------------------------
A -> ".-x"
Current Morse: .-x
L -> "x-x"
Current Morse: .-xx-x
B -> ".x."
Current Morse: .-xx-x.x.
I -> "..x"
Current Morse: .-xx-x.x...x
X -> "-xx"
Current Morse: .-xx-x.x...x-xx
----------------------------------------------------------------------------------------------------
Morse: .-xx-x.x...x-xx
----------------------------------------------------------------------------------------------------
".-" -> A
Current Plaintext: A
"-" -> T
Current Plaintext: A T
"." -> E
Current Plaintext: A TE
"..." -> S
Current Plaintext: A TES
"-" -> T
Current Plaintext: A TEST
----------------------------------------------------------------------------------------------------
Plaintext: A TEST
```

**Important**

The code does not check to make sure that your key or plaintext/ciphertext are valid.
Your results will not be correct if your key is not 26 letters long or if your key is not a mixed alphabet.
Also, make sure that your input is valid which means there should be no extra spaces between words or at the beginning or end.
