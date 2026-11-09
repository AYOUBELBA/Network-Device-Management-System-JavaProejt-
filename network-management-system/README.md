# Java Network Management System

This subproject models routers, switches, and firewalls. It demonstrates Java inheritance, interfaces, collections (`List`, `Set`, `Map`), streams, lambdas, and simple alert/protocol simulations.

## Compile and run

From this folder:

```bash
javac -d out src/network/*.java
java -cp out network.Main
```

The protocols, alerts, and collected metrics are simulated; the program does not contact real network devices.

## Files

- `src/network/` contains the Java source code.
- `Explication_code.txt` explains the code in French.
- `diagramme.mmd` is the Mermaid class diagram source.
- `network_management_class_diagram_with_status.html` displays the diagram in a browser.
- `Diagramme_classes_reseau.pdf` is the PDF class diagram.
