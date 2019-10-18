import matplotlib.pyplot as plt

def parseToIntList(lista):
    nuevaLista = []
    for item in lista:
        nuevaLista.append(int(item))
    return nuevaLista

def parseToFloatList(lista):
    nuevaLista = []
    for item in lista:
        nuevaLista.append(float(item))
    return nuevaLista

def plotFitness(data):
    iterations = []
    maximums = []
    means = []
    mins = []
    accuracy=[]
    counter = 0
    for line in data:
        line = line.replace('\n',"")
        line = line.split(" ")
        if counter==0:
            iterations = line
        elif counter ==1:
            maximums = line
        elif counter ==2:
            means = line
        elif counter == 3:
            mins = line
        counter+=1

    iterations = parseToIntList(iterations[:-1])
    maximums = parseToIntList(maximums[:-1])
    means = parseToFloatList(means[:-1])
    mins = parseToIntList(mins[:-1])

    
    fig, ax = plt.subplots()
    ax.plot(iterations,maximums,'go', label= 'Maximum fitness')
    ax.plot(iterations,means,'bo', label = 'Mean fitness')
    ax.plot(iterations,mins,'ro', label = 'Minimum fitness')
    ax.legend(loc = 'upper center',shadow = True, fontsize='large')
    #ax..axis([0,300,0,10])
    plt.axis([0,300,0,13])
    plt.xlabel('Iteration number')
    plt.ylabel('Fitness score')
    plt.title('Fitness vs Iteration')
    plt.show()

File = open("./wordFindStatistics.txt",'r')
lines = File.readlines()
plotFitness(lines)

