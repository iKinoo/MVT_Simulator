## Setup

Usa `./gradlew tasks` para mostrar todos los comandos posibles (tareas)

- Para compilar usa `./gradlew build`
- Para correr el programa `./gradlew run`
- Para generar un ejecutable binario `.exe`: `./gradlew jpackage`, al compilar se mostrar el ejecutable en `app/build/jpackage`
    > Importante: el ejecutable MVT_Simulator.exe por si solo no es funcional, se necesita que el ejecutable esté en la carpeta MVT_Simulator, con todas sus dependencias

    El resultado de esta compilación trae consigo su propia JVM, por lo que no depende de Java para ser ejecutado

### Recomendaciones

En caso de usar VsCode: 
- [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- [Gradle for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-gradle)





Overview
---


```mermaid

classDiagram

namespace Model{
    class Hole
    class Process
    class Partition
}

namespace Controller{
    class HolesTableController
    class PartitionsTableController
    class ProcessesTableController
}

class Hole{
    -IntegerProperty number
    -IntegerProperty location
    -IntegerProperty size
    -StringProperty status
}

class Process{
    -StringProperty name
    -IntegerProperty size
    -IntegerProperty arrivalTime
    -IntegerProperty duration
}

class Partition{
    -IntegerProperty number
    -IntegerProperty location
    -IntegerProperty size
    -StringProperty status
    -Process process
}

class HolesTableController{
    -TableView<Hole> holesTable
    -TableColumn~Hole, Integer~ holeNumber
    -TableColumn~Hole, Integer~ holeLocation
    -TableColumn~Hole, Integer~ holeSize
    -TableColumn~Hole, String~ holeStatus
}

class PartitionsTableController{

    -TableView~Partition~ partitionsTable
    -TableColumn~Partition, Integer~ partitionNumber
    -TableColumn~Partition, Integer~ partitionLocation
    -TableColumn~Partition, Integer~ partitionSize
    -TableColumn~Partition, String~ partitionStatus
    -TableColumn~Partition, String~ partitionProcess

}

class ProcessesTableController{
    -TableView~Process~ processesTable
    -TableColumn~Process, String~ processName
    -TableColumn~Process, Integer~ processSize
    -TableColumn~Process, Integer~ processArrivalTime
    -TableColumn~Process, Integer~ processDuration
}

Partition --> Process

ProcessesTableController --> Process
PartitionsTableController --> Partition
HolesTableController --> Hole

class Memory{
    -ArrayList~Process~ procesos
    -ArrayList~Hole~ holes
    ~ArrayList~Partition~ partitions
}

Memory --> Process
Memory --> Hole
Memory --> Partition

```
