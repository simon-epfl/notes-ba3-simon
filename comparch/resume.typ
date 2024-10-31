== Tricks

=== Multiplication avec shift et log

Quand on veut calculr $a dot b$, si on dispose du $log_a$ on peut faire $b << log_a$.

=== Charger un mot au milieu

Toutes les adresses doivent être alignées sur la taille des données qu'elles manipulent (donc quand on fait un `lw` ça doit être un multiple de 4). Mais RISCV va modifier le code pour tomber sur le mot juste avant si on utilise un `lw` qui n'est pas un multiple de 4. `lw_ecrit = 4k + r`, donc `lw_corrige = 4k`.

=== Charger un immédiat avec 32 bits

`li` supporte le chargement d'un immediate de 32 bits (tandis que toutes les autres opérations comme `addi`, la constante devant `lw`, etc.) ne supportent que des 12 bits.

=== Convention d'appel

Même si on sait que la fonction `b` que notre fonction `a` va appeler ne modifie pas les saved registers, la fonction appelante doit *TOUJOURS* utiliser et sauvegarder les saved registers

```yasm
addi sp, sp, -12 # mettre à jour le stack pointer (on le fait remonter dans la mémoire)
sw ra, 0(sp)
sw s1 4(sp)
sw s2, 8(sp) # 8... + 4 = 12 bytes libérés utilisés

# blabla

lw ra, 0(sp)
lw s1, 4(sp)
lw s2, 8(sp)
addi sp, sp, 12
```

=== Sign Extend

Quand on veut faire un `andi`, `xori`, etc. ce qui compte c'est la valeur du 12ème bit pour savoir si on sign-extend ou pas.

donc 0x3 va donner 000000...011

=== Interrupt handler

#emoji.warning Écrire avec le register `zero` ou l'immediate `0` dans le interrupt handler ne va jamais modifier les valeurs des CSRs.

```yasm
interrupt_handler:
  # fait par le CPU automatiquement :
  # MPIE = MIE
  # MIE = 0

  # là le CPU clear le MIP.
  # mais nous on lit le MIP.

  # là on doit (nous) save les registers

  # là on doit (nous) gérer les service routines

  # là on doit (nous) restaurer les registers

  mret
  # fait par le CPU :
  # MIE = MPIE
  # PC = MEPC
```

==== Service routines

Toujours sauver les registers si pas de handler.

Quand on des nested interrupts, on sauvegarde dans le `mepc` dans `t0`, puis `t0` dans le stack. 
