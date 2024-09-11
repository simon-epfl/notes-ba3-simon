# Comparch

## Setup

### RISC-V Toolchain

* Download `riscv.zip` file from [here](https://cloud.androz2091.fr/api/public/dl/hz3QQc0o/risc.zip).
* Extract the contents so the `opt/riscv` directory is located in `/opt/riscv` in your computer.
* Run the debugger and see if it is showing the memory preview.


### Verilator

If verilator can not be built on your computer, you can use the docker image:
```bash
sudo docker run -ti -v ${PWD}:/work --user root:root verilator/verilator:latest --timescale 1ns/1ns --top-module tb --cc --exe --binary --timing --trace --trace-underscore -O2 lu.sv tb.sv
```
