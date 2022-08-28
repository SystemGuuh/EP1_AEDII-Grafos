# EP1_AEDII
Exercício de programação de Algoritmo e Estrutura de Dados II

O trabalho consiste em desenvolver um programa em Java
que recebe um grafo orientado e encontra as componentes fortemente
conectadas . Na entrada o usuário deverá selecionar o tipo de representação a ser
usada para representar os grafos durante a execução dos algoritmos, a qual pode
ser uma coleção de listas de adjacências ou uma matriz de adjacências.

Além disso, o programa deverá imprimir:
1. Se o grafo é fortemente conexo
2. O número de componentes fortemente conectados
3. Uma ordenação topológica do grafo de componentes fortemente conectados
4. A representação em texto do grafo de componentes fortemente conectados

**Entrada**</br>
A entrada conterá a especificação do grafo orientado. A primeira linha do texto
conterá a quantidade de vértices do grafo, |V|. Para cada vértice listamos os nós
adjacentes de cada vértice em cada linha, separando cada vérticeAdjacente por
“;”. E a última linha especifica o tipo de representação dos grafos desejado pelo
usuário, que pode ser:</br>
1: coleção de listas de adjacências ou</br>
2: matriz de adjacências.

**Saída**</br>
A saída conterá as seguintes linhas.
A primeira linha conterá “Sim” se o grafo é fortemente conexo e “Não” caso
contrário.
A segunda linha conterá o número de componentes fortemente conectados.
A terceira linha conterá uma ordenação topológica do grafo de componentes
fortemente conectados
As demais linhas conterão a representação em texto do grafo de componentes
fortemente conectados seguindo o mesmo formato da entrada, caso a
representação escolhida seja do tipo 1 ou a matriz, caso seja tipo 2.

**Exemplo**</br>
&nbsp;&nbsp;Entrada: </br>
&nbsp;&nbsp;&nbsp;8</br>
&nbsp;&nbsp;&nbsp;a: b;</br>
&nbsp;&nbsp;&nbsp;b: c; e; f;</br>
&nbsp;&nbsp;&nbsp;c: d; g;</br>
&nbsp;&nbsp;&nbsp;d: c; h;</br>
&nbsp;&nbsp;&nbsp;e: a; f;</br>
&nbsp;&nbsp;&nbsp;f: g;</br>
&nbsp;&nbsp;&nbsp;g: f; h;</br>
&nbsp;&nbsp;&nbsp;h: h;</br>
&nbsp;&nbsp;&nbsp;2</br>

&nbsp;&nbsp;Saída: </br>
&nbsp;&nbsp;&nbsp;Não</br>
&nbsp;&nbsp;&nbsp;abe cd fg h</br>
&nbsp;&nbsp;&nbsp;abe cd fg h</br>
&nbsp;&nbsp;&nbsp;abe 0 1 1 0</br>
&nbsp;&nbsp;&nbsp;cd  0 0 1 1</br>
&nbsp;&nbsp;&nbsp;fg  0 0 0 1</br>
&nbsp;&nbsp;&nbsp;h   0 0 0 0</br>
