@256
D=A
@SP
M=D

@RETURN_LABEL0
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@0
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.init
0;JMP
(RETURN_LABEL0)
(Class1.set)
@0
D = A
@ARG
M = M + D
A = M
D = M
@SP
A = M
M = D
@SP
M = M + 1
@0
D = A
@ARG
M = M - D
@SP
M = M - 1
A = M
D = M
@Class1.vm.0
M = D
@1
D = A
@ARG
M = M + D
A = M
D = M
@SP
A = M
M = D
@SP
M = M + 1
@1
D = A
@ARG
M = M - D
@SP
M = M - 1
A = M
D = M
@Class1.vm.1
M = D
@0
D = A
@SP
A = M
M = D
@SP
M = M + 1
@LCL
D = M
@R11
M = D
@5
A = D - A
D = M
@R12
M = D
@ARG
D = M
@0
D = D + A
@R13
M = D
@SP
AM = M - 1
D = M
@R13
A = M
M = D
@ARG
D = M
@SP
M = D + 1
@R11
D = M - 1
AM = D
D = M
@THAT
M = D
@R11
D = M - 1
AM = D
D = M
@THIS
M = D
@R11
D = M - 1
AM = D
D = M
@ARG
M = D
@R11
D = M - 1
AM = D
D = M
@LCL
M = D
@R12
A = M
0;JMP
(Class1.get)
@Class1.vm.0
D = M
@SP
A = M
M = D
@SP
M = M + 1
@Class1.vm.1
D = M
@SP
A = M
M = D
@SP
M = M + 1
@SP
A = M
A = A - 1
A = A - 1
D = M
A = A + 1
D = D - M
@SP
M = M - 1
M = M - 1
A = M
M = D
@SP
M = M + 1
@LCL
D = M
@R11
M = D
@5
A = D - A
D = M
@R12
M = D
@ARG
D = M
@0
D = D + A
@R13
M = D
@SP
AM = M - 1
D = M
@R13
A = M
M = D
@ARG
D = M
@SP
M = D + 1
@R11
D = M - 1
AM = D
D = M
@THAT
M = D
@R11
D = M - 1
AM = D
D = M
@THIS
M = D
@R11
D = M - 1
AM = D
D = M
@ARG
M = D
@R11
D = M - 1
AM = D
D = M
@LCL
M = D
@R12
A = M
0;JMP
(Class2.set)
@0
D = A
@ARG
M = M + D
A = M
D = M
@SP
A = M
M = D
@SP
M = M + 1
@0
D = A
@ARG
M = M - D
@SP
M = M - 1
A = M
D = M
@Class2.vm.0
M = D
@1
D = A
@ARG
M = M + D
A = M
D = M
@SP
A = M
M = D
@SP
M = M + 1
@1
D = A
@ARG
M = M - D
@SP
M = M - 1
A = M
D = M
@Class2.vm.1
M = D
@0
D = A
@SP
A = M
M = D
@SP
M = M + 1
@LCL
D = M
@R11
M = D
@5
A = D - A
D = M
@R12
M = D
@ARG
D = M
@0
D = D + A
@R13
M = D
@SP
AM = M - 1
D = M
@R13
A = M
M = D
@ARG
D = M
@SP
M = D + 1
@R11
D = M - 1
AM = D
D = M
@THAT
M = D
@R11
D = M - 1
AM = D
D = M
@THIS
M = D
@R11
D = M - 1
AM = D
D = M
@ARG
M = D
@R11
D = M - 1
AM = D
D = M
@LCL
M = D
@R12
A = M
0;JMP
(Class2.get)
@Class2.vm.0
D = M
@SP
A = M
M = D
@SP
M = M + 1
@Class2.vm.1
D = M
@SP
A = M
M = D
@SP
M = M + 1
@SP
A = M
A = A - 1
A = A - 1
D = M
A = A + 1
D = D - M
@SP
M = M - 1
M = M - 1
A = M
M = D
@SP
M = M + 1
@LCL
D = M
@R11
M = D
@5
A = D - A
D = M
@R12
M = D
@ARG
D = M
@0
D = D + A
@R13
M = D
@SP
AM = M - 1
D = M
@R13
A = M
M = D
@ARG
D = M
@SP
M = D + 1
@R11
D = M - 1
AM = D
D = M
@THAT
M = D
@R11
D = M - 1
AM = D
D = M
@THIS
M = D
@R11
D = M - 1
AM = D
D = M
@ARG
M = D
@R11
D = M - 1
AM = D
D = M
@LCL
M = D
@R12
A = M
0;JMP
(Sys.init)
@6
D = A
@SP
A = M
M = D
@SP
M = M + 1
@8
D = A
@SP
A = M
M = D
@SP
M = M + 1
@RETURN_LABEL1
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@2
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Class1.set
0;JMP
(RETURN_LABEL1)
@SP
M = M - 1
A = M
D = M
@5
M = D
@23
D = A
@SP
A = M
M = D
@SP
M = M + 1
@15
D = A
@SP
A = M
M = D
@SP
M = M + 1
@RETURN_LABEL2
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@2
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Class2.set
0;JMP
(RETURN_LABEL2)
@SP
M = M - 1
A = M
D = M
@5
M = D
@RETURN_LABEL3
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@0
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Class1.get
0;JMP
(RETURN_LABEL3)
@RETURN_LABEL4
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@0
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Class2.get
0;JMP
(RETURN_LABEL4)
(WHILE)
@WHILE
0;JMP
