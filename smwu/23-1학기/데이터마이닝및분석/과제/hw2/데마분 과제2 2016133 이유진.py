#do clustering using X
import numpy as np
from sklearn.datasets import make_blobs
X, _ = make_blobs(n_samples = 100, centers = 5,
                  n_features = 2, random_state = 0)

from sklearn.cluster import KMeans
from sklearn.cluster import AgglomerativeClustering
from sklearn.cluster import DBSCAN

while 1:
    print("[ Student ID: 2016133 ]")
    print("[ Name: 이유진 ]")
    print("1. K-means")
    print("2. Hierarchical clustering")
    print("3. DBSCAN")
    print("4. Quit")
    print(">", end = " ")
    x = int(input())
    print()

    if x == 1: #K-means
        n_clusters = int(input("n_clusters: ")) #K
        random_state = int(input("random_state: ")) #initial centroid's random seed
        
        #cluster.KMeans([n_clusters, init, n_init, max_iter, tol, random_state])
        result = KMeans(n_clusters = n_clusters, random_state = random_state,
                        n_init = "auto").fit(X)
        
    elif x == 2: #Hierarchical clustering
        n_clusters = int(input("n_clusters: "))
        linkage = input("linkage: ") #ward, complete, average, single (exception handling x)

        #cluster.AgglomerativeClustering([n_clusters, metric, linkage])
        result = AgglomerativeClustering(n_clusters = n_clusters, linkage = linkage).fit(X)
        
    elif x == 3: #DBSCAN
        eps = float(input("eps: "))
        min_samples = int(input("min_samples: ")) #minpoint

        #cluster.DBSCAN([eps, min_samples, metric])
        result = DBSCAN(eps = eps, min_samples = min_samples).fit(X)
    
    elif x == 4: #Quit
        print("quit clustering!")
        break
    
    else:
        print("invalid input!\n")
        continue

    print("\n<Clustering result>")
    print(result.labels_)
    print()
