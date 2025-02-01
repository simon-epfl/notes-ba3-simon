# Notes BA3 Simon

Mes notes du semestre 3 de bachelor informatique à l'EPFL.

Pour contribuer ou modifier les fichiers de notes : les `.typ` peuvent être compilés directement avec Typst. Les fichiers `.md` sont à ouvrir avec Obsidian et le plugin Wypst (pour le support de Typst).

## Analyse III

* Notes de cours : [PDF](./analyseiii/Notes_Analyse_III_Simon.pdf)
* Formulaire examen final : [PDF](./analyseiii/Formulaire_Analyse_III_Simon.pdf)

## Électromagnétisme

* Formulaire examen final : [PDF](./electromag/Formulaire_Final_Electromagnetisme_Simon.pdf)
* Formulaire examen de mi-semestre : [PDF](./electromag/Formulaire_Midterm_Electromagnetisme_Simon.pdf)
* Tricks des séries : [PDF](./electromag/Tricks_Series_Electromagnetisme_Simon.pdf)

## Computer Architecture

* Notes de cours (jusqu'au midterm) : [PDF](./comparch/Notes_Comparch_Midterm_Simon.pdf)
* Notes de cours (Pipelining) : [PDF](./comparch/Notes_Comparch_Pipelining_Simon.pdf)
* Notes de cours (Multiprocessors) : [PDF](./comparch/Notes_Comparch_Multiprocessors_Simon.pdf)
* Notes (exercices pipelining et multiprocesseurs) : [PDF](./comparch/Notes_Comparch_Exercices_Simon.pdf)

## État et droits humains (SHS)

* Notes de cours : [PDF](./etat-droits-humains-shs/notes.pdf)
* Constitution Fédérale : [PDF](./etat-droits-humains-shs/constitution-federale.pdf)

## Probability and Statistics

* Notes (méthodes, tricks, un peu de cours) : [PDF](./probastats/Probastats_Simon_Notes_Tricks.pdf)
* Notes (distributions) : [PDF](./probastats/Probastats_Simon_Distributions.pdf)
* Morris (book) : [PDF](./probastats/Probastats_Morris_Book.pdf)

## Software Construction

* Notes (midterm) : [PDF](./softcon/midterm.pdf)
* Notes (final) : [PDF](./softcon/final.pdf)
* Exercises : [PDF](./softcon/exercises/)

## Computer Architecture Setup

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
