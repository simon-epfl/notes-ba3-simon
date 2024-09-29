== Tricks

=== Multiplication avec shift et log

Quand on veut calculr $a dot b$, si on dispose du $log_a$ on peut faire $b << log_a$.

=== Charger un mot au milieu

Toutes les adresses doivent être alignées sur la taille des données qu'elles manipulent (donc quand on fait un `lw` ça doit être un multiple de 4).
