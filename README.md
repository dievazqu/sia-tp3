# Algoritmos Geneticos
Para compilar: Ir hasta la carpeta tp3, y una vez ahi, ejecutar "ant Jar" se generará un sia.jar ejecutable.

Para ejecutar: En la carpeta donde se genero el ejecutable (tienen que estar la carpeta equipamiento para que pueda levantar los datos y tambien el archivo config/default de donde se obtienen los parametros iniciales), ejecutar "java -jar sia.jar".

Archivo config/default:
Los posibles campos son:
* generationSize: indica el tamaño de la poblacion (2000 por defecto)
* selectionSize: indica el tamaño de poblacion seleccionada si se usa metodos de reemplazo 2 o 3. (1200 por defecto)
* generationGap: indica el porcentaje de hijos generados utilizando el metodo de reemplazo "GENERATIONGAP" (0.6 por defecto)
* probabilityToCrossover: probabilidad de cruza (0.95 por defecto)
* probabilityToMutate: probabilidad de mutar (0.01 por defecto)
* mutationType: metodo de mutacion (CLASSIC o UNIFORM) (UNIFORM por defecto)
* replacementType: metodo de reemplazo (ALL, REPLACE_2, REPLACE_3 o GENERATIONGAP) (GENERATIONGAP por defecto)
* crossoverType: metodo de cruza (ONE_POINT, TWO_POINT, ANULAR o UNIFORM_PARAMETRIZED) (UNIFORM_PARAMETRIZED por defecto)
* selectionType1/selectionType2/selectionType3/selectionType4:
	metodos de seleccion, el 1 y 2 es para la parte de seleccion de padres para cruzar mientras que el 3 y 4 son para la seleccion en los metodos de reemplazo.
	posibles valores: ELITE, ROULETTE, UNIVERSAL, BOLTZMANN, BOLTZMANN99, TOURNAMENT_DETERMINISTIC, TOURNAMENT_PROBABILISTIC o RANKING.
	valores por defecto: ELITE/BOLTZMANN/ELITE/BOLTZMANN
* A: (por defecto 0.5)
* B: (por defecto 0.5)
* endConditionType: condicion de corte (GENERATIONS, CONTENT, STRUCTURE, MAX_FITNESS) (CONTENT por defecto)
* maxGeneration: indica la cantidad de generacion a evolucionar si GENERATIONS es la codicion de corte (0 por defecto)
* maxFitness: indica el maximo fitness para dejar de evolucionar si MAX_FITNESS es la condicion de corte (20 por defecto)
* maxSteps: indica la cantidad de generacion en el cual el maximo no vario para dejar de evolucionar si CONTENT es la condicion de corte (500 por defecto)
* seed: valor de la semilla del random para poder replicar mediciones (1 por defecto)
