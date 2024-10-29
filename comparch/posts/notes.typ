== Arithmetic/Logic instructions

"easy": two operands or one operand and a constant (immediate)

like `sll`, `add`, `xor`, `slt`, etc.

because immediate are limited in terms of space, we can use a register with `lui` (12 bits), then `addiu` (add unsigned) and `xor` to copy

== Assembler directives

Like `.text`, `.data`, `.asciiz`..

== Functions

`jal x1, sqrt` --> leaves `PC+4` into the `x1` register so the funtion can callback `x1` with a simple `jr x1` when finishing.

With RISCV we can simply use `jal offset` and `ret` instead of specifying the register `x1`.

#pagebreak()

== Stack Pointer

#image("sp_alloc.png")
#image("sp_inst.png")

#pagebreak()

== Passing Arguments

#image("passing_arg.png")

== Little/Big Endian

#image("little.png")

Little endian is used by RISCV and is cool because when using:
if `t0 = 1`:
```yasm
sw t0, 0(t1)
```
writes the same in memory as:
```yasm
sb t0, 0(t1)
```
!
