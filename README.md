# Notes BA3 Simon

Mes notes du semestre 3 de bachelor informatique à l'EPFL.

## Électromagnétisme

* Notes : [PDF](./electromag/resume.pdf)
* Formulaire Midterm : [PDF](./electromag/formulaire%20midterm%20electromag.pdf)

## État et droits humains (SHS)

* Notes : [PDF](./shs/notes.pdf)
* Constitution Fédérale : [PDF](./shs/constitution-federale.pdf)

## Probability and Statistics

* Notes (résumé) : [PDF](./probastats/resume.pdf)
* Notes (distributions) : [PDF](./probastats/distributions.pdf)
* Morris (book) : [PDF](./probastats/Morris_H_DeGroot_Mark_J_Schervish_Probability_and_statistics_Pearson.pdf)

## Software Construction

* Notes (midterm) : [PDF](./softcon/midterm.pdf)
* Notes (final) : [PDF](./softcon/final.pdf)
* Exercises : [PDF](./softcon/exercises/)

## Computer Architecture

* Notes : [PDF](./comparch/resume.pdf)

### Setup the RISC-V Toolchain

* Download `riscv.zip` file from [here](https://github.com/simon-epfl/prebuilt-binaries-riscv-toolchain/blob/main/riscv.zip).
* Extract the contents so the `opt/riscv` directory is located in `/opt/riscv` in your computer.
* Run the debugger and see if it is showing the memory preview.

### Setup Verilator

If verilator can not be built on your computer, you can use the docker image:
```bash
sudo docker run -ti -v ${PWD}:/work --user root:root \ 
verilator/verilator:latest --timescale 1ns/1ns --top-module tb \
--cc --exe --binary --timing --trace --trace-underscore -O2 lu.sv tb.sv
```

### Setup Verible Verilog Linter

If you can not build verible on your computer, you can use my docker image:
```bash
sudo docker run -ti -v ${PWD}:/work --user root:root androz2091/verible:sha-2195809 verible-verilog-lint
```
