import requests
import re
from socket import *

def main():
    serverSocket = socket(AF_INET, SOCK_STREAM)
    serverSocket.setsockopt(SOL_SOCKET,SO_REUSEADDR,1)
    serverSocket.bind(("",6000))
    serverSocket.listen(1)
    print ('Waiting for connection...')
    tcpCliSock,addr = serverSocket.accept()

    print('...connected from',addr)
    message = tcpCliSock.recv(1024)
    print("receive : ", message)
    tcpCliSock.send(message)
    tcpCliSock.close()

if __name__ == '__main__':
    main ()
