import sqlite3
import geopy.distance
from numpy import *

rowsWants=[]
rowsOffers=[]
connMatrix=[]

def create_connection(db_file):
    """ create a database connection to the SQLite database
        specified by the db_file
    :param db_file: database file
    :return: Connection object or None
    """
    try:
        conn = sqlite3.connect(db_file)
        return conn
    except Error as e:
        print(e)

    return None


print("This is just example of car parking arrangement")
def getKey(item):
    return item[0]

def connExist(record1, record2):
    coords_1 = (record1[2], record1[3])
    coords_2 = (record2[2], record2[3])
    dist = geopy.distance.vincenty(coords_1, coords_2).m
    if (dist < float(record1[4])):
        return True
    else:
        return False


def calculatePath():
    for it0 in range(len(rowsWants)):
        counter=0
        for it1 in range(len(rowsOffers)):
            if connMatrix[it0][it1] == 1:
                counter+=1
        if counter>0:
            print("There is a possibility of indirect exchange with "+str(counter)+" persons")
    pass

def calculateP2P(conn):
    cur = conn.cursor()
    global rowsWants
    global rowsOffers
    global connMatrix

    cur.execute("SELECT * FROM data WHERE type='wants'")
    rowsWants = cur.fetchall()

    cur.execute("SELECT * FROM data WHERE type='offers'")
    rowsOffers = cur.fetchall()

    connMatrix = [[0 for j in range(len(rowsOffers))] for i in range(len(rowsWants))]

    for it0 in range(len(rowsWants)):
        for it1 in range(len(rowsOffers)):
            if connExist(rowsWants[it0],rowsOffers[it1]):
                connMatrix[it0][it1] = 1
                if connExist(rowsOffers[it1], rowsWants[it0]):
                    connMatrix[it0][it1]=2

    result=[]
    for it0 in range(len(rowsWants)):
        for it1 in range(len(rowsOffers)):
            if connMatrix[it0][it1] == 2:
                result=[]
                coords_1 = (rowsOffers[it1][2], rowsOffers[it1][3])
                coords_2 = (rowsWants[it0][2], rowsWants[it0][3])
                dist = geopy.distance.vincenty(coords_1, coords_2).m
                result.append((dist, rowsOffers[it1], rowsWants[it0]))
        SortedResult = sorted(result, key=getKey)
        #print(SortedResult)
        SortedResult=[]



    #for it0 in range(len(rowsWants)):
        #print(connMatrix[it0])

def main():
    database = "car_park_data"

    # create a database connection
    conn = create_connection(database)

    with conn:
        calculateP2P(conn)
        calculatePath()


if __name__ == '__main__':
    main()
