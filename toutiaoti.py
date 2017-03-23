from sys import argv
import math


class toutiao:
    def __init__(self, x, y):
        self.x = x
        self.y = y

class tongle:
    def __init__(self, toutiaos):
        self.toutiaos = toutiaos
        self.length = 0

    def _getLength(self):
        if self.toutiaos.__len__() < 3:
            return
        else:
            for i in range(1,self.toutiaos.__len__()):
                xran = self.toutiaos[i].x - self.toutiaos[i-1].x
                yran = self.toutiaos[i].y - self.toutiaos[i-1].y
                self.length = math.hypot(xran,yran) + self.length
            self.length = self.length + math.hypot(3,4)
        print self.length
        return self.length
        pass

if __name__ == "__main__":
    toutiao0 = toutiao(0, 0)
    toutiao1 = toutiao(1, 2)
    toutiao2 = toutiao(3, 4)
    a = [toutiao0, toutiao1, toutiao2]
    print a.__len__()
    tongle1 = tongle([toutiao0, toutiao1, toutiao2])
    print tongle1.toutiaos[0].x
    print tongle1._getLength()
    print "main"


