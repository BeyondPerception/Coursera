@17
D = A
@SP
A = M
M = D
@SP
M = M + 1
@17
D = A
@SP
A = M
M = D
@SP
M = M + 1
@SP
M = M - 1
A = M
D = M
A = A - 1
D = D - M
@EQ0
D;JEQ
@0
D = A
@SP
A = M - 1
M = D
@SKIPEQ0
0;JMP
(EQ0)
@1
D = A
@SP
A = M - 1
M = -D
(SKIPEQ0)
@17
D = A
@SP
A = M
M = D
@SP
M = M + 1
@16
D = A
@SP
A = M
M = D
@SP
M = M + 1
@SP
M = M - 1
A = M
D = M
A = A - 1
D = D - M
@EQ1
D;JEQ
@0
D = A
@SP
A = M - 1
M = D
@SKIPEQ1
0;JMP
(EQ1)
@1
D = A
@SP
A = M - 1
M = -D
(SKIPEQ1)
@16
D = A
@SP
A = M
M = D
@SP
M = M + 1
@17
D = A
@SP
A = M
M = D
@SP
M = M + 1
@SP
M = M - 1
A = M
D = M
A = A - 1
D = D - M
@EQ2
D;JEQ
@0
D = A
@SP
A = M - 1
M = D
@SKIPEQ2
0;JMP
(EQ2)
@1
D = A
@SP
A = M - 1
M = -D
(SKIPEQ2)
@892
D = A
@SP
A = M
M = D
@SP
M = M + 1
@891
D = A
@SP
A = M
M = D
@SP
M = M + 1
@SP
M = M - 1
A = M
D = M
A = A - 1
D = D - M
@LT0
D;JGT
@0
D = A
@SP
A = M - 1
M = D
@SKIPLT0
0;JMP
(LT0)
@1
D = A
@SP
A = M - 1
M = -D
(SKIPLT0)
@891
D = A
@SP
A = M
M = D
@SP
M = M + 1
@892
D = A
@SP
A = M
M = D
@SP
M = M + 1
@SP
M = M - 1
A = M
D = M
A = A - 1
D = D - M
@LT1
D;JGT
@0
D = A
@SP
A = M - 1
M = D
@SKIPLT1
0;JMP
(LT1)
@1
D = A
@SP
A = M - 1
M = -D
(SKIPLT1)
@891
D = A
@SP
A = M
M = D
@SP
M = M + 1
@891
D = A
@SP
A = M
M = D
@SP
M = M + 1
@SP
M = M - 1
A = M
D = M
A = A - 1
D = D - M
@LT2
D;JGT
@0
D = A
@SP
A = M - 1
M = D
@SKIPLT2
0;JMP
(LT2)
@1
D = A
@SP
A = M - 1
M = -D
(SKIPLT2)
@32767
D = A
@SP
A = M
M = D
@SP
M = M + 1
@32766
D = A
@SP
A = M
M = D
@SP
M = M + 1
@SP
M = M - 1
A = M
D = M
A = A - 1
D = M - D
@GT0
D;JGT
@0
D = A
@SP
A = M - 1
M = D
@SKIPGT0
0;JMP
(GT0)
@1
D = A
@SP
A = M - 1
M = -D
(SKIPGT0)
@32766
D = A
@SP
A = M
M = D
@SP
M = M + 1
@32767
D = A
@SP
A = M
M = D
@SP
M = M + 1
@SP
M = M - 1
A = M
D = M
A = A - 1
D = M - D
@GT1
D;JGT
@0
D = A
@SP
A = M - 1
M = D
@SKIPGT1
0;JMP
(GT1)
@1
D = A
@SP
A = M - 1
M = -D
(SKIPGT1)
@32766
D = A
@SP
A = M
M = D
@SP
M = M + 1
@32766
D = A
@SP
A = M
M = D
@SP
M = M + 1
@SP
M = M - 1
A = M
D = M
A = A - 1
D = M - D
@GT2
D;JGT
@0
D = A
@SP
A = M - 1
M = D
@SKIPGT2
0;JMP
(GT2)
@1
D = A
@SP
A = M - 1
M = -D
(SKIPGT2)
@57
D = A
@SP
A = M
M = D
@SP
M = M + 1
@31
D = A
@SP
A = M
M = D
@SP
M = M + 1
@53
D = A
@SP
A = M
M = D
@SP
M = M + 1
@SP
A=M
A=A-1
A=A-1
D=M
A=A+1
D=D+M
@SP
M=M-1
M=M-1
A=M
M=D
@SP
M=M+1
@112
D = A
@SP
A = M
M = D
@SP
M = M + 1
@SP
A=M
A=A-1
A=A-1
D=M
A=A+1
D=D-M
@SP
M=M-1
M=M-1
A=M
M=D
@SP
M=M+1
@SP
A = M
A = A - 1
M = -M
@SP
M = M - 1
A = M
D = M
A = A - 1
M = D&M
@82
D = A
@SP
A = M
M = D
@SP
M = M + 1
@SP
M = M - 1
A = M
D = M
A = A - 1
M = D|M
@SP
A = M
A = A - 1
M = !M
