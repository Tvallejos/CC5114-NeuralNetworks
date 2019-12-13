import numpy as np
import matplotlib
import matplotlib.pyplot as plt

def parseToIntList(lista):
    nuevaLista = []
    for row in lista:
        l = []
        row = row[:-1]
        for item in row:
            l.append(int(item))
        nuevaLista.append(l)
    return nuevaLista

def plotHeatMap(data):
    yMutationRate = ["1.0","0.9","0.8","0.7","0.6","0.5","0.4","0.3","0.2","0.1"]

    xPopulation = ["50","100","150","200","250","300","350","400","450","500"
                    ,"550","600","650","700","750","800","850","900","950","1000"]
    listOfRows = []
    
    for line in data:
        line = line.replace('\n',"")
        line = line.split(" ")
        listOfRows.append(line)

    listOfRows = parseToIntList(listOfRows)
    
    listOfRows = np.array(listOfRows)

    fig, ax = plt.subplots()
    im = ax.imshow(listOfRows)

    # We want to show all ticks...
    ax.set_xticks(np.arange(len(xPopulation)))
    ax.set_yticks(np.arange(len(yMutationRate)))
    # ... and label them with the respective list entries
    ax.set_xticklabels(xPopulation)
    ax.set_yticklabels(yMutationRate)

    # Rotate the tick labels and set their alignment.
    plt.setp(ax.get_xticklabels(), rotation=45, ha="right",
         rotation_mode="anchor")

    # Loop over data dimensions and create text annotations.
    for i in range(len(yMutationRate)):
        for j in range(len(xPopulation)):
            text = ax.text(j, i, listOfRows[i, j],
                           ha="center", va="center", color="w")

    #ax.set_title("harvest of local farmers (in tons/year)")
    plt.xlabel('Population Size')
    plt.ylabel('Mutation Rate')
    plt.title('Heatmap of the solving problem iteration')
    fig.tight_layout()
    plt.show()

File = open("./heatMapNumFindData.txt",'r')
lines = File.readlines()
plotHeatMap(lines)

