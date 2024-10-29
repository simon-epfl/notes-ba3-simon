# Notes BA3 Simon

## Electromag

* Notes : [PDF](./electromag/resume.pdf)
* Formulaire Midterm : [PDF](./electromag/formulaire%20midterm%20electromag.pdf)

## SHS

* Notes : [PDF](./shs/notes.pdf)
* Constitution Fédérale : [PDF](./shs/constitution-federale.pdf)

## Probastats

* Notes : [PDF](./probastats/resume.pdf)
* Morris (book) : [PDF](./probastats/Morris_H_DeGroot_Mark_J_Schervish_Probability_and_statistics_Pearson.pdf)

## Softcon

* Notes (midterm) : [PDF](./softcon/midterm.pdf)
* Exercises : [PDF](./softcon/exercises/)

## Comparch

* Notes : [PDF](./comparch/resume.pdf)

### Setup the RISC-V Toolchain

* Download `riscv.zip` file from [here](https://cloud.androz2091.fr/api/public/dl/hz3QQc0o/risc.zip).
* Extract the contents so the `opt/riscv` directory is located in `/opt/riscv` in your computer.
* Run the debugger and see if it is showing the memory preview.

### Setup Verilator

If verilator can not be built on your computer, you can use the docker image:
```bash
sudo docker run -ti -v ${PWD}:/work --user root:root verilator/verilator:latest --timescale 1ns/1ns --top-module tb --cc --exe --binary --timing --trace --trace-underscore -O2 lu.sv tb.sv
```
